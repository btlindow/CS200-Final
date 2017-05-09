package cs200fall2016team4;

import java.util.List;
import java.util.Scanner;

/**ProviderTerminal Class
 * 
 * Allows provider to login into the terminal
 * 
 * @author Adam J. Alred
 */


//This is the provider terminal class that extends terminal
public class ProviderTerminal extends Terminal {
	
	private static ProviderList pList = new ProviderList();
	private static MemberList mList = new MemberList();
	private static ServiceList sList = new ServiceList();
	private static ProvidedServiceList psList;
	
	public static final Scanner read = new Scanner(System.in);
	
	public ProviderTerminal(ProvidedServiceList psl) {
		psList = psl;
	}
	/**
	 * (non-Javadoc)
	 * @see cs200fall2016team4.Terminal#run()
	 * This function starts the process for ProviderTerminal. 
	 * It starts by running and then lets the provider choose from a variety of reasons.
	 */
	public void run() {
		pList.populateProviderList();
		mList.populateMemberList();
		sList.populateServiceList();
		Member member;
		
		
		
		while(true) {
			System.out.println("\nProvider Terminal");
			System.out.println("1. Bill ChocAn\n2. Validate Member\n3. Request Provider Directory\n4. Exit");
			String option = prompt("Input Option: ");
			System.out.print("\n");
			
			switch(option){
				case "1": billChocAn();	//billChocan option
					break;
				case "2": 	//validate member option
					member = validateMember(null, mList);
					if(member != null)
						processStatus(member.getStatus());
					break;
				case "3": requestProviderDirectory();	//requestProviderDirectory option
					break;
				case "4": quit();	//exit for after the provider is finished.
					return;
				default: System.out.println("Invalid Input!\n");
					break;
			}
		}
	}
	/**
	 * This function is the billChocAn function. It bills a member for the 
	 * services they acquire within the given week.
	 */
	public static void billChocAn() {
		
		
		Member mem = validateMember(null, mList);//We have to validate the member before we bill the member!
		if(mem == null) return;
		processStatus(mem.getStatus());
		if(mem.getStatus().equals("s")) return;
		
		String date = prompt("Date Service Provided(MM-DD-YYYY): ");
		
		Provider pro = pList.findProviderByNumber(prompt("Provider Number (9 digits): "));
		if(pro == null) {
			pressEnterToContinue();
			return;
		}
		
		String code;
		ServiceItem service = null;
		String valid;
		
		while(true) {
			code = prompt("Service Code (6 digits): ");
			service = sList.findServiceByCode(code);
			while(service == null) {
				System.err.println("Nonexistent Service Code!");
				return;
			}
			System.out.println("Service: " + service.getName());
			valid = prompt("Correct Service[y]/[n]: ");
			if (valid.equals("y")) {
				break;
			}
			else {
				return;
			}
		}
		String comments = prompt("Comments: ");
		
		System.out.println("Fee: $" + service.getFee());
		
		ProvidedServiceRecord psr = new ProvidedServiceRecord(service, mem, pro, date, comments);
		psList.addToList(psr);
		
	}
	/**
	 * This is the validate member function. It is so the provider can validate they are a member before they 
	 * bill the member for any services etc.
	 * @param List<String> args - This parameter is used for JUnit testing only.
	 * @param MemberList mList - This parameter is used when checking to see if the member exists and to validate them!
	 */
	public static Member validateMember(List<String> args, MemberList mList) {
		
		String memberID = prompt("Enter Member ID(9 characters long): ", args);
		if(memberID.length() != 9) {
			System.err.println("Member ID must be 9 characters long");
			pressEnterToContinue();
			return null;
		}
		
		Member mem = mList.findMemberByNumber(memberID);
		if(mem == null) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("\n"); 
			return null;
		}
		else {
			return mem;
		}
		
	}
	/**
	 * This function determines whether a given member is validated, suspended, or invalid.
	 */
	public static void processStatus(String status)
	{
		
		if(status.equals("v"))
			System.out.println("Member Validated");
		else if (status.equals("s"))
			System.out.println("Member Suspended");
		else
			System.out.println("Member Invalid");
	}
	/**
	 * This is the requestProviderDirectory function. It merely sends the directory of providers
	 * to a given email, usually the member's who is requesting it.
	 */
	public static void requestProviderDirectory() {
		
		String email = prompt("Enter Email Account: ");
		sList.writeProviderDirectoryFile();
		
		System.out.println("Provider Directory Sent Successfully to: " + email);
	}
	
	/**
	 * This function quits out of the provider Terminal.
	 */
	public static void quit() {
		psList.writeServiceListToFile();
		mList.clear();
		pList.clear();
		sList.clear();
	}
}
