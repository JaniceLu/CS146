package sjsu.lu.cs146.project3;

/**
 * Implementation of RedBlack Tree using template provided by 
 * Professor Potika. Some functions were removed since they
 * were not used. Some functions have some slight modifications.
 * @author Janice Lu
 *
 * @param <Key>
 */
public class RedBlackTree<Key extends Comparable<Key>> {	
	private static RedBlackTree.Node<String> root;
	
	/**
	 * Node class that contains information about each
	 * node in the RB tree
	 * @author Janice Lu
	 *
	 * @param <Key>
	 */
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
		  
	}
	
	/**
	 * used for visiting the node
	 * @author Janice Lu
	 *
	 * @param <Key>
	 */
	public interface Visitor<Key extends Comparable<Key>> {
		
		/**
		This method is called at each node.
		@param n the visited node
		*/
		void visit(Node<Key> n);  
	}
	
	/**
	 * Place a new node in the RB tree with data the parameter and
	 * handles root case
	 * @param data - the string to add as the key for the node
	 */
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
	
	/**
	 * modified version of addNode that properly traverses the tree
	 * @param current - node to be added into the tree
	 * @param k - the data to be inserted as the key in the node
	 */
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
				if(k.compareTo(current.key) > 0)
				{
					current = current.rightChild;
				}
			}
		}
		//temp is the parent node (which we found in while loop)
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

	/**
	 * used as a requirement for Potika's JUnit test, as it uses
	 * insert method
	 * @param data - string to be added to the key of the node
	 */
	public void insert(String data)
	{
		addNode(data);	
	}
	
	/**
	 * used in the spell check to see if there is a match
	 * @param k - the word to search for
	 * @return - return null if there is no match, return found word otherwise
	 */
	public RedBlackTree.Node<String> lookup(String k)
	{ 
		return lookup(root, k);
	}
 	
	/**
	 * uses comparisons to find a match in the tree, did not end up using the
	 * provided compareTo method and used the generic java library compareTo 
	 * method
	 * @param n - where to start the search in the RB tree
	 * @param k - the word to search for
	 * @return - returns null if there is no match in RB tree, returns
	 * 			 a node if there is a match
	 */
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
	
	/**
	 * getter for grandparent
	 * @param n - node from which grandparent is derived from
	 * @return - the parent's parent of the parameter
	 */
	public RedBlackTree.Node<String> getGrandparent(RedBlackTree.Node<String> n){
		return n.parent.parent;
	}
	
	/**
	 * rotates the graph to the left when the RB tree needs to
	 * @param n - the node to base the left rotation off of
	 */
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
	
	/**
	 * rotates the graph to the right when the RB tree needs to
	 * @param n - the node to base the right rotation off of
	 */
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
		 * make sure node fulfills the following conditions
		 * so that we can fix it:
		 * 1. current is not root
		 * 2. current node is red
		 * 3. current node's parent is also red
		 */
		while((current != root) 
				&& (current.color == 0)
				&& (current.isRed == true) 
				&& (current.parent.isRed)
				&& (current.parent.color == 0))
		{
			parentNode = current.parent; 
			grandParentNode = getGrandparent(current);
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
					//case two: node is left child of parent
					//          needs right rotation
					if(current.equals(parentNode.leftChild)) 
					{
						current = parentNode;
						rotateRight(current);
					}
					//case three: node is left child of parent
					//            needs right rotation
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

	/**
	 * used in the tester to check the correctness of the RB tree
	 * @param v - the node to start visiting from
	 */
	public void preOrderVisit(Visitor<String> v) {
	   	preOrderVisit(root, v);
	}
	 
	 /**
	  * recursive function to complete preorder visit of rb tree
	  * @param n - where to start the preorder from
	  * @param v - where to visitor is
	  */
	private static void preOrderVisit(RedBlackTree.Node<String> n, Visitor<String> v) {
	  	if (n == null) {
	  		return;
	  	}
	  	v.visit(n);
	  	preOrderVisit(n.leftChild, v);
	  	preOrderVisit(n.rightChild, v);
	}
}

