package com.ait.calc.Controller;

public interface TrigonometricInterface {

	/*
	 *  calculating trigonometric functions
	 */
	// parameter angle
	public double calculateSine(double angle);
	public double calculateCosine(double angle);
	public double calculateTangent(double angle);
	public double calculateCosecant(double angle);
	public double calculateSecant(double angle);	
	public double calculateCotangent(double angle);
	
	// Overloading :: parameters (angle and angleType)
	public double calculateSine(double angle, String angleType);
	public double calculateCosine(double angle, String angleType);
	public double calculateTangent(double angle, String angleType);	
	public double calculateCosecant(double angle, String angleType);
	public double calculateSecant(double angle, String angleType);	
	public double calculateCotangent(double angle, String angleType);

	// Overloading :: parameters (two sides and angleType)
	public double calculateSine(double oppositeSide, double hypotenuseSide, String angleType);
	public double calculateCosine(double adjacentSide, double hypotenuseSide, String angleType);
	public double calculateTangent(double oppositeSide, double adjacentSide, String angleType);	
	public double calculateCosecant(double oppositeSide, double hypotenuseSide, String angleType);
	public double calculateSecant(double adjacentSide, double hypotenuseSide, String angleType);	
	public double calculateCotangent(double oppositeSide, double adjacentSide, String angleType);
	
	/*
	 *  calculating inverse trigonometric functions
	 */
	// parameter (angle)
	public double calculateArcSine(double angle);
	public double calculateArcCosine(double angle);
	public double calculateArcTangent(double angle);
	
	// Overloading :: parameters (angle and angleType)
	public double calculateArcSine(double angle, String angleType);
	public double calculateArcCosine(double angle, String angleType);
	public double calculateArcTangent(double angle, String angleType);
	
	// Overloading :: parameters (two sides and angleType)
	public double calculateArcSine(double oppositeSide, double hypotenuseSide, String angleType);
	public double calculateArcCosine(double adjacentSide, double hypotenuseSide, String angleType);
	public double calculateArcTangent(double oppositeSide, double adjacentSide, String angleType);
	
	/*
	 *  calculating hyperbolic functions
	 */
	// parameter (angle)
	public double calculateHyperbolicSine(double angle);
	public double calculateHyperbolicCosine(double angle);
	public double calculateHyperbolicTangent(double angle);
	public double calculateHyperbolicCosecant(double angle);
	public double calculateHyperbolicSecant(double angle);	
	public double calculateHyperbolicCotangent(double angle);
}
