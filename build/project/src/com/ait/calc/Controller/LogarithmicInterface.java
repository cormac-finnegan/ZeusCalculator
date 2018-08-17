package com.ait.calc.Controller;

public interface LogarithmicInterface {
	// natural logarithm of x
	public double ln(double x);
	// Overloading ln(x/y) 
	public double ln(double x, double y);
	
	// e^x
	public double expToPowerOfX(double x);
	// Overloading e^(x/y)
	public double expToPowerOfX(double x, double y);
	
	// 10^x
	public double tenToPowerOfX(double x);
	// Overloading 10^(x/y)
	public double tenToPowerOfX(double x, double y);
	
	// log of base 10
	public double log(double x);
	
	/* Overloading methods of logarithm */ 
	// log of base b	
	public double log(double x, int b);
	// log of fractions (log(x/y) base 10)
	public double log(double x, double y);
	// log of fractions (log(x/y) base b)
	public double log(double x, double y, int b);
	// log of fractions (log(x/y) base (b/c))
	public double log(double x, double y, int b, int c);
	// log of fractions (log(x) base (b/c))
	public double log(double x, int b, int c);	
	// log of fractions (log(x) base (b/c) to the power of n)
	public double log(double x, int b, int c, int n);
	
	// ln(xy)
	public double lnXY(double x, double y);
	
	// e^(xy)
	public double expToPowerOfXY(double x, double y);
	
	// 10^(xy)
	public double tenToPowerOfXY(double x, double y);
	
	// log of fractions (log(xy) base b)
	public double logXY(double x, double y, int b);
	// log of fractions (log(x) base b to the power of n)
	public double logBPowerOfN(double x, int b, int n);
}
