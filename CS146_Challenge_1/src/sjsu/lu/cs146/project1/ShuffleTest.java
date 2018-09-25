package sjsu.lu.cs146.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The purpose of this .java file is to test the methods of 
 * Shuffle.java using JUnit tests.
 * @author janice_lu
 */
public class ShuffleTest
{
   //instance of class object to be used in JUnit test
   Shuffle shuffleTester;

   //to be used in JUnit test to check test output
   String expectedLine, actualLine;
   
   //string array to hold songs from playlist
   String[] originalPlaylist = new String[256]; 
   
   //to be used for iterating through indexes in tests
   int i;
   
   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception
   {
      shuffleTester = new Shuffle();
   }

   /**
    * Test method for {@link sjsu.lu.cs146.project1.Shuffle#songToArray()}. 
    * Checks if the songs were tranferred to the String array properly
    * @return No message if all songs have been transferred correctly.
    *         AssertionError if a song has been not transferred correctly from the file
    * @throws IOException 
    */
   @Test
   public void testSongToArray() throws IOException
   {
	  i= 0;
	  //A stream to read a file
      BufferedReader In = new BufferedReader (new FileReader ("Playlist.txt"));
      shuffleTester.songToArray();
      while ((expectedLine = In.readLine()) != null) 
      {
    	 //takes a song from the list
         String actualLine = shuffleTester.songPlayList[i];
         //the line from the file should be the same as the array
         assertEquals(expectedLine, actualLine);
         i++;
      }
      In.close();
   }

   /**
    * Test method for {@link sjsu.lu.cs146.project1.Shuffle#shuffleSongs()}.
    * Tests the output of the newly shuffled playlist.
    * @return no message if all lines in both files match, 
    *         AssertionError if any of the lines do not match
    * @throws IOException
    */
   @Test
   public void testShuffleSongs() throws IOException
   {
	   shuffleTester.songToArray();   
	   shuffleTester.shuffleSongs();
	   //A stream to read the results of the shuffled list
	   BufferedReader Out = new BufferedReader (new FileReader ("LuJanicePlaylist.txt"));
	   //A stream to read the expected results of the shuffled list
	   BufferedReader In = new BufferedReader (new FileReader ("Target2.txt"));
	   while ((expectedLine = In.readLine()) != null) 
	   {     
		   //A string with the correct song to be compared to
		   String actualLine = Out.readLine();
		   //Should return true if songs were shuffled correctly
		   assertEquals(expectedLine, actualLine);   
	   }
	   Out.close();
	   In.close();
   } 
   
}