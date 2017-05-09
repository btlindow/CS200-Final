package cs200fall2016team4;

import java.io.*;
import java.util.ArrayList;

/**Member Report
 * 
 * Holds information for members who have had services provided
 * 
 * @author Stephen Plautz
 *
 */

public class MemberReport extends Report {

	private static final String memberReportFile = "./Disk/MemberReports/";
	
	public MemberReport(Member member) {
		super(member.getName(), member.getNumber(), member.getAddress(), member.getCity(), member.getState(), member.getZipCode());
	}
	
	/**
	 * Method for creating the report that members will receive
	 * @param psl - list of Provided Services for the week
	 */
	public void generateReport(ProvidedServiceList psl) {
			
			/**
			 * titles the file as "./Disk/MemberReports/1234.txt"
			 */
			final String filename = memberReportFile + this.getNumber() + ".txt";
			ArrayList<ProvidedServiceRecord> list = psl.getProvidedServiceList();		 
			try {
				File file = new File(filename);
				file.delete();
			}
			
			/**
			 * determines the location of the error in the event file could not be created
			 */
			catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				PrintWriter pwriter = new PrintWriter(filename, "UTF-8");
				
				/**
				 * prints static information of report (info that will not change) to report file
				 */
				pwriter.println("Member Name: " + this.getName());
				pwriter.println("Member Number: " + this.getNumber());
				pwriter.println("Street Address: " + this.getStreet());
				pwriter.println("City: " + this.getCity());
				pwriter.println("State: " + this.getState());
				pwriter.println("Zip Code: " + this.getZip() + "\n");
				
				ProvidedServiceRecord psr;
				
				/**
				 * prints specific non static information about each service performed for member to report file
				 */
				for(int i = 0; i < list.size(); i++) {
					psr = list.get(i);
					if(this.getNumber().equals(psr.member.getNumber())) {
						pwriter.println("\tDate of Service: " + psr.getDate());
						pwriter.println("\tProvider Name: " + psr.provider.getName());
						pwriter.println("\tService Name: " + psr.getName() + "\n");
					}
				}
				
				pwriter.close();
			}
			catch (Exception e) {
				System.out.println("Could Not Write To File");
			}
	}
	
	
}
