package gerard;

/**
 * @author Timothy Gerard
 * this class creates a format so the user can print the users names and info out.
 *
 */
public class Label {
	private ContestantInformation ci;
	private String output;

/**
 * 
 * @param ci
 */
	public Label(ContestantInformation ci){
		this.ci = ci;
		formatName();
		formatAdress();
		formatPhoneNum();
	}
	/**
	 * formats the users name information
	 */
	public void formatName(){
		this.output = ci.getFname() + " " + ci.getLname();
		//return formatName();
		
	}
	/**
	 * formats all of the uses adress info
	 */
	public void formatAdress(){
		this.output = output + ", " +  ci.getStNum() + " " + ci.getStName();
		this.output = output + ", " + ci.getCity() + " " + ci.getProvince();
		this.output = output + ", " + ci.getPostalCode();
		//return formatAdress();
	}
	/**
	 * formats the users phone number
	 */
	public void formatPhoneNum(){
		this.output = output + ", " + ci.getPhoneNum();
		//return formatPhoneNum();
}
	/**
	 * 
	 */
	public String toString(){
		return output;
	}
}