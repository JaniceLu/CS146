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
		int iterations = 0;
		int deletedNumber = 0;
		Node toDelete = prisoners.head;
		while(prisoners.getNodeCount() > 1)
		{
			System.out.println("count is: " + prisoners.getNodeCount());
			for(int i = 0; i < elimFactor - 1; i++)
			{
				toDelete = toDelete.next;
				System.out.println("i: " + i + "\nnext: "+ toDelete.number);
			}
			System.out.println("Delete this node: " + toDelete.number);
			deletedNumber = toDelete.number;
			toDelete = toDelete.next;
			prisoners.deleteAt(deletedNumber);
		
		}
		return deletedNumber;
	}
	
	
	
}
