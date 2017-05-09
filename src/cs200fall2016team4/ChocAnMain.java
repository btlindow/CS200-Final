package cs200fall2016team4;

import java.io.*;
import java.util.Scanner;

/**ChocAnMain Class
 * 
 * Main Controller Class for the ChocAn Terminal
 * 
 * @author Ben Lindow
 */


public class ChocAnMain {
	/**
	 * Database File Names
	 */
	private static final String credfile = "./DataCenter/cred.txt";
	
	/**
	 * Setup Scanner
	 */
	public static final Scanner read = new Scanner(System.in);
		
	/**
	 * Main function to run ChocAn Terminal
	 * @param args - input string arguments for main function
	 */
	public static void main(String [] args) {
		Terminal term;
		String type = null;
		
		/**
		 * Initialize a new provided service list
		 */
		ProvidedServiceList psl = new ProvidedServiceList();
		
		/**
		 * display login menu
		 */
		while(true) {	
			System.out.println("\nWelcome to the Chocoholics Anonymous Terminal\n");
			System.out.println("\nType 'q' as a Username to Quit");
			type = readCredentials();
			System.out.print("\n");
			
			switch(type) {
			case "p":
				term = new ProviderTerminal(psl);
				term.run();
				break;
			case "m":
				term = new ManagerTerminal(psl);
				term.run();
				break;
			case "o":
				term = new OperatorTerminal();
				term.run();
				break;
			case "z":
				return;
			default:
				System.out.println("Invalid Credentials.");
			}
		}
	}
	
	/**
	 * Reads input credentials.
	 * @return - returns user type
	 */
	private static String readCredentials() {
		BufferedReader breader = null;
		String line;
		String uname;
		String pword;
		
		/**
		 * Gather user input
		 */
		System.out.print("Enter Username: ");
		uname = read.next();
		
		if(uname.equals("q")) {
			return "z";
		}
			
		
		System.out.print("Enter Password: ");
		pword = read.next();
	
		try {
			breader = new BufferedReader(new FileReader(credfile));
							
			while((line = breader.readLine()) != null) {
				String[] filecred = line.split(",");
				
				/**
				 * search line by line until user creds are found
				 */
				if(filecred[0].equals(uname) && filecred[1].equals(pword)) {
					breader.close();
					return filecred[2]; 
				}
			}
			breader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + credfile + "'");
		}
	    catch(IOException ex) {
	    	System.out.println("Error reading file '" + credfile + "'");
	    }
		
		return "x";
	}
}
