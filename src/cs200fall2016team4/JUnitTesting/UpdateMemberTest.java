package cs200fall2016team4.JUnitTesting;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import cs200fall2016team4.Member;
import cs200fall2016team4.MemberList;
import cs200fall2016team4.OperatorTerminal;

/**JUnit test for Updating Member
 * 
 * Test success and failure of updating member
 * 
 * @author Noah Gleason
 */
public class UpdateMemberTest {
	
	/**
	 * Test member
	 */
	Member testmem = new Member("Test Name", "123456789", "123 Test Street", "Testville", "TE", "12345", "v");
	
	/**
	 * Tests successful update of a member
	 */
	@Test
	public void testSuccess() {
		//Creates new MemberList and adds test member to it
		MemberList mList = new MemberList();
		mList.addMemberToList(testmem);
		
		//Creates list of strings with new information for member
		List<String> args = new ArrayList<String>();
		args.add("123456789");
		args.add("New Name"); 
		args.add("New Street");
		args.add("New City");
		args.add("New State");
		args.add("New ZIP");
		
		//Calls actual update member function
		OperatorTerminal.updateMember(mList, args);
		
		assertEquals(testmem.getName(), "New Name");
		assertEquals(testmem.getAddress(), "New Street");
		assertEquals(testmem.getCity(), "New City");
		assertEquals(testmem.getState(), "New State");
		assertEquals(testmem.getZipCode(), "New ZIP");
	}

	/**
	 * Test failed update of a member 
	 */
	@Test
	public void testFailure() {
		//Creates new MemberList and adds test member to it
		MemberList mList = new MemberList();
		mList.addMemberToList(testmem);
		
		//Creates list of strings with new information for member
		List<String> args = new ArrayList<String>();
		args.add("123456788"); //does not match member's number
		args.add("New Name"); 
		args.add("New Street");
		args.add("New City");
		args.add("New State");
		args.add("New ZIP");
		
		//Calls actual update member function
		OperatorTerminal.updateMember(mList, args);
		
		//Checks every attribute to see if any did not change
		assertNotEquals(testmem.getName(), "New Name");
		assertNotEquals(testmem.getAddress(), "New Street");
		assertNotEquals(testmem.getCity(), "New City");
		assertNotEquals(testmem.getState(), "New State");
		assertNotEquals(testmem.getZipCode(), "New ZIP");
	}
	
	/**
	 * Test Sanity when member is updated then changed
	 */
	@Test
	public void testSanity() {
		//Creates new MemberList and adds test member to it
		MemberList mList = new MemberList();
		mList.addMemberToList(testmem);
		
		//Creates list of strings with new information for member
		List<String> args = new ArrayList<String>();
		args.add("123456789");
		args.add("New Name"); 
		args.add("New Street");
		args.add("New City");
		args.add("New State");
		args.add("New ZIP");
		
		//Calls actual update member function
		OperatorTerminal.updateMember(mList, args);
		
		args.add("123456789");
		args.add("Test Name"); 
		args.add("123 Test Street");
		args.add("Testville");
		args.add("TE");
		args.add("12345");
		
		OperatorTerminal.updateMember(mList, args);
		
		assertEquals(testmem.getName(), "Test Name");
		assertEquals(testmem.getAddress(), "123 Test Street");
		assertEquals(testmem.getCity(), "Testville");
		assertEquals(testmem.getState(), "TE");
		assertEquals(testmem.getZipCode(), "12345");		
	}
}
