package com.ait.calc.Model;

public class Token {
	public enum TokenType {
		NOTHING, NUMBER, OPERATOR, LEFTBRACE, RIGHTBRACE
	}

	public enum Associativity {
		LEFT, RIGHT
	}

	private TokenType tokenType;
	private double value;
	private char symbol;
	private Associativity asoc;
	private int precedence;
	private int parameterCount;

	public Token() {
		super();
	}

	public static Token stringToToken(String s) {
		Token t = new Token();

		try {
			Double.parseDouble(s);
			t.tokenType = TokenType.NUMBER;
			t.value = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			if (s.equals("(")) {
				t.tokenType = TokenType.LEFTBRACE;
			} else if (s.equals(")")) {
				t.tokenType = TokenType.RIGHTBRACE;
			} else {
				switch (s.toLowerCase()) {
				case "+":
					t.tokenType = TokenType.OPERATOR;
					t.symbol = '+';
					t.asoc = Associativity.LEFT;
					t.precedence = 10;
					t.parameterCount = 2;
					break;
				case "-":
					t.tokenType = TokenType.OPERATOR;
					t.symbol = '-';
					t.asoc = Associativity.LEFT;
					t.precedence = 10;
					t.parameterCount = 2;
					break;
				case "*":
					t.tokenType = TokenType.OPERATOR;
					t.symbol = '*';
					t.asoc = Associativity.LEFT;
					t.precedence = 20;
					t.parameterCount = 2;
					break;
				case "/":
					t.tokenType = TokenType.OPERATOR;
					t.symbol = '/';
					t.asoc = Associativity.LEFT;
					t.precedence = 20;
					t.parameterCount = 2;
					break;
				case "^":
					t.tokenType = TokenType.OPERATOR;
					t.symbol = '^';
					t.asoc = Associativity.LEFT;
					t.precedence = 30;
					t.parameterCount = 2;
					break;
				default:
					t.tokenType = TokenType.NOTHING;
				}
			}
		}

		return t;
	}

	@Override
	public String toString() {
		return "Token [tokenType=" + tokenType + ", value=" + value
				+ ", symbol=" + symbol + ", asoc=" + asoc + ", precedence="
				+ precedence + ", parameterCount=" + parameterCount + "]";
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public Associativity getAsoc() {
		return asoc;
	}

	public void setAsoc(Associativity asoc) {
		this.asoc = asoc;
	}

	public int getPrecedence() {
		return precedence;
	}

	public void setPrecedence(int precedence) {
		this.precedence = precedence;
	}

	public int getParameterCount() {
		return parameterCount;
	}

	public void setParameterCount(int parameterCount) {
		this.parameterCount = parameterCount;
	}
	
	public boolean equals(Token newToken) {
		if(this.getAsoc() != newToken.getAsoc()) {
			return false;
		}if(this.getParameterCount() != newToken.getParameterCount()) {
			return false;
		}if(this.getPrecedence() != newToken.getPrecedence()) {
			return false;
		}if(this.getSymbol() != newToken.getSymbol()) {
			return false;
		}if(this.getTokenType() != newToken.getTokenType()) {
			return false;
		}if(this.getValue() != newToken.getValue()) {
			return false;
		}
		return true;
	}
	
}
