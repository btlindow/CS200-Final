package cs200fall2016team4.JUnitTesting;

/**JUnit test for Updating Member
 * 
 * Test success and failure of updating provider
 * 
 * @author Stephen Plautz
 */

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import cs200fall2016team4.Provider;
import cs200fall2016team4.ProviderList;
import cs200fall2016team4.MemberList;
import cs200fall2016team4.OperatorTerminal;

public class UpdateProviderTest {

	/*
	 * Test for success
	 */
	@Test
	public void testS() {
		Provider prov = new Provider("ACME","123456789","15th Street","Tuscaloosa","AL","35401");
		ProviderList provList = new ProviderList();
		provList.addProviderToList(prov);
		
		/*
		 * Initializing values to update the provider with
		 */
		List<String> args = new ArrayList<String>();
		args.add("123456789"); //selects which provider to update
		args.add("Updated Name");
		args.add("Updated Street");
		args.add("Updated City");
		args.add("Updated State");
		args.add("Updated ZIP");
		
		OperatorTerminal.updateProvider(provList, args);
		
		/*
		 * In order to succeed, the test provider should have the new Values
		 */
		assertEquals(prov.getName(), "Updated Name");
		assertEquals(prov.getAddress(), "Updated Street");
		assertEquals(prov.getCity(), "Updated City");
		assertEquals(prov.getState(), "Updated State");
		assertEquals(prov.getZipCode(), "Updated ZIP");
	}
	
	/*
	 * Test for failure
	 */
	@Test
	public void testF() {
		Provider prov = new Provider("ACME","123456789","15th Street","Tuscaloosa","AL","35401");
		ProviderList provList = new ProviderList();
		provList.addProviderToList(prov);
		
		/*
		 * Initializing values to update another provider with
		 */
		List<String> args = new ArrayList<String>();
		args.add("123456780"); //different provider number than one desired
		args.add("Updated Name");
		args.add("Updated Street");
		args.add("Updated City");
		args.add("Updated State");
		args.add("Updated ZIP");
		
		OperatorTerminal.updateProvider(provList, args);
		
		/*
		 * In order to succeed, the test provider should not have the new Values
		 */
		assertNotEquals(prov.getName(), "Updated Name");
		assertNotEquals(prov.getAddress(), "Updated Street");
		assertNotEquals(prov.getCity(), "Updated City");
		assertNotEquals(prov.getState(), "Updated State");
		assertNotEquals(prov.getZipCode(), "Updated ZIP");
}

/**
 * Test Sanity when provider is updated then changed
 */
@Test
public void testSanity() {
	Provider prov = new Provider("ACME","123456789","15th Street","Tuscaloosa","AL","35401");
	ProviderList provList = new ProviderList();
	provList.addProviderToList(prov);

	List<String> args = new ArrayList<String>();
	args.add("123456789");
	args.add("New Name"); 
	args.add("New Street");
	args.add("New City");
	args.add("New State");
	args.add("New ZIP");
	

	OperatorTerminal.updateProvider(provList, args);
	
	args.add("123456789");
	args.add("Test Name"); 
	args.add("123 Test Street");
	args.add("Testville");
	args.add("TE");
	args.add("12345");
	
	OperatorTerminal.updateProvider(provList, args);
	
	assertEquals(prov.getName(), "Test Name");
	assertEquals(prov.getAddress(), "123 Test Street");
	assertEquals(prov.getCity(), "Testville");
	assertEquals(prov.getState(), "TE");
	assertEquals(prov.getZipCode(), "12345");		
}
}
