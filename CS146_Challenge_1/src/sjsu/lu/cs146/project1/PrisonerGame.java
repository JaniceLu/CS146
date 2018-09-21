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
