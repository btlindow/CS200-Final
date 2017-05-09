package cs200fall2016team4;

import java.util.Scanner;


/**ManagerTerminal Class
 * 
 * Main Controller for the Manager Features of the ChocAn Terminal
 * 
 * @author Ben Lindow
 * @author Adam Alred
 */

public class ManagerTerminal extends Terminal {

	private static MemberList mList = new MemberList();
	private static ProviderList pList = new ProviderList();
	private static ProvidedServiceList psList;
	private static SummaryReport sumRep = new SummaryReport();
	private static EFTRecordList eList = new EFTRecordList();
	
	public static final Scanner read = new Scanner(System.in);
	
	public ManagerTerminal(ProvidedServiceList psl) {
		psList = psl;
	}
	/**
	 * (non-Javadoc)
	 * @see cs200fall2016team4.Terminal#run()
	 * This is the run function. It begins the process of starting the 
	 * manager terminal. 
	 */
	public void run() {
		mList.populateMemberList();
		pList.populateProviderList();
		
			//clears the screen
		while(true) {
			System.out.println("\nManager Terminal");
			System.out.println("1. Generate Member Report\n2. Generate Provider Report\n3. Generate Summary Report\n4. Exit\n");
			String option = prompt("Input Option: ");
			System.out.print("\n");
			
			/**
			 * This switch statement picks one of 3 options available to managers 
			 */
			switch(option) {
			case "1": generateMemberReport();
				break;
			case "2": generateProviderReport();
				break;
			case "3": generateSummaryReport();
				break;
			case "4": quit();
				return;
			default: 
				
				System.out.println("Incorrect Input\n");
				break;	
			}
		}
	}
	/**
	 * This is the generateMemberReport function.
	 * This function generates the member report and prints it to the output screen.
	 */
	public void generateMemberReport() {
		mList.generateMemberReports(psList);
		
		System.out.println("Member Reports Written Successfully");
	}
	/**
	 * This is the generateProviderReport function.
	 * This function generates the provider report and prints it to the output screen.
	 */
	public void generateProviderReport() {
		 pList.generateProviderReports(psList, eList);
		 eList.writeEFTRecordsToFile();
		 
		 System.out.println("Provider Reports Written Successfully");
		 
	}
	/**
	 * This is the generateSummaryReport function.
	 * This function generates the provider report and prints it to the output screen.
	 */
	public void generateSummaryReport() {
		sumRep.generateReport(psList, pList);
		
		System.out.println("Summary Report Written Successfully");
	}	
	/**
	 * This is the quit function.
	 * It is for when the manager wants to exit the manager terminal.
	 */
	public void quit() {
		mList.clear();
		pList.clear();
		eList.clear();
	}
}