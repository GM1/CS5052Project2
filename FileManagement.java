import javax.swing.*; 
import java.util.Scanner;
import java.io.*;

public class FileManagement
{

	/**
	*
	* checkDataFilePopulated()
	* 
	* A method to check if Users.txt file is populated...
	* Is passed no value but returns a boolean - validate
	* @IOException
	*
	*/
	

	public static boolean checkDataFilePopulated() throws IOException
	{
		boolean hasData = true; 
		
		File LoginDetails = new File("Users.txt");
		System.out.println(LoginDetails.length());
			
		if (LoginDetails.length() == 0)
			hasData = false;
		
		return hasData;
	}

}