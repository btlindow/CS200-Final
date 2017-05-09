package cs200fall2016team4.JUnitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import cs200fall2016team4.Member;
import cs200fall2016team4.MemberList;
import cs200fall2016team4.ProviderTerminal;

/**
 * JUnit test for Validating a Member
 * @author Bryan
 *
 */

public class ValidateMemberTest {
	Member member1 = new Member("Ben The Man Lindow", "111111111", "123 Fake St.", "Tuscaloosa", "AL", "35401", "v");
	Member member2 = new Member ("Noah Ark Builder Gleason", "222222222", "Not A Real Avenue","Tuscaloosa", "AL", "35401", "v");
	Member member3 = new Member ("Adam Average Coder Alred", "333333333", "1 University Avenue","Normal", "IL", "61761", "v");
	Member member4 = new Member ("Bryan Strong Bodied Pauken", "444444444", "2412 IDK Street", "Bloomington", "IL","61704", "v");
	MemberList memList = new MemberList();
	
	/**
	 * Test for success
	 */
	@Test
	public void TestValidateMember() {
		memList.addMemberToList(member1);
		memList.addMemberToList(member2);
		memList.addMemberToList(member3);
		List<String> args = new ArrayList<String>();
		args.add("111111111");
		args.add("222222222");
		args.add("333333333");
		
		Member testmem = ProviderTerminal.validateMember(args,  memList);
		assertEquals(testmem.getName(), "Ben The Man Lindow");
		
		testmem = ProviderTerminal.validateMember(args, memList);
		assertEquals(testmem.getName(), "Noah Ark Builder Gleason");
		
		testmem = ProviderTerminal.validateMember(args, memList);
		assertEquals(testmem.getName(), "Adam Average Coder Alred");
		
	}
	
	/**
	 * Test for failure
	 */
	@Test
	public void TestValidateMemberInvalid() {
		memList.addMemberToList(member1);
		memList.addMemberToList(member2);
		memList.addMemberToList(member3);
		
		List<String> args = new ArrayList<String>();
		args.add("999999999");
		
		Member testmem = ProviderTerminal.validateMember(args,  memList);
		assertEquals(testmem, null);
	}
	
	/**
	 * Test when name is changed
	 */
	@Test
	public void TestValidateMemberWhenNameIsChanged(){
		memList.addMemberToList(member1);
		memList.addMemberToList(member2);
		memList.addMemberToList(member3);
		
		member1.setName("Ben Is Not The Man Lindow");
		
		List<String> args = new ArrayList<String>();
		args.add("111111111");
		args.add("222222222");
		args.add("333333333");
		
		Member testmem = ProviderTerminal.validateMember(args,  memList);
		assertEquals(testmem.getName(), "Ben Is Not The Man Lindow");
		
		testmem = ProviderTerminal.validateMember(args,  memList);
		assertEquals(testmem, member2);
		
		testmem = ProviderTerminal.validateMember(args,  memList);
		assertEquals(testmem, member3);
		
		member1.setName("Ben The Man Lindow");
		
		args.add("111111111");
		testmem = ProviderTerminal.validateMember(args,  memList);
		assertEquals(testmem.getName(), "Ben The Man Lindow");
	}
	
	/**
	 * Test when number is changed
	 */
	@Test
	public void TestValidateMemberNumberChange(){
		memList.addMemberToList(member1);

		member1.setNumber("123123123");
		
		List<String> args = new ArrayList<String>();
		args.add("111111111");
		args.add("123123123");
		
		Member testmem = ProviderTerminal.validateMember(args,  memList);
		
		/**
		 * No member should be found because the number has been changed
		 */
		assertEquals(testmem, null);
		
		testmem = ProviderTerminal.validateMember(args,  memList);
		
		/**
		 * Should find member because number matches
		 */
		assertEquals(testmem.getName(),  "Ben The Man Lindow");
		
	}
}

