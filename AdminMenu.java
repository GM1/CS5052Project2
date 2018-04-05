/**
* AdminMenu.java
*
* This class displays the main menu options
*
*
*
*/

import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.JOptionPane;
import java.nio.file.*;

public class AdminMenu {

	static int check = 0;
/**
* 
*
* Start() Method 
*
*
*
*/
	
	public static void Start() 
	
	{
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		String choice="main";
		
			while(!choice.equals("exit") )
			{
		
				switch(choice)
				{
					case "main": 
						choice = displayAdminMenu();
					break;
			
					case "register_new_user":
						choice = registerNewUser();
					break;
					/*
					case "create_league":
						choice = createLeague();

					break;
				
					case "enter_edit_results":
						choice = enter_editResults();
					break;
				
					case "generate_league_table":
						choice = generateLeagueTable();
					break;
				
					case "delete_league":
						choice = deleteLeague();
					break;
					*/
					default:
						choice = displayAdminMenu();
					break;
			
				}
			
			}
			
			System.out.println("Exiting...");
		
		
	}
	
/**********************************************************************************
 * Flow Control (Menu) methods
 * 
 **********************************************************************************/
	
/**
 * displayMainMenu()	
 * @return 
 * @throws IOException 
 */
	
	public static String displayAdminMenu()
	{
		int 	option=0;
		String	input, returnString="";
		
		Scanner console = new Scanner(System.in);
/*		
		try {
			clearScreen();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(final IOException e ){};
*/		
		System.out.println("\t\t\t\t Administrator Main Menu");
		System.out.println("\t\t\t\t -----------------------");
		System.out.println("\t\t\t\t (1) Register New User ");
		System.out.println("\t\t\t\t (2) View Bookings ");
		System.out.println("\t\t\t\t (3) Create Bookings ");
		System.out.println("\t\t\t\t (4) Decommission Facility ");
		System.out.println("\t\t\t\t (5) Delete a League  ");
		System.out.println("\t\t\t\t (0) Exit ");
		System.out.println("");
		System.out.print("\t\t\t\t Enter option [0-6] :");
		
		input = console.nextLine();
		
		if(input.matches("[0-9]{1}"))
		{
			option = Integer.parseInt(input);
		}
		else
		{
			option=255;	// this will select default choice
		}
				
		switch(option)
		{
			case 1:
				returnString="register_new_user";
				break;
			case 2:
				returnString="create_league";
				break;
			case 3:
				returnString="enter_edit_results";
				break;
			case 4:
				returnString="generate_league_table";
				break;
			case 5:
				returnString="delete_league";
				break;
			case 0:
				returnString="exit";
				break;
			default:
				returnString="main";
				break;
		}
		
		return returnString;
		
	}
	
	public static String registerNewUser()
	{
		
		String userEmail;
		
		
		int 	option;
	
		String	input="", returnString="", essentialLeagueDetails="";
			
		Scanner consoleClearLeague = new Scanner(System.in);
/*				
		try {
			clearScreen();
		} 
		catch (InterruptedException e) 
		{

		// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(final IOException e ){};
*/
		
		System.out.println("\t\t\t\t Register New User");
		System.out.println("\t\t\t\t -----------------");
		System.out.println("\t\t\t\t (1) Register New User");
		System.out.println("\t\t\t\t (0) Back to Main Menu ");
		System.out.println("");
		System.out.print("\t\t\t\t Enter option [0-1] :");
		
		input = consoleClearLeague.nextLine();
		
		if(input.matches("[0-1]{1}"))
		{
			option = Integer.parseInt(input);
		}
		else
		{
			option=255;	// this will select default choice
		}
				
				switch(option)
				{
					case 1:
						
						
						try{
						Login.registerRegularUser();
						}
						catch (IOException e) {e.printStackTrace();}
						
						
			/*			try { 
								System.in.read();
							} 
							catch (IOException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	// just hold here to display fixtures
			*/			
					
						returnString="register_new_user";	// displays the register new user menu
						break;
					
					
					
					default:
						returnString="main";	// by default go back to main menu
						break;
				}
		
		return returnString;
		
	}
		
		
	}
	
