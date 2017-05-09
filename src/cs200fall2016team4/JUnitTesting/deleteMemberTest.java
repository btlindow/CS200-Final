package cs200fall2016team4.JUnitTesting;

import static org.junit.Assert.*; 

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/*
 * JUnit test by Adam Alred. Tests to make sure addMember in OperatorTerminal function
 */

import cs200fall2016team4.Member;
import cs200fall2016team4.MemberList;
import cs200fall2016team4.OperatorTerminal;

//Junit test created by Adam J. Alred

public class deleteMemberTest {
	
	@Test
	public void testSuccess() {
		Member mem = new Member("Billy Bob", "123456789", "716 Carl Raines Lake Road", "Birmingham", "AL", "35244", "v");
		MemberList mList = new MemberList();
		mList.populateMemberList();
		mList.addMemberToList(mem);
		
		List<String> args = new ArrayList<String>();
		args.add("123456789");
		//Test for success!
		OperatorTerminal.deleteMember(mList, args);
		
		Member member = mList.findMemberByNumber("123456789");
		
		assertEquals(member, null);
	}
	
	@Test
	public void testFailure(){
		Member mem = new Member("Billy Bob", "123456789", "716 Carl Raines Lake Road", "Birmingham", "AL", "35244", "Validated");
		MemberList mList = new MemberList();
		mList.populateMemberList();
		mList.addMemberToList(mem);
		
		List<String> args = new ArrayList<String>();
		args.add("123456780");
		//Test for failure!
		OperatorTerminal.deleteMember(mList, args);
		
		Member member = mList.findMemberByNumber("123456789");
		
		assertNotEquals(member, null);
		
	}
	
	@Test
	public void testSanity(){
		Member mem = new Member("Billy bob", "123456789", "716 Carl Raines Lake Road", "Birmingham", "AL", "35244", "Validated");
		MemberList mList = new MemberList();
		mList.populateMemberList();
		mList.addMemberToList(mem);
		
		List<String> args = new ArrayList<String>();
		args.add("123456789");
		//deleting member....
		OperatorTerminal.deleteMember(mList, args);
		
		//Adding member back to the memberlist to make sure delete works properly
		mList.addMemberToList(mem);
		
		Member member = mList.findMemberByNumber("123456789");
		String name = member.getName();
		assertEquals(name, "Billy bob");
	}

}
