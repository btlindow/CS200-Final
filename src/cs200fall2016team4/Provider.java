package cs200fall2016team4;

/**Provider Class
 * 
 * Holds information the pertains to providers
 * 
 * @author Bryan Pauken
 *
 */
public class Provider {
	
	//Variables of provider
	private String name, number, address, city, state, zipCode;
	
	/**
	 * @param name			the name of the provider
	 * @param number		the number of the provider
	 * @param address		the street name and number of the provider
	 * @param city			the city of the provider
	 * @param state			the state of the provider
	 * @param zipCode		the Zip Code of the provider
	 */
	
	public Provider(String name, String number, String address, String city, String state, String zipCode) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/**
	 * rints the name, number, address, city, state, and zipcode of a provider
	 */
	public void printProvider() {
		System.out.println("Provider Name: " + this.getName());
		System.out.println("Provider ID: " + this.getNumber());
		System.out.println("Street: " + this.getAddress());
		System.out.println("City: " + this.getCity());
		System.out.println("State: " + this.getState());
		System.out.println("ZipCode: " + this.getZipCode());

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
    
}
