package gerard;

import java.util.ArrayList;

/**
 * @author 322040049
 * this will search for the user in a linear or binary fastion
 *
 */
public class SearchingArrays {

/*	public static int linearSearch(int target, int [] ints){
		
		for(int i = 0; i < ints.length; i++){
			if (ints[i] == target)
			return i;
		}
		return -1;
	}

	public static int linearSearch(double target, double [] doubles){
	
	for(int i = 0; i < doubles.length; i++){
		if (doubles[i] == target)
		return i;
	}
	return -1;
}

	public static int linearSearch(String target, String [] Strings){
	
	for(int i = 0; i < Strings.length; i++){
		if (Strings[i].equals(target))
		return i;
	}
	return -1;
}
	public static int binarySearch(int target, int [] ints){
		int begIndex = 0;
		int endIndex = ints.length- 1;
				
		do{
		int midIndex = (begIndex + endIndex)/2;
		int i = midIndex;
		if (ints[midIndex] == target)
			return i;
		if (ints[midIndex] < target)
			begIndex = midIndex + 1;
		if (ints[midIndex] > target)
			endIndex = midIndex - 1;
		}while  (begIndex <= endIndex);
		
		return -1;

	}
	public static int binarySearch(double target, double [] doubles){
		int begIndex = 0;
		int endIndex = doubles.length- 1;
				
		do{
		int midIndex = (begIndex + endIndex)/2;
		int i = midIndex;
		if (doubles[midIndex] == target)
			return i;
		if (doubles[midIndex] < target)
			begIndex = midIndex + 1;
		if (doubles[midIndex] > target)
			endIndex = midIndex - 1;
		}while  (begIndex <= endIndex);
		
		return -1;
	}
	
	public static int binarySearch(String target, String [] Strings){
		int begIndex = 0;
		int endIndex = Strings.length- 1;
				
		do{
		int midIndex = (begIndex + endIndex)/2;
		int i = midIndex;
		if (target.compareTo(Strings[midIndex]) == 0)
			return i;
		if (target.compareTo(Strings[midIndex]) < 0)
			endIndex = midIndex - 1;
		if (target.compareTo(Strings[midIndex]) > 0)
			begIndex = midIndex + 1;
		}while  (begIndex <= endIndex);
		
		return -1;
	}
*/
	/**
	 * 
	 * @param aL
	 * @param ci
	 * @return 
	 * searches for contestants in a linear fashion
	 */
	public static int linearSearch(ArrayList<ContestantInformation> aL, ContestantInformation ci){
		
		for(int i = 0; i < aL.size(); i++){
			if (aL.get(i).equals(ci))
			return i;
		}
		return -1;
	}
/*
	public static int binarySearch(ArrayList<ContestantInformation> aL, ContestantInformation ci){
		int begIndex = 0;
		int endIndex = aL.size()- 1;
				
		do{
		int midIndex = (begIndex + endIndex)/2;
		if (ci.compareTo(aL.get(midIndex)) == 0)
			return midIndex;
		if (ci.compareTo(aL.get(midIndex)) < 0)
			endIndex = midIndex - 1;
		if (ci.compareTo(aL.get(midIndex)) > 0)
			begIndex = midIndex + 1;
		}while  (begIndex <= endIndex);
		
		return -1;
	}
*/
	/**
	 * 
	 * @param aL
	 * @param firstname
	 * @param lastname
	 * @return
	 * a linear search that searches for the contesants in the arry or txt file by first name and last name
	 */
	public static int linearSearch(ArrayList<ContestantInformation> aL, String firstname, String lastname){
		 
			for(int i = 0; i < aL.size(); i++){
				if (aL.get(i).getLname().equals(lastname))
					if(aL.get(i).getFname().equals(firstname))
					return i;
			}
			return -1;
	 }
	/**
	 * @param aL
	 * @param lastName
	 * @param firstName
	 * @return 
	 * searches for contestants in a binary fashion by using first name and last name
	 */
	public static int binarySearch(ArrayList<ContestantInformation> aL, String lastname, String firstname){
		int begIndex = 0;
		int endIndex = aL.size()- 1;
				
		for(int i = 0; i < aL.size(); i++){
		int midIndex = (begIndex + endIndex)/2;
		if (aL.get(i).getLname().compareTo(lastname) < 0)
			endIndex = midIndex - 1;
		else if (aL.get(i).getLname().compareTo(lastname) > 0)
			begIndex = midIndex + 1;
		else
			if(aL.get(i).getLname().compareTo(firstname) < 0)
				endIndex = midIndex - 1;
			else if (aL.get(i).getLname().compareTo(firstname) > 0)
				begIndex = midIndex + 1;
			else
				return 0;
		
		}
		
		return -1;
	}
	/**
	 * 
	 * @param aL
	 * @param target
	 * @return
	 * recursive binary search that searches for conestants
	 */
	public static int binarySearch(ArrayList<ContestantInformation>aL, String target ){

		return binarySearch(aL, target, 0, aL.size()-1);
	}
	
	private static int binarySearch(ArrayList<ContestantInformation>aL, String target, int beg, int end ){
		if (beg > end)
			return -1;
		int mid = (beg + end)/2;
		if ((aL.get(mid).compareTo(target) < 0))
			return binarySearch(aL, target,mid + 1, end);
		else if((aL.get(mid).compareTo(target) > 0))
			return binarySearch(aL, target,beg, mid - 1);
		else
			return mid;
	}
	
	 

}
