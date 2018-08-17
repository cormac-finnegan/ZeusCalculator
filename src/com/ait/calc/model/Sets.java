package com.ait.calc.model;

import com.ait.calc.controller.SetsInterface;

public class Sets implements SetsInterface {

	// Formula: n to the power of r
	@Override
	public int permutationWithRepeat(int n, int r) {		
		if(n >= 0) {
			return (int)Math.pow(n,r);			
		} else {		
			return 0;
		}		 
	}

	// Formula: n!/(n-r)!
	@Override
	public int permutationWithOutRepeat(int n, int r) {				
		if(n >= 0) {
			if(n > r) {
				return nFactorial(n) / nMinusRFactorial(n,r);				
			} else if(n == r) {
				return nFactorial(n);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	// Formula: (r+n-1)! / r!(n-1)!
	@Override
	public int combinationWithRepeat(int n, int r) {		
		if(n >= 0) {			
			return rPlusNMinusOneFactorial(n,r) /		
					(rFactorial(r) * nMinusOneFactorial(n));			
		} else {
			return 0;
		}		
	}

	// Formula: n! / r!(n-1)!
	@Override
	public int combinationWithOutRepeat(int n, int r) {		
		if(n >= 0) {
			if(n > r) {
				return nFactorial(n) / 
						(rFactorial(r) * nMinusRFactorial(n,r));
			} else if(n == r) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
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
