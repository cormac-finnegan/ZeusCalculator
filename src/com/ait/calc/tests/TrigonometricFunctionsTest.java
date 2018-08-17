package com.ait.calc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ait.calc.controller.TrigonometricInterface;
import com.ait.calc.model.TrigonometricFunctions;

public class TrigonometricFunctionsTest {

	private TrigonometricInterface trigoInterface;
	static double angle = 2.0;
	static String angleType = "DEGREES";
	static double opposite = 3.0;
	static double adjacent = 4.0;
	static double hypotenuse = 5.0;
	static double x = 1.0;
	
	@Before
	public void setUp() {
		trigoInterface = new TrigonometricFunctions();
	}
	
	@Test
	public void testCalculateSine() {
		assertEquals(trigoInterface.calculateSine(angle), 0.909, 0.001);
	}
	
	@Test
	public void testCalculateSineWithAngleType() {
		assertEquals(trigoInterface.calculateSine(angle, angleType), 0.034, 0.001);
	}
	
	@Test
	public void testCalculateSineWithSidesAndAngleType() {
		assertEquals(trigoInterface.calculateSine(opposite, hypotenuse, angleType), 0.010, 0.001);
	}
	
	@Test
	public void testCalculateCosine() {
		assertEquals(trigoInterface.calculateCosine(angle), -0.416, 0.001);
	}
	
	@Test
	public void testCalculateCosineWithAngleType() {
		assertEquals(trigoInterface.calculateCosine(angle, angleType), 0.999, 0.001);
	}
	
	@Test
	public void testCalculateCosineWithSidesAndAngleType() {
		assertEquals(trigoInterface.calculateCosine(adjacent, hypotenuse, angleType), 0.999, 0.001);
	}
	
	@Test
	public void testCalculateTangent() {
		assertEquals(trigoInterface.calculateTangent(angle), -2.185, 0.001);
	}
	
	@Test
	public void testCalculateTangentWithAngleType() {
		assertEquals(trigoInterface.calculateTangent(angle, angleType), 0.034, 0.001);
	}
	
	@Test
	public void testCalculateTangentWithSidesAndAngleType() {
		assertEquals(trigoInterface.calculateTangent(opposite, adjacent, angleType), 0.013, 0.001);
	}

	@Test
	public void testCalculateCosecant() {
		assertEquals(trigoInterface.calculateCosecant(angle), 1.099, 0.001);
	}
	
	@Test
	public void testCalculateCosecantWithAngleType() {
		assertEquals(trigoInterface.calculateCosecant(angle, angleType), 28.653, 0.001);
	}
	
	@Test
	public void testCalculateCosecantWithSidesAndAngleType() {
		assertEquals(trigoInterface.calculateCosecant(opposite, hypotenuse, angleType), 0.029, 0.001);
	}
	
	@Test
	public void testCalculateSecant() {
		assertEquals(trigoInterface.calculateSecant(angle), -2.402, 0.001);
	}
	
	@Test
	public void testCalculateSecantWithAngleType() {
		assertEquals(trigoInterface.calculateSecant(angle, angleType), 1.000, 0.001);
	}
	
	@Test
	public void testCalculateSecantWithSidesAndAngleType() {
		assertEquals(trigoInterface.calculateSecant(adjacent, hypotenuse, angleType), 1.000, 0.001);
	}
		
	@Test
	public void testCalculateCotangent() {
		assertEquals(trigoInterface.calculateCotangent(angle), -0.457, 0.001);
	}
	
	@Test
	public void testCalculateCotangentWithAngleType() {
		assertEquals(trigoInterface.calculateCotangent(angle, angleType), 28.636, 0.001);
	}
	
	@Test
	public void testCalculateCotangentWithSidesAndAngleType() {
		assertEquals(trigoInterface.calculateCotangent(opposite, adjacent, angleType), 0.023, 0.001);
	}
	
	@Test
	public void testCalculateArcSine() {
		assertEquals(trigoInterface.calculateArcSine(x), 1.570, 0.001);
	}
	
	@Test
	public void testCalculateArcCosine() {
		assertEquals(trigoInterface.calculateArcCosine(x), 0.000, 0.001);
	}
	
	@Test
	public void testCalculateArcTangent() {
		assertEquals(trigoInterface.calculateArcTangent(x), 0.785, 0.001);
	}
	
	@Test
	public void testCalculateHyperbolicSine() {
		assertEquals(trigoInterface.calculateHyperbolicSine(x), 1.175, 0.001);
	}
	
	@Test
	public void testCalculateHyperbolicCosine() {
		assertEquals(trigoInterface.calculateHyperbolicCosine(x), 1.543, 0.001);
	}
	
	@Test
	public void testCalculateHyperbolicTangent() {
		assertEquals(trigoInterface.calculateHyperbolicTangent(x), 0.761, 0.001);
	}
	
	@Test
	public void testCalculateHyperbolicCosecant() {
		assertEquals(trigoInterface.calculateHyperbolicCosecant(x), 0.850, 0.001);
	}
	
	@Test
	public void testCalculateHyperbolicSecant() {
		assertEquals(trigoInterface.calculateHyperbolicSecant(x), 0.648, 0.001);
	}
	
	@Test
	public void testCalculateHyperbolicCotangent() {
		assertEquals(trigoInterface.calculateHyperbolicCotangent(x), 1.313, 0.001);
	}

}
