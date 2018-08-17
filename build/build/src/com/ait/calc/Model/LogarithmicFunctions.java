package com.ait.calc.Model;

import com.ait.calc.Controller.LogarithmicInterface;

public class LogarithmicFunctions implements LogarithmicInterface {

	@Override
	public double ln(double x) {
		return Math.log(x);
	}

	@Override
	public double ln(double x, double y) {
		return 0;
	}
	
	@Override
	public double expToPowerOfX(double x) {
		return Math.pow(Math.E, x);
	}

	@Override
	public double tenToPowerOfX(double x) {
		return Math.pow(10, x);
	}

	@Override
	public double log(double x) {
		return Math.log10(x);
	}
	
	@Override
	public double log(double x, int b) {
		return Math.log10(x)/(double)Math.log10(b);
	}

	@Override
	public double log(double x, double y) {
		return Math.log10(x) - Math.log10(y);
	}

	@Override
	public double log(double x, double y, int b) {
		return (Math.log10(x)/(double)Math.log10(b)) - (Math.log10(y)/(double)Math.log10(b));
	}
	
	@Override
	public double log(double x, double y, int b, int c) {
		double d = (double)b/c;
		return (Math.log10(x)/(double)Math.log10(d)) - (Math.log10(y)/(double)Math.log10(d));
	}

	@Override
	public double log(double x, int b, int c) {
		double d = (double)b/c;
		return Math.log10(x)/(double)Math.log10(d);
	}
	
	@Override
	public double log(double x, int b, int c, int n) {
		double d = (double)b/c;
		return n * (Math.log10(x)/(double)Math.log10(d));
	}

	@Override
	public double logXY(double x, double y, int b) {
		return (Math.log10(x)/(double)Math.log10(b)) + (Math.log10(y)/(double)Math.log10(b));
	}

	@Override
	public double logBPowerOfN(double x, int b, int n) {
		return n * (Math.log10(x)/(double)Math.log10(b));
	}

	@Override
	public double expToPowerOfX(double x, double y) {
		return (Math.pow(Math.E, x)) - (Math.pow(Math.E, y));
	}

	@Override
	public double tenToPowerOfX(double x, double y) {
		return (Math.pow(10, x)) - (Math.pow(10, y));
	}

	@Override
	public double lnXY(double x, double y) {
		return (Math.log(x)) + (Math.log(y));
	}

	@Override
	public double expToPowerOfXY(double x, double y) {
		return (Math.pow(Math.E, x)) + (Math.pow(Math.E, y));
	}

	@Override
	public double tenToPowerOfXY(double x, double y) {
		return (Math.pow(10, x)) + (Math.pow(10, y));
	}	
		
}
