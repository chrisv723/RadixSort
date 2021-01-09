

import java.util.LinkedList;

// name: Christopher Valerio 
		 

public class Radix {


	private int getMax(int[] a)
	{

		// returns the maximum number from the array
		// almost exactly the same as getmin from the selection and bubble sort lab but this time you need the max value
		
		int largest = a[0];
		
		for(int i = 1; i < a.length; i++) {
			if(a[i] > largest)
				largest = a[i];
		}
		return largest;


	}
	
	public void sort(int[] arrayToBeSorted)
	{
		// You will need at least the following variables:
		
		// an array of linked lists of size 10, up to you to determine what type
		// you may use the built in linked list from java.util
 
		LinkedList<Integer>[] table = (LinkedList<Integer>[])new LinkedList[10]; 
		// http://steveo.us/howtos/java-ds.html
		// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
	
		
		// a var to keep track of the current radix
		int radix = 1;
		int maxNum = getMax(arrayToBeSorted);
		//System.out.println("\nMaxNum: " + maxNum);
		int maxLen = 0;
		
		int temp = maxNum;
		while(temp != 0) {
			temp = (temp / 10);
			maxLen++;
		}
		//System.out.println("Len of Max: " + maxLen);
		
		
		//int reArrange[] = new int[arrayToBeSorted.length];
		int reArrange[] = arrayToBeSorted;
		for(int i = 0; i < maxLen; i++) {
			
			for(int j = 0; j < arrayToBeSorted.length; j++) {
				int indexRadix = (arrayToBeSorted[j] / radix) % 10;
				if(table[indexRadix] == null) {
					table[indexRadix] = new LinkedList<Integer>();
					table[indexRadix].addLast(arrayToBeSorted[j]);
				}
				else
					table[indexRadix].addLast(arrayToBeSorted[j]);
			}
			
			//System.out.println("\nCurrent Radix Table: ");
			//for(int z = 0; z < table.length; z++) {
				//System.out.println(table[z]);
			//}
			
			int index = 0;
			for(int k = 0; k < table.length; k++) {
				
				while(table[k] != null) {
					reArrange[index++] = table[k].removeFirst();
					if(table[k].isEmpty())
						table[k] = null;
				}

			}
			
		//	StringBuilder str = new StringBuilder();
		//	for(int z = 0; z < reArrange.length; ) {
		//		str.append(reArrange[z++]);
		//		str.append(", ");
		//	}
			//System.out.println("\nValues after dequeue: \n" + str.toString());
			radix *= 10;
		}
		/* 
		  basic steps for radix sort using linked lists:

		  go through numbers in arrayToBeSorted
		  start with the right most digit in the number (least significant digit), based on the digit add the number (not just the digit)
		  in the appropriate list in the linked list array. Do this with all the numbers.

		  Once done remove items from the linked list array in order and put them in an array

		  Go through that array again but now use the digit to the left (next significant digit)

		  repeat process as many times as the length of the max number
		  
		 */
	}	
}
