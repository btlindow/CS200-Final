package cs200fall2016team4;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**SummaryReport Class
 * 
 * Main Object to Report Weekly Summarized Data
 * 
 * @author Ben Lindow
 *
 */

public class SummaryReport {
	
	
	/**
	 * Generates a summary report of the services each provider has rendered during the week
	 * @param psl - Ongoing Provided Service List of the Week
	 * @param pList - Current Provider List
	 */
	public void generateReport(ProvidedServiceList psl, ProviderList pList) {
		
		final String filename = "./Disk/Misc/summaryreport.txt";
		ArrayList<ProvidedServiceRecord> servlist = psl.getProvidedServiceList();
		ArrayList<Provider> prolist = pList.getProviderList();
		Provider provider;
		ProvidedServiceRecord serv;
		String pnum;
		String snum;
		int consults = 0;
		int numPros = 0;
		double total = 0.00;
		int globalConsults = 0;
		double globalTotal = 0.00;
		
		/**
		 * Create a file, delete if already exists
		 */
		
		try {
			File file = new File(filename);
			file.delete();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			PrintWriter pwriter = new PrintWriter(filename, "UTF-8");

			/**
			 * Scan through the provider list
			 */
			for(int i = 0; i < prolist.size(); i++) {
				provider = prolist.get(i);
				pnum = provider.getNumber();
				consults = 0;
				total = 0.00;
				
				/**
				 * look at each of the provided services per provider
				 */
				for(int j = 0; j < servlist.size(); j++) {							
					serv = servlist.get(j);
					snum = serv.provider.getNumber();
					
					/**
					 * if a provider's number is found under a provided service, update that providers weekly totals and update global weekly totals
					 */
					if(pnum.equals(snum)) {
						consults++;
						globalConsults++;
						total = total + Double.parseDouble(serv.getFee());
						globalTotal = globalTotal + total;
					}
				}
				
				/**
				 * Write a providers weekly totals if there is more than 0 consults for the week
				 */
				if(consults > 0) {
					numPros++;
					pwriter.println("\nProvider Name: " + provider.getName());
					pwriter.println("Total Consultations: " + String.valueOf(consults));
					pwriter.println("Total Fee for Week: $" + String.valueOf(total));
				}
			}
			
			/**
			 * Append global totals to the end of the file
			 */
			pwriter.println("\nOverall Total Providers: " + numPros);
			pwriter.println("Overall Total Consultations: " + globalConsults);
			pwriter.println("Overall Total Fee for Week: $" + globalTotal);
			
			pwriter.close();
			System.out.println("Summary Report File Written Successfully");
		}
		catch (Exception e) {
			System.out.println("Could Not Write To File");
		}
	}
}
