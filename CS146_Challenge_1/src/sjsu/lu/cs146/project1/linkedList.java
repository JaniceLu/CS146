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
	
	public int deleteFirst() {
		
		Node temp = new Node();
		 
		int deleted;
		
		
		if((head == null) && (tail == null))
		{
			deleted = 0;
		}
		else if((head == tail) && (getNodeCount() == 1)) 
		{
			deleted = head.number;
			
			head.prev = null;
			
			head.next = null; 
			
			head = null;
			
			tail.prev = null;
			
			tail.next = null;
			
			tail = null;
			
			setNodeCount(getNodeCount() - 1);
		}
		else if((head == tail) && (getNodeCount() == 2))
		{
			tail.next = tail;
			tail.prev = tail;
			deleted = head.number;
			head = tail;
			head.next = tail;
			head.prev = tail;
			
			setNodeCount(getNodeCount() - 1);
		}
		else 
		{
			temp = head.next;
			tail.next = head.next; 
			deleted = head.number;
			head = tail.next; 
			head.prev = tail;
			head.next = temp;
						
			setNodeCount(getNodeCount() - 1);
		}
		return deleted;
	}
	
	public int deleteAt(int position) {
		if((head == null) && (tail == null)) 
		{
			return 0;
		}
		Node current = head;
		Node previous = head.prev;
		int deleted;
		System.out.println("head: "+ current.number);
		while(current.number != position)
		{
			current = current.next;
			previous = previous.next;
		}
		deleted = current.number;
		System.out.println("Delete at " + deleted);
		if (current == head)
		{
			System.out.println("delete @ head");
			return deleteFirst();   
		}
		else
		{ 
			previous.next = current.next; 
			current = current.next;
			current.prev = previous;
			setNodeCount(getNodeCount() - 1);
			return deleted;
		}
	}
	
	public int getNodeCount() {
		return nodeCount;
	}
	
	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
	
}
