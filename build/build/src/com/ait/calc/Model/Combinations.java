package com.ait.calc.Model;

import com.ait.calc.Controller.CombinationsInterface;

public class Combinations implements CombinationsInterface {

	// Formula: n to the power of r
	@Override
	public int orderedWithRepeat(int n, int r) {		
		return (int)Math.pow(n,r);		 
	}

	// Formula: n!/(n-r)!
	@Override
	public int orderedWithOutRepeat(int n, int r) {		
		return nFactorial(n) / nMinusRFactorial(n,r);		
	}

	// Formula: (r+n-1)! / r!(n-1)!
	@Override
	public int unOrderedWithRepeat(int n, int r) {		
		return rPlusNMinusOneFactorial(n,r) / 
				(rFactorial(r) * nMinusOneFactorial(n));		
	}

	// Formula: n! / r!(n-1)!
	@Override
	public int unOrderedWithOutRepeat(int n, int r) {		
		return nFactorial(n) / 
				(rFactorial(r) * nMinusRFactorial(n,r));		
	}

	// Formula: (r + n -1)!
	public static int rPlusNMinusOneFactorial(int num1, int num2) {
		int rpnmoFactorial = 0;
		int rPlusNMinusOne = num2 + num1 - 1;
		for(int i = rPlusNMinusOne; i > 0; i--) {
			if(rpnmoFactorial == 0) {
				rpnmoFactorial = i;
			} else {
				rpnmoFactorial *= i;
			}
		}
		return rpnmoFactorial;
	}
		
	// Formula: n!
	public static int nFactorial(int number) {
		int nFac = 0;
		for(int i = number; i > 0; i--) {
			if(nFac == 0) {
				nFac = i;
			} else {
				nFac *= i;
			}
		}
		return nFac;
	}
		
	// Formula: r!
	public static int rFactorial(int number) {
		int rFac = 0;
		for(int i = number; i > 0; i--) {
			if(rFac == 0) {
				rFac = i;
			} else {
				rFac *= i;
			}
		}
		return rFac;
	}
		
	// Formula: (n-1)!
	public static int nMinusOneFactorial(int number) {
		int nmoFactorial = 0;
		int nMinusOne = number - 1;
		for(int i = nMinusOne; i > 0; i--) {
			if(nmoFactorial == 0) {
				nmoFactorial = i;
			} else {
				nmoFactorial *= i;
			}
		}
		return nmoFactorial;
	}
		
	// Formula: (n-r)!
	public static int nMinusRFactorial(int num1, int num2) {
		int nmrFactorial = 0;
		int nMinusR = num1 - num2;
		for(int i = nMinusR; i > 0; i--) {
			if(nmrFactorial == 0) {
				nmrFactorial = i;
			} else {
				nmrFactorial *= i;
			}
		}
		return nmrFactorial;
	}
	
}
