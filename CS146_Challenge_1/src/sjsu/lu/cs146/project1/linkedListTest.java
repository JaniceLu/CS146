package sjsu.lu.cs146.project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class linkedListTest {

	@Test
	public void testIsEmpty() {
		linkedList prisoner = new linkedList();
		assertTrue(prisoner.isEmpty()); //before inserting, list is empty
		assertEquals(0, prisoner.getNodeCount());
	}

	@Test
	public void testAdd() {
		linkedList prisoner = new linkedList();
		prisoner.add(1);
		assertEquals(1, prisoner.getNodeCount());
	}

	@Test
	public void testDeleteFirst() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAt() {
		fail("Not yet implemented");
	}

}
