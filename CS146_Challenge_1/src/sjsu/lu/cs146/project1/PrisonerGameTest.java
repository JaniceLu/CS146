package sjsu.lu.cs146.project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrisonerGameTest {

	@Test
	public void testBringPrisoners()
	{
		PrisonerGame game = new PrisonerGame();
		int prisonerCount = 5;
		int results = game.bringPrisoners(prisonerCount);
		assertEquals(prisonerCount, results);
	}

	@Test
	public void test1PrisonerGame() 
	{
		fail("oops");
		PrisonerGame game = new PrisonerGame();
		
		int prisonerCount = 1;
		
		int elimFactor = 9;
		
		assertTrue(game.prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, game.prisoners.getNodeCount()); // Size is 0

		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
  
		assertFalse(game.prisoners.isEmpty()); // after inserting element, list is not empty
  
		assertEquals(1, game.winFreedom(elimFactor));
		
	}
	
	@Test
	public void test2PrisonerGame() 
	{
		PrisonerGame game = new PrisonerGame();
		
		int prisonerCount = 12;
		
		int elimFactor = 8;
		
		assertTrue(game.prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, game.prisoners.getNodeCount()); // Size is 0

		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
  
		assertFalse(game.prisoners.isEmpty()); // after inserting element, list is not empty
        assertEquals(12, game.prisoners.getNodeCount());
		assertEquals(2, game.winFreedom(elimFactor));
		
	}
	
}
