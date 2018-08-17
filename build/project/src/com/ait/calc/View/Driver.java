package com.ait.calc.View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;


public class Driver implements Initializable {

	@FXML
	public Button one;
	public Button two;
	public Button three;
	public Button four;
	public Button five;
	public Button six;
	public Button seven;
	public Button eight;
	public Button nine;
	public Button zero;
	public Button point;
	public Button equals;
	public Button plus;
	public Button minus;
	public Button multiply;
	public Button divide;
	public Button cancel;
	public Button plusminus;
	public Button modulus;
	public TextField input;
	public Label equation;
	
	private long numOne;
	private long numTwo;
	private String operation;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void choosePoint() {
		String firstValue =  input.getText();
		String choice = ".";
		input.setText(firstValue + choice);
	}
	
	public void chooseOne() {
		String firstValue =  input.getText();
		String choice = "1";
		input.setText(firstValue + choice);
	}
	
	public void chooseTwo() {
		String firstValue =  input.getText();
		String choice = "2";
		input.setText(firstValue + choice);
	}
	
	public void chooseThree() {
		String firstValue =  input.getText();
		String choice = "3";
		input.setText(firstValue + choice);
	}
	
	public void chooseFour() {
		String firstValue =  input.getText();
		String choice = "4";
		input.setText(firstValue + choice);
	}
	
	public void chooseFive() {
		String firstValue =  input.getText();
		String choice = "5";
		input.setText(firstValue + choice);
	}
	
	public void chooseSix() {
		String firstValue =  input.getText();
		String choice = "6";
		input.setText(firstValue + choice);
	}
	
	public void chooseSeven() {
		String firstValue =  input.getText();
		String choice = "7";
		input.setText(firstValue + choice);
	}
	public void chooseEight() {
		String firstValue =  input.getText();
		String choice = "8";
		input.setText(firstValue + choice);
	}
	
	public void chooseNine() {
		String firstValue =  input.getText();
		String choice = "9";
		input.setText(firstValue + choice);
	}
	public void chooseZero() {
		String firstValue =  input.getText();
		String choice = "0";
		input.setText(firstValue + choice);
	}
	public void choosePlus() {
		String firstValue =  input.getText();
		long valueNum = Integer.parseInt(firstValue);
		this.numOne = valueNum;
		equation.setText(firstValue + " + ");
		operation = "+";
	}
	
	public void chooseMinus() {
		String firstValue =  input.getText();
		long valueNum = Integer.parseInt(firstValue);
		this.numOne = valueNum;
		equation.setText(firstValue + " - ");
		operation = "-";
	}
	public void chooseMultiply() {
		String firstValue =  input.getText();
		long valueNum = Integer.parseInt(firstValue);
		this.numOne = valueNum;
		equation.setText(firstValue + " * ");
		operation = "*";
	}
	
	public void chooseDivision() {
		String firstValue =  input.getText();
		long valueNum = Integer.parseInt(firstValue);
		this.numOne = valueNum;
		equation.setText(firstValue + " / ");
		operation = "/";
	}
	public void chooseCancel() {
		input.setText("");
		equation.setText("");
		this.numOne = 0;
		this.numTwo = 0;
	}
	
	public void choosePlusMinus() {
		String firstValue =  input.getText();
		long valueNum = Integer.parseInt(firstValue);
		this.numOne = valueNum;
		equation.setText("-" + firstValue);
		operation = "+/-";
	}
	public void chooseModulus() {
		String firstValue =  input.getText();
		long valueNum = Integer.parseInt(firstValue);
		this.numOne = valueNum;
		equation.setText(firstValue + " % ");
		operation = "%";
	}
	
	public void chooseEquals() {
		switch(operation) {
		case "+":
			String value = input.getText();
			this.numTwo = Integer.parseInt(value);
			long result = this.numOne + this.numTwo;
			input.setText(String.valueOf(result));
			String oldLabel = equation.getText();
			equation.setText(oldLabel + value);
			break;
		case "-":
			String valueMinus = input.getText();
			this.numTwo = Integer.parseInt(valueMinus);
			long resultMinus = this.numOne - this.numTwo;
			input.setText(String.valueOf(resultMinus));
			String oldLabelMinus = equation.getText();
			equation.setText(oldLabelMinus + valueMinus);
			break;
			
		case "*":
			String valueMulti = input.getText();
			this.numTwo = Integer.parseInt(valueMulti);
			long resultMulti = this.numOne * this.numTwo;
			input.setText(String.valueOf(resultMulti));
			String oldLabelMulti = equation.getText();
			equation.setText(oldLabelMulti + valueMulti);
			break;
			
		case "/":
			String valueDiv = input.getText();
			this.numTwo = Integer.parseInt(valueDiv);
			long resultDiv = this.numOne / this.numTwo;
			input.setText(String.valueOf(resultDiv));
			String oldLabelDiv = equation.getText();
			equation.setText(oldLabelDiv + valueDiv);
			break;
			
		case "%":
			String valueMod = input.getText();
			this.numTwo = Integer.parseInt(valueMod);
			long resultMod = this.numOne % this.numTwo;
			input.setText(String.valueOf(resultMod));
			String oldLabelMod = equation.getText();
			equation.setText(oldLabelMod + valueMod);
			break;
		}
		
		
	}
	
	
}
