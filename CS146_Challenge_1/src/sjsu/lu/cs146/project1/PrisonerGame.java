package sjsu.lu.cs146.project1;

/**
 * A class that uses the linkedList class to delete
 * certain nodes and add nodes in order to simulate
 * a King deciding who to grant freedom to.
 * @author janice_lu
 *
 */
public class PrisonerGame {
	//A linked list object to use to hold prisoner nodes
	public linkedList prisoners;
	
	/**
	 * A constructor for the PrisonerGame class
	 */
	PrisonerGame()
	{
		prisoners = new linkedList();
	}
	
	/**
	 * A function to add prisoners (nodes) to a list (linkedList)
	 * @param prisonerQueue the amount of people waiting to
	 *        be freed
	 * @return the amount of people that were successfully
	 * 		   inserted into the linked list
	 */
	public int bringPrisoners(int prisonerQueue) 
	{
		prisoners.insert(prisonerQueue);
		//size is prisonerQueue
		return prisoners.getNodeCount(); 
	}
	 
	/**
	 * A function to determine which prisoner in the linkedList
	 * will receive freedom. It is based on the last node left in the 
	 * linkedList. The last node will be the "freed" prisoner.
	 * @param elimFactor The factor at which the function counts by to
	 * 		  determine which node is to be deleted
	 * @return the number of the node that is deleted
	 */
	public int winFreedom(int elimFactor) 
	{
		/*
		 * the number to be assigned the deleted node number
		 * and assigned to later
		 */
		int deletedNumber = 0;  
		//the very last node remaining in the queue
		int winner = 0;  
		//A placeholder Node to determine which node to delete
		Node toDelete = prisoners.head; 
		/*
		 * this while loop determines which node is to be deleted
		 * so long as the linkedList is larger than 1
		 */
		while(prisoners.getNodeCount() != 1) 
		{
			for(int i = 0; i < elimFactor; i++)
			{ 
				toDelete = toDelete.next;  
			}
			
			deletedNumber = toDelete.number;
			
			toDelete = toDelete.next;  
			
			deletedNumber = prisoners.deleteAt(deletedNumber);
		}    
		
		winner = prisoners.tail.number;
		
		return winner; 
	} 
	
	
	 
}
