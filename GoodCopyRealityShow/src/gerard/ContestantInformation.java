package gerard;
import java.util.Scanner;
import java.util.Calendar;

/**
 * 
 * This class will get the fist name, last name age, birthday, street number, 
 * street name, Province, city, postal code and phone number of a person for a 
 * Reality show..
 * 
 * @author Timothy Gerard 
 *
 */

@SuppressWarnings("rawtypes")
public class ContestantInformation implements Comparable {

	private String Fname, Lname, StName, City, PostalCode, PhoneNum;
	private int StNum;
	private Calendar Bday;
	private Province province;
	
	/**   
	 * 
	 * @param firstName to set the first name
	 */
	public void setFname(String firstName) throws InvalidInputException{
		for(int a = 0; a < firstName.length(); a++ ){
			if (!Character.isLetter(firstName.charAt(a)))
			throw new InvalidInputException("Please check to insure that there are no numbers or symbols.");
		}
		firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1).toLowerCase();
		this.Fname = firstName;
	}
	/**
	 * 
	 * @param lastName to set the last name
	 */
	public void setLname(String lastName )throws InvalidInputException {
		for(int i = 0; i <lastName.length(); i++ ){
			if (!Character.isLetter(lastName.charAt(i)))
			throw new InvalidInputException("Please check to insure that there are no numbers or symbols.");
		}
		lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
		this.Lname = lastName;
	}
	/**
	 * 
	 * @param stName to set the street name
	 */
	public void setStName(String stName)throws InvalidInputException {
		for(int e = 0; e < stName.length(); e++ ){
			if (!Character.isLetter(stName.charAt(e)))
			throw new InvalidInputException("Please check to insure that there are no numbers or symbols.");
		}
		stName = Character.toUpperCase(stName.charAt(0)) + stName.substring(1);
		this.StName = stName;
	}
	/**
	 * 
	 * @param provance to set the Province
	 */
	public void setProvince(Province province) throws  InvalidInputException{
//		for(int c = 0; c <= province.length(); c++ ){
//			if (!Character.isLetter(province.charAt(c)))
//				throw new InvalidInputException("Please check to insure that there are no numbers or symbols.");
//		}
//		province = Character.toUpperCase(province.charAt(0)) + province.substring(1).toLowerCase();
		this.province = province;
	}
	/**
	 * 
	 * @param city to set the city
	 */
	public void setCity(String city) throws  InvalidInputException{
		for(int d = 0; d < city.length(); d++ ){
			if (!Character.isLetter(city.charAt(d)))
				throw new InvalidInputException("Please check to insure that there are no numbers or symbols.");
		}
		city= Character.toUpperCase(city.charAt(0)) + city.substring(1).toLowerCase();
		this.City = city;
	}
	/**
	 * 
	 * @param stNum to set the street number
	 */
	public void setStNum(String stNum)throws  InvalidInputException {
		for(int f = 0; f < stNum.length(); f++ ){
			if (!Character.isDigit(stNum.charAt(f)))
				throw new InvalidInputException("Please check to insure that there are no letters or symbols.");
		}
		this.StNum = Integer.parseInt(stNum);
	}
	/**
	 * 
	 * @param phoneNum to set the phone number
	 */
	public void setPhoneNum(String phoneNum) throws InvalidInputException {
		if(phoneNum.length() > 10)
			throw new InvalidInputException("The phone number that you have given us has to many charactars please input 10 characters.");
		else if(phoneNum.length() < 10)
			throw new InvalidInputException("The phone number that you have given us has to feww charactars please input 10 characters.");
		for(int b = 0; b <phoneNum.length(); b++ ){
			if (!Character.isDigit(phoneNum.charAt(b)))
				throw new InvalidInputException("Please check to insure that there are no letters or symbols.");
		}
				this.PhoneNum = phoneNum;
	}
	/**
	 * 
	 * @param bDay to set the birth day of the person as a calendar object
	 */
	public void setBday(Calendar bDay) throws InvalidInputException{
		
		this.Bday = bDay;
	}
	/**
	 * 
	 * @param postalCode set the persons postal code
	 */
	public void setPostalCode(String postalCode) throws InvalidInputException{
	 
		if(postalCode.length() > 6)
			throw new InvalidInputException("The postal code has to many charactars please input 6 characters.");
		else if(postalCode.length() < 6)
			throw new InvalidInputException("The postal code does not have enough characters please input 6 characters.");
		else if (!Character.isLetter(postalCode.charAt(0)))
			throw new InvalidInputException("Please make the fist character a letter.");
		else if (!Character.isLetter(postalCode.charAt(2)))
			throw new InvalidInputException("Please make the third character a letter.");
		else if (!Character.isLetter(postalCode.charAt(4)))
			throw new InvalidInputException("Please make the fifth character a letter.");
		else if (!Character.isDigit(postalCode.charAt(1)))
			throw new InvalidInputException("Please make the second character a number.");
		else if (!Character.isDigit(postalCode.charAt(3)))
			throw new InvalidInputException("Please make the fourth character a number.");
		else if (!Character.isDigit(postalCode.charAt(5)))
			throw new InvalidInputException("Please make the sixth character a number.");
		else
			
		this.PostalCode = postalCode;
		
	}
	/**
	 * 
	 * @return Fname
	 * gets the first name
	 */
	public String getFname() {
		return this.Fname;
	}
	/**
	 * 
	 * @return Lname
	 * gets the last name 
	 */
	public String getLname() {
		return this.Lname;
	}

	/**
	 * 
	 * @return StName
	 * gets the st name
	 */
	public String getStName() {
		return this.StName;
	}
	/**
	 * 
	 * @return Province
	 * gets the province
	 */
	public Province getProvince() {
		return this.province;
	}
	/**
	 * 
	 * @return City
	 * gets the city
	 */
	public String getCity() {
		return this.City;
	}
	/**
	 * 
	 * @return StNum
	 * gets the st number
	 */
	public int getStNum() {
		return this.StNum;
	}
	/**
	 * 
	 * @return PhoneNum
	 * gest the phone number
	 */
	public String getPhoneNum() {
		return this.PhoneNum;
	}
	/**
	 * 
	 * @return Bday 
	 * gets the birth day
	 */
	public Calendar getBday() {
		return this.Bday;
	}
	/**
	 * 
	 * @return PostalCode
	 * gets the postalcode
	 */
	public String getPostalCode() {
		return this.PostalCode;
	}
	/**
	 * 
	 */
	public ContestantInformation() {

	}
	/**
	 * print the persons fist name, last name age, birthday, street number, street name, 
	 * Province, city, postal code and phone number on one line.
	 */
	public String toString() {
		return Fname + ", " + Lname + ", " + Bday.get(Calendar.YEAR) + "/" + (Bday.get(Calendar.MONTH) + 1) + "/" + Bday.get(Calendar.DAY_OF_MONTH) + ", " + StNum + ", " + StName + ", " + province + ", " + City + ", " + PostalCode + ", " + PhoneNum;  
	}
	/**
	 * 
	 * @param firstN
	 * @param lastN
	 * @param age
	 * @param bDay
	 */
	public ContestantInformation(String firstN, String lastN, int age, Calendar bDay)throws InvalidInputException{
		setFname(firstN);
		setLname(lastN);
		setBday(bDay); 
	}
	/**
	 * 
	 * @param SNum
	 * @param SName
	 */
	public ContestantInformation(int stNum, String stNa)throws InvalidInputException {
		setStNum(Integer.toString(stNum));
		setStName(stNa);
	}
	/**
	 * 
	 * @param prov
	 * @param city
	 * @param postalC
	 * @param phoneN
	 */
	public ContestantInformation(Province prov , String city, String postalC, String phoneN )throws InvalidInputException{
		setProvince(prov);
		setCity(city);
		setPostalCode(postalC);
		setPhoneNum(phoneN);
	}
	
	/**
	 * 
	 * @param ci
	 * @return
	 * compairs one contestant to another
	 */
	public int compareTo(Object agrs){
		ContestantInformation ci = (ContestantInformation)agrs;
		if(ci.getLname().compareTo(this.Lname) < 0)
			return -1;
		else if(ci.getLname().compareTo(this.Lname) > 0)
			return 1;
		else
			if(ci.getFname().compareTo(this.Fname) < 0)
				return -1;
		if(ci.getFname().compareTo(this.Fname) > 0)
			return 1 ;
		else
			return 0;			
	}
	/**
	 * 
	 * @param ci
	 * @return
	 * and equals method in case there are 2 people with the same name 
	 */
	
 public boolean equals(ContestantInformation ci){
	 if(ci.getFname().equals(this.Fname) && ci.getLname().equals(this.Lname))
		 return true;
	 
	 return false;
	 
 }
}

