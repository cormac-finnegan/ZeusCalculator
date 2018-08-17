package com.ait.calc.model;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ait.calc.controller.Calculator;
import com.ait.calc.controller.Tokenizer;
import com.ait.calc.controller.TrigonometricConstants;
import com.ait.calc.controller.TrigonometricInterface;
import com.ait.calc.controller.Trigonometry;

public class InlineFunction {

	private String fullFunction = "";
	public String inlineFunctionRegex;
	public Pattern inlineFunctionPattern;
	private static String[] functionNameArray = {"sec", "cosec", "cotan", "cos", "tan", "sin","log10", "log", "arcsin", "arccos", "arctan",  "√", "ln", "³√"};
	private String function;
	private String operands;
	private String opResult;
	public double result = 0.0;
	public double radResult;
	public double degResult;
	


	public InlineFunction(String function) {
		this.fullFunction = function.toLowerCase();
		this.inlineFunctionRegex = constructRegex();
		this.inlineFunctionPattern = Pattern.compile(inlineFunctionRegex);
		String[] functionAndOperand = matchRegex();
		this.function = functionAndOperand[0]; 
		this.operands = functionAndOperand[1];
		try {
			try {
				this.opResult = Calculator.calculate(new BigDecimal(this.operands).toPlainString());
			}catch(NumberFormatException nb) {
				this.opResult = Calculator.calculate(this.operands);
			}
			Matcher prepended = CmacToken.prependedFunctionPattern.matcher(this.function);
			if(prepended.find()) {
				try {
					String prependedValue = prepended.group(1);
					this.function = this.function.replaceAll("[()]", "");
					this.function = this.function.replaceAll(prependedValue, "");
					this.result = getCalculatedFunction(false);
					if(this.function.equals("cos") || this.function.equals("sin") || this.function.equals("tan") || 
							this.function.equals("arccos") || this.function.equals("arcsin") || this.function.equals("arctan") ||
							this.function.equals("sec") || this.function.equals("cosec") || this.function.equals("cotan")) {
						this.degResult = getCalculatedFunction(true);
					}else {
						this.degResult = result;
					}
					this.result = Double.parseDouble(Calculator.calculate(prepended.group(0) +"*"+ this.result+""));
					this.radResult = result;
				}catch(NumberFormatException nb){

				}
			}else {
				this.result = getCalculatedFunction(false);
				if(this.function.equals("cos") || this.function.equals("sin") || this.function.equals("tan") || 
						this.function.equals("arccos") || this.function.equals("arcsin") || this.function.equals("arctan")||
						this.function.equals("sec") || this.function.equals("cosec") || this.function.equals("cotan")) {
					this.degResult = getCalculatedFunction(true);
				}else {
					this.degResult = result;
				}
				this.radResult = result;

				
				
			}
		}catch(NullPointerException e) {
			System.out.println("There has been an error parsing the inline function: NULL");
		}


	}

	public static String constructRegex() {
		String regex = "";
		//(?:(cos)|(tan)|(sin)|(log))\(?(.+).\)?
		//"((?:cos|tan|sin|log)(?:\\({1}(?:(?:[0-9]\\d*(?:\\.\\d+)?)\\){1})|(?:(?:[0-9]\\d*(?:\\.\\d+)?))))"
		regex = "(";
		for(int i = 0; i < functionNameArray.length; i++) {
			regex += "("+functionNameArray[i]+")";
			if(functionNameArray.length - i > 1 ) {
				regex += "|";
			}

		}
		regex+=")";
		//System.out.println(regex);
		return regex;

	}

	private String[] matchRegex() {
		Matcher infMatcher = inlineFunctionPattern.matcher(this.fullFunction);
		String[] subs = new String[2];
		//for(int i = 0; i <= this.functionNameArray.length; i++) {
		infMatcher.find();
		try{
			//System.out.println(infMatcher.group(i));
			if(infMatcher.group(0).equals("log")) {
				subs[0] = this.fullFunction.substring(0, infMatcher.end()); 
				String modifier = this.fullFunction.substring(infMatcher.end(), this.fullFunction.indexOf('('));
				subs[0] += modifier;
				subs[1] = this.fullFunction.substring(this.fullFunction.indexOf('('));

				subs[1] = evaluateParams(subs[1]);
			}else {
				subs[0] = this.fullFunction.substring(0, infMatcher.end()); 
				subs[1] = this.fullFunction.substring(infMatcher.end());

				subs[1] = evaluateParams(subs[1]);
			}
			

			//subs[1] = Calculator.calculate(subs[1]);
		}catch (IllegalStateException ils){

		}
		//}
		return subs;

	}
	
	

	public String evaluateParams(String input) {
		if(input.startsWith("(") && input.endsWith("")) {
			input = input.substring(1, input.length()-1); //trims brackets off
		}

		return input;
	}

	public double getCalculatedFunction(boolean radians) {
		TrigonometricFunctions tf = new TrigonometricFunctions();
		double answer = 0.0;
		if(radians) {
			this.opResult = Math.toRadians(Double.parseDouble(this.opResult))+"";
		}
		switch(this.function) {
		case "cos":
			answer = tf.calculateCosine(Double.parseDouble(this.opResult));
			break;
		case "sin":
			answer = tf.calculateSine(Double.parseDouble(this.opResult));
			break;
		case "tan":
			answer = tf.calculateTangent(Double.parseDouble(this.opResult));
			break;
		case "arccos":
			answer = tf.calculateArcCosine(Double.parseDouble(this.opResult));
			break;
		case "arcsin":
			answer = tf.calculateArcSine(Double.parseDouble(this.opResult));
			break;
		case "arctan":
			answer = tf.calculateArcTangent(Double.parseDouble(this.opResult));
			break;
		case "cosec":
			answer = tf.calculateCosecant(Double.parseDouble(this.opResult));
			break;
		case "sec":
			answer = tf.calculateSecant(Double.parseDouble(this.opResult));
			break;
		case "cotan":
			answer = tf.calculateCotangent(Double.parseDouble(this.opResult));
			break;
		case "log":
			LogarithmicFunctions lf = new LogarithmicFunctions();
			answer = lf.log(Double.parseDouble(this.opResult));
			break;//√
		case "√":
			//LogarithmicFunctions lf = new LogarithmicFunctions();
			answer = Math.sqrt(Double.parseDouble(this.opResult));
			//answer = lf.log(Double.parseDouble(this.opResult));
			break;//√
		case "ln":
			//LogarithmicFunctions lf = new LogarithmicFunctions();
			answer = Math.log(Double.parseDouble(this.opResult));
			//answer = lf.log(Double.parseDouble(this.opResult));
			break;//√log_[0-9]\\d*
		case "log10":
			answer = Math.log10(Double.parseDouble(this.opResult));
			break;//³√
		case "³√":
			answer = Math.cbrt(Double.parseDouble(this.opResult));
			break;//³√
		}
		//System.out.println("OP Result for Inline Function: " + answer);
		return answer;

	}

}
