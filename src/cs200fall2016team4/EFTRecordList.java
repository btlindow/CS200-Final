package cs200fall2016team4;

import java.io.*;
import java.util.ArrayList;

/**EFTRecordList Class
 *
 * Defines list of EFT Records
 * 
 * @author Noah Gleason
 */
public class EFTRecordList {
	
	/**
	 * private variables:
	 * 	EFTfile - path of txt file to write list of EFTRecords to
	 * 	list - ArrayList of EFTRecords to be later added to	
	 */
	private static final String EFTfile = "./Disk/Misc/eftFile.txt";
	private ArrayList<EFTRecord> list = new ArrayList<EFTRecord>();
	
	/**
	 * adds new EFTRecord to list of EFTRecords
	 * 
	 * @param record	EFTRecord to be added to list
	 */
	public void addEFTRecordToList(EFTRecord record) {
		list.add(record);
	}
	
	/**
	 * writes list of EFTRecords to file
	 */
	public void writeEFTRecordsToFile() {
		try {
			EFTRecord record; //temporary record
			PrintWriter pwriter = new PrintWriter(EFTfile, "UTF-8"); //PrintWriter to write to specified txt file
			
			//goes through entire list and prints contents of each EFTRecord to file
			for(int i = 0; i < list.size(); i++) {
				record = list.get(i); 
				pwriter.print(record.getName() + ", ");
				pwriter.print(record.getNumber() + ", ");
				pwriter.print(record.getPayment() + "\n");
			}
			pwriter.close();
			System.out.println("EFTRecords Written Successfully");
		}
		
		catch (Exception e) {
			System.out.println("Could Not Write EFTRecords To File");
		}
	}
	
	/**
	 * clears contents of EFTRecord list
	 */
	public void clear() {
		list.clear();
	}

}