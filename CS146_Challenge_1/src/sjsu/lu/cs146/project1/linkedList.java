package sjsu.lu.cs146.project1;

/**
 * This program implements a circular doubly linked list
 * for usage in the Prisoner program.
 * @author janice_lu
 */
public class linkedList {
	//The first node of the linkedlist
	Node head;
	//The last node of the linkedlist
	Node tail;
	//The number of nodes in the linkedlist
	int nodeCount;
	
	/**
	 * A constructor for the linkedlist class
	 */
	linkedList() {
		head = null;
		tail = null;
		nodeCount = 0; 
	} 
	  
	/**
	 * A function to test if the linkedlist is with
	 * or without nodes.
	 * @return TRUE if there are no nodes in the array as 
	 * 		   as well as head and tail nodes are null
	 * 		   FALSE if there are nodes in the array or 
	 *         either/both head and tail are not null
	 */
	public boolean isEmpty() { 
		if(getNodeCount() == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * A function to insert nodes into a linkedlist. It 
	 * has capability to insert numerous nodes in at once.
	 * @param n the number of nodes to insert into the list
	 */
	public void insert(int n) {
		/**
		 * A placeholder node to be used as a placeholder 
		 * when changing node assignments.
		 */
		Node temp;
		
		/**
		 * This code block assigns head to a newly
		 * created node and then assigns tail to that 
		 * same node. Then, it assigns prev and next
		 * nodes accordingly. At the end, it assigns a number 
		 * to the node.
		 */
		if(isEmpty())
		{
			temp = new Node();
			
			head = temp;
			tail = head;
			tail.prev = head;
			tail.next = head;
			
			head.prev = tail;
			head.next = tail;
		
			tail.number = 1;	
			head.number = tail.number;
			
			setNodeCount(getNodeCount() + 1);
			n--;
		}
		//A placeholder for the head node
		Node last = head;
		
		/**
		 * Adds a node n amount of times and
		 * assigns each node with a number
		 */
		for(int i = 0; i < n; i++)
		{
			while (last.next != head) 
			{
				last = last.next;
			}
			temp = new Node();
			
			last.next = temp;
			temp.prev = last;
			temp.next = head;
			head.prev = temp;
			
			setNodeCount(getNodeCount()+1);
			
			temp.number = getNodeCount();

			tail = temp;
			tail.prev = temp.prev;
			tail.next = head;
		} 
		
	}
	
	/**
	 * A function that deletes a node at the specified
	 * spot.
	 * @param position specifies the node that is to be
	 *        deleted from the list
	 * @return the node number that was deleted or
	 * 		   zero if there are no nodes 
	 */
	public int deleteAt(Node position) {
		/**
		 * A node to represent the current node the function
		 * is looking at to determine if it is the node to 
		 * be deleted.
		 */
		
		/**
		 * Delete node specified in parameter in the linked list 
		 */  
		if(getNodeCount() == 0)
		{
			return 0;  
		}
		if(position == head)
		{
			head = head.next;
			tail.next = head;
			position = null; 
		}
		else if(position == tail)
		{
			tail.prev.next = head;
			head.prev = tail.prev; 
			position = null;
		}
		else
		{
			position.prev.next = position.next;
			position.next.prev = position.prev;
			position = null;
		}
		
		setNodeCount(getNodeCount() - 1);
		
		return getNodeCount(); 
		 
	}
	
	/**
	 * A function to get the size of the linked list
	 * @return the number of nodes in the linked list
	 */
	public int getNodeCount() {
		return nodeCount;
	}
	  
	/**
	 * A function to set the size of the linked list
	 * after adding or removing a node
	 * @param nodeCount the number of nodes in the linked list
	 */
	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
	
}
