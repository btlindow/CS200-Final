package cs200fall2016team4;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.*;

/**ProvidedServiceList
 * 
 * Creates a list of all services provided to a member
 * 
 * @author Stephen Plautz
 *
 */

public class ProvidedServiceList {
	
	private ArrayList<ProvidedServiceRecord> list = new ArrayList<ProvidedServiceRecord>();
	private static final String pslfile = "./Disk/Misc/providedservices.txt";
	
	/**
	 * adds the service to the associated member's service list
	 * 
	 * @param psr
	 */
	public void addToList(ProvidedServiceRecord psr) {
		list.add(psr);
		System.out.println("Added \"" + psr.getName() + "\" to " + psr.member.getName() + "'s account.\n");
	}
	
	/**
	 * method to output the service information provided to a member
	 */
	public void printList() {
		ProvidedServiceRecord psr;
		Member member;
		Provider provider;
		
		for(int i = 0; i < list.size(); i++) {
			psr = list.get(i);
			member = psr.member;
			provider = psr.provider;
			
			System.out.println("\nMember Name: " + member.getName());
			System.out.println("Provider Name: " + provider.getName());
			System.out.println("Service: " + psr.getName());
			System.out.println("Date: " + psr.getDate());
			
		}
	}
	
	/**
	 * method to write service information provided to a member onto a file
	 */
	public void writeServiceListToFile() {
		ProvidedServiceRecord psr;
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM'-'dd'-'yyyy' 'HH':'mm':'ss");
		
		try {
			File file = new File(pslfile);
			file.delete();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			PrintWriter pwriter = new PrintWriter(pslfile, "UTF-8");
			for(int i = 0; i < list.size(); i++) {
				psr = list.get(i);
				psr.setCurrentDTG(ft.format(date));
				pwriter.println("Current Date and Time: " + psr.getCurrentDTG());
				pwriter.println("Date Service Was Provided: " + psr.getDate());
				pwriter.println("Provider Number: " + psr.provider.getNumber());
				pwriter.println("Member Number: " + psr.member.getNumber());
				pwriter.println("Service Code: " + psr.getCode());
				pwriter.println("Comments: " + psr.getComments() + "\n");
			}
			pwriter.close();
			System.out.println("Service Record File Written Successfully");
		}
		catch (Exception e) {
			System.out.println("Could Not Write To File");
		}
	}
	
	/**
	 * returns the list of provided service records
	 * 
	 * @return
	 */
	public ArrayList<ProvidedServiceRecord> getProvidedServiceList() {
		return this.list;
	}

}
