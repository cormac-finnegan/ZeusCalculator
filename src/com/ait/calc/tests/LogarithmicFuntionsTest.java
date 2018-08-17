package com.ait.calc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ait.calc.controller.LogarithmicInterface;
import com.ait.calc.model.LogarithmicFunctions;

public class LogarithmicFuntionsTest {

	private LogarithmicInterface logarithmicInterface;
	static double x = 2.0;
	
	@Before
	public void setUp() {
		logarithmicInterface = new LogarithmicFunctions();
	}

	@Test
	public void testLn() {
		assertEquals(logarithmicInterface.ln(x), 0.693, 0.001);
	}
	
	@Test
	public void testExpToPowerOfX() {
		assertEquals(logarithmicInterface.expToPowerOfX(x), 7.389, 0.001);
	}
	
	@Test
	public void testTenToPowerOfX() {
		assertEquals(logarithmicInterface.tenToPowerOfX(x), 100.0, 0.001);
	}

	@Test
	public void testLog() {
		assertEquals(logarithmicInterface.log(x), 0.301, 0.001);
	}

}
