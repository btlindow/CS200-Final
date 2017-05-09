package cs200fall2016team4;

import java.io.*;
import java.util.ArrayList;

/**MemberList class
 * 
 * Holds Members and allows for members to be saved, deleted, or found
 * 
 * @author Bryan Pauken
 *
 */

public class MemberList {
	Member mem;
	private static final String memberfile = "./DataCenter/memberlist.txt";
	private ArrayList<Member> list = new ArrayList<Member>();
	
	/**
	 * Fills member list with members from a file
	 */
	public void populateMemberList() {
		BufferedReader breader = null;
		String line;

		try {
			breader = new BufferedReader(new FileReader(memberfile));
			while((line = breader.readLine()) != null) {
				String[] meminfo = line.split(",");
				mem = new Member(meminfo[0], meminfo[1], meminfo[2], meminfo[3], meminfo[4], meminfo[5], meminfo[6]);
				this.addMemberToList(mem);
			}
			breader.close();
		}
		
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + memberfile + "'");
			}
	    catch(IOException ex) {
	    	System.out.println("Error reading file '" + memberfile + "'");
	    	}	
	}
	
	/**
	 * Prints the members in the member list
	 */
	public void printMemberList() {
		for(int i = 0; i < list.size(); i++) {
			mem = list.get(i);
			System.out.println("");
			mem.printMember();
			System.out.println("");
		}
	}

	/**
	 * Adds the given member to the member list
	 * 
	 * @param mem	The member object to add to the list
	 */
	public void addMemberToList(Member mem) {
		list.add(mem);
	}
	
	/**
	 * Checks to see if member list file already exists,
	 * if it does, it deletes the file, and then writes to file
	 */
	public void saveMemberList() {
		try {
			File file = new File(memberfile);
			if(file.delete())
				this.writeMemberListToFile();
			else
				System.out.println("Member File Could NOT Be Deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Finds a member in the member list by a given number
	 * 
	 * @param num	Number of member to look up
	 * @return		Returns a member object if found otherwise return null
	 */
	public Member findMemberByNumber(String num) {
		String found;
		for(int i = 0; i < list.size(); i++) {
			found = (list.get(i)).getNumber();
			if(num.equals(found)) {
				mem = list.get(i);
				return mem;
			}
		}
		System.err.println("Member not found for ID: " + num);
		return null;
	}
	
	/**
	 * Looks up member in the member list but does not print any error message
	 * 
	 * @param num  The member number to find
	 * @return
	 */
	public Member findMember(String num) {
		String found;
		for(int i = 0; i < list.size(); i++) {
			found = (list.get(i)).getNumber();
			if(num.equals(found)) {
				mem = list.get(i);
				return mem;
			}
		}
	
		return null;
	}
	/**
	 * Removes the given member object from the member list
	 * 
	 * @param mem	The given member object to be removed
	 */
	public void removeMemberFromList(Member mem) {
		String memNum = mem.getNumber();
		String findNum;
		for(int i=0; i < list.size(); i++) {
			findNum = (list.get(i)).getNumber();
			if(findNum.equals(memNum)) {
				list.remove(i);
			}
		}
	}
	
	/**
	 * Makes a member report for each member in the member list
	 * 
	 * @param psl	The Provided Service list
	 */
	public void generateMemberReports(ProvidedServiceList psl) {
		MemberReport memrep;
		for(int i = 0; i < list.size(); i++) {
			memrep = new MemberReport(list.get(i));
			memrep.generateReport(psl);
		}
	}
	
	/**
	 * Writes each member to a file with each element seperated by commas
	 */
	public void writeMemberListToFile() {
		try {
			PrintWriter pwriter = new PrintWriter(memberfile, "UTF-8");
			for(int i = 0; i < list.size(); i++) {
				mem = list.get(i);
				pwriter.print(mem.getName() + ",");
				pwriter.print(mem.getNumber() + ",");
				pwriter.print(mem.getAddress() + ",");
				pwriter.print(mem.getCity() + ",");
				pwriter.print(mem.getState() + ",");
				pwriter.print(mem.getZipCode() + ",");
				pwriter.print(mem.getStatus() + "\n");
			}
			pwriter.close();
			System.out.println("Member File Written Successfully");
		}
		catch (Exception e) {
			System.out.println("Could Not Write To File");
		}
	}
	
	/**
	 * Clears the member list
	 */
	public void clear()
	{
		list.clear();
	}
	
	/**
	 * Allows access to the member list
	 * @return	Returns the member list
	 */
	public ArrayList<Member> getMemberList() {
		return this.list;
	}
}
