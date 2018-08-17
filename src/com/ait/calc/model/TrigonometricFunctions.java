package com.ait.calc.model;

import com.ait.calc.controller.TrigonometricConstants;
import com.ait.calc.controller.Trigonometry;

public class TrigonometricFunctions implements Trigonometry, TrigonometricConstants {
	
	// Formula: sin(angle)
	@Override
	public double calculateSine(double angle) { //The MATH library seems to already handle negative values
		// sin(-x) = -sinx
		//if(angle < 0) {
			//return -Math.sin(angle);
		//} else {
			return Math.sin(angle);
		//}
	}

	// Formula: cos(angle)
	@Override
	public double calculateCosine(double angle) {		
		return Math.cos(angle);
	}

	// Formula: tan(angles) //Is this right?
	@Override
	public double calculateTangent(double angle) { //The MATH library seems to already handle negative values
		// tan(-x) = -tanx
		//if(angle < 0) {
			//return -Math.tan(angle);
		//} else {
			return Math.tan(angle);
		//}		
	}

	// Formula: 1/sin(angle)
	@Override
	public double calculateCosecant(double angle) {		
		// csc(-x) = -cscx
		//if(angle < 0) {
			//return -(1 / Math.sin(angle));
		//} else {
			return 1 / Math.sin(angle);
		//}		
	}
	
	// Formula: 1/cos(angle)
	@Override
	public double calculateSecant(double angle) {		
		return 1 / Math.cos(angle);
	}

	// Formula: 1/tan(angle)
	@Override
	public double calculateCotangent(double angle) {		
		// cot(-x) = -cotx
		//if(angle < 0) {
			//return -(1 / Math.tan(angle));
		//} else {
			return 1 / Math.tan(angle);
		//}
	}

	@Override
	public double calculateSine(double angle, String angleType) {
		// convert to Radians if type is Degrees
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;					
		} 
		// sin(-x) = -sinx
		if(angle < 0) {
			return -Math.sin(angle);
		} else {
			return Math.sin(angle);
		}		
	}

	@Override
	public double calculateCosine(double angle, String angleType) {
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}				
		return Math.cos(angle);
	}

	@Override
	public double calculateTangent(double angle, String angleType) {
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		} 
		// tan(-x) = -tanx
		if(angle < 0) {
			return -Math.tan(angle);
		} else {
			return Math.tan(angle);
		}		
	}

	@Override
	public double calculateCosecant(double angle, String angleType) {
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}
		// csc(-x) = -cscx
		if(angle < 0) {
			return -(1 / (Math.sin(angle)));
		} else {
			return 1 / (Math.sin(angle));
		}		
	}
	
	@Override
	public double calculateSecant(double angle, String angleType) {
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}						
		return 1 / (Math.cos(angle));
	}

	@Override
	public double calculateCotangent(double angle, String angleType) {
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}
		// cot(-x) = -cotx
		if(angle < 0) {
			return -(1 / (Math.tan(angle)));
		} else {
			return 1 / (Math.tan(angle));
		}		
	}

	@Override
	public double calculateSine(double oppositeSide, double hypotenuseSide, String angleType) {
		double angle = 0.0;
		angle = oppositeSide / hypotenuseSide;
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}
		// sin(-x) = -sinx
		if(angle < 0) {
			return -Math.sin(angle);
		} else {
			return Math.sin(angle);
		}
	}

	@Override
	public double calculateCosine(double adjacentSide, double hypotenuseSide, String angleType) {
		double angle = 0.0;
		angle = adjacentSide / hypotenuseSide;
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}		
		return Math.cos(angle);
	}

	@Override
	public double calculateTangent(double oppositeSide, double adjacentSide, String angleType) {
		double angle = 0.0;
		angle = oppositeSide / adjacentSide;
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}
		// tan(-x) = -tanx
		if(angle < 0) {
			return -Math.tan(angle);
		} else {
			return Math.tan(angle);
		}		
	}
		
	@Override
	public double calculateCosecant(double oppositeSide, double hypotenuseSide, String angleType) {
		double angle = 0.0;
		angle = hypotenuseSide / oppositeSide;
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}
		// csc(-x) = -cscx
		if(angle < 0) {
			return -Math.sin(angle);
		} else {
			return Math.sin(angle);
		}
	}
	
	@Override
	public double calculateSecant(double adjacentSide, double hypotenuseSide, String angleType) {
		double angle = 0.0;
		angle = hypotenuseSide / adjacentSide;
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}		
		return Math.cos(angle);
	}

	@Override
	public double calculateCotangent(double oppositeSide, double adjacentSide, String angleType) {
		double angle = 0.0;
		angle = adjacentSide / oppositeSide;
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * DEGREE_TO_RADIAN;						
		}
		// cot(-x) = -cotx
		if(angle < 0) {
			return -Math.tan(angle);
		} else {
			return Math.tan(angle);
		}
	}
	
	/* 
	 * calculating Inverse Trigonometric Functions 
	 */
	// Formula arcsin(angle)
	@Override
	public double calculateArcSine(double angle) {
		return Math.asin(angle);		
	}
	
	@Override
	public double calculateArcCosine(double angle) {
		return Math.acos(angle);		
	}
	
	@Override
	public double calculateArcTangent(double angle) {
		return Math.atan(angle);		
	}
	
	@Override
	public double calculateArcSine(double angle, String angleType) {
		angle = Math.asin(angle);		
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * RADIAN_TO_DEGREE;						
		}
		
		return angle; 
	}

	@Override
	public double calculateArcCosine(double angle, String angleType) {
		angle = Math.acos(angle);
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * RADIAN_TO_DEGREE;						
		}
		
		return angle;
	}

	@Override
	public double calculateArcTangent(double angle, String angleType) {
		angle = Math.atan(angle);		
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * RADIAN_TO_DEGREE;						
		}
		
		return angle;
	}

	@Override
	public double calculateArcSine(double oppositeSide, double hypotenuseSide, String angleType) {
		double angle = 0.0;		
		angle = Math.asin(oppositeSide / hypotenuseSide);
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * RADIAN_TO_DEGREE;
		}
		
		return angle;
	}

	@Override
	public double calculateArcCosine(double adjacentSide, double hypotenuseSide, String angleType) {
		double angle = 0.0;
		angle = Math.acos(adjacentSide / hypotenuseSide);
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * RADIAN_TO_DEGREE;						
		}
		
		return angle;
	}

	@Override
	public double calculateArcTangent(double oppositeSide, double adjacentSide, String angleType) {
		double angle = 0.0;
		angle = Math.atan(oppositeSide / adjacentSide);
		if(angleType.equalsIgnoreCase("Degrees")) {
			angle = angle * RADIAN_TO_DEGREE;						
		}
		
		return angle;
	}
	
	/* 
	 * calculating Hyperbolic Functions 
	 */
	// Formula: sinh(x)
	@Override
	public double calculateHyperbolicSine(double angle) {
		// sinh(-x) = -sinhx
		if(angle < 0) {
			return -Math.sinh(angle);
		} else { 
			return Math.sinh(angle);
		}	
	}

	// Formula: cosh(x) 
	@Override
	public double calculateHyperbolicCosine(double angle) {
		return Math.cosh(angle);
	}
	
	// Formula: tanh(x)
	@Override
	public double calculateHyperbolicTangent(double angle) {
		// tanh(-x) = -tanhx
		if(angle < 0) {
			return -Math.tanh(angle);
		} else {	
			return Math.tanh(angle);
		}
		
	}	

	@Override
	public double calculateHyperbolicCosecant(double angle) {
		// csch(-x) = -cschx
		if(angle < 0) {
			return -(1 / Math.sinh(angle));
		} else {
			return 1 / Math.sinh(angle);
		}
	}
	
	@Override
	public double calculateHyperbolicSecant(double angle) {
		return 1 / Math.cosh(angle);
	}

	@Override
	public double calculateHyperbolicCotangent(double angle) {
		// coth(-x) = -cothx
		if(angle < 0) {
			return -(1 / Math.tanh(angle));
		} else {
			return 1 / Math.tanh(angle);
		}
	}

}
