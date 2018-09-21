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
		PrisonerGame game = new PrisonerGame();
		
		int prisonerCount = 123456;
		
		int elimFactor = 2;
		 
		assertTrue(game.prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, game.prisoners.getNodeCount()); // Size is 0

		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
  
		assertFalse(game.prisoners.isEmpty()); // after inserting element, list is not empty
		assertEquals(123456, game.prisoners.getNodeCount());
		assertEquals(1, game.winFreedom(elimFactor)); 
		
	}
	
	@Test
	public void test2PrisonerGame()  
	{
		PrisonerGame game = new PrisonerGame();
		int prisonerCount = 1; 
		int elimFactor = 9;  
		assertTrue(game.prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, game.prisoners.getNodeCount()); // Size is 0

		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
  
		assertFalse(game.prisoners.isEmpty()); // after inserting element, list is not empty
		assertEquals(1, game.prisoners.getNodeCount());
		assertEquals(1, game.winFreedom(elimFactor));
	}  
	@Test  
	public void test3PrisonerGame() 
	{
		fail("Takes too long to test");
		PrisonerGame game = new PrisonerGame();
		 
		int prisonerCount = 1234567;
		
		int elimFactor = 7; 
		 
		assertTrue(game.prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, game.prisoners.getNodeCount()); // Size is 0

		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
  
		assertFalse(game.prisoners.isEmpty()); // after inserting element, list is not empty
      //  assertEquals(1234567, game.prisoners.getNodeCount());
		assertEquals(4, game.winFreedom(elimFactor));
		
	}
	
	@Test
	public void test4PrisonerGame()
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
	@Test
	public void test5PrisonerGame()
	{
		PrisonerGame game = new PrisonerGame();
		 
		int prisonerCount = 12345;
		
		int elimFactor = 1; 
		 
		assertTrue(game.prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, game.prisoners.getNodeCount()); // Size is 0

		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
  
		assertFalse(game.prisoners.isEmpty()); // after inserting element, list is not empty
        assertEquals(12345, game.prisoners.getNodeCount());
		assertEquals(3, game.winFreedom(elimFactor));	
	}
	
	@Test
	public void test6PrisonerGame()
	{
		PrisonerGame game = new PrisonerGame();
		 
		int prisonerCount = 6;
		
		int elimFactor = 2; 
		 
		assertTrue(game.prisoners.isEmpty()); //before inserting, list is empty
		assertEquals(0, game.prisoners.getNodeCount()); // Size is 0

		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
  
		assertFalse(game.prisoners.isEmpty()); // after inserting element, list is not empty
        assertEquals(6, game.prisoners.getNodeCount());
		assertEquals(1, game.winFreedom(elimFactor));	
	} 
} 
