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
		boolean t = true;
		boolean f = false;
		int result = getNodeCount();
		if(result != 0 || result == null)
		{
			return f;
		}
		else 
		{
			return t;
		}
	}
	
	public void add(int n)
	{
		setNodeCount(getNodeCount() + 1);
		Node temp = new Node(n);
		if(head == null) 
		{
			head = temp;
		}
		else
		{
			Node newNode = head;
			while(newNode.next != head)
			{
				newNode = newNode.next;
			}
			temp.next = head;
		}
	}
	
	public int deleteFirst()
	{
		
		Node temp = head;
		
		int deleted = temp.info;
		
		if(isEmpty())
		{
			return deleted;
		}
		else
		{
			
			head = head.next;
			
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
		deleted = current.info;
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
