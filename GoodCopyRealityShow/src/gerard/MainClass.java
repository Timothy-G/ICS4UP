/**
 * 
 */
package gerard;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Timothy Gerard 
 * This class i s the main class and exicutes the program
 *
 */
import java.util.Scanner;
public class MainClass {
	/**
	 * 
	 */
	 static Scanner scan = new Scanner(System.in);
	/**
	 * 
	 * @param month
	 * @param dob
	 * method that calculates the date of birth 
	 */
	 public static void setMonth(int month, Calendar dob){
		 	if(month == 1)
		 		dob.set(Calendar.MONTH, Calendar.JANUARY);
		 	else if(month == 2)
		 		dob.set(Calendar.MONTH, Calendar.FEBRUARY);
		 	else if(month == 3)
		 		dob.set(Calendar.MONTH, Calendar.MARCH);
		 	else if(month == 4)
		 		dob.set(Calendar.MONTH, Calendar.APRIL);
		 	else if(month == 5)
		 		dob.set(Calendar.MONTH, Calendar.MAY);
		 	else if(month == 6)
		 		dob.set(Calendar.MONTH, Calendar.JUNE);
		 	else if(month == 7)
		 		dob.set(Calendar.MONTH, Calendar.JULY);
		 	else if(month == 8)
		 		dob.set(Calendar.MONTH, Calendar.AUGUST);
		 	else if(month == 9)
		 		dob.set(Calendar.MONTH, Calendar.SEPTEMBER);
		 	else if(month == 10)
		 		dob.set(Calendar.MONTH, Calendar.OCTOBER);
		 	else if(month == 11)
		 		dob.set(Calendar.MONTH, Calendar.NOVEMBER);
		 	else if(month == 12)
		 		dob.set(Calendar.MONTH, Calendar.DECEMBER);
		}
	 /**
	  * 
	  * @param prov
	  * @return
	  * method for the name of the province
	  */
	public static Province findProv(String prov){
		if (prov.equalsIgnoreCase("Alberta")||prov.equalsIgnoreCase("AB"))
			return Province.AB;		
		else if (prov.equalsIgnoreCase("BrithishColumbia")||prov.equalsIgnoreCase("BC")|| prov.equalsIgnoreCase("Brithish Columbia"))
			return Province.BC;		
		else if (prov.equalsIgnoreCase("Manitoba")||prov.equalsIgnoreCase("MB"))
			return Province.MB;			
		else if (prov.equalsIgnoreCase("NewBrunswick")||prov.equalsIgnoreCase("NB")||prov.equalsIgnoreCase("New Brunswick"))
			return Province.NB;			
		else if (prov.equalsIgnoreCase("NewFoundLand")||prov.equalsIgnoreCase("NL"))
			return Province.NL;			
		else if (prov.equalsIgnoreCase("NovaScotia")||prov.equalsIgnoreCase("NS"))
			return Province.NS;			
		else if (prov.equalsIgnoreCase("NorthWestTerritory")||prov.equalsIgnoreCase("NT"))
			return Province.NT;			
		else if (prov.equalsIgnoreCase("Nunavut")||prov.equalsIgnoreCase("NU"))
			return Province.NU;			
		else if (prov.equalsIgnoreCase("Ontario")||prov.equalsIgnoreCase("Ont.")||prov.equalsIgnoreCase("ON"))
			return  Province.ON;		
		else if (prov.equalsIgnoreCase("PrinceEdwardIsland")||prov.equalsIgnoreCase("Prince Edward Island")||prov.equalsIgnoreCase("PEI"))
			return  Province.PEI;		
		else if (prov.equalsIgnoreCase("Quebec")||prov.equalsIgnoreCase("QC"))
			return Province.QC;		
		else if (prov.equalsIgnoreCase("Yukon")||prov.equalsIgnoreCase("Yukon Territory")||prov.equalsIgnoreCase("YT"))
			return  Province.YT;		
		else if (prov.equalsIgnoreCase("Saskatchiwan")||prov.equalsIgnoreCase("SK"))
			return  Province.SK;
		
		return null;	
	}
	
	public static Calendar stringToCalendar(String everything){
		Calendar bday = new GregorianCalendar();	
		bday.set(Calendar.YEAR, Integer.parseInt(everything.substring(0,4)));
		setMonth(Integer.parseInt(everything.substring(5,7)),bday);
		bday.set(Calendar.DAY_OF_MONTH, Integer.parseInt(everything.substring(8,10)));
		return bday;
	}
	/**
	 * 
	 * @param aL
	 * method that adds a new contestant
	 */
	 public static void addContestant(ArrayList <ContestantInformation> aL) {
		   
		 //initalizing the objects	
			Calendar bday = new GregorianCalendar();	
			
			//initalizing other variables just in case they are needed
			String fname, lname, stName, city, postalCode;
			int stNum, phoneNum;
			
			String prov;
			Province province = null;
			String userInput;
			boolean flag = false;
			boolean continuee = false;
			
			ContestantInformation contestant = new ContestantInformation();
			
			//user inputs their first Name
			do{
				flag = false;
				try{
					System.out.print("What is your first name?");
					contestant.setFname(scan.nextLine());
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			
			//use inputs their last Name
			do{
				flag = false;
				try{
					System.out.print("What is your last name?");
					contestant.setLname(scan.nextLine());
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			
			do{
				flag = false;
				try{
					System.out.print("What is your date of birth? (yyyy/mm/dd)");
					String everything = scan.nextLine();
					 bday = stringToCalendar(everything);
					contestant.setBday(bday);
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			
			
			//user inputs their stNumber
			do{
				flag = false;
				try{
					System.out.print("What is your street number?");
					contestant.setStNum(scan.nextLine());
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			// user inputs their stName
			do{
				flag = false;
				try{
					System.out.print("What street do you live on?");
					contestant.setStName(scan.nextLine());
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			
			//user inputs the city they live in
			do{
				flag = false;
				try{
					System.out.print("What city do you live in?");
					contestant.setCity(scan.nextLine());
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}
			while(flag);
			
			//user inputs the province they live in
			do{
				flag = false;
				try{
					System.out.println("What Province do you live in?");
					System.out.println("Please use one of the following: AB, BC, MB, NB, NL, NS, NT, NU, ON, PEI, QC, YT, SK");
					prov = scan.nextLine();
					contestant.setProvince(findProv(prov));
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			
			//user inputs their postal code
			do{
				flag = false;
				try{
					System.out.print("What is your Postal Code?");
					contestant.setPostalCode(scan.nextLine());
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			
			//the user inputs their phone number
			do{
				flag = false;
				try{
					System.out.print("What is your phone number?");
					contestant.setPhoneNum(scan.nextLine());
				}catch(InvalidInputException e)
				{
					System.out.print(e.getMessage());
					flag = true;
				}
			}while(flag);
			
			//adds the contestant information the the array list aL
					aL.add(contestant);
	 }
	 /**
	  * 
	  * @param aL
	  * allows the user to print one of the contestants information using the print class
	  */
	 public static void printLabel(ArrayList <ContestantInformation> aL, int index){
		 ContestantInformation contestant;		
		 if(index >= 0 && index < aL.size()){
			 //formats the contestants information using the code in the Label class
			 Label Label = new Label(aL.get(index));
			 System.out.println(Label.toString());
		 }
		 else
			 System.out.println("Please enter a persons name that has already been entered.");
	 }
	 
	 /**
	  * 
	  * @param aL
	  * allows the user to print all the contestants information using the print class
	  */
	 public static void printAllLabel(ArrayList <ContestantInformation> aL){
		 for(int i = 0; i < aL.size(); i++){
			 printLabel(aL, i);
		 }
	 }
	 /**
	  * 
	  * @param aL
	  * 
	  * allows the user to search for a contestant
	  */
	 
	 public static void search(ArrayList <ContestantInformation> aL){
		 ContestantInformation contestant;
		 SearchingArrays Search = new SearchingArrays();
			System.out.println("Enter Last Name: ");
			String lastname = scan.nextLine();
			System.out.println("Enter First Name: ");
			String firstname = scan.nextLine();
			System.out.println("Choose one of the following options.");
			System.out.println("1. Linear Search.");		
			String input = scan.nextLine();
			if (input.equals("1"))
				printLabel(aL, Search.linearSearch(aL, firstname, lastname));
			if(input.equals("2"))
				Search.binarySearch(aL, lastname, firstname);
		 
		 
	 } 
	 /**
	  * @param aL
	  * 
	  * method that delete the contestant information
	  */
	 public static void deleteContestant(ArrayList <ContestantInformation> aL){
		 	System.out.println("Choose one of the following options.");
			System.out.println("1. Delete by name  (last name).");
			String input = scan.nextLine();
			System.out.println("Enter Last Name: ");
		 	String lastname = scan.nextLine();
			
			for(int i = 0; i < aL.size(); i++){
			if(lastname.equals(aL.get(i).getLname())){
				System.out.println(aL.get(i).getFname() + " " +  aL.get(i).getLname()); 
				System.out.print("are you sure you want to delete this person? (y = yes, n = no)");
				String input1 = scan.nextLine();
				if(input1.equals("y")){
					aL.remove(i);
					System.out.print("The contestant has succesfully been deleted");
				}
				else if (input1.equals("n"))
					return;
			}
		}
	 }
	 
	 /**
	  * @param aL
	 * @throws FileNotFoundException
	 * the method save the contestant information that is stored in the arraylist to a text file 
	  */
	 
	 public static void save(ArrayList <ContestantInformation> aL) throws FileNotFoundException{
		
		 PrintStream fps = new PrintStream("contestant.txt");
		 for(int i = 0; i < aL.size();i++){
			 fps.println(aL.get(i).toString());
		 }
	 }
	 /**
	  * @param aL
	 * @throws IOException
	 * @throws InvalidInputException 
	 * 
	 *  the method that loads the contestants information
	  */
	 public static void load(ArrayList <ContestantInformation> aL) throws IOException, InvalidInputException{
		 BufferedReader fbr = new BufferedReader(new FileReader("contestant.txt"));
		 Calendar bday = new GregorianCalendar();
		 for(int i = 0; i < aL.size();i++){
			String ReadLines;
			 ReadLines = fbr.readLine(); 
			 String[] array = ReadLines.split(", ");
			 aL.add(new ContestantInformation());
			 aL.get(i).setFname(array[0]);
			 aL.get(i).setLname(array[1]);
			 aL.get(i).setBday(stringToCalendar(array[2]));
			 aL.get(i).setStNum(array[3]);
			 aL.get(i).setStName(array[4]);
			 aL.get(i).setProvince(findProv(array[5]));
			 aL.get(i).setCity(array[6]);
			 aL.get(i).setPostalCode(array[7]);
			 aL.get(i).setPhoneNum(array[8]);
			 
		 }
	 }
	 /**
	  * 
	  * @param aL
	  * sorts the contestants in the array list 
	  */
	 public static void sort(ArrayList <ContestantInformation> aL){
		 Collections.sort(aL);
	 }
	/**
	 * @param args
	 * @throws InvalidInputException 
	 * @throws IOException 
	 * 
	 * This is the main method where the program is executed.
	 */
	public static void main(String[] args) throws IOException, InvalidInputException {
		// TODO Auto-generated method stub
		
		ArrayList<ContestantInformation> aL = new ArrayList<ContestantInformation>();
		String input;
		boolean done = false;
		
		while(!done){
		System.out.println("Choose one of the following options.");
		System.out.println("1. Add another contestant.");
		System.out.println("2. Print the contestant information.");
		System.out.println("3. Search for a contestant.");
		System.out.println("4. Delete contestant");
		System.out.println("5. Delete all the contestants");
		System.out.println("6. Save a contestant to a text document");
		System.out.println("7. Load a contestant to a text documanet");
		System.out.println("8. Exit Program.");
		
		input = scan.nextLine();
		
		if (input.equals("1"))
			addContestant(aL);
		else if (input.equals("2"))
			 printAllLabel(aL);
		else if(input.equals("3"))
			search(aL);
		else if(input.equals("4"))
			deleteContestant(aL);
		else if (input.equals("5"))
			aL.removeAll(aL);
		else if (input.equals("6"))
			save(aL);
		else if (input.equals("7"))	
			load(aL);
		else if(input.equals("8"))
			System.exit(0);
		 }done = true;
	}

}

