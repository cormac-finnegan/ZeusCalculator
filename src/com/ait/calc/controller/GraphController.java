package com.ait.calc.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import com.ait.calc.model.PlotPoint;

public class GraphController {
	//array to store plotPoints obtained from equation
	public static ArrayList<PlotPoint> plotPoints;
	static String function;
	static double minX,maxX,amount;
	static boolean algebra;
	public static boolean isTan() {
		return tan;
	}

	static boolean tan;

	public static void Plotting(String function, double minX, double maxX){


		if ((function.contains("tan("))||(function.contains("TAN("))){
			tan=true;
		}

		else{
			tan=false;
		}
		if(function.startsWith("1/", 0)){
			tan=true;
		}

		//converting to lowercase
		String output="";
		char[] functionChars=function.toCharArray();
		String lower="";
		for(char c:functionChars){
			c=new Character(Character.toLowerCase(c));
			lower+=c;

		}

		functionChars=lower.toCharArray();

		//checking contains x
		for(char c:functionChars){

			if(c=='x'){
				algebra=true;
				break;
			}
		}


		if(algebra){
			if(!compare(minX,maxX)){
				System.out.println("Min value must be smaller than max");

			}

			for(int ii=0;ii<functionChars.length;ii++){
				if(functionChars[ii]=='x'){
					if(ii==0){
						output+=String.valueOf(functionChars[ii]);
					}
					else if(Character.isDigit(functionChars[ii-1])){
						output+="*";
						output+=String.valueOf(functionChars[ii]);
					}
					else{output+=String.valueOf(functionChars[ii]);
					}
				}
				else{
					output+=String.valueOf(functionChars[ii]);
				}

			}

			String out="";



			plotPoints=new ArrayList<PlotPoint>();



			double difference=Double.parseDouble(new BigDecimal(maxX).subtract(new BigDecimal(minX)).toPlainString());
			double intervalRate = (difference*.0015);



			double previous=0;
			for(double i=minX;i<maxX;i+=intervalRate){


				out=output.replaceAll(String.valueOf('x'),((Double.valueOf(i))).toString());
				String y=Calculator.calculate(out);

				if(y.equals("Infinity")){
					//Marker
					plotPoints.add(new PlotPoint(0.12343256724356724,0.12343256724356724));
					continue;
				}
				else	if(plotPoints.isEmpty()){
					previous = Double.valueOf(y);
					plotPoints.add(new PlotPoint(i,Double.valueOf(y)));
					continue;

				}

				else if(tan&&Math.abs(Double.valueOf(y)-previous)>7){

					plotPoints.add(new PlotPoint(0.12343256724356724,0.12343256724356724));
					continue;
				}


				else{
					plotPoints.add(new PlotPoint(i,Double.valueOf(y)));

				}

			}
		}
	}






	public static String getFunction() {
		return function;
	}

	public static void setFunction(String function) {
		GraphController.function = function;
	}

	public static boolean compare(double x,double y ){
		if(x<y){
			return true;
		}
		else{
			return false;
		}

	}








}




