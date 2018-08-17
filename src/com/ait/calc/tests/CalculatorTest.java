package com.ait.calc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.calc.controller.Calculator;

public class CalculatorTest {

	private double getAsDouble(String ex) {
		return Double.parseDouble(Calculator.calculate(ex));
	}
	
	@Test
	public void testAddition() {
		assertEquals(4, getAsDouble("2+2"), 0.001);
	}
	
	@Test
	public void testMinus() {
		assertEquals(4, getAsDouble("6-2"), 0.001);
	}
	
	@Test
	public void testMinusWithOneNegative() {
		assertEquals(-4, getAsDouble("-6+2"), 0.001);
	}
	
	@Test
	public void testMinusWithTwoNegative() {
		assertEquals("-8", Calculator.calculate("-6-2"));
	}
	
	@Test
	public void testMultiplyEasy() {
		assertEquals("4", Calculator.calculate("2*2"));
	}
	
	@Test
	public void testMultiplyMed() {
		assertEquals(4.96, getAsDouble("2*2.48"), 0.001);
	}
	
	@Test
	public void testSimpleWithThreePrecedence() {
		assertEquals(0.8266666666666667, getAsDouble("2*2.48/6"), 0.0000000000001);
	}
	
	@Test
	public void testSimpleWithFourPrecedence() {
		assertEquals(-6.173333333333334, getAsDouble("2*2.48/6-7"), 0.0000000000001);
	}
	
	@Test
	public void testSimpleWithFourPrecedenceWithBrackets() {
		assertEquals(-6.173333333333334, getAsDouble("(2)*(2.48/6)-7"), 0.0000000000001);
	}
	
	@Test
	public void testSin() {
		assertEquals(Math.sin(32), getAsDouble("sin(32)"), 0.000000001);
	}
	
	@Test
	public void testCos() {
		assertEquals(Math.cos(32), getAsDouble("cos(32)"), 0.000000001);
	}
	
	@Test
	public void testTan() {
		assertEquals(Math.tan(32), getAsDouble("tan(32)"), 0.000000001);
	}
	
	@Test
	public void testNegSin() {
		assertEquals(Math.sin(-32), getAsDouble("sin(-32)"), 0.000000001);
	}
	
	@Test
	public void testNegCos() {
		assertEquals(Math.cos(-32), getAsDouble("cos(-32)"),0.000000001);
	}
	
	@Test
	public void testNegTan() {
		assertEquals(Math.tan(-32), getAsDouble("tan(-32)"),0.000000001);
	}
	
	
	
	
	@Test
	public void testarcSin() {
		assertEquals(Math.asin(1), getAsDouble("arcsin(1)"), 0.000000001);
	}
	
	@Test
	public void testarcCos() {
		assertEquals(Math.acos(1.0471975511965979), getAsDouble("arcsin(1.0471975511965979)"), 0.000000001);
	}
	
	@Test
	public void testarcTan() {
		assertEquals(Math.atan(1), getAsDouble("arctan(1)"), 0.000000001);
	}
	
	@Test
	public void testNegarcSin() {
		assertEquals(Math.asin(-1), getAsDouble("arcsin(-1)"), 0.000000001);
	}
	
	@Test
	public void testNegarcCos() {
		assertEquals(Math.acos(-0.5), getAsDouble("arccos(-0.5)"), 0.000000001);

	}
	
	@Test
	public void testSec() {
		assertEquals(1/Math.cos(1), getAsDouble("sec(1)"), 0.000000001);
		assertEquals(getAsDouble("1/cos(1)"), getAsDouble("sec(1)"), 0.0000001);
		
		assertEquals(1/Math.cos(32), getAsDouble("sec(32)"), 0.000000001);
		assertEquals(getAsDouble("1/cos(32)"), getAsDouble("sec(32)"), 0.0000001);
		
		assertEquals(1/Math.cos(-1), getAsDouble("sec(-1)"), 0.000000001);
		assertEquals(getAsDouble("1/cos(-1)"), getAsDouble("sec(-1)"), 0.0000001);
		
		assertEquals(1/Math.cos(-32), getAsDouble("sec(-32)"), 0.000000001);
		assertEquals(getAsDouble("1/cos(-32)"), getAsDouble("sec(-32)"), 0.0000001);
	}

	
	@Test
	public void testCosec() {
		assertEquals(1/Math.sin(1), getAsDouble("cosec(1)"), 0.000000001);
		assertEquals(getAsDouble("1/sin(1)"), getAsDouble("cosec(1)"), 0.0000001);
		
		assertEquals(1/Math.sin(32), getAsDouble("cosec(32)"), 0.000000001);
		assertEquals(getAsDouble("1/sin(32)"), getAsDouble("cosec(32)"), 0.0000001);
		
		assertEquals(1/Math.sin(-1), getAsDouble("cosec(-1)"), 0.000000001);
		assertEquals(getAsDouble("1/sin(-1)"), getAsDouble("cosec(-1)"), 0.0000001);
		
		assertEquals(1/Math.sin(-32), getAsDouble("cosec(-32)"), 0.000000001);
		assertEquals(getAsDouble("1/sin(-32)"), getAsDouble("cosec(-32)"), 0.0000001);
	}
	
	@Test
	public void testCotan() {
		assertEquals(1/Math.tan(1), getAsDouble("cotan(1)"), 0.000000001);
		assertEquals(getAsDouble("1/tan(1)"), getAsDouble("cotan(1)"), 0.0000001);
		
		assertEquals(1/Math.tan(-1), getAsDouble("cotan(-1)"), 0.000000001);
		assertEquals(getAsDouble("1/tan(-1)"), getAsDouble("cotan(-1)"), 0.0000001);
		
		assertEquals(1/Math.tan(32), getAsDouble("cotan(32)"), 0.000000001);
		assertEquals(getAsDouble("1/tan(32)"), getAsDouble("cotan(32)"), 0.0000001);
		
		assertEquals(1/Math.tan(32), getAsDouble("cotan(32)"), 0.000000001);
		assertEquals(getAsDouble("1/tan(32)"), getAsDouble("cotan(32)"), 0.0000001);
		
		assertEquals(1/Math.tan(32), getAsDouble("cos(32)/sin(32)"), 0.000000001);
	}
	
	@Test
	public void testLog10() {
		assertEquals(Math.log10(32), getAsDouble("log10(32)"), 0.000000001);
	}
	
	@Test
	public void testLog() {
		assertEquals(Math.log(32), getAsDouble("ln(32)"), 0.1);
		assertEquals(Math.log1p(32), getAsDouble("ln(32)"), 0.1);
	}
	
	@Test
	public void testPredecatedFunctions() {
		assertEquals(56*Math.sin(32), getAsDouble("56sin(32)"), 0.000000001);
		assertEquals(56*Math.cos(32), getAsDouble("56cos(32)"), 0.000000001);
		assertEquals(56*Math.tan(32), getAsDouble("56tan(32)"), 0.000000001);
	}
	
	@Test
	public void testPowerOf() {
		assertEquals(Math.pow(2, 4), getAsDouble("2^4"), 0.000000001);
		assertEquals(Math.pow(4, 6), getAsDouble("4^6"), 0.000000001);
		assertEquals(Math.pow(Math.sin(32), Math.sin(32)), getAsDouble("sin(32)^sin(32)"), 0.000000001);

	}
	
	@Test
	public void testModulus() {
		assertEquals(4%6,getAsDouble("4%6"), 0.000000001);
		assertEquals(6%4,getAsDouble("6%4"), 0.000000001);
	}
	
	@Test
	public void testConst() {
		assertEquals(Math.PI,getAsDouble("π"), 0.000000001);
		assertEquals(Math.E,getAsDouble("ℇ"), 0.000000001);
	}


}
