package sjsu.lu.cs146.project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrisonerGameTest {

	@Test
	public void testWinFreedom() {
		fail("Not yet implemented");
	}

	@Test
	public void test() 
	{
		
	      linkedList prisoners=new linkedList();

	      assertTrue(prisoners.isEmpty()); //before inserting, list is empty

	      assertEquals(0, prisoners.getNodeCount()); // Size is 0

	      assertFalse(prisoners.isEmpty()); // after inserting element, list is not empty

	     assertEquals(1,prisoners.getNodeCount()); //size is 1
	}
	
}
