package com.ait.calc.controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ait.calc.model.CmacToken;
import com.ait.calc.model.InlineFunction;
import com.ait.calc.model.Token;
import com.ait.calc.model.Token.TokenType;

/**
 * Created by C.I.T on 24-Sep-17.
 */
public class Tokenizer{

	private ArrayList<Token> tokenArrayList = new ArrayList<>();
	public static String abstractRegex = "("+CmacToken.inlineFunctionRegex+"|"+CmacToken.numericalRegex+"|"+CmacToken.operandRegex+")";
	Pattern numericalPattern = Pattern.compile(abstractRegex);
	public static boolean degrees = false;

	public Tokenizer(String input){
		Matcher absMatcher = numericalPattern.matcher(input);
		//System.out.println("Tokenizer = " + degrees);

		while(absMatcher.find()){
			String s = null;
			try{
				s = absMatcher.group(0);
				//System.out.println(s);
			}catch (IllegalStateException ils){

			}
			Token t = tokenize(s);
			if(s.equals("-"))
			{
				if(tokenArrayList.size() ==  0|| tokenArrayList.get(tokenArrayList.size()-1).getTokenType() == Token.TokenType.LEFTBRACE || tokenArrayList.get(tokenArrayList.size()-1).getTokenType() == Token.TokenType.OPERATOR)
				{		
					t.setSymbol('_');
					t.setTokenType(TokenType.OPERATOR);
					t.setAsoc(Token.Associativity.RIGHT);
					t.setPrecedence(30);
					t.setParameterCount(1);

				}
			}

			tokenArrayList.add(t);

			//tokenArrayList.add(tokenize(s));

		}
	}

	public Token tokenize(String value){
		Matcher infMatcher = CmacToken.inlineFunctionPattern.matcher(value);
		Matcher numMatcher = CmacToken.numericalPattern.matcher(value);
		Matcher opMatcher = CmacToken.operandPattern.matcher(value);
		//Matcher aInfMatcher = CmacToken.abstractSpecialCharPattern.matcher(value);
		

		if(infMatcher.find()){
			InlineFunction inlineFunction = new InlineFunction(infMatcher.group(0));
			//System.out.println(inlineFunction.getCalculatedFunction());
			if(degrees)
				return Token.stringToToken(inlineFunction.degResult+"");
			else {
				return Token.stringToToken(inlineFunction.radResult+"");
			}
		}else if(numMatcher.find()){
			return Token.stringToToken(numMatcher.group(0));
		}else if(opMatcher.find()){
			return Token.stringToToken(opMatcher.group(0));
		}
		return null;
	}


	public ArrayList<Token> getTokenArrayList() {
		return tokenArrayList;
	}


	public Stack<CmacToken> toStack(ArrayList<CmacToken> arrayList){
		Stack<CmacToken> stack = new Stack<>();
		for(CmacToken t : arrayList){
			stack.add(t);
		}
		return stack;
	}

	public Queue<CmacToken> toQueue(ArrayList<CmacToken> arrayList){
		Queue<CmacToken> queue = new LinkedList<CmacToken>();
		for(CmacToken t : arrayList){
			queue.add(t);
		}
		return queue;
	}

}
