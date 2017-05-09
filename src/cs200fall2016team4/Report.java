package cs200fall2016team4;

import java.io.*;

/**Report Class
 * 
 * Defines single Report class data type
 * 
 * @author Noah Gleason
 */
public abstract class Report {
	
	/**
	 * public variable:
	 * 	file - 
	 * 
	 * private variables:
	 * 	name, number, street, city, state, zip - information about subject of Report
	 */
	public File file;
	private String name, number, street, city, state, zip;
	
	/**
	 * Default constructor which sets variables to empty default values
	 */
	public Report() {
		this.name = "";
		this.number = "";
		this.street = "";
		this.city = "";
		this.state = "";
		this.zip = "";
	}
	
	/**
	 * Constructor to set values based on arguments
	 * 
	 * @param name		name on Report
	 * @param number	number on Report
	 * @param street	street on Report
	 * @param city		city on Report
	 * @param state		state on Report
	 * @param zip		zip on Report
	 */
	public Report(String name, String number, String street, String city, String state, String zip) {
		this.name = name;
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/**
	 * Abstract Report Generation to be defined by extended classes
	 * 
	 * @param psl	list of provided services
	 */
	public abstract void generateReport(ProvidedServiceList psl);
	
	/**
	 * Sets name
	 * 
	 * @param name		used to set value of name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets name
	 * 
	 * @return name		name on Report
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets number
	 * 
	 * @param number	used to set value of number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Gets Number
	 * 
	 * @return number	number on Report
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Sets street
	 * 
	 * @param street	used to set value of street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Get street
	 * 
	 * @return street	street on Report
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets city
	 * 
	 * @param city		used to set value of city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets city
	 * 
	 * @return city		city on Report
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets state
	 * 
	 * @param state		used to set value of state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Get state
	 * 
	 * @return state	state on Report
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets zip
	 * 
	 * @param zip		used to set value of zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * Get Zip
	 * 
	 * @return zip		zipcode on Report
	 */
	public String getZip() {
		return zip;
	}
}
