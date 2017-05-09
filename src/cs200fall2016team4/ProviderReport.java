package cs200fall2016team4;

import java.io.*;
import java.util.ArrayList;

/**ProviderReport Class
 * 
 * Provides weekly reports for each provider and their services
 * 
 * @author Ben Lindow
 *
 */

public class ProviderReport extends Report {

	/**
	 *  Base file path string
	 */
	private static final String providerReportFile = "./Disk/ProviderReports/";
	
	/**
	 * Global total for providers
	 */
	private Double total = 0.00;
	
	/**
	 * Constructor for a Provider Report. Utilizes Superclass "Report" Constructor to gather base information from provider.
	 * @see Report Class
	 * @param provider - Provider to update base report information from. Used in super class constructor.
	 */
	public ProviderReport(Provider provider) {
		super(provider.getName(), provider.getNumber(), provider.getAddress(), provider.getCity(), provider.getState(), provider.getZipCode());
	}
	
	/**
	 * Generates a report of weekly services and totals for each provider
	 * @param psl -  Provided Service List of the Week
	 */
	public void generateReport(ProvidedServiceList psl) {
					
			/**
			 * append provider number to text file name
			 */
			final String filename = providerReportFile + this.getNumber() + ".txt";
			ArrayList<ProvidedServiceRecord> list = psl.getProvidedServiceList();		
			
			/**
			 * Create new file, delete if exists
			 */
			try {
				File file = new File(filename);
				file.delete();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			/**
			 * write provider information
			 */
			try {
				PrintWriter pwriter = new PrintWriter(filename, "UTF-8");
				
				pwriter.println("Provider Name: " + this.getName());
				pwriter.println("Provider Number: " + this.getNumber());
				pwriter.println("Street Address: " + this.getStreet());
				pwriter.println("City: " + this.getCity());
				pwriter.println("State: " + this.getState());
				pwriter.println("Zip Code: " + this.getZip() + "\n");
				
				ProvidedServiceRecord psr;
				int consults = 0;
				
				/**
				 * for each provided service record that matches the provider number, print the records information
				 */
				for(int i = 0; i < list.size(); i++) {
					psr = list.get(i);
					if(this.getNumber().equals(psr.provider.getNumber())) {
						pwriter.println("\tDate of Service: " + psr.getDate());
						pwriter.println("\tDate Received: " + psr.getCurrentDTG());
						pwriter.println("\tMember Name: " + psr.member.getName());
						pwriter.println("\tMember Number: " + psr.member.getNumber());
						pwriter.println("\tService Code: " + psr.getCode());
						pwriter.println("\tFee to Be Paid: " + psr.getFee() + "\n");
						total = total + Double.parseDouble(psr.getFee());
						consults++;
					}
				}
				
				/**
				 * print weekly totals
				 */
				pwriter.println("Total Consultations: " + String.valueOf(consults));
				pwriter.println("Total Fee for Week: $" + String.valueOf(total));

				pwriter.close();
			}
			catch (Exception e) {
				System.out.println("Could Not Write To File");
			}
	}
	
	/**
	 * Getter Function for Reports Total Dollar Amount
	 * @return - returns report's total amount
	 */
	public Double getTotal() {
		return this.total;
	}
	
	
}
