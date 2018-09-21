package sjsu.lu.cs146.project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class linkedListTest {

	@Test
	public void testIsEmpty() {
		linkedList prisoners = new linkedList();
		assertTrue(prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, prisoners.getNodeCount());
		prisoners.insert(1);
		assertFalse(prisoners.isEmpty()); //after inserting, list is not empty
	}  
   
	@Test
	public void testInsert() {
		linkedList prisoners = new linkedList();
		prisoners.insert(5);
		assertEquals(5, prisoners.getNodeCount());
		prisoners.insert(2);
		assertEquals(7, prisoners.getNodeCount());
	}
	
/*	@Test
	public void testDeleteFirst() {
		linkedList prisoners = new linkedList();
		linkedList otherPrisoners = new linkedList();
		assertTrue(otherPrisoners.isEmpty());
		prisoners.insert(5);
		assertEquals(5, prisoners.getNodeCount());
		assertEquals(1, prisoners.deleteFirst());
		assertEquals(4, prisoners.getNodeCount());
		assertEquals(0, otherPrisoners.deleteFirst());
		assertEquals(2, prisoners.deleteFirst());		
		assertEquals(3, prisoners.getNodeCount());
		assertEquals(3, prisoners.deleteFirst()); 
		assertEquals(2, prisoners.getNodeCount());
		assertEquals(4, prisoners.deleteFirst());
		assertEquals(1, prisoners.getNodeCount());  
		assertEquals(5, prisoners.deleteFirst());
		assertEquals(0, prisoners.getNodeCount());
		assertEquals(0, prisoners.deleteFirst());
	} */
  
	@Test
	public void testDeleteAt() { 
		linkedList prisoners = new linkedList();
		prisoners.insert(5);
		assertEquals(5, prisoners.getNodeCount()); 
		assertEquals(4, prisoners.deleteAt(4));
		assertEquals(5, prisoners.deleteAt(5));
		assertEquals(1, prisoners.deleteAt(1));
	}

}
