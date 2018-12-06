package sjsu.lu.cs146.project3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;


public class RBTTester {
  
	@Test
    //Test the Red Black Tree
	public void test() {
		RedBlackTree<String> rbt = new RedBlackTree<String>();
        rbt.insert("D");
        rbt.insert("B");
        rbt.insert("A");
        rbt.insert("C");
        rbt.insert("F");
        rbt.insert("E");
        rbt.insert("H");
        rbt.insert("G");
        rbt.insert("I"); 
        rbt.insert("J");
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=     "Color: 1, Key:D Parent: \n"+
                        "Color: 1, Key:B Parent: D\n"+
                        "Color: 1, Key:A Parent: B\n"+
                        "Color: 1, Key:C Parent: B\n"+
                        "Color: 1, Key:F Parent: D\n"+
                        "Color: 1, Key:E Parent: F\n"+
                        "Color: 0, Key:H Parent: F\n"+
                        "Color: 1, Key:G Parent: H\n"+
                        "Color: 1, Key:I Parent: H\n"+
                        "Color: 0, Key:J Parent: I\n";
		assertEquals(str, makeStringDetails(rbt));
        spellCheck();
    }
	
	//tester for spell checker
    public void spellCheck()
    {
    	File input = new File("dictionary.txt");
    	File poem = new File("Democracy_Langston_Hughes.txt");
		try
		{
			Scanner in = new Scanner(input);
			
			RedBlackTree<String> dictionary = new RedBlackTree<String>();
			long start =  System.currentTimeMillis();
			while(in.hasNextLine())
			{
				String data = in.nextLine();
				dictionary.insert(data);
			}
			long end = System.currentTimeMillis();
			long processTime = end - start;
			System.out.println("Dictionary filled in: "+ processTime + " milliseconds");
			in.close();
			
			Scanner read = new Scanner(poem);
			long checkStart = System.currentTimeMillis(); 
			int count = 0;
			while(read.hasNextLine())
			{
				Scanner line = new Scanner(read.nextLine());
				while(line.hasNext())
				{
					String word = line.next();
					word = word.replaceAll("[\\,\\.\\\"\\']", "");
					RedBlackTree.Node<String> checker = dictionary.lookup(word);
					if(checker == null)
					{
						System.out.println("Misspelled: " + word);
						count++;
					}
				}
				line.close();
			}
			long checkEnd = System.currentTimeMillis();
			long checkTime = checkEnd - checkStart;
			System.out.println("The poem has " + count + " misspelled words.");
			System.out.println("Spell check finished in: "+  checkTime + " milliseconds");
			read.close();
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("File could not be read.");
		}
    }
    
    public static String makeString(RedBlackTree<String> t)
    {
       class MyVisitor implements RedBlackTree.Visitor {
          String result = "";
          public void visit(RedBlackTree.Node n)
          {
             result = result + n.key;
          }
       };
       MyVisitor v = new MyVisitor();
       t.preOrderVisit(v);
       return v.result;
    }

    /**
     * Had to change this because NIL leafs were not initialized 
     * and kept as nulls, so it had to handle the root print
     * @param t - a RedBlackTree
     * @return a string with the expected output for the JUnit test
     */
    public static String makeStringDetails(RedBlackTree<String> t) 
    {
    	{
    	       class MyVisitor implements RedBlackTree.Visitor {
    	          String result = "";
    	          public void visit(RedBlackTree.Node n)
    	          {
    	        	  if(!(n.key).equals(""))
    	        	  {
    	        		  //checks the root
    	        		  if(n.parent == null)
    	        		  {
    	        			  result = result + "Color: "+n.color+", Key:"+n.key+" Parent: \n";
    	        		  }
    	        		  else
    	        		  {
    	        			  result = result +"Color: "+n.color+", Key:"+n.key+" Parent: "+n.parent.key+"\n";
    	        		  }
    	        	  }
    	             
    	          }
    	       };
    	       MyVisitor v = new MyVisitor();
    	       t.preOrderVisit(v);
    	       return v.result;
    	 }
    } 
 }
  