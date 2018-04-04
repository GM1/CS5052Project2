import java.util.regex.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class Validate
{

	public static boolean checkEmail(String email)
	{
		boolean checkEmail = false;
		
		//String pattern = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}";
		
		Pattern valid_email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = valid_email.matcher(email);
        checkEmail = matcher.find();
		
		System.out.println("Email string passed to method = " + email + "\nThe value of checkEmail = " + checkEmail);
		
		return checkEmail;
			
	
	}
	
	/**
*
* uniqueEmail()
* A method for checking a user name is unique during registration of a new user
* The method is passed a String email from the method RegisterUser()
* and returns a boolean - validate
* @IOException
*
*/
	public static boolean uniqueEmail(String email) throws IOException
	{
		boolean validate = true;
		String loginDetails[];
		String temp; 
		int check = 0;
		int userNo = 0;
		
			File LoginDetails = new File("Users.txt");
			
			FileReader fr = new FileReader("Users.txt");
			
			Scanner in = new Scanner(fr);
			
			if (LoginDetails.length() !=0)
			{
					do
					{
						temp = in.nextLine();
					
						loginDetails = temp.split(",");
					
						if (loginDetails[1].equals(email))
							{check = 1; validate = false;}
					}
					while (!(check==1) && in.hasNext());
		
			}
			
			
			else{JOptionPane.showMessageDialog(null, "No records found in the user database.","",JOptionPane.INFORMATION_MESSAGE);}
			
			in.close();
			
			return validate;
			
	}
	
	public static int returnUserType(String email)
	{
		
		
		String loginDetails[];
		String temp; 
		int check = 0;
		int userType = 0;
		
			File LoginDetails = new File("Users.txt");
			try{
			FileReader fr = new FileReader("Users.txt");
			
			Scanner in = new Scanner(fr);
			
			if (LoginDetails.length() !=0)
			{
					do
					{
						temp = in.nextLine();
					
						loginDetails = temp.split(",");
					
						if (loginDetails[1].equals(email) && loginDetails[3].equals("Admin"))
							{check = 1; userType = 1;}
							
					}
					while (!(check==1) && in.hasNext());
		
			}
			
			
			else{JOptionPane.showMessageDialog(null, "Regular user.","",JOptionPane.INFORMATION_MESSAGE);}
			
			in.close();
			}
			catch (FileNotFoundException fne)
			{fne.printStackTrace();}
			
			return userType; // userType == 1 if the user is an Admin, returns 0 if a normal user...
		
	}

}