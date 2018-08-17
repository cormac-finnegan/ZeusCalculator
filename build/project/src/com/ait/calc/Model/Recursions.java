package com.ait.calc.Model;

import com.ait.calc.Controller.RecursionsInterface;

public class Recursions implements RecursionsInterface {

	@Override
	public int factorial(int n) {
		if(n == 0 || n == 1) {		// base cases
			return 1;
		} else {
			// recursion step
			return factorial(n-1) * n;
		}
	}

	@Override
	public int fibonacci(int n) {
		if ((n == 0) || (n == 1)) { // base cases
		      return n; 
		} else {
			// recursion step
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
