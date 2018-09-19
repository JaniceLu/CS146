/**
 *  The purpose of this program is to take in a file 
 *  containing a list of songs and place 
 *  them in an array to be shuffled according 
 *  to the Fisher-Yates shuffle algorithm. 
 *  @author janice_lu
 */
package sjsu.lu.cs146.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author janice_lu
 *
 */
public class ShuffleTest
{
   //instance of class object to be used in JUnit test
   Shuffle shuffleTester;
   
   //to be used in JUnit test to check test output
   String expectedLine, actualLine;
   
   //string array to hold songs from playlist
   String[] originalPlaylist = new String[256];
   
   //to be used for iterating through indexes in tests
   int i;
   
   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception
   {
      shuffleTester = new Shuffle();
   }

   /**
    * Test method for {@link sjsu.lu.cs146.project1.Shuffle#songToArray()}.
    * @return No message if all songs have been transferred correctly.
    *         AssertionError if a song has been not transferred correctly from the file
    * @throws IOException 
    */
   @Test
   public void testSongToArray() throws IOException
   {
      fail("Not yet implemented"); // TODO
      BufferedReader In = new BufferedReader (new FileReader ("Playlist.txt"));
      while ((expectedLine = In.readLine()) != null) 
      {
         String actualLine = originalPlaylist[i];
         assertEquals(expectedLine, actualLine);
         i++;
      }
      In.close();
   }

   /**
    * Test method for {@link sjsu.lu.cs146.project1.Shuffle#shuffleSongs()}.
    * Tests the output of the newly shuffled playlist.
    * @return no message if all lines in both files match, 
    *         AssertionError if any of the lines do not match
    * @throws IOException
    */
   @Test
   public void testShuffleSongs() throws IOException
   {
      fail("Not yet implemented"); // TODO
      BufferedReader Out = new BufferedReader (new FileReader ("Playlist.txt"));
      BufferedReader In = new BufferedReader (new FileReader ("Target1.txt"));
      while ((expectedLine = In.readLine()) != null) 
      {
         String actualLine = Out.readLine();
         assertEquals(expectedLine, actualLine);
      }
      Out.close();
      In.close();
   }

}