package billyGoat;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class billifiedArraysTest {

	// The billify function should add the sum of all of the squares as the last element in the array
	// Property-based testing reminder ****
	// This test is to ensure that the billified array's last element is the largest number
	@Test
	public void largestValueTest(){
			
		Random r = new Random();
			
		int[][] array1 = new int[100][];
					
		int[][] billified = new int[100][];
					
		for(int x = 0; x < array1.length; x++){
			array1[x] = new int[r.nextInt((101 - 1)) + 1];
		}
			
		for(int i = 0; i < array1.length; i++){
			for(int z = 0; z < array1[i].length; z++){
				array1[i][z] = r.nextInt((101 - 1)) + 1;
			}
		}
			
		Boolean status = true;
		for(int i = 0; i < array1.length; i++){
			billified[i] = billify(array1[i]);
						
			int largest = 0;
				
			for(int z = 0; z < billified[i].length; z++){
				if(billified[i][z] >= largest){
					largest = billified[i][z];
				}	
			}
					
			if(largest != billified[i][billified[i].length-1]){
				status = false;
			}
		}
			
		assertTrue(status);
			
	}
	
	// Test to ensure that the Billify method is simply adding on an extra value to each billified array that is returned
	// Create the arrays using random values as well as a blank array to hold the returned billified arrays
	// Compare each billified array length to the length of the original, we want them to be 1 element larger
	@Test
	public void arrayLengthTest() {
		
		Random r = new Random();
				
		int[][] array1 = new int[100][];
				
		int[][] billified = new int[100][];
				
		for(int x = 0; x < array1.length; x++){
			array1[x] = new int[r.nextInt((101 - 1)) + 1];
		}
		
		for(int i = 0; i < array1.length; i++){
			for(int z = 0; z < array1[i].length; z++){
				array1[i][z] = r.nextInt((101 - 1)) + 1;
			}
	    }
		
		Boolean status = null;
		for(int i = 0; i < array1.length; i++){
			billified[i] = billify(array1[i]);
					
			if(billified[i].length == array1[i].length){	
				status = false;
			}else if(billified[i].length == array1[i].length+1){
				status = true;		
			}		
		}
		
		assertTrue(status);
	}
	
	// This test is to ensure that the Billify function is actually doing its mapping correctly
	// which is to square each element of the array
	// To test this property-based, this test will ensure that if the same array gets passed through twice,
	// the billified arrays that get returned each time should be equal to each other
	@Test
	public void billifySquareTest() {
		
		Random r = new Random();
		
		int[][] array1 = new int[100][];
				
		int[][] billified = new int[100][];
		
		int[][] billified2 = new int[100][];
				
		for(int x = 0; x < array1.length; x++){
			array1[x] = new int[r.nextInt((101 - 1)) + 1];
		}
		
		for(int i = 0; i < array1.length; i++){
			for(int z = 0; z < array1[i].length; z++){
				array1[i][z] = r.nextInt((101 - 1)) + 1;
			}
	    }
		
		Boolean status = true;
		for(int i = 0; i < array1.length; i++){
			billified[i] = billify(array1[i]);
		}
		
		for(int i = 0; i < array1.length; i++){
			billified2[i] = billify(array1[i]);
		}
		
		for(int z = 0; z < billified.length; z++){
			for(int q = 0; q < billified[z].length; q++){
				if(billified[z][q] != billified2[z][q]){
					status = false;	
				}	
			}
		}
		
		assertTrue(status);
	}
	
	// Billify function that takes in an array, squares each element in the array,
	// adds the sum of all the squares to the end of the array and then returns the 'billified' array
	public int[] billify(int[] x) throws IllegalArgumentException {
		int minArrayLength = 1;
		
		if(x.length < minArrayLength){
			String message = 
					"Array length is \""
					+ Integer.toString(x.length)
					+ "\" when it should be \""
					+ Integer.toString(minArrayLength)
					+ "\" or greater.";
			
			throw new IllegalArgumentException(message);
		}
		
		int[] billifiedArray = new int[x.length + 1];
		int exponent = 2;
		int total = 0;
		
		for(int ii = 0; ii < x.length; ii++){
			int newNumber = (int) Math.pow(x[ii], exponent);
			
			billifiedArray[ii] = newNumber;
			
			total += newNumber;
		}
		
		billifiedArray[x.length] = total;
		
		return billifiedArray;
	}
	
}
