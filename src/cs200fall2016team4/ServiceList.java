package cs200fall2016team4;
import java.io.*;
import java.util.*;

/**ServiceList
 * 
 * Holds information pertaining to specific services available
 * 
 * @author Stephen Plautz
 *
 */

public class ServiceList {
	ServiceItem serv;
	
	/**
	 * declaring static string titles to ensure proper directory association
	 */
	private static final String servicefile = "./DataCenter/servicelist.txt";
	private static final String providerDirectory = "./Disk/Misc/providerdirectory.txt";

	private ArrayList<ServiceItem> servicelist = new ArrayList<ServiceItem>();
	

	/**
	 * fills the service list with services read in from a buffered reader
	 */
	public void populateServiceList() {
		BufferedReader breader = null;
		String line;

		try {
			breader = new BufferedReader(new FileReader(servicefile));
			while((line = breader.readLine()) != null) {
				/**
				 * splits the lines into individual data pieces upon encountering the "," character
				 */
				String[] serviceinfo = line.split(",");
				serv = new ServiceItem(serviceinfo[0], serviceinfo[1], serviceinfo[2]);
				this.addServiceToList(serv);
			}
			breader.close();
		}
		
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + servicefile + "'");
		}
	    catch(IOException ex) {
	    	System.out.println("Error reading file '" + servicefile + "'");
	    }	
	}
	
	/**
	 * outputs the services in the list to standard output
	 */
	public void printServiceList() {
		ServiceItem service;
		for(int i = 0; i < servicelist.size(); i++) {
			service = servicelist.get(i);
			System.out.println("");
			service.printService();
			System.out.println("");
		}
		
	}
	
	/**
	 * handles writing the provider directory to a file
	 */
	public void writeProviderDirectoryFile() {
		ServiceItem service;
		
		try {
			File file = new File(providerDirectory);
			file.delete();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			PrintWriter pwriter = new PrintWriter(providerDirectory, "UTF-8");
			Collections.sort(servicelist, new Comparator<ServiceItem>() {
				@Override
				public int compare(ServiceItem s1, ServiceItem s2) {
					return s1.getName().compareTo(s2.getName());
				}
			});
			for(int i = 0; i < servicelist.size(); i++) {
				service = servicelist.get(i);
				pwriter.println("Service: " + service.getName());
				pwriter.println("Code: " + service.getCode());
				pwriter.println("Fee: " + service.getFee() + "\n");
			}
			pwriter.close();
		}
		catch (Exception e) {
			System.out.println("Could Not Write To File");
		}
	}

	public void addServiceToList(ServiceItem serv1) {
		servicelist.add(serv1);
	}
	
	/**
	 * a method to search the service list and find a service based upon a given service code
	 * 
	 * @param code
	 * @return
	 */
	public ServiceItem findServiceByCode(String code) {
		String found;
		ServiceItem service;
		for(int i = 0; i < servicelist.size(); i++) {
			found = (servicelist.get(i)).getCode();
			if(code.equals(found)){
				service = servicelist.get(i);
				//service.printService();
				return service;
			}
		}
		System.err.println("Service not found");
		return null;
	}
	
	/**
	 * a method to remove a specific unwanted or outdated service
	 * 
	 * @param serv2
	 */
	public void removeServiceFromList(ServiceItem serv2) {
		String servicecode = serv2.getCode();
		String findCode;
		for(int i=0; i < servicelist.size(); i++) {
			findCode = (servicelist.get(i)).getCode();
			if(findCode.equals(servicecode)) {
				servicelist.remove(i);
			}
		}
	}
	
	/**
	 * removes all the elements of the list
	 */
	public void clear()
	{
		servicelist.clear();
	}


}
