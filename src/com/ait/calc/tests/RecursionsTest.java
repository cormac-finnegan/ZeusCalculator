package com.ait.calc.tests;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

import com.ait.calc.controller.RecursionsInterface;
import com.ait.calc.model.Recursions;

public class RecursionsTest {
	
	private static DecimalFormat df = new DecimalFormat("#00.000E00");
	private static DecimalFormat formatter = new DecimalFormat("####00.00");
	
	RecursionsInterface recursionsinterface;
	
	@Before
	public void setUp() {
		recursionsinterface = new Recursions();
	}
	
	@Test
	public void testFactorialZero() {
		assertEquals(recursionsinterface.factorial(0), 1.0, 0.01);
	}
	
	@Test
	public void testFactorialOne() {
		assertEquals(recursionsinterface.factorial(1), 1.0, 0.01);
	}
	
	@Test
	public void testFactorialTwo() {
		assertEquals(recursionsinterface.factorial(2), 2.0, 0.01);
	}
	
	@Test
	public void testFactorialThree() {
		assertEquals(recursionsinterface.factorial(3), 6.0, 0.01);
	}
	
	@Test
	public void testFactorialFour() {
		assertEquals(recursionsinterface.factorial(4), 24.0, 0.01);
	}
	
	@Test
	public void testFibonacciZero() {
		assertEquals(recursionsinterface.fibonacci(0), 0.0, 0.01);
	}
	
	@Test
	public void testFibonacciOne() {
		assertEquals(recursionsinterface.fibonacci(1), 1.0, 0.01);
	}
	
	@Test
	public void testFibonacciTwo() {
		assertEquals(recursionsinterface.fibonacci(2), 1.0, 0.01);
	}
	
	@Test
	public void testFibonacciThree() {
		assertEquals(recursionsinterface.fibonacci(3), 2.0, 0.01);
	}
	
	@Test
	public void testFibonacciFour() {
		assertEquals(recursionsinterface.fibonacci(4), 3.0, 0.01);
	}
	
	@Test
	public void testFibonacciFive() {
		assertEquals(recursionsinterface.fibonacci(5), 5.0, 0.01);
	}
	
	@Test
	public void testFibonacciSix() {
		assertEquals(recursionsinterface.fibonacci(6), 8.0, 0.01);
	}
	
	@Test
	public void testFibonacciTen() {
		assertEquals(recursionsinterface.fibonacci(10), 55.0, 0.01);
	}
	
	@Test
	public void testFibonacciTwenty() {
		assertEquals(recursionsinterface.fibonacci(20), 6765.0, 0.01);
	}
	
	@Test
	public void testFibonacciThirty() {
		assertEquals(recursionsinterface.fibonacci(30), 832040.0, 0.01);
	}
	
	@Test
	public void testFibonacciForty() {
		assertEquals(recursionsinterface.fibonacci(40), 1.02334155*Math.pow(10, 8), 0.001);
	}
	
	@Test
	public void testFibonacciFifty() {
		assertEquals(recursionsinterface.fibonacci(50), 2.0365011074*Math.pow(10, 10), 0.001);
	}
	
	@Test
	public void testFibonacciOneHundred() {
		assertEquals(recursionsinterface.fibonacci(100), 5.731478440138172*Math.pow(10, 20), 0.001);
	}

}
