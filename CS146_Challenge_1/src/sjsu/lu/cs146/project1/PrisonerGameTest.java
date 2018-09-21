package sjsu.lu.cs146.project1;

import static org.junit.Assert.*;


import org.junit.Test;
/**
 * This class is used to test the PrisonerGame class
 * @author janice_lu
 */
public class PrisonerGameTest {

	/**
	 * A function to test inserting prisoners 
	 * into the linked list.
	 */
	@Test
	public void testBringPrisoners()
	{
		//Initializes a new class object to test
		PrisonerGame game = new PrisonerGame();
		//sets an amount of prisoners to add to the linked list
		int prisonerCount = 5;
		//sets how many prisoners were added to the linked list
		int results = game.bringPrisoners(prisonerCount);
		//after added prisoners, check to see if correct amount of prisoners are added
		assertEquals(prisonerCount, results);
	}

	/**
	 * A function to test the Prisoner Game with 
	 * n = 123456 and k = 2
	 */
	@Test
	public void test1PrisonerGame() 
	{
		//Initializes a new class object to test
		PrisonerGame game = new PrisonerGame();
		//sets an amount of prisoners to add to the linked list
		int prisonerCount = 123456;
		//sets the factor at which prisoners are deleted from the linked list
		int elimFactor = 2;
		//before inserting, list is empty
		assertTrue(game.prisoners.isEmpty());
		//Size is 0
		assertEquals(0, game.prisoners.getNodeCount());
		//Size is 123456
		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
		// after inserting element, list is not empty
		assertFalse(game.prisoners.isEmpty());
		//check if there are 123456 nodes
		assertEquals(123456, game.prisoners.getNodeCount());
		//test if winner is in position 1
		assertEquals(1, game.winFreedom(elimFactor)); 
		
	}
	
	/**
	 * A function to test the Prisoner Game with
	 * n = 1 and k = 9
	 */
	@Test
	public void test2PrisonerGame()  
	{
		//Initializes a new class object to test
		PrisonerGame game = new PrisonerGame();
		//Sets an amount of prisoners to add to the linked list
		int prisonerCount = 1; 
		//The factor at which prisoners are deleted from the linked list
		int elimFactor = 9;  
		//Before inserting, list is empty
		assertTrue(game.prisoners.isEmpty());
		//Size is 0
		assertEquals(0, game.prisoners.getNodeCount());
		//Size is 1
		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
		//After inserting element, list is not empty
		assertFalse(game.prisoners.isEmpty());
		//Size is 1
		assertEquals(1, game.prisoners.getNodeCount());
		//Returns true
		assertEquals(1, game.winFreedom(elimFactor));
	}  
	
	/**
	 * A function to test the Prisoner Game
	 * with n = 1234567 and k = 7
	 */
	@Test  
	public void test3PrisonerGame() 
	{
		fail("Takes too long to test");
		//Initializes a new class object to test
		PrisonerGame game = new PrisonerGame();
		//Sets an amount of prisoners to add to the linked list
		int prisonerCount = 1234567;
		//the factor at which prisoners are deleted from the linked list
		int elimFactor = 7; 
		//before inserting, list is empty
		assertTrue(game.prisoners.isEmpty());
		//Size is 0
		assertEquals(0, game.prisoners.getNodeCount());
		//Size is 1234567
		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
		//After inserting element, list is not empty
		assertFalse(game.prisoners.isEmpty());
		//Size is 1234567
        assertEquals(1234567, game.prisoners.getNodeCount());
        
		assertEquals(4, game.winFreedom(elimFactor));
		
	}
	
	/**
	 * A function to test the Prisoner Game
	 * with n = 12 and k = 8
	 */
	@Test
	public void test4PrisonerGame()
	{
		//Initializes a new class object to test
		PrisonerGame game = new PrisonerGame();
		//amount of prisoners in the linked list
		int prisonerCount = 12;
		//the factor at which prisoners are deleted from the linked list
		int elimFactor = 8; 
		//before inserting, list is empty 
		assertTrue(game.prisoners.isEmpty()); 
		//Size is 0
		assertEquals(0, game.prisoners.getNodeCount()); 
		//size is 12
		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
		//After inserting element, list is not empty
		assertFalse(game.prisoners.isEmpty()); 
		//Size is 12
        assertEquals(12, game.prisoners.getNodeCount());
        //returns true
		assertEquals(2, game.winFreedom(elimFactor));	
	}
	
	/**
	 * A function to test the Prisoner Game
	 * with n = 12345 and k = 1
	 */
	@Test
	public void test5PrisonerGame()
	{
		//Initializes a new class object to test
		PrisonerGame game = new PrisonerGame();
		//amount of prisoners in the linked list
		int prisonerCount = 12345;
		//the factor at which prisoners are deleted from the linked list 
		int elimFactor = 1; 
		//before inserting, list is empty
		assertTrue(game.prisoners.isEmpty());
		//Size is 0
		assertEquals(0, game.prisoners.getNodeCount()); 
		//size is 12345
		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
		//After inserting element, list is not empty
		assertFalse(game.prisoners.isEmpty()); 
		//size is 12345
        assertEquals(12345, game.prisoners.getNodeCount());
        //returns false
		assertEquals(3, game.winFreedom(elimFactor));	
	} 
	
	/**
	 * A function to test the Prisoner Game
	 * with n = 6 and k = 2
	 */
	@Test
	public void test6PrisonerGame()
	{
		//Initializes a new class object to test
		PrisonerGame game = new PrisonerGame();
		//amount of prisoners in the linked list 
		int prisonerCount = 6;
		//the factor at which prisoners are deleted from the linked list
		int elimFactor = 2; 
		 //before inserting, list is empty
		assertTrue(game.prisoners.isEmpty()); 
		// Size is 0
		assertEquals(0, game.prisoners.getNodeCount()); 
		//size is 6
		assertEquals(prisonerCount, game.bringPrisoners(prisonerCount));
		//after inserting element, list is not empty
		assertFalse(game.prisoners.isEmpty()); 
		//size is 6
        assertEquals(6, game.prisoners.getNodeCount());
        //return true
		assertEquals(1, game.winFreedom(elimFactor));	
	} 
} 
