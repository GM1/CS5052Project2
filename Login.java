
/**
*
* Login.java
* A class containing the Login method and others necessary for initiating the program
* @IOException
* @InterruptedException
* @Author Gearoid Mahon
*/

	
import javax.swing.*; 
import java.util.Scanner;
import java.io.*;


public class Login{
	
	
	
	/**
	*
	* main()
	* Main method for Login class 
	* The method calls other methods in the class depending on the sequence of user inputs
	* @IOException
	* @InterruptedException
	*
	*/
	
	public static int currentLineNumber; 
	public static boolean dataFilePopulated; 
	public static int userType;
	
	public static void main (String[] args) throws IOException, InterruptedException
	{
		dataFilePopulated = FileManagement.checkDataFilePopulated();
	
		int check = 0; 
		
		if (dataFilePopulated == true)
		{
			//__________________________________________________________________________
			//Prompts user, registered or not?
			do
				{
					
					int choice = JOptionPane.showOptionDialog(null,
					"Login?",
					"Welcome",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,null,null);
				
				
					if (choice == JOptionPane.YES_OPTION)
							{check =1;Login(check);}
						 
					else	{/*check =2;Login(check);*/
								check =3;
								System.out.println("The program will terminate at this point...");
							}
					
				}
				
			while (check == 0);
		}
		
		else if (dataFilePopulated== false)
		{
			int choice = JOptionPane.showOptionDialog(null,
					"No registered users in the database\n\nWould you like to register as an Administrator?\nThe first user is registered as the Administrator.",
					"Welcome",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,null,null);
			
			if (choice == JOptionPane.YES_OPTION)
							{RegisterUser();} 	
					else	{JOptionPane.showMessageDialog(null, "The program will terminate","",JOptionPane.INFORMATION_MESSAGE);}
		}
		
			

	}

/**
*
*	Login()
*	Login method - checks if the user is existing or not and allows for user registration or login
*   Method is passed the integer check - determined by user input in main
*	@IOException
*	@InterruptedException
*
*/


	public static void Login(int check) throws IOException, InterruptedException

	{
		String email, passWord; 
		String registered;
		JTextField userNom = new JTextField(30);
		JTextField userPass = new JTextField(30);
		
		
				if (check == 1)	//This is an existing user
					{
							
							JPanel loginPanel = new JPanel();
							loginPanel.add(new JLabel("Email:"));
							loginPanel.add(userNom);
								
							loginPanel.add(new JLabel("Password:"));
							loginPanel.add(userPass);
							
							
							
							boolean checker = false; 
							
							int i =0;
						do{
							
							int result = JOptionPane.showConfirmDialog(null, loginPanel, "Administrator Login: Please enter your Email and password.", JOptionPane.OK_CANCEL_OPTION);
						 
							if (result == JOptionPane.OK_OPTION) 
							{
								 email = (userNom.getText()).trim();
								 passWord = (userPass.getText()).trim();
								 
								
								
								 if (checkUserDetails(email,passWord)== true && (email.length() != 0) && (passWord.length()!=0))
									 {
										JOptionPane.showMessageDialog(null, "You are now logged in.","",JOptionPane.INFORMATION_MESSAGE);
										
										userType = Validate.returnUserType(email);
										if (userType == 1)
											MenuDriver.menuTypeSelector(1);
										else{MenuDriver.menuTypeSelector(0);}
										checker = true; 
										
									  }
								 
								 else{JOptionPane.showMessageDialog(null, "User details not found...\nTry again","",JOptionPane.INFORMATION_MESSAGE); i++; }
								 
								 if (i == 3)
									 {JOptionPane.showMessageDialog(null, "You've reached the maximum number of login attempts.\nThe program will terminate.","",JOptionPane.INFORMATION_MESSAGE);
									 checker = true;}
							}
							
							else if(result == JOptionPane.OK_CANCEL_OPTION)
								{checker = true;}
								
						}
						
							while(checker == false);
					}
					
				else if (check == 2) //The admin wishes to register a new user...
				{
					
					int choice = JOptionPane.showOptionDialog(null,
					"Would you like to register a new user?\nRequired: Valid email address, password autogenerated...",
					"Registration",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,null,null);
					
					
					if (choice == JOptionPane.YES_OPTION)
						{
							JOptionPane.showMessageDialog(null, "You'll now be registered","Registration",JOptionPane.INFORMATION_MESSAGE);
							RegisterUser();
						} 	
						
					else{JOptionPane.showMessageDialog(null, "The program will terminate","",JOptionPane.INFORMATION_MESSAGE);}
					
				}
		
		
		else {
				JOptionPane.showMessageDialog(null, "No existing users in the database.\n" + "You'll now be registered...","",JOptionPane.INFORMATION_MESSAGE);
		
				RegisterUser();	
		
			}
			
				
		}

/**
*
* checkUserDetails()
* This method checks if the details an existing user entered, to login, are valid, gets the admin number and writes to an admin header file
* The method is passed the strings: String Email and String passWord and returns a Boolean - validate when called.
* @IOException
*
*/


	public static boolean checkUserDetails(String email, String passWord) throws IOException
		
	{
		boolean validate = false;
		String loginDetails[];
		String temp; 
		int check = 0;
		int userNo = 0;
		
			File LoginDetails = new File("Users.txt");
			
			FileReader fr = new FileReader("Users.txt");
			
			Scanner in = new Scanner(fr);
			
			if (LoginDetails.length() !=0 && email.length() != 0)
			{
					do
					{
						temp = in.nextLine();
						
						loginDetails = temp.split(",");
					
						if (loginDetails[1].equals(email) && loginDetails[2].equals(passWord))
							{check = 1;		validate = true;	userNo = Integer.parseInt(loginDetails[0]);}
					}
					while (!(check==1) && in.hasNext());
					
			
					
			}
			
			
			else{JOptionPane.showMessageDialog(null, "No records found in the user database.","",JOptionPane.INFORMATION_MESSAGE);}
			
			in.close();
			
		
		
		
		return validate;
		
	}

//End of Login method.

//

/**
*
* RegisterUser()
* A method for registering new users...
* Is passed no value and returns nothing
* @IOException
* @InterruptedException
*
*/

	public static void RegisterUser() throws IOException,InterruptedException
	{
			
			File LoginDetails = new File("Users.txt");
			
			FileReader fr = new FileReader("Users.txt");
			
			LineNumberReader lnr = new LineNumberReader(fr);
			
			lnr.skip(Long.MAX_VALUE);
			
			
			//System.out.println("Number of Lines = " + lnr.getLineNumber());
		
			String email,passWord;
			
			JTextField userNom = new JTextField(30);
			JTextField userPass = new JTextField(30);
		
			JPanel RegisterPanel = new JPanel();
			RegisterPanel.add(new JLabel("Email Address:"));
			RegisterPanel.add(userNom);
			//loginPanel.add(Box.createVerticalStrut(30)); //Spacer?
							
			RegisterPanel.add(new JLabel("Password:"));
			RegisterPanel.add(userPass);
						
			boolean checker = false; 
						
			int i =0;
					do{
						
						int result = JOptionPane.showConfirmDialog(null, RegisterPanel, "Registration: Please enter your chosen Email and password"
						, JOptionPane.OK_CANCEL_OPTION);
					 
						if (result == JOptionPane.OK_OPTION) 
						{
							 email = (userNom.getText()).trim();
							 passWord = (userPass.getText()).trim();
						
						//if (lnr.getLineNumber() > 1) 	 
						
								boolean validate = Validate.uniqueEmail(email);
								boolean checkEmail = Validate.checkEmail(email);
								 if (validate == false || checkEmail == false)
								 {
									 System.out.println("Entered if statement");
									 
									 if (checkEmail == false)
										JOptionPane.showMessageDialog(null, "Enter a correctly formatted email address","",JOptionPane.INFORMATION_MESSAGE);
									 
									 else if ((email.length() == 0) || (passWord.length() == 0))
										JOptionPane.showMessageDialog(null, "Neither Email address nor password fields may be empty...","",JOptionPane.INFORMATION_MESSAGE);
									 
									 if (email.length() != 0 && passWord.length() != 0)
										JOptionPane.showMessageDialog(null, "This Email exists already. Try again","",JOptionPane.INFORMATION_MESSAGE);
								
								}
								
						
							 else if (validate == true && (email.length() != 0) && (passWord.length() != 0))
								{
									JOptionPane.showMessageDialog(null, "Creating new user","",JOptionPane.INFORMATION_MESSAGE);checker = true;
								
									currentLineNumber = lnr.getLineNumber();	
							 
								try{
									
									FileWriter fw = new FileWriter("Users.txt", true);
									PrintWriter pw = new PrintWriter(fw);
									
									if (!dataFilePopulated)
										pw.println(currentLineNumber + "," + email + "," + passWord + "," + "Admin");
									else if (dataFilePopulated)
										{pw.println(currentLineNumber + "," + email + "," + passWord + "," + "User");}
									
									pw.close();
									fw.close();
									}
									
								catch(IOException e){e.printStackTrace();}
								
								
								
								//CreateAdminLeagueFile.CreateFile(lnr.getLineNumber());
								
								Login(1); //Commencing Login once registration is complete...
								
								
							  }
							 
							 
						}
						
						else if (result == JOptionPane.CANCEL_OPTION)
							{
								
								int choice = JOptionPane.showOptionDialog(null,
								"Would you like to leave the program?",
								"Choose one option",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,null,null);
				
				
								if (choice == JOptionPane.YES_OPTION)
									{
										checker = true;
									} 	
									
								else{checker = false;}
								
							}
					}
					
					while(checker == false);
					
	}	




	
	

}



