package com.ait.calc.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.ait.calc.Model.Token;
import com.ait.calc.Model.Token.TokenType;

public class Calculator {
	private static Scanner sc;
	
	
	public static void main(String[] args) {
		//Test String
		String input = "-88+3"; 
		 
		Calculator.calculate(input);
	}
	
	public static String calculate(String expression) {
		double answer;
			ArrayList<Token> tokens = getTokens(expression);
			Tokenizer tokenizer = new Tokenizer(expression);
			ArrayList<Token> tokenArrayList = tokenizer.getTokenArrayList();
			
			//x^4+5x-4
			
			for(int i = 0; i < tokenArrayList.size(); i++) {
				if(!tokenArrayList.get(i).equals(tokens.get(i))) {
					System.out.println("Parser mismatch on element " + i + "\n" +
							"Token(" + tokens.get(i).getSymbol() + ") " +
							"CMacToken(" + tokenArrayList.get(i).getSymbol() + ") " +
							" Token: " + tokens.get(i).toString() +
							" TokenRegex: " + tokenArrayList.get(i).toString());
				}
			}
			
			
			try
			{
				Queue<Token> outputQueue = shuntingYard(tokens);
				answer = calculateExpression(outputQueue);
				System.out.println("Answer: "+answer);
			}catch(Exception e){
				return(e.getMessage());
			}
		return answer+"";
	}

	private static double calculateExpression(Queue<Token> outputQueue) throws Exception {
		Stack<Token> stack = new Stack<Token>();
		for (Token token : outputQueue) {
			if(token.getTokenType() == Token.TokenType.NUMBER){
				stack.push(token);
			}else{
				if(stack.size() < token.getParameterCount())
				{
					System.out.println("Stack Size:" + stack.size());
					System.out.println("Param Count:" + token.getParameterCount());
					
					throw new Exception("Insufficient values");
				}else{
					ArrayList<Token> operands = new ArrayList<Token>();
					for (int i = 0; i < token.getParameterCount(); i++) {
						operands.add(stack.pop());
					}
					stack.push(evaluateOperator(token, operands));
				}
			}
		}
		if(stack.size()==1)
		{
			return stack.pop().getValue();
		}else{
			throw new Exception("Error, the user has input too many values");
		}
	}

	private static Token evaluateOperator(Token operator, ArrayList<Token> operands) throws Exception {
		Token result = new Token();
		result.setTokenType(TokenType.NUMBER);
		switch (operator.getSymbol()) {
		case '+':
			result.setValue(operands.get(1).getValue() + operands.get(0).getValue());
			break;
		case '-':
			result.setValue(operands.get(1).getValue() - operands.get(0).getValue());
			break;
		case '*':
			result.setValue(operands.get(1).getValue() * operands.get(0).getValue());
			break;
		case '/':
			result.setValue(operands.get(1).getValue() / operands.get(0).getValue());
			break;
		case '^':
			result.setValue(Math.pow(operands.get(1).getValue(), operands.get(0).getValue()));
			break;
		case '_':
			result.setValue(-operands.get(0).getValue());
			break;

		default:
			throw new Exception("Unknown Operator");
		}
		return result;
	}

	private static Queue<Token> shuntingYard(ArrayList<Token> tokens) throws Exception {
		Queue<Token> outputQueue = new LinkedList<Token>();
		Stack<Token> stack = new Stack<Token>();
		for (Token token : tokens) {
			if(token.getTokenType() == Token.TokenType.NUMBER){
				outputQueue.add(token);
			}else if(token.getTokenType() == Token.TokenType.OPERATOR){
				while(!stack.isEmpty()){
					Token topOfStack = stack.peek();
					if(topOfStack.getTokenType() != Token.TokenType.OPERATOR)
					{
						break;
					}
					if(token.getAsoc() == Token.Associativity.LEFT && token.getPrecedence() <= topOfStack.getPrecedence())
					{
						outputQueue.add(stack.pop());
					}else
					{
						break;
					}
				}
				stack.push(token);
			}else if(token.getTokenType() == Token.TokenType.LEFTBRACE){
				stack.push(token);
			}else if(token.getTokenType() == Token.TokenType.RIGHTBRACE){
				while(stack.peek().getTokenType() != Token.TokenType.LEFTBRACE){
					outputQueue.add(stack.pop());
					if(stack.isEmpty())
					{
						throw new Exception("Mismatched Braces");
					}
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty()){
			if(stack.peek().getTokenType() == Token.TokenType.LEFTBRACE || stack.peek().getTokenType() == Token.TokenType.RIGHTBRACE)
			{
				throw new Exception("Mismatched Braces");
			}
			else{
				outputQueue.add(stack.pop());
			}
		}
		return outputQueue;
	}

	private static ArrayList<Token> getTokens(String s) {
		String[] split = splitForTokens(s);
		ArrayList<Token> tokens = new ArrayList<Token>();
		for (String string : split) {
			Token t = Token.stringToToken(string);
			if(string.equals("-"))
			{
				if(tokens.size() ==  0|| tokens.get(tokens.size()-1).getTokenType() == Token.TokenType.LEFTBRACE || tokens.get(tokens.size()-1).getTokenType() == Token.TokenType.OPERATOR)
				{
					t.setSymbol('_');
					t.setTokenType(TokenType.OPERATOR);
					t.setAsoc(Token.Associativity.RIGHT);
					t.setPrecedence(30);
					t.setParameterCount(1);
				}
			}
			tokens.add(t);
		}
		return tokens;
	}
	
	private static String[] splitForTokens(String s){
		s = s.replace("+", " + ");
		s = s.replace("-", " - ");
		s = s.replace("*", " * ");
		s = s.replace("/", " / ");
		s = s.replace("^", " ^ ");
		s = s.replace("(", " ( ");
		s = s.replace(")", " ) ");
		s=s.trim();
		return s.split("\\s+");
	}

}
