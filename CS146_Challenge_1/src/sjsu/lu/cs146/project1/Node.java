package sjsu.lu.cs146.project1;

public class Node 
{
	int info;
	Node next;
	public Node(int data)
	{
		this.info = data;
	}
	
	public Node(int data, Node link)
	{
		this.info = data;
		this.next = link;
	}
}
