package cs200fall2016team4;

import java.util.List;
import java.util.Scanner;

/** Terminal
 * 
 * Parent class for all terminal classes.
 * 
 * @author Adam J. Alred
 */

public abstract class Terminal {
	public static final Scanner read = new Scanner(System.in);
	/**
	 * This is the prompt function. It is used for reading in input from the keyboard.
	 * It is used in all terminals to determine what feature the given person would like to use.
	 * @param String promptString - A user generated response that prompt takes in.
	 */
	public static String prompt(String promptString) {
		try {
			System.out.print(promptString);
			String response = read.nextLine();
			Thread.sleep(5);
			return response;
		} catch (Exception e) {}
		return null;
	}
	/**
	 * This is another prompt function but passes a List with it. Functions identical to prompt(string).
	 * @param String promptString - A user generated response that prompt takes in.
	 * @param List<String> args - This is used for JUnit testing to make sure certain functions are working properly.
	 */
	public static String prompt(String promptString, List<String> args) {
		try {
			if(args == null) {
				System.out.print(promptString);
				String response = read.nextLine();
				Thread.sleep(5);
				return response;
			}
			else {
				String response = args.get(0);
				args.remove(0);
				return response;
			}
		} catch (Exception e) {}
		return null;
	}
	
	/**
	 * This function is for when the user needs to press enter
	 * in order to go to the next step. It is much like most websites enter
	 * function.
	 */
	public static void pressEnterToContinue() {
		try {
			Thread.sleep(10);
			System.out.println("Press enter to continue...");
			read.nextLine();
		}catch(Exception e) {}
		return;
	}
	
	public abstract void run();
}
