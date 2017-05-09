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

/**
 * 
 * @author Ben Lindow
 *
 */

public class AddMemberTest {
	
	@Test
	public void testSuccess() {
		MemberList mList = new MemberList();
		mList.populateMemberList();
		
		List<String> args = new ArrayList<String>();
		args.add("Richard Cranium");
		args.add("999888777");
		args.add("321 Fake Court");
		args.add("Fakeville");
		args.add("Kentucky");
		args.add("12321");
		
		//Test for success!
		OperatorTerminal.addMember(mList, args);
		
		Member member = mList.findMemberByNumber("999888777");
		
		assertNotEquals(member, null);
		
		//test member attributes
		String string = member.getName();
		assertEquals(string, "Richard Cranium");	
		string = member.getNumber();
		assertEquals(string, "999888777");
		string = member.getState();
		assertEquals(string, "Kentucky");
	}
	
	@Test
	public void testSanity() {
		MemberList mList = new MemberList();
		mList.populateMemberList();
		
		List<String> args = new ArrayList<String>();
		args.add("Richard Cranium");
		args.add("999888777");
		args.add("321 Fake Court");
		args.add("Fakeville");
		args.add("Kentrucky");
		args.add("12321");
		
		//Test for my sanity!
		OperatorTerminal.addMember(mList, args);
		
		Member member = mList.findMemberByNumber("999888777");
		
		assertNotEquals(member, null);
		
		//set and reset member attributes
		member.setName("Bobby Hill");
		member.setName("Richard Cranium");
		member.setNumber("123123123");
		member.setNumber("999888777");
		member.setState("Oregon");
		member.setState("Kentucky");
		
		String string = member.getName();
		assertEquals(string, "Richard Cranium");
		string = member.getNumber();
		assertEquals(string, "999888777");
		string = member.getState();
		assertEquals(string, "Kentucky");
	}
	
	
	
	@Test
	public void testFailure() {
		MemberList mList = new MemberList();
		mList.populateMemberList();
		
		List<String> args = new ArrayList<String>();
		args.add("Richard Cranium");
		args.add("999888777");
		args.add("321 Fake Court");
		args.add("Fakeville");
		args.add("Kentrucky");
		args.add("12321");
		
		//Test for failure!
		OperatorTerminal.addMember(mList, args);
				
		Member member = mList.findMemberByNumber("999888777");
		
		assertNotEquals(member, null);

		String string = member.getName();
		assertNotEquals(string, "Richards Cranium");		
		string = member.getNumber();
		assertNotEquals(string, "777888999");
		string = member.getState();
		assertNotEquals(string, "Oregon");
	}
	
}
