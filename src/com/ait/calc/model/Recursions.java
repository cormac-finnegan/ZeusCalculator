package com.ait.calc.model;

import com.ait.calc.controller.RecursionsInterface;

public class Recursions implements RecursionsInterface {

	@Override
	public double factorial(double n) {
		if(n >= 0) {
			if(n == 0 || n == 1) {		// base cases
				return 1;
			} else {
				// recursion step
				return factorial(n-1) * n;
			}
		} else {
			return 0;
		}
	}

	@Override
	public double fibonacci(double n) {
		double prev=0d, next=1d, result=0d;
		if(n >= 0) {
			if(n < 41) { // recursive code
				if ((n == 0) || (n == 1)) { // base cases
				    result = n;  
					return result; 
				} else {
					// recursion step
					result = fibonacci(n - 1) + fibonacci(n - 2);
					return result;
				}
			} else { // non-recursive code to cater more than 40
				for (int i = 0; i < n; i++) {
			        result = prev+next;
			        prev = next;
			        next = result;
			    }
			    return result;
			}
		} else {
			return result;
		}
	}

}
