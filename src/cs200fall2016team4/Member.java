package cs200fall2016team4;

/**Member class
 * 
 * Holds information the pertains to each member
 * 
 * @author Bryan Pauken - AKA Super Sub-Average Coder
 * 
 */

public class Member {
	
	//Variables of a member
	private String name, number, address, city, state, zipCode, status;
	
	/**
	 * @param name			the name of the member
	 * @param number		the number of the member
	 * @param address		the street name and number of the member
	 * @param city			the city of the member
	 * @param state			the state of the member
	 * @param zipCode		the Zip Code of the member
	 * @param status		the status of the member (Valid, Invalid, Suspended)
	 */
	
	public Member(String name, String number, String address, String city, String state, String zipCode, String status){
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.status = status;
	}
	
	/**
	 * Prints the name, number, address, city, state, zipcode, and status of a member
	 */
	public void printMember() {
		System.out.println("Member Name: " + this.getName());
		System.out.println("Member ID: " + this.getNumber());
		System.out.println("Street: " + this.getAddress());
		System.out.println("City: " + this.getCity());
		System.out.println("State: " + this.getState());
		System.out.println("ZipCode: " + this.getZipCode());
		System.out.println("Member Status: " + this.getStatus());		
	}
	
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getNumber() {
    	return number;
    }
    
    public void setNumber(String number) {
    	this.number = number;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public String getCity() {
    	return city;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    public String getState() {
    	return state;
    }
    
    public void setState(String state) {
    	this.state = state;
    }
    
    public String getZipCode() {
    	return zipCode;
    }
    
    public void setZipCode(String zipCode) {
    	this.zipCode = zipCode;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
    
    
}
