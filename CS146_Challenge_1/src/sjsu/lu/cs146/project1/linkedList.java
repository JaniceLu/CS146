package sjsu.lu.cs146.project1;


public class linkedList {
	Node head;
	Node tail;
	int nodeCount;
	
	linkedList() {
		head = null;
		tail = null;
		nodeCount = 0;
	} 
	  
	public boolean isEmpty() {

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
	
	public void insert(int n) {
		Node temp;
		
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
			head.number = 1;
			
			setNodeCount(getNodeCount() + 1);
			n = n - 1;
		}
		
		Node last = head;
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
	
	public int deleteAt(int position) {
		Node current = head;
		Node previous = head.prev;
		int deleted;
		while(current.number != position)
		{
			current = current.next;
			previous = previous.next;
		} 
		deleted = current.number;
		if(deleted == head.number)
		{
			head = head.next;
			head.prev = previous;
			tail.next = head;
		}
		else if(deleted == tail.number)
		{
			tail = tail.prev;
		}
		previous.next = current.next; 
		current = current.next;
		current.prev = previous;
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
