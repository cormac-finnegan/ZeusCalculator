package com.ait.calc.model;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HaarPanel {
	private static final int N = 8;
	private double[][] matrixOriginal = new double[N][N];
	public static double[][] matrixCalculate = new double[N][N];
	private Scanner sc = new Scanner(System.in);
	
	public HaarPanel(double[][] matrixOriginal) {
		super();
		this.matrixOriginal = matrixOriginal;
	}
	
	
	public double[][] decomposeColumn1(){		
		for(int i=0; i<N; i++){
			for(int j=0; j<N/2; j++){
				matrixCalculate[i][j] = ( matrixOriginal[i][j]+matrixOriginal[i][j+N/2] )/2.0;
				matrixCalculate[i][j+N/2] =( matrixOriginal[i][j]-matrixOriginal[i][j+N/2] )/2.0;				
			}			
		}
		return matrixCalculate;
	}
	
	public double[][] decomposeColumn2(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N/4; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i][j+N/4])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i][j+N/4])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i][N/4+j] = tempDifference;									
			}			
		}
		return matrixCalculate;
	}
	
	public double[][] decomposeColumn3(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N/8; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i][j+N/8])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i][j+N/8])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i][j+N/8] = tempDifference;	
			}			
		}	
		return matrixCalculate;
	}
	
	public double[][] decomposeRow1(){
		for(int i=0; i<N/2; i++){
			for(int j=0; j<N; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i+N/2][j])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i+N/2][j])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i+N/2][j] = tempDifference;				
			}			
		}
		return matrixCalculate;
	}
		
	public double[][] decomposeRow2(){
		for(int i=0; i<N/4; i++){
			for(int j=0; j<N; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i+N/4][j])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i+N/4][j])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i+N/4][j] = tempDifference;				
			}			
		}
		return matrixCalculate;
	}
	
	public double[][] decomposeRow3(){		
		for(int i=0; i<N/8; i++){
			for(int j=0; j<N; j++){
				double tempAverage = (matrixCalculate[i][j]+matrixCalculate[i+N/8][j])/2.0;
				double tempDifference = (matrixCalculate[i][j]-matrixCalculate[i+N/8][j])/2.0;
				
				matrixCalculate[i][j] = tempAverage;
				matrixCalculate[i+N/8][j] = tempDifference;				
			}			
		}	
		return matrixCalculate;
	}
	
	public double[][] recomposeColumn1(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N/8; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i][j+N/8];
				matrixCalculate[i][j+N/8] = matrixCalculate[i][j]-2*matrixCalculate[i][j+N/8];			
			}			
		}
		return matrixCalculate;
	}
	
	public double[][] recomposeColumn2(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N/4; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i][j+N/4];
				matrixCalculate[i][j+N/4] = matrixCalculate[i][j]-2*matrixCalculate[i][j+N/4];								
			}			
		}
		return matrixCalculate;
	}
		
	public double[][] recomposeColumn3(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N/2; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i][j+N/2];
				matrixCalculate[i][j+N/2] = matrixCalculate[i][j]-2*matrixCalculate[i][j+N/2];	
			}			
		}
		return matrixCalculate;
	}//end recomposeColumn3()
	
	public double[][] recomposeRow1(){
		for(int i=0; i<N/8; i++){
			for(int j=0; j<N; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i+N/8][j];
				matrixCalculate[i+N/8][j] = matrixCalculate[i][j]-2*matrixCalculate[i+N/8][j];			
			}			
		}
		return matrixCalculate;
	}
	
	public double[][] recomposeRow2(){
		for(int i=0; i<N/4; i++){
			for(int j=0; j<N; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i+N/4][j];
				matrixCalculate[i+N/4][j] = matrixCalculate[i][j]-2*matrixCalculate[i+N/4][j];			
			}			
		}
		return matrixCalculate;
	}
	
	public double[][] recomposeRow3(){
		for(int i=0; i<N/2; i++){
			for(int j=0; j<N; j++){
				matrixCalculate[i][j] = matrixCalculate[i][j]+matrixCalculate[i+N/2][j];
				matrixCalculate[i+N/2][j] = matrixCalculate[i][j]-2*matrixCalculate[i+N/2][j];			
			}			
		}
		return matrixCalculate;
	}//end recomposeRow3()	
	
	
	

}
