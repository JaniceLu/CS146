package sjsu.lu.cs146.project1;

public class PrisonerGame {
	
	public linkedList prisoners;
	
	PrisonerGame()
	{
		prisoners = new linkedList();
	}
	
	public int bringPrisoners(int prisonerQueue) 
	{
		prisoners.insert(prisonerQueue);
		return prisoners.getNodeCount(); 
	}
	 
	public int winFreedom(int elimFactor) 
	{
		int deletedNumber = 0; 
		int winner = 0;
		Node toDelete = prisoners.head;  
		while(prisoners.getNodeCount() != 1) 
		{
			System.out.println("There are " + prisoners.getNodeCount() + " prisoners left.");
			for(int i = 0; i < elimFactor; i++)
			{ 
				toDelete = toDelete.next;
				
			}
			System.out.println("Delete this node: " + toDelete.number);
			deletedNumber = toDelete.number;
			toDelete = toDelete.next; 
			deletedNumber = prisoners.deleteAt(deletedNumber);
		}
		
		winner = prisoners.head.number;
		
		return winner; 
	}
	
	
	
}
