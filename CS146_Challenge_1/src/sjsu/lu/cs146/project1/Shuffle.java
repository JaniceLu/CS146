package sjsu.lu.cs146.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *  The purpose of this program is to take in a file 
 *  containing a list of songs and place 
 *  them in an array to be shuffled according 
 *  to the Fisher-Yates shuffle algorithm. 
 *  @author janice_lu
 */
public class Shuffle
{
	//a String array to hold the songs from the original file
	public String[] originalSongOrder;
	
	//Pseudo-random number to be used for Fisher-Yates shuffle
    private Random r = new Random();
    
    //String to put song name into for inserting into String array
	private String songName;
	
    //integer for iterating String array
    int i;
    
	/**
	 * This method takes a file and takes each line and inserts
	 * it into a String array.
	 * @return a String array with all the songs from the file
	 * @throws IOException 
	 */
   public String[] songToArray() throws IOException 
   {
	   
	   //input stream that reads in info from playlist.txt
	   BufferedReader In = new BufferedReader (new FileReader("Playlist.txt"));
	   
	   while((songName = In.readLine()) != null)
	   {
		   originalSongOrder[i] = songName;
		   i++;
	   }
	   
	   In.close();
	   
	   return originalSongOrder;
   }
   
   /**
    * This method takes a String and shuffles the songs based on the
    * Fisher-Yates shuffle algorithm and puts the shuffled songs into 
    * a new file.
    * @throws IOException if file cannot be created
    */
   public void shuffleSongs() throws IOException
   {
       
	   r.setSeed(20);
       
       /*
        * For loop is shuffle the String array according to the Fisher-Yates
        * algorithm. It uses the seeded pseudorandom number as the index to be 
        * swapped with the current iteration of the array.
        * 
        */
       for(int i = originalSongOrder.length - 1; i > 0; i--)
       {
    	   int index = r.nextInt(i);
    	   String currentSong = originalSongOrder[index];
    	   originalSongOrder[index] = originalSongOrder[i];
    	   originalSongOrder[i] = currentSong;
       }
       
       //A stream to write the newly shuffled playlist to the file
       BufferedWriter writeToFile = null;
       
       writeToFile = new BufferedWriter(new FileWriter("LuJanicePLaylist.txt"));
   
       for(int j = 0; j < originalSongOrder.length; j++)
       {
    	   writeToFile.write(originalSongOrder[j]);
    	   writeToFile.newLine();
       }
       
       writeToFile.flush();
       writeToFile.close();
   }
   
   /**
    * A constructor for the class
    */
   Shuffle()
   {
	   originalSongOrder = new String[458];
	   songName = "";
	   i = 0;
   }
}
