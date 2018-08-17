package com.ait.calc.model;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Haar {
	private static final int N = 8;
	private int[][] matrixOriginal = new int[N][N];
	private static double[][] matrixCalculate = new double[N][N];
	private Scanner sc = new Scanner(System.in);
	
	public Haar(int[][] matrixOriginal) {
		super();
		this.matrixOriginal = matrixOriginal;
	}
	
	
	public void decomposeColumn(){
		System.out.println("Start decompose columns: ");
		for(int i=0; i<N; i++){
			for(int j=0; j<N/2; j++){
				matrixCalculate[i][j] = ( matrixOriginal[i][j]+matrixOriginal[i][j+N/2] )/2.0;
				matrixCalculate[i][j+N/2] =( matrixOriginal[i][j]-matrixOriginal[i][j+N/2] )/2.0;				
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N/4; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i][j+N/4])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i][j+N/4])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i][N/4+j] = tempDifference;									
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N/8; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i][j+N/8])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i][j+N/8])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i][j+N/8] = tempDifference;	
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
	}
	
	public void decomposeRow(){
		System.out.println("Start decompose rows: ");
		for(int i=0; i<N/2; i++){
			for(int j=0; j<N; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i+N/2][j])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i+N/2][j])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i+N/2][j] = tempDifference;				
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N/4; i++){
			for(int j=0; j<N; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i+N/4][j])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i+N/4][j])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i+N/4][j] = tempDifference;				
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N/8; i++){
			for(int j=0; j<N; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i+N/8][j])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i+N/8][j])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i+N/8][j] = tempDifference;				
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
	}
	
	public void recomposeColumn(){
		System.out.println("Start recompose columns: ");
		for(int i=0; i<N; i++){
			for(int j=0; j<N/8; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i][j+N/8];
				matrixCalculate[i][j+N/8] = matrixCalculate[i][j]-2*matrixCalculate[i][j+N/8];			
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N/4; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i][j+N/4];
				matrixCalculate[i][j+N/4] = matrixCalculate[i][j]-2*matrixCalculate[i][j+N/4];								
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N/2; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i][j+N/2];
				matrixCalculate[i][j+N/2] = matrixCalculate[i][j]-2*matrixCalculate[i][j+N/2];	
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		
	}
	
	public void recomposeRow(){
		System.out.println("Start recompose rows: ");
		for(int i=0; i<N/8; i++){
			for(int j=0; j<N; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i+N/8][j];
				matrixCalculate[i+N/8][j] = matrixCalculate[i][j]-2*matrixCalculate[i+N/8][j];			
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N/4; i++){
			for(int j=0; j<N; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i+N/4][j];
				matrixCalculate[i+N/4][j] = matrixCalculate[i][j]-2*matrixCalculate[i+N/4][j];			
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
		for(int i=0; i<N/2; i++){
			for(int j=0; j<N; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i+N/2][j];
				matrixCalculate[i+N/2][j] = matrixCalculate[i][j]-2*matrixCalculate[i+N/2][j];			
			}			
		}
		sc.nextLine();
		printArray(matrixCalculate);
		
	}
	
	
	//print int array[][]
	public static void printArray(double[][] doubleArray){
		System.out.print("  ----------------------------------------------------------");
		for(int i=0; i<doubleArray.length; i++){			
			System.out.println();
			for(int j=0; j<doubleArray[i].length; j++){
				if(j==0 ){
					System.out.print(" | ");
				}
				//ystem.out.print( String.format(" %4d ", doubleArray[i][j]) );
				System.out.printf(" %6.1f", doubleArray[i][j] );
				//System.out.print(new DecimalFormat(" ####.#").format( doubleArray[i][j]) );
				if(j==doubleArray[i].length-1){
					System.out.print(" | ");
				}
			}
		}
		System.out.println();
		System.out.println("  ----------------------------------------------------------");
		System.out.println();
	}
	
	

}
