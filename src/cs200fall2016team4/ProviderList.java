package cs200fall2016team4;

import java.io.*;
import java.util.ArrayList;

/**ProviderList Class
 * 
 * Holds providers and allows for providers to be saved, deleted, and found
 * 
 * @author Bryan Pauken
 *
 */

public class ProviderList {
	Provider prov;
	private static final String providerfile = "./DataCenter/providerlist.txt";
	private ArrayList<Provider> prolist = new ArrayList<Provider>();
	
	/**
	 * Fills provider list with providers from a file
	 */
	public void populateProviderList() {
		BufferedReader breader = null;
		String line;

		try {
			breader = new BufferedReader(new FileReader(providerfile));
			while((line = breader.readLine()) != null) {
				String[] proinfo = line.split(",");
				prov = new Provider(proinfo[0], proinfo[1], proinfo[2], proinfo[3], proinfo[4], proinfo[5]);
				this.addProviderToList(prov);
			}
			breader.close();
		}
		
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + providerfile + "'");
		}
	    catch(IOException ex) {
	    	System.out.println("Error reading file '" + providerfile + "'");
	    }	
	}
	
	/**
	 * Prints all the providers in the list
	 */
	public void printProviderList() {
		Provider provider;
		for(int i = 0; i < prolist.size(); i++) {
			provider = prolist.get(i);
			System.out.println("");
			provider.printProvider();
			System.out.println("");
		}
		
	}
	
	/**
	 * Makes a new provider report for each provider in the provider list
	 * If total owed to provider is greater than 0, write a new EFT record
	 * 
	 * @param psl		Provided Service List object
	 * @param eList		EFT Record list
	 */
	public void generateProviderReports(ProvidedServiceList psl, EFTRecordList eList) {
		ProviderReport prorep;
		EFTRecord eft;
		for(int i = 0; i < prolist.size(); i++) {
			prorep = new ProviderReport(prolist.get(i));
			prorep.generateReport(psl);
			
			if(prorep.getTotal() > 0) {
				eft = new EFTRecord(prolist.get(i), prorep.getTotal());
				eList.addEFTRecordToList(eft);
			}
		}
	}
	
	/**
	 * Checks to see if provider list file already exists,
	 * if it does, it deletes the file, and then writes to file
	 * 
	 */
	public void saveProviderList(){
		try {
			File file = new File(providerfile);
			if(file.delete()) {
				this.writeProviderListToFile();
			}
			else {
				System.out.println("Provider File Could NOT Be Deleted");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a provider object to the provider list
	 * 
	 * @param prov1		A provider object
	 */
	public void addProviderToList(Provider prov1) {
		prolist.add(prov1);
	}
	
	/**
	 * Looks through provider list to find a provider by a number
	 * 
	 * @param num	The provider number to look up
	 * @return		Returns a provider object if found otherwise returns null
	 */
	public Provider findProviderByNumber(String num) {
		String found;
		Provider provider;
		for(int i = 0; i < prolist.size(); i++) {
			found = (prolist.get(i)).getNumber();
			if(num.equals(found)) {
				provider = prolist.get(i);
				//provider.printProvider();
				return provider;
			}
		}
		System.err.println("Provider not found for this ID: " + num);
		return null;
	}
	
	/**
	 * Looks up the provider with the given number but does not print error message
	 * 
	 * @param num	The number to look up
	 * @return
	 */
	public Provider findProvider(String num) {
		String found;
		Provider provider;
		for(int i = 0; i < prolist.size(); i++) {
			found = (prolist.get(i)).getNumber();
			if(num.equals(found)) {
				provider = prolist.get(i);
				//provider.printProvider();
				return provider;
			}
		}

		return null;
	}
	/**
	 * Removes the provider entered from the list
	 * 
	 * @param prov2		The provider object to remove from the list
	 */
	public void removeProviderFromList(Provider prov2) {
		String providerNum = prov2.getNumber();
		String findNum;
		for(int i=0; i < prolist.size(); i++) {
			findNum = (prolist.get(i)).getNumber();
			if(findNum.equals(providerNum)) {
				prolist.remove(i);
			}
		}
	}
	
	/**
	 * Writes the provider list to a file with each element seperated by a comma
	 */
	public void writeProviderListToFile() {
		try {
			PrintWriter pwriter = new PrintWriter(providerfile, "UTF-8");
			for(int i = 0; i < prolist.size(); i++) {
				prov = prolist.get(i);
				pwriter.print(prov.getName() + ",");
				pwriter.print(prov.getNumber() + ",");
				pwriter.print(prov.getAddress() + ",");
				pwriter.print(prov.getCity() + ",");
				pwriter.print(prov.getState() + ",");
				pwriter.print(prov.getZipCode() + "\n");
			}
			pwriter.close();
			System.out.println("Provider File Written Successfully");
		}
		catch (Exception e) {
			System.out.println("Could Not Write To File");
		}
	}
	
	/**
	 * Clears the provider list
	 */
	public void clear()
	{
		prolist.clear();
	}
	
	/**
	 * Allows acces to the provider list
	 * 
	 * @return	Returns the provider list
	 */
	public ArrayList<Provider> getProviderList() {
		return this.prolist;
	}

}
