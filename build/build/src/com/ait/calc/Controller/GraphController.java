package com.ait.calc.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.ait.calc.Model.PlotPoint;

public class GraphController {
	//array to store plotPoints obtained from equation
	public static ArrayList<PlotPoint> plotPoints;
	static String function;
	static int minX,maxX,amount;
	
	public static void Plotting(){
		
		int choice=0;
		Scanner scan=new Scanner(System.in);

		System.out.println("Enter function for f(x)");
		function =scan.next();

		System.out.println("Enter min amount for x:");
		minX=scan.nextInt();
		System.out.println("Enter max amount for X:");
		maxX=scan.nextInt();



		String output="";
		char[] functionChars=function.toCharArray();


		for(int ii=0;ii<functionChars.length;ii++){
			if(functionChars[ii]=='x'){
				if(ii==0){
					output+=String.valueOf(functionChars[ii]);
				}
				else if(Character.isDigit(functionChars[ii-1])){
					output+="*";
					output+=String.valueOf(functionChars[ii]);
				}
			}
			else{
				output+=String.valueOf(functionChars[ii]);
			}

		}
		System.out.println(output);

		String out="";



		plotPoints=new ArrayList<PlotPoint>();

		double intervalRate=.25;

		for(double i=minX;i<=maxX;i+=intervalRate){
			System.out.println(Double.valueOf(i));
			out=output.replaceAll(String.valueOf('x'),((Double.valueOf(i))).toString());
			System.out.println(out);
			String y=Calculator.calculate(out);
			
			System.out.println(y);
			plotPoints.add(new PlotPoint(i,Double.valueOf(y)));


		}}

	public static String getFunction() {
		return function;
	}

	public static void setFunction(String function) {
		GraphController.function = function;
	}

}




