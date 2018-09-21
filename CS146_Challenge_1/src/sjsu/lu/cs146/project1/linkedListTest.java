package sjsu.lu.cs146.project1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test class with JUnit test cases to
 * cover a circular doubly linked test class
 * @author janice_lu
 *
 */
public class linkedListTest {
	
	/**
	 * A function to test if the linked list is empty.
	 */
	@Test
	public void testIsEmpty() {
		//Initialize a new class object to test
		linkedList prisoners = new linkedList();
		//before inserting, list is empty
		assertTrue(prisoners.isEmpty()); 
		//Size is 0
		assertEquals(0, prisoners.getNodeCount());
		//add a node to the linked list
		prisoners.insert(1);
		//after inserting, list is not empty
		assertFalse(prisoners.isEmpty()); 
	} 
   
	/**
	 * A function to test if a node can be
	 * inserted succesfully via insert function.
	 * Since size only increases with insert function, 
	 * we may use getNodeCount() to check if it is 
	 * successfully added to the linked list.
	 */
	@Test
	public void testInsert() {
		//Initialize a new class object to test
		linkedList prisoners = new linkedList();
		//Insert 5 nodes
		prisoners.insert(5);
		//size is 5
		assertEquals(5, prisoners.getNodeCount());
		//insert 2 nodes
		prisoners.insert(2);
		//after insert, total size is 7
		assertEquals(7, prisoners.getNodeCount());
	}
  
	/**
	 * A function to test if the node specified
	 * has been deleted.
	 */
	@Test
	public void testDeleteAt() {
		//Initialize a new class object to use
		linkedList prisoners = new linkedList();
		//insert 5 nodes
		prisoners.insert(5);
		//check size is 5
		assertEquals(5, prisoners.getNodeCount()); 
		/**
		 * asserts below check deleteAt function and
		 * their expected results
		 */
		assertEquals(4, prisoners.deleteAt(4));
		
		assertEquals(5, prisoners.deleteAt(5));
		
		assertEquals(2, prisoners.deleteAt(2));
		
		assertEquals(3, prisoners.deleteAt(3)); 
		
		assertEquals(1, prisoners.deleteAt(1));
		//tests return 0 function 
		assertEquals(0, prisoners.deleteAt(1));
	}

}
