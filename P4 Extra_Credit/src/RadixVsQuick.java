import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class RadixVsQuick {

	static void printArray(int array[]) 
	{ 
	    int n = array.length; 
	    for (int i=0; i<n; ++i) {
	        System.out.print(array[i]+" "); 
	    System.out.println(); 
	    }
	} 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		Radix rad = new Radix();
		QuickSort quick = new QuickSort();
		
		int choice = 0;
		while(choice != 5) {
			System.out.println("Please select from the following options: \n"
					+ "1) decimal to binary \n"
					+ "2) binary to decimal \n"
					+ "3) User's choice radix and quicksorted lists \n"
					+ "4) Randomly generated list with radix vs quicksort \n"
					+ "5) Quit the program");
			choice = in.nextInt();
		switch(choice) {
		
		case 1:
			
			System.out.println("Please enter a nonnegative integer: ");
			int n = in.nextInt();
			System.out.println("Enter the max number of bit places: ");
			int k = in.nextInt();
			int binary[] = new int[k];
			int index = 0;
			while (n > 0) {
				binary[index++] = n % 2;
				n = n / 2;
			}
			for(int i = index-1; i >= 0; i--) {
				System.out.print(binary[i]);
			}
			System.out.println("");
		break;
			
		case 2:
			
			System.out.println("Enter a string of 1's and 0's: ");
			String binaryString = in.next();  
			int decimal=Integer.parseInt(binaryString,2);  
			System.out.println(decimal);  		
			
		break;
			
		case 3:
			
			System.out.println("Please enter nonnegative integers seperated by commas: ");
			String commaSeperatedValues = in.next(); 
			String[] values = commaSeperatedValues.split(","); 
			System.out.println(Arrays.toString(values));
			int size = values.length;
			int[] intValues = new int[size];
			for(int i=0; i<size; i++) {
		         intValues[i] = Integer.parseInt(values[i]);
		      }
			int[] intValuesTwo;
			intValuesTwo = Arrays.copyOf(intValues, intValues.length);
			rad.radixsort(intValues, (values.length - 1));
			quick.sort(intValuesTwo, 0, (values.length - 1));
			System.out.println("Radix Array Sorted: " + Arrays.toString(intValues));
			System.out.println("Quick Array Sorted: " + Arrays.toString(intValuesTwo));
			
		break;
					
		case 4:
			System.out.println("How many integers would you like sorted? (<= 100 will print whole list) ");
			n = in.nextInt();
			System.out.println("What would you like the highest possible value to be?");
			int m = in.nextInt();
			int randList[] = new int[n-1];
			for(int i = 0; i < n-1; i++) {
				int randGenNum = rand.nextInt(m);
				randList[i] = randGenNum;
			}		
			
			int[] randListTwo;
			randListTwo = Arrays.copyOf(randList, randList.length);
			if(n <= 100) {
				System.out.println("Radix Array Unsorted: " + Arrays.toString(randList));
				System.out.println("Quick Array Unsorted: " + Arrays.toString(randListTwo));
			}
			long start = System.nanoTime();
			rad.radixsort(randList, n-1);
			long finish = System.nanoTime();
			long timeElapsed = finish - start;
			System.out.println("It took Radix Sort " + timeElapsed + " nano seconds to complete");
			
			start = System.nanoTime();
			quick.sort(randListTwo, 0, n-2);
			finish = System.nanoTime();
			timeElapsed = finish - start;
			System.out.println("It took Quick Sort " + timeElapsed + " nano seconds to complete");
			
			
			if(n <= 100) {
			
			System.out.println("Radix Array Sorted: " + Arrays.toString(randList));
			System.out.println("Quick Array Sorted: " + Arrays.toString(randList));
			}
			
			
		break;
					
		case 5:
			
			choice = 5;
		break;
		
			}
		}
	}
	
	
	
}
