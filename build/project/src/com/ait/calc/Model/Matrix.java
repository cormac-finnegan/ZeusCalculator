//https://www.media.mit.edu/pia/Research/deepview/src/JpegEncoder.java
//https://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image
package com.ait.calc.Model;

import java.util.Scanner;

public class Matrix {
	private static int[][] m = new int[8][8];;
	public static String start(){
		//generate matrix, DCT deal with matrix range [-128,127]  
		System.out.println("A 8*8 matrix will be generated with random number [-128,127] ");
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				m[i][j] = (int)(Math.random() * (255)) -128;
			}
		}
		

	    int[][] M = {{16,8,23,16,5,14,7,22},
	                            {20,14,22,7,14,22,24,6},
	                            {15,23,24,23,9,6,6,20},
	                            {14,8,11,14,12,12,25,10},
	                            {10,9,11,9,13,19,5,17},
	                            {8,22,20,15,12,8,22,17},
	                            {24,22,17,12,18,11,23,14},
	                            {21,25,15,16,23,14,22,22}};
	    
		
		printArray(m);
		
		System.out.println("Enter Quantization Level [1-99]: ");
		Scanner in = new Scanner(System.in);
		int qLevel = 0;
		do {
	        while (!in.hasNextInt()){
	        	in.next();
	        } 
	        qLevel = in.nextInt();
	    } while (qLevel<1 || qLevel>99);
		
		
		//call for DCT, and return result		
		//display DCT'ed matrix
		
		//printArray( DctAndIdct.dct(m, qLevel) );
		
		//call for IDCT
		//display IDCT'ed matrix
		//System.out.println("De-Compressed");
		//printArray( DctAndIdct.Idct() );
		
		//call for Haar to decompose
		Haar haar = new Haar(m);
		haar.decomposeColumn();
		haar.decomposeRow();
		haar.recomposeColumn();
		haar.recomposeRow();
		
		//display Haar'ed result
		
		//call for I-Haar to recompose
		
		//display I-Haar'ed result
		
		
		
		return null;
	}
	
	//print int array[][]
	public static void printArray(int[][] intArray){
		System.out.print("  --------------------------------------------------");
		for(int i=0; i<intArray.length; i++){			
			System.out.println();
			for(int j=0; j<intArray[i].length; j++){
				if(j==0 ){
					System.out.print(" | ");
				}
				System.out.print( String.format(" %4d ", intArray[i][j]) );
				if(j==intArray[i].length-1){
					System.out.print(" | ");
				}
			}
		}
		System.out.println();
		System.out.println("  --------------------------------------------------");
		System.out.println();
	}
	
}
