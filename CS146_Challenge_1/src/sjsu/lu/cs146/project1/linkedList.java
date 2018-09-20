package sjsu.lu.cs146.project1;


public class linkedList {
	Node head;
	int nodeCount;
	
	linkedList() {
		head = null;
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
			
			temp.number = getNodeCount();
		}
		
	}
	
	public int deleteFirst() {
		
		Node temp = head;
		
		int deleted;
		
		int currentSize = getNodeCount();
		if(temp == null)
		{
			deleted = 0;
		}
		else if(currentSize == 1) 
		{
			deleted = head.number;
			
			head.prev = null;
			
			head.next = null;
			
			head = null;
			
			temp = null;
			
			setNodeCount(getNodeCount() - 1);
			
		}
		else
		{
			Node previous = head.prev;
			deleted = head.number;
			
			previous.next = head.next;
			
			head = temp.next;
			
			head.prev = previous;
			
			head.next = temp.next.next;
			
			temp = null;
			
			setNodeCount(getNodeCount() - 1);
		}
		System.out.println("Delete at " + deleted);
		return deleted;
	}
	
	public int deleteAt(int position) {
		if(head == null) {
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
			System.out.println("delete elsewhere");
			System.out.println("previous: " + previous.number);
			System.out.println("previous.prev: " + previous.prev.number);
			System.out.println("previous.next: " + previous.next.number);
			previous.next = current.next;
			current = current.next;
			current.prev = previous;
			System.out.println("current.number: " + current.number);
			System.out.println("current.prev: " + current.prev.number);
			System.out.println("current.next: " + current.next.number);
			setNodeCount(getNodeCount() - 1);
			System.out.println("size of linkedlist: " + getNodeCount());
			return deleted;
		}
	}
	
	public int getNodeCount() {
		return nodeCount;
	}
	
	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
	
	public int checkNodes() {
		
		if(head == null) {
			return 0;
		}
		
		Node temp = head;
		
		int count = 1;
		
		if(temp.next == head) {
			return count;
		}
		
		while(temp.next != head)
		{
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
}
