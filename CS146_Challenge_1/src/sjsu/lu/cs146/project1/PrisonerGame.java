package sjsu.lu.cs146.project1;

public class PrisonerGame {
	
	public static linkedList prisoners;
	
	int size;
	
	PrisonerGame()
	{
		prisoners = new linkedList();
		size = 0;
	}
	
	public static void bringPrisoners(int n) 
	{
		prisoners.insert(n);
	}
	public static void winFreedom() 
	{
		return;
	}
	
	
	
}
