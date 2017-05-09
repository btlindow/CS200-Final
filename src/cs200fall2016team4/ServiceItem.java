package cs200fall2016team4;
/**
 * Service Class
 * 
 * Holds information pertaining to services
 * 
 * @author Bryan Pauken 
 *
 */
public class ServiceItem {
	
	//Variables of a service
	private String name, code;
	private String fee;
	
	/**
	 * @param name		the name of the service
	 * @param code		the code of the service
	 * @param fee		the fee of the service
	 */
	public ServiceItem(String name, String code, String fee) {
		this.name = name;
		this.code = code;
		this.fee = fee;
	}
	
	/**
	 * Prints the name, code, and fee of the service
	 */
	public void printService() {
		System.out.println("Service Name: " + this.name);
		System.out.println("Service Code: " + this.code);
		System.out.println("Service Fee: " + this.fee);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getFee() {
		return fee;
	}
	
	public void setFee(String fee) {
		this.fee = fee;
	}
}
