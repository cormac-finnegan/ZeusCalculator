package com.ait.calc.Init;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ait.calc.Controller.LogarithmicInterface;
import com.ait.calc.Controller.Trigonometry;
import com.ait.calc.Model.Combinations;
import com.ait.calc.Model.LogarithmicFunctions;
import com.ait.calc.Model.Recursions;
import com.ait.calc.Model.TrigonometricFunctions;



public class MainApp {
	public static DecimalFormat df = new DecimalFormat("#00.0E00");
	public static DecimalFormat formatter = new DecimalFormat("####00.00");
	private static Scanner sc = new Scanner(System.in);
	public static String type;
	public static String trigonometricFunction;
	public static int n;
	public static int r;
	public static int recursion;
	public static double angle;
	public static double x;
	public static double y;
	public static int b;
	public static int c;
	public static double value;
	
	public static void main(String[] args) {
		Trigonometry trigo =  new TrigonometricFunctions();
		LogarithmicInterface logAndExp = new LogarithmicFunctions();
		
		double angle = trigo.calculateSine(-34, "Degrees");
		System.out.println("SINE -34 deg angle: " + angle);		
		double angle2 = trigo.calculateSine(-34, "Radians");
		System.out.println("SINE -34 Radian angle: " + angle2);
		System.out.println();
		
		angle = trigo.calculateCosine(-40, "Degrees");
		System.out.println("Cos -40 deg angle: " + angle);		
		angle2 = trigo.calculateCosine(-40, "Radians");
		System.out.println("Cos -40 Radian angle: " + angle2);
		System.out.println();
		
		angle = trigo.calculateTangent(40, "Degrees");
		System.out.println("Tan 40 deg angle: " + angle);		
		angle2 = trigo.calculateTangent(40, "Radians");
		System.out.println("Tan 40 Radian angle: " + angle2);
		System.out.println();
		
		angle = trigo.calculateSecant(40, "Degrees");
		System.out.println("Sec 40 deg angle: " + angle);		
		angle2 = trigo.calculateSecant(40, "Radians");
		System.out.println("Sec 40 Radian angle: " + angle2);
		System.out.println();
		
		angle = trigo.calculateArcSine(3, 5, "Degrees");
		System.out.println("ArcSin (InvSine) 3/5 deg angle: " + angle);		
		angle2 = trigo.calculateArcSine(3, 5, "Radians");
		System.out.println("ArcSin 3/5 Radian angle: " + angle2);
		System.out.println();
		
		System.out.println("VALUE 0.6 ");
		angle = trigo.calculateArcSine(0.6, "Degrees");
		System.out.println("ArcSin (InvSine) (0.6) deg angle: " + angle);		
		angle2 = trigo.calculateArcSine(0.6, "Radians");
		System.out.println("ArcSin (0.6) Radian angle: " + angle2);
		System.out.println();
		
		System.out.println("ArcCos 0.6 ");
		angle = trigo.calculateArcCosine(0.6, "Degrees");
		System.out.println("ArcCos (InvSine) (0.6) deg angle: " + angle);		
		angle2 = trigo.calculateArcCosine(0.6, "Radians");
		System.out.println("ArcCos (0.6) Radian angle: " + angle2);
		System.out.println();
		
		angle = trigo.calculateArcCosine(3, 5, "Degrees");
		System.out.println("ArcCos (InvCosine) 3/5 deg angle: " + angle);		
		angle2 = trigo.calculateArcCosine(3, 5, "Radians");
		System.out.println("ArcCos 3/5 Radian angle: " + angle2);
		System.out.println();
	}

	public static int print() {
		System.out.println("Please select one (0-2):\n");
		System.out.println("Option 1: Combination.");
		System.out.println("Option 2: Trigonometry.");
		System.out.println("Option 3: Recursion.");		
		System.out.println("Option 0: Exit");
		
		return sc.nextInt();
	}
	
	public static int printMenu() {
		System.out.println("Please select one of the following (0-4):\n");
		System.out.println("Option 1: Permutation.");
		System.out.println("Option 2: Permutation WITHOUT repetition.");
		System.out.println("Option 3: Combination.");
		System.out.println("Option 4: Combination WITHOUT repetition.");
		System.out.println("Option 0: Exit");
		
		return sc.nextInt();
	}
	
	public static int printFunction() {
		System.out.println("Please select function (0-2):\n");
		System.out.println("Option 1: Trigonometric Function.");
		System.out.println("Option 2: Hyperbolic Function.");
		System.out.println("Option 3: Logarithmic function.");
		System.out.println("Option 0: Exit.");
		
		return sc.nextInt();
	}
	
	public static int printType() {
		System.out.println("Please select type of the angle (0-2):\n");
		System.out.println("Option 1: Degree.");
		System.out.println("Option 2: Radian.");
		System.out.println("Option 0: Exit.");
		
		return sc.nextInt();
	}	
	
	public static int printTrigonometricFunction() {
		System.out.println("Please select function (0-9):\n");
		System.out.println("Option 1: Sine.");
		System.out.println("Option 2: Cosine.");
		System.out.println("Option 3: Tangent.");
		System.out.println("Option 4: Secant.");
		System.out.println("Option 5: Cosecant.");
		System.out.println("Option 6: Cotangent.");
		System.out.println("Option 7: Arc Sine.");
		System.out.println("Option 8: Arc Cosine.");
		System.out.println("Option 9: Arc Tangent.");
		System.out.println("Option 0: Exit.");
				
		return sc.nextInt();
	}
	
	public static int printHyperbolicFunction() {
		System.out.println("Please select function (0-6):");
		System.out.println("Option 1: Hyperbolic Sine.");
		System.out.println("Option 2: Hyperbolic Cosine.");
		System.out.println("Option 3: Hyperbolic Tangent.");
		System.out.println("Option 4: Hyperbolic Secant.");
		System.out.println("Option 5: Hyperbolic Cosecant.");
		System.out.println("Option 6: Hyperbolic Cotangent.");
		System.out.println("Option 0: Exit.");
				
		return sc.nextInt();
	}
	
	public static int printRecursion() {
		System.out.println("Please select function (0-2):");
		System.out.println("Option 1: Factorial.");
		System.out.println("Option 2: Fibonacci.");
		System.out.println("Option 0: Exit.");
		
		return sc.nextInt();
	}
	
	public static int printLogarithmicFunction() {
		System.out.println("Please select function:");
		System.out.println("Option 1: Log.");
		System.out.println("Option 2: 10^x.");
		System.out.println("Option 3: Ln.");
		System.out.println("Option 4: e^x.");
		System.out.println("Option 5: Log of x with base b.");
		System.out.println("Option 6: Log of x/y.");
		System.out.println("Option 7: Log of x/y base b.");
		System.out.println("Option 8: Log of x with base b/c.");
		System.out.println("Option 9: Log of x/y base b/c.");
		System.out.println("Option 0: Exit.");
				
		return sc.nextInt();
	}

}
