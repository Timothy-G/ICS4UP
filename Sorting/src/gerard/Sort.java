package gerard;

import java.util.Arrays;

public class Sort {
		 
	public static int partition(int[] unsort, int beg, int end) {
 		int temp;
 		int pivot = unsort[end];
 		int partIndex = beg;
 		for (int i=0;i<end;i++) {
 				if (unsort[i] <= pivot) {
 				temp = unsort[i];
 				unsort[i] = unsort[partIndex];
 				unsort[partIndex] = temp;
 				partIndex++;
 			}
 		}
 		temp = unsort[partIndex];
 		unsort[partIndex] = unsort[end];
 		unsort[end] = unsort[partIndex];
 		return partIndex;
 		
 	}

		 	public static int[] selectionSort(int[] unsort){
		 	
		 	int first, second, temp;
		 		for (int i=0;i<unsort.length-1; i++) {
		 			first = i;
		 			for (second=i + 1; second<=unsort.length-1;second++) {
		 				if (unsort[first] > unsort[second]) {
		 				first = second;
		 				}
		 			}
		 			temp = unsort[i];
		 			unsort[i] = unsort[first];
		 			unsort[first] = temp;		
		 		}
		 		return unsort;
		 	}

		 	public static int[] insertionSort(int[] unsort) {
		 		int i, counter, swap, temp;
		 		for (i=1; i<=unsort.length-1;i++) {
		 			swap=unsort[i];
		 			counter = i-1;
		 			while (counter>=0 && swap < unsort[counter]) {
		 				temp = unsort[counter];
		 				unsort[counter] = unsort[counter+1];
		 				unsort[counter+1] = temp;
		 				counter--;
		 			}
		 		}
		 		return unsort;
		 	}

		 	public static int[] bubbleSort(int[] unsort) {
				int temp;
		 		for (int i=0;i<unsort.length-1;i++) {
		 			for (int counter=0;counter<unsort.length-1;counter++) {
		 				if (unsort[counter] > unsort[counter+1]) {
		 					int swap = unsort[counter+1];
							unsort[counter] = unsort[counter+1];
		 				unsort[counter] = swap;
		 				}
		 			}
		 		}
		 		return unsort;
		 	}
		 	
		 	public static int[] quickSort(int[] unsort, int beg, int end) {
			if (beg<end) {
		 			int partIndex = partition(unsort, beg, end);
		 			quickSort(unsort,beg,partIndex - 1);
		 			quickSort(unsort,partIndex + 1,end);
		 			
		 		}
		 		return unsort;
		 	}

		 	
		 	public static int[] mergePartition(int[] left, int[] right, int[] unsort) {
		 		int leftNum = left.length;
		 		int rightNum = right.length;
		 		int leftIndex = 0;
		 		int rightIndex = 0;
		 		int arrayIndex = 0;
		 		while (leftNum>leftIndex && rightNum>rightIndex) {
		 			if (left[leftIndex]<=right[rightIndex]) {
		 			unsort[arrayIndex] = left[leftIndex];
		 				leftIndex++;
		 			}
		 			else {
		 				unsort[arrayIndex] = right[rightIndex];
		 				rightIndex++;
		 			}
		 			arrayIndex++;
		 		}
		 		while (arrayIndex<leftNum) {
		 			unsort[arrayIndex++] = left[leftIndex++];
		 		}
				while(arrayIndex<rightNum) {
					unsort[arrayIndex++] = right[rightIndex];
		 		}
		 		return unsort;
		 	}

		 	public static int[] mergeSort(int[] unsort) {
		 		int i = unsort.length;
		 		if (i<=1) {
				return unsort;
		 		}
		 		int middle = i/2;
		 		int left[] = new int[middle];
				int right[] = new int[i-middle];
		 		for (int a=0; a<=middle-1;a++) {
		 			left[a] = unsort[a];
		 		}
		 		for (int b=middle; b<=i-1;b++) {
		 			right[b-middle] = unsort[b];
		 		}
		 		mergeSort(left);
		 		mergeSort(right);
		 		mergePartition(left, right, unsort);
		 		return unsort;
		 	}
		 	 
		 	public static void main(String[] args) {
		 		// TODO Auto-generated method stub
		 		
		 		int unsort[] = {3, 99, 62, 1, 2, 8, 20, 66, 82, 42, 56};
		 		
		 		System.out.println(Arrays.toString(Sort.selectionSort(unsort)) + "\n");
		 		System.out.println(Arrays.toString(Sort.insertionSort(unsort)) + "\n");
		 		System.out.println(Arrays.toString(Sort.bubbleSort(unsort)) + "\n");
		 		System.out.println(Arrays.toString(Sort.quickSort(unsort, 0, unsort.length-1)) + "\n");
		 		System.out.println(Arrays.toString(Sort.mergeSort(unsort)) + "\n");
		 		}
		 	}

