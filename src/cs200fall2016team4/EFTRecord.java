package cs200fall2016team4;

/**EFTRecord Class
 * 
 * Defines single EFT Record class data type
 * 
 * @author Noah Gleason
 */
public class EFTRecord {
	
	/**
	 * private variables:
	 * 	providerName - name of provider for record
	 * 	providerNumber - provider's number
	 * 	paymentAmount - amount paid
	 */
	private String providerName;
	private String providerNumber;
	private Double paymentAmount;
	
	/**
	 * Default EFTRecord constructor which sets variables to empty default values 
	 */
	public EFTRecord() {
		this.providerName = "";
		this.providerNumber = "";
		this.paymentAmount = 0.0;
	}
	
	/**
	 * EFTRecord constructor to set values based on arguments
	 * 
	 * @param provider		used to set provider name and number
	 * @param payment		used to set payment amount
	 */
	public EFTRecord(Provider provider, Double payment) {
		this.providerNumber = provider.getNumber();
		this.providerName = provider.getName();
		this.paymentAmount = payment;
	}
	
	/**
	 * Sets providerName
	 * 
	 * @param name		used to set providerName
	 */
	public void setname(String name) {
		this.providerName = name;
	}
	
	/**
	 * Gets providerName
	 * 
	 * @return providerName		name of provider
	 */
	public String getName() {
		return this.providerName;
	}
	
	/**
	 * Sets providerNumber
	 * 
	 * @param number	used to set providerNumber
	 */
	public void setNumber(String number) {
		this.providerNumber = number;
	}
	
	/**
	 * Gets providerNumber
	 * 
	 * @return providerNumber	number of provider
	 */
	public String getNumber() {
		return this.providerNumber;
	}
	
	/**
	 * Sets paymentAmount
	 * 
	 * @param payment	used to set paymentAmount
	 */
	public void setPayment(Double payment) {
		this.paymentAmount = payment;
	}
	
	/**
	 * Gets paymentAmount
	 * 
	 * @return paymentAmount	amount of payment
	 */
	public String getPayment() {
		return String.valueOf(this.paymentAmount);
	}
}
