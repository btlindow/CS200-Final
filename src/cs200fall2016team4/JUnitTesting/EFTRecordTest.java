package cs200fall2016team4.JUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import cs200fall2016team4.EFTRecord;
import cs200fall2016team4.Provider;

//Test Created By Ben Lindow


public class EFTRecordTest {
	
	EFTRecord eRecord;

	@Test
	public void testGetName() {
		Provider provider = new Provider("MyName", "123123123", "123 Fake St.", "Tuscaloosa", "AL", "35401");
		eRecord = new EFTRecord(provider, 99.99);
		String name = eRecord.getName();
		assertEquals("MyName", name);
	}

	@Test
	public void testGetNumber() {
		Provider provider = new Provider("MyName", "123123123", "123 Fake St.", "Tuscaloosa", "AL", "35401");
		eRecord = new EFTRecord(provider, 99.99);
		String number = eRecord.getNumber();
		assertEquals("123123123", number);
	}

	@Test
	public void testGetPayment() {
		Provider provider = new Provider("MyName", "123123123", "123 Fake St.", "Tuscaloosa", "AL", "35401");
		eRecord = new EFTRecord(provider, 99.99);
		Double payment = Double.parseDouble(eRecord.getPayment());
		assertEquals(99.99, payment, 0.00);
	}

}
