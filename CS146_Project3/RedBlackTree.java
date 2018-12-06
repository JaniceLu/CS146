package sjsu.lu.cs146.project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RedBlackTree<Key extends Comparable<Key>> {	
	private static RedBlackTree.Node<String> root;

	public static class Node<Key extends Comparable<Key>> 
	{ //changed to static 
		
		  Key key;  		  
		  Node<String> parent;
		  Node<String> leftChild;
		  Node<String> rightChild;
		  boolean isRed;
		  int color;
		  
		  public Node(Key data)
		  {
			  this.key = data;
			  leftChild = null;
			  rightChild = null;
		  }		
		  
		  public int compareTo(Node<Key> n)
		  { 									//this < that  <0
		 		return key.compareTo(n.key);  	//this > that  >0
		  }
		  
		  public boolean isLeaf()
		  {
			  if (this.equals(root) && this.leftChild == null && this.rightChild == null) 
			  {
				  return true;
			  }
			  if (this.equals(root)) 
			  {
				  return false;
			  }
			  if (this.leftChild == null && this.rightChild == null)
			  {
				  return true;
			  }
			  return false;
		  }
	}

	 public boolean isLeaf(RedBlackTree.Node<String> n)
	 {
		  if (n.equals(root) && n.leftChild == null && n.rightChild == null) 
		  {
			  return true;
		  } 
		  if (n.equals(root)) 
		  {
			  return false;
		  }
		  if (n.leftChild == null && n.rightChild == null)
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
		  
	  }
	
	public interface Visitor<Key extends Comparable<Key>> {
		/**
		This method is called at each node.
		@param n the visited node
		*/
		void visit(Node<Key> n);  
	}
	
	public void visit(Node<Key> n){
		System.out.println(n.key);
	}
	
	public void printTree(){  //preorder: visit, go left, go right
		RedBlackTree.Node<String> currentNode = root;	
		printTree(currentNode);
	}
	
	public void printTree(RedBlackTree.Node<String> node){
		System.out.print(node.key);
		if (node.isLeaf()){
			return;
		}
		printTree(node.leftChild);
		printTree(node.rightChild);
	}
	
	// place a new node in the RB tree with data the parameter and color it red. 
	public void addNode(String data){  	//this < that  <0.  this > that  >0
		//add root node if it isn't populated yet
		if(root == null)
		{
			RedBlackTree.Node<String> add = new RedBlackTree.Node<String>(data);
			add.leftChild = null;
			add.rightChild = null;
			add.color = 1;
			add.isRed = false;
			root = add;
		}
		else
		{
			addNode(root, data);
		}
		
	}
	
	public void addNode(RedBlackTree.Node<String> current, String k)
	{
		RedBlackTree.Node<String> add = new RedBlackTree.Node<String>(k);
		add.color = 0;
		add.isRed = true;
		RedBlackTree.Node<String> temp = null;
		//traverse the tree until you reach a nil leaf
		while(current != null)
		{
			temp = current;
			if(k.compareTo(current.key) < 0)
			{
				current = current.leftChild;
			}
			else
			{
				current = current.rightChild;
			}
		}
		add.parent = temp;
		if(add.key.compareTo(temp.key) < 0) 
		{
			temp.leftChild = add;
		}
		else
		{
			temp.rightChild = add;
		}
		add.leftChild = null;
		add.rightChild = null;
		fixTree(add);
		return;
	}

	public void insert(String data)
	{
		addNode(data);	
	}
	
	public RedBlackTree.Node<String> lookup(String k)
	{ 
		return lookup(root, k);
	}
 	
	public RedBlackTree.Node<String> lookup(RedBlackTree.Node<String> n, String k)
	{
		boolean found = false;
		while((n != null) && (!found))
		{
			if(n.key.compareTo(k) == 0)
			{
				found = true;
				break;
			}
			else {
				if(n.key.compareTo(k) < 0)
				{
					n = n.rightChild;
				}
				else if(n.key.compareTo(k) > 0)
				{
					n = n.leftChild;
				}
				lookup(n, k);
			}
		}
		return n;
	}
	
	public RedBlackTree.Node<String> getSibling(RedBlackTree.Node<String> n){  
		if(n.parent == null || n.parent.leftChild == null || n.parent.rightChild == null)
		{
			return null;
		}
		else
		{
			if(n.equals(n.parent.rightChild))
			{
				return n.parent.leftChild;
			}
			else
			{
				return n.parent.rightChild;
			}
		}
	}
	
	
	public RedBlackTree.Node<String> getAunt(RedBlackTree.Node<String> n){
		return getSibling(n);
	}
	
	public RedBlackTree.Node<String> getGrandparent(RedBlackTree.Node<String> n){
		return n.parent.parent;
	}
	
	public void rotateLeft(RedBlackTree.Node<String> n)
	{
		RedBlackTree.Node<String> y = n.rightChild;
		n.rightChild = y.leftChild;
		if(y.leftChild != null) 
		{
			y.leftChild.parent = n;		
		}
		y.parent = n.parent;
		if(n.parent == null)
		{
			root = y;
		}
		else if(n == n.parent.leftChild)
		{
			n.parent.leftChild = y;
		}
		else
		{
			n.parent.rightChild = y;
		}
		y.leftChild = n;
		n.parent = y;
	}
	
	public void rotateRight(RedBlackTree.Node<String> n)
	{
		RedBlackTree.Node<String> y = n.leftChild;
		n.leftChild = y.rightChild;
		if(y.rightChild != null)
		{
			y.rightChild.parent = n;
		}
		y.parent = n.parent;
		if(n.parent == null)
		{
			root = y;
		}
		else if(n == n.parent.rightChild)
		{
			n.parent.rightChild = y;
		}
		else
		{
			n.parent.leftChild = y;
		}
		y.rightChild = n;
		n.parent = y;
	}
	
	/**
	 * method fixes the RedBlack Tree to be in accordance to
	 * RedBlack Tree rules
	 * @param current - the current node to be fixed
	 */
	public void fixTree(RedBlackTree.Node<String> current) 
	{
		RedBlackTree.Node<String> parentNode = null;
		RedBlackTree.Node<String> grandParentNode = null;
		
		/*
		 * make sure node fulfills the following conditions:
		 * 1. current is not root
		 * 2. 
		 */
		while((current != root) 
				&& (current.color == 0)
				&& (current.isRed == true) 
				&& (current.parent.isRed)
				&& (current.parent.color == 0))
		{
			parentNode = current.parent; 
			grandParentNode = current.parent.parent;
			//deals with all parents that are to the left of the grandparent
			if(parentNode.equals(grandParentNode.leftChild))
			{
				RedBlackTree.Node<String> auntNode = grandParentNode.rightChild;
				//case one: aunt is red and parent is red
				if((auntNode != null) 
						&& (auntNode.isRed) 
						&& (auntNode.color == 0))
				{
					grandParentNode.color = 0;
					grandParentNode.isRed = true;
					parentNode.color = 1;
					parentNode.isRed = false;
					auntNode.color = 1;
					auntNode.isRed = false;
					current = grandParentNode;
				}
				else
				{
					//case two: node is right child of parent
					//          needs left rotation
					if(current.equals(parentNode.rightChild))
					{
						current = parentNode;
						rotateLeft(current);
					}
					//case three: node is left child of parent
					//            needs right rotation
					parentNode.color = 1;
					parentNode.isRed = false;
					grandParentNode.color = 0;
					grandParentNode.isRed = true;
					rotateRight(grandParentNode);
				}
			}
			//deals with all parents that are to the left of the grandparent
			else
			{
				RedBlackTree.Node<String> auntNode = grandParentNode.leftChild;
				
				if((auntNode != null) 
						&& (auntNode.isRed) 
						&& (auntNode.color == 0))
				{
					grandParentNode.color = 0;
					grandParentNode.isRed = true;
					parentNode.color = 1;
					parentNode.isRed = false;
					auntNode.color = 1;
					auntNode.isRed = false;
					current = grandParentNode;
				}
				else
				{
					//case two: node is left child of parent
					//          needs right rotation
					if(current.equals(parentNode.leftChild)) 
					{
						current = parentNode;
						rotateRight(current);
					}
					parentNode.color = 1;
					parentNode.isRed = false;
					grandParentNode.color = 0;
					grandParentNode.isRed = true;
					rotateLeft(grandParentNode);
				}
			}
		} 
		root.color = 1;
		root.isRed = false;
	}
	 
	public boolean isLeftChild(RedBlackTree.Node<String> parent, RedBlackTree.Node<String> child)
	{
		if (child.compareTo(parent) < 0 ) {//child is less than parent
			return true;
		}
		return false;
	}
	
	public boolean isRightChild(RedBlackTree.Node<String> parent, RedBlackTree.Node<String> child)
	{
		if (child.compareTo(parent) > 0 ) {//child is less than parent
			return true;
		}
		return false;
	}

	public void preOrderVisit(Visitor<String> v) {
	   	preOrderVisit(root, v);
	}
	 
	 
	private static void preOrderVisit(RedBlackTree.Node<String> n, Visitor<String> v) {
	  	if (n == null) {
	  		return;
	  	}
	  	v.visit(n);
	  	preOrderVisit(n.leftChild, v);
	  	preOrderVisit(n.rightChild, v);
	}
}

