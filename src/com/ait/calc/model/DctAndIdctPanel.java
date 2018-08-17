package com.ait.calc.model;
import java.util.Scanner;

public class DctAndIdctPanel {
	
	//private DecimalFormat df = new DecimalFormat("####0.00");
    private static final int N = 8;
    private static final double NDOUBLE = 8.0;
    private static double [][] t = new double[N][N];     	// matrix t
    private static double [][] t_t= new double[N][N];		// matrix t'
    
    private static double [][]dct = new double[N][N];		// dct = t*m*t'
    private static int [][]compressedMatrix = new int[N][N];		//final compressed matrix
    private static int [][]decompressedMatrix = new int[N][N];	//final decompressed matrix = t' * compressedArray * t
    private static double[][] inverse = new double[N][N];		//matrix after inverse quantilization
    private double[][] origin;
    private int q;
    
    
    public DctAndIdctPanel(double[][] origin, int q){
    	this.origin = origin;
    	this.q = q;
    }
    
    public double[][] returnT(){
    	generateTAndTt();
    	
    	return t;
    }
    
   
    public double[][] returnTMT(){
    	calculateFDCT( convertToInt(origin) );
    	
    	return dct;
    }
    
    public double[][] returnQ50(){
    	
    	
    	return convertToDouble(q50);
    }
    
    public double[][] returnQActual(){
    	return convertToDouble(generateQ(q));
    	
    	
    }
    
    public double[][] returnDQ(){
    	quantilise(q);
    	
    	
    	return convertToDouble(compressedMatrix);
    }
    
    public double[][] returnQC(){
    	quantiliseInverse(q);
    	
    	return inverse;
    }
   
    
    public double[][] returnTRT(){
    	calculateIDCT();
    	
    	return convertToDouble(decompressedMatrix);
    }
    
    public int[][] convertToInt(double[][] doubleArray){
    	int[][] intArray=new int[doubleArray.length][doubleArray[0].length];
    	for(int i=0; i<doubleArray.length; i++){
    		for(int j=0; j<doubleArray[0].length; j++){
    			intArray[i][j] = Math.round((float)doubleArray[i][j]);
    		}
    	}
    	return intArray;    	
    }
    public double[][] convertToDouble(int[][] intArray){
    	double[][] doubleArray=new double[intArray.length][intArray[0].length];
    	for(int i=0; i<doubleArray.length; i++){
    		for(int j=0; j<doubleArray[0].length; j++){
    			doubleArray[i][j] = (double)intArray[i][j];
    		}
    	}
    	return doubleArray;    	
    }
    
    private static int qLevel; 	// level for quality [1-99]
    final static int[][] q50 = {{16,11,10,16,24,40,51,61},
			    		{12,12,14,19,26,58,60,55},
			    		{14,13,16,24,40,57,69,56},
					    {14,17,22,29,51,87,80,62},
					    {18,22,37,56,68,109,103,77},
					    {24,35,55,64,81,104,113,92},
					    {49,64,78,87,103,121,120,101},
					    {72,92,95,98,112,100,103,99}};
	
	public static int[][] dct(int[][] origin, int q){
		
		qLevel = q;
			
		generateTAndTt();
		calculateFDCT(origin);
		quantilise(qLevel);	
		//System.out.println("After FDCT and Quantization ");
		return compressedMatrix;
		
	}
	
	public static int[][] Idct(){
		quantiliseInverse(qLevel);
		calculateIDCT();		
		return decompressedMatrix;
		
	}
	
	
	//QuantizationStepForward
	public static void quantilise(int q){		
		 for(int r=0;r<N;r++){
	            for(int c=0;c<N; c++){
	                compressedMatrix[r][c] = (int)Math.round(dct[r][c]/generateQ(q)[r][c]);
	            }
		 }		 
	}
	
	//QuantizationInverse
	public static void quantiliseInverse(int q){
		//System.out.println(" q level is " + q);
        for(int r=0;r<N;r++){
        	for(int c=0;c<N; c++){
        		inverse[r][c] = (int)compressedMatrix[r][c]*(generateQ(q)[r][c]);
        		
        	}
        }
    }
	
	
	//DCT T*M*T'
	 public static void calculateFDCT(int[][] m)
	    {	double[][] tm = new double[N][N];			//temporary matrix tm = t * m
	        double sum = 0.0;
	        for(int r=0;r<N;r++){
	            for(int c=0;c<N; c++){
	                for(int k=0;k<N; k++)
	                    sum = sum + t[r][k]*m[k][c];
	                tm[r][c] = sum;
	                sum = 0;
	            }
	        }
	        sum=0.0;
	        for(int r=0;r<N;r++){
	            for(int c=0;c<N; c++){
	                for(int k=0;k<N; k++)
	                    sum = sum + tm[r][k]*t_t[k][c];
	                dct[r][c] = sum;
	                sum = 0;
	            }
	        }
	    }
	
	//IDCT T'*M*T
	public static void calculateIDCT()
		    {	double[][] t_tm = new double[N][N];   //temporary matrix t_tm = t' * m
		        double sum = 0.0;
		        
		        for(int r=0;r<N;r++){
		            for(int c=0;c<N; c++){
		                for(int k=0;k<N; k++){
		                    sum = sum + t_t[r][k]*inverse[k][c];		                    
		                }
		                t_tm[r][c] = sum;			                
		                sum = 0;
		            }
		        }
		        
		        sum=0.0;
		        for(int r=0;r<N;r++){
		            for(int c=0;c<N; c++){
		                for(int k=0;k<N; k++){
		                    sum = sum + t_tm[r][k]*t[k][c];
		                }
		                decompressedMatrix[r][c] = (int) sum;
		                sum = 0;
		            }
		        }
		    }
		
	 
	//generate T and Tt Matrix
	public static void generateTAndTt(){
		for(int r=0;r<N;r++){
            for(int c=0;c<N; c++){
               if(r==0){
            	   t[r][c] = 1/Math.sqrt(NDOUBLE);
               } else  {
            	   t[r][c] = Math.sqrt((2.0/NDOUBLE))*Math.cos((r*Math.PI*(2*c+1))/(2*NDOUBLE));      
               } 
               t_t[c][r] = t[r][c];
            }
        }    
    }
	
	// generate Q Matrix [1-255]
	public static int[][] generateQ(int q){
        double temp=0;
        if(q==50){
        	return q50;
        }
        
        int[][] qArray = new int[N][N];
        for(int r=0;r<N;r++){
        	for(int c=0;c<N;c++){
        		if(q<50){
        			temp = ((double)q50[r][c])*(50/(double)q);
        		}else{
        			temp = ((double)q50[r][c])*((100-(double)q)/50);
        		}
        		
        		qArray[r][c] = (int)Math.round(temp);
        		
        		if(qArray[r][c]>255){
        			qArray[r][c] =255;
        		}else if(qArray[r][c]<1){
        			qArray[r][c] =1;
        		}        		
        	}        	
        }
        
        /*if(q<50){
        	for(int r=0;r<N;r++){
                for(int c=0;c<N; c++){
                    temp = (int)(q50[r][c]*(50/q));
                    if(temp>255){
                    	qArray[r][c] = 255;
                    } else {
                    	qArray[r][c] = (int)Math.round(q50[r][c]*(50/(double)q));
                    }                        
                }
            }        	
        } else {
            for(int r=0;r<N;r++){
                for(int c=0;c<N; c++){
                    qArray[r][c] = (int)Math.round(q50[r][c]*((100-(double)q)/50));
                }
            }
        }*/
        return qArray;
    }

}
