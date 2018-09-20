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

	@Test
	public void testDeleteFirst() {
		linkedList prisoners = new linkedList();
		linkedList otherPrisoners = new linkedList();
		prisoners.insert(5);
		assertEquals(5, prisoners.getNodeCount());
		assertEquals(1, prisoners.deleteFirst());
		assertEquals(2, prisoners.deleteFirst());
		assertEquals(0, otherPrisoners.deleteFirst());
		
	}

	@Test
	public void testDeleteAt() {
		fail("Not yet implemented");
	}

}
