package sjsu.lu.cs146.project1;


public class linkedList {
	private Node head;
	private int nodeCount;
	
	linkedList()
	{
		head = null;
		nodeCount = 0;
	}
	
	public boolean isEmpty()
	{

		int result = getNodeCount();
		
		if(result != 0)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	public void insert(int n)
	{
		Node temp;
		
		if(isEmpty())
		{
			temp = new Node();
			head = temp;
			head.prev = head;
			head.next = head;
			head.number = 1;
			setNodeCount(getNodeCount() + 1);
			n = n - 1;
		}
		
		Node last = head;
		for(int i = 0; i < n; i++)
		{
			while(last.next != head)
			{
				last = last.next;
			}
			temp = new Node();
			last.next = temp;
			
			temp.prev = last;
			
			temp.next = head;
			
			head.prev = temp;
			
			setNodeCount(getNodeCount()+1);
			
			temp.number = getNodeCount()+1;
		}
		
	}
	
	public int deleteFirst()
	{
		
		Node temp = head;
		
		int deleted = temp.number;
		
		if(isEmpty())
		{
			deleted = getNodeCount();
		}
		else
		{
			head.next = head.next.next;
			head = head.next;
			head.prev = null;
			
			setNodeCount(getNodeCount() - 1);
		}
		
		return deleted;
	}
	
	public int deleteAt(int position)
	{
		Node current = head;
		Node previous = head;
		int deleted;
		for(int i = 0; i < position; i++)
		{
			if(current.next == null)
			{
				current = head;
			}
			else
			{
				previous = current;
				current = current.next;
			}
		}
		deleted = current.number;
		if (position == 0)
		{
			deleteFirst();
		}
		else
		{
			previous = current.next;
		}
		setNodeCount(getNodeCount() - 1);
		return deleted;
	}
	public int getNodeCount() {
		return nodeCount;
	}
	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
	
}
