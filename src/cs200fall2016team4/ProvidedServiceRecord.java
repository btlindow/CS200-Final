package cs200fall2016team4;

/**ProvidedServiceRecord
 * 
 * Class declaration for Records of services that have been provided, to be put into a list
 * 
 * @author Stephen Plautz
 *
 */

/**
 * declaring class ProvidedServiceRecord that is a subclass of ServiceItem
 */
public class ProvidedServiceRecord extends ServiceItem {
	
	Member member;
	Provider provider;
	String serviceDTG;
	String currentDTG;
	String comments;
	
	public ProvidedServiceRecord(ServiceItem s, Member mem, Provider pro, String dateAndTime, String com) {
		super(s.getName(), s.getCode(), s.getFee());
		member = mem;
		provider = pro;
		serviceDTG = dateAndTime;
		comments = com;
	}
	
	/**
	 * returns the date and time when service was performed
	 * 
	 * @return
	 */
	public String getDate() {
		return this.serviceDTG;
	}
	
	/**
	 * returns the comments added to a service performed
	 * 
	 * @return
	 */
	public String getComments() {
		return this.comments;
	}
	
	/**
	 * returns the date and time currently
	 * @return
	 */
	public String getCurrentDTG(){
		return this.currentDTG;
	}
	
	/**
	 * sets the current date and time
	 * 
	 * @param CTG
	 */
	public void setCurrentDTG(String CTG){
		this.currentDTG = CTG;
	}
	
	
}
