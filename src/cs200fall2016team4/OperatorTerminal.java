package cs200fall2016team4;

import java.util.List;

/**OperatorTerminal Class
 * 
 * Controls Main Operation Features of the ChocAn Terminal
 * 
 * @author Noah Gleason
 */
public class OperatorTerminal extends Terminal {	
	
	/**
	 * private variables:
	 * 	mList - new unpopulated list of members
	 * 	pList - new unpopulated list of providers
	 */
	private static MemberList mList = new MemberList();
	private static ProviderList pList = new ProviderList();
	
	/**
	 * Default run for terminal
	 */
	public void run(){
		//Populate Member and Provider Lists
		mList.populateMemberList();
		pList.populateProviderList();

		//Runs Operator Main Menu
		while(true) {
			System.out.println("\nOperator Terminal");
			System.out.println("1. Add Member\n2. Add Provider\n3. Delete Member\n4. Delete Provider\n5. Update Member\n6. Update Provider\n7. Print Member List\n8. Print Provider List\n9. Exit\n");
			String option = prompt("Input Option: ");
			
			switch(option) {
			case "1": addMember(mList, null);
				break;
			case "2": addProvider(pList, null);
				break;
			case "3": deleteMember(mList, null);
				break;
			case "4": deleteProvider(pList, null);
				break;
			case "5": updateMember(mList, null);
				break;
			case "6": updateProvider(pList, null);
				break;
			case "7": mList.printMemberList();
				break;
			case "8": pList.printProviderList();
				break;
			case "9": quit();
				return;
			default:
				System.out.println("Incorrect Input\n");
				break;	
			}
		}
	}
	
	/**
	 * Adds member to member list
	 * 
	 * @param mList		member list to be added to
	 * @param args		list of strings to test functionality, if null will be expected command line interface
	 */
	public static void addMember(MemberList mList, List<String> args) {
		//Gather input from user
		System.out.println("Add Member\n-------------\n");
		String name = prompt("Member Name: ", args);
		String number = prompt("Member Number(9 characters long!): ", args);
		if(number.length() != 9) {
			System.err.println("Must be 9 characters long!"); 
			return;
		}
		else if(mList.findMember(number) != null) {
			System.err.println("Member already exists!");
			return;
		}
		String address = prompt("Street: ", args);
		String city = prompt("City: ", args);
		String state = prompt("State: ", args);
		String zip = prompt("Zip: ", args);
	
		//Create member from input, add to member list
		Member member = new Member(name, number, address, city, state, zip, "v");
		mList.addMemberToList(member);
		
		System.out.println("Member Added Successfully");
		//set status
	}
	
	/**
	 * Adds provider to provider list
	 * 
	 * @param pList		provider list to be added to
	 * @param args		list of strings to test functionality, if null will be expected command line interface
	 */
	public static void addProvider(ProviderList pList, List<String> args) {
		//Gather input from user
		System.out.println("Add Provider\n-------------\n");
		String name = prompt("Provider Name: ", args);
		String number = prompt("Provider Number: ", args);
		if(number.length() != 9) {
			System.err.println("Must be 9 characters long!"); 
			return;
		}
		else if(pList.findProvider(number) != null) {
			System.err.println("Provider already exists!");
			return;
		}
		String address = prompt("Street: ", args);
		String city = prompt("City: ", args);
		String state = prompt("State: ", args);
		String zip = prompt("Zip: ", args);
		
		//Create provider from input, add to provider list
		Provider provider = new Provider(name, number, address, city, state, zip);
		pList.addProviderToList(provider);
		
		System.out.println("Provider Added Successfully");
	}
	
	/**
	 * Deletes member from member list
	 * 
	 * @param mList		member list to be deleted from
	 * @param args		list of strings to test functionality, if null will be expected command line interface
	 */
	public static void deleteMember(MemberList mList, List<String> args) {
		System.out.println("Delete Member\n------------\n");
		String number = prompt("Member Number: ", args); //get member number to look up
		Member member = mList.findMemberByNumber(number);
		
		//delete member if found
		if(member != null) {
			System.out.println("Deleting Member: " + member.getName() + "\n");
			mList.removeMemberFromList(member);
			System.out.println("Deleted Member Successfully");
		}
		else { //else state delete failed and return
			System.out.println("Delete Member Failed!\n");
		}
	}
	
	/**
	 * Deletes provider from provider list
	 * 
	 * @param pList		provider list to be deleted from
	 * @param args		list of strings to test functionality, if null will be expected command line interface
	 */
	public static void deleteProvider(ProviderList pList, List<String> args) {
		System.out.println("Delete Provider\n------------\n");
		String number = prompt("Provider Number: ", args); //get member to look up
		Provider provider = pList.findProviderByNumber(number);
		
		//delete member if exists
		if(provider != null) {
			System.out.println("Deleting Provider: " + provider.getName() + "\n");
			pList.removeProviderFromList(provider);
			System.out.println("Deleted Provider Successfully");
		}
		else { //else state delete failed if not
			System.out.println("Deleted Provider Failed");
		}
	}
	
	/**
	 * Update attributes of member from member list
	 * 
	 * @param mList		member list to be updated from
	 * @param args		list of strings to test functionality, if null will be expected command line interface
	 */
	public static void updateMember(MemberList mList, List<String> args) {
		System.out.println("Update Member\n------------\n");
		String number = prompt("Member Number: ", args); //find member number to look up
		Member member = mList.findMemberByNumber(number);
		
		//if member exists, gather input to update
		if(member != null) {
			System.out.println("Updating Member: " + member.getName() + "\n");
			String name = prompt("Member Name: ", args);
			member.setName(name);
			String address = prompt("Address: ", args);
			member.setAddress(address);
			String city = prompt("City: ", args);
			member.setCity(city);
			String state = prompt("State: ", args);
			member.setState(state);
			String zip = prompt("Zip: ", args);
			member.setZipCode(zip);
			String status = prompt("Status: ", args);
			member.setStatus(status);
		}
		else { //else if member does not exists, return
			return;
		}
		
		System.out.println("Updated Member Successfully");
	}
	
	/**
	 * Update attributes of provider from provider list
	 * 
	 * @param pList		provider list to be updated from
	 * @param args		list of strings to test functionality, if null will be expected command line interface
	 */
	public static void updateProvider(ProviderList pList, List<String> args) {
		System.out.println("Update Provider\n------------\n");
		String number = prompt("Provider Number: ", args); //find provider number to look up
		Provider pro = pList.findProviderByNumber(number);
		
		//gather input to update provider information
		if(pro != null) {
			System.out.println("Updating Provider: " + pro.getName() + "\n");
			String name = prompt("Provider Name: ", args);
			pro.setName(name);
			String address = prompt("Address: ", args);
			pro.setAddress(address);
			String city = prompt("City: ", args);
			pro.setCity(city);
			String state = prompt("State: ", args);
			pro.setState(state);
			String zip = prompt("Zip: ", args);
			pro.setZipCode(zip);
		}
		else { //else return if provider does not exist
			return;
		}
		
		System.out.println("Updated Provider Successfully");
	}
	
	/**
	 * Save the current member and provider list
	 * Purge the list so it can start empty next call
	 */
	public static void quit() {
		mList.saveMemberList();
		pList.saveProviderList();
		mList.clear();
		pList.clear();
	}
	
}
