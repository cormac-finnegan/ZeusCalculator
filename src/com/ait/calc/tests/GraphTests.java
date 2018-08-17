package com.ait.calc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ait.calc.controller.GraphController;
import com.ait.calc.view.Driver;

public class GraphTests {


	private Driver driver;
	private GraphController gc;
	@Before
	public void setUp(){
		driver=new Driver();
		gc=new GraphController();
	}

	@Test
	public void testMinGreaterThanMax() {
		assertFalse(driver.checkNumbers("100", "10"));	
	}
	
	@Test(expected=Exception.class)
	public void testMinNotNumber(){
		assertFalse(driver.checkNumbers("sin","10"));
	}
	
	@Test(expected=Exception.class)
	public void testMaxNotNumber(){
		assertFalse(driver.checkNumbers("2","TEST"));
	}
	
	@Test
	public void testMinMaxSame(){
		assertFalse(driver.checkNumbers("0", "0"));
	}

	@Test(expected=Exception.class)
	public void testFunctionMissingX(){
		assertFalse(driver.checkAlgebra("sin"));
	}

	@Test(expected=Exception.class)
	public void testFunctionInvalidLetters(){
		assertFalse(driver.checkAlgebra("abc"));
	}
	
	
	@Test
	public void testValidFunctionWithTrig(){
		assertTrue(driver.checkAlgebra("1/sin(x)"));
	}
	
	@Test
	public void testValidXFunction(){
		assertTrue(driver.checkAlgebra("5x+3x"));
	}
	
	
	
	@Test
	public void testMinSmallerThanMax(){
		assertTrue(driver.checkNumbers("1", "2"));
	}
	
	@Test
	public void testContainsTan(){
		gc.Plotting("tan", 1, 2);
		assertEquals(GraphController.isTan(),false);
	}
	
	@Test
	public void testDoesNotContainsTan(){
		gc.Plotting("sin", 1, 2);
		assertEquals(GraphController.isTan(),false);
	}
	
	
	
	

}
