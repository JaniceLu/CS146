package sjsu.lu.cs146.project1;


public class linkedList {
	private Node head;
	private int nodeCount;
	
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
			System.out.println("We have "+n+" nodes more to create.");
			System.out.println("node with number: " + temp.number+"\n");
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
			System.out.println("node with number: " + temp.number+"\n");
		}
		
	}
	
	public int deleteFirst() {
		
		Node temp = head;
		
		int deleted;
		
		int current_size = getNodeCount();
		
		if(temp == null)
		{
			deleted = 0;
		}
		else if(current_size == 1) 
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
			
			head = temp.next;
			
			head.prev = temp.prev;
			
			head.next = temp.next.next;
			
			previous.next = head;
			
			previous.prev = head;
			
			setNodeCount(getNodeCount() - 1);
		}
		
		return deleted;
	}
	
	public int deleteAt(int position) {
		if(head == null) {
			return 0;
		}
		Node current = head;
		Node previous = head.prev;
		int deleted;
		System.out.println("At beginning of function: "+ current.number);
		for(int i = 0; i < position-1; i++)
		{
			current = current.next;
			previous = previous.next;
			System.out.println(current.number);
		}
		System.out.println("Previous is: " + previous.number + "\nCurrent is: "+ current.number +"\n");
		deleted = current.number;
		if (current == head)
		{
			deleteFirst();
		}
		else
		{
			previous.next = current.next;
			current.next = null;
			current.prev = null;
			setNodeCount(getNodeCount() - 1);
		}
		System.out.println("Deleted "+ deleted +". There are " + getNodeCount() + " node(s) left.");
		return deleted;
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
