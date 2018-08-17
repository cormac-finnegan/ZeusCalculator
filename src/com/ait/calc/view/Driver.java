package com.ait.calc.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.concurrent.Executor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ait.Database.Formula;
import com.ait.Database.FormulaDao;
import com.ait.Database.HistoricalEquation;
import com.ait.Database.HistoryDao;
import com.ait.calc.controller.Calculator;
import com.ait.calc.controller.GraphController;
import com.ait.calc.controller.TrigonometricConstants;
import com.ait.calc.init.AudioInit;
import com.ait.calc.model.MatrixPanel;
import com.ait.calc.model.Recursions;
import com.ait.calc.model.Sets;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ToggleGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.ait.calc.model.FourierFunctionChart;
import com.ait.calc.model.FourierSeriesChart;
import com.ait.calc.model.PlotPoint;
import com.sun.javafx.geom.Rectangle;

import java.io.File;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;



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
	public Button fibonacci;
	public TextField input;
	public Label equation;
	@FXML
	private Pane rootStackPane;

	private long numOne;
	private long numTwo;
	private String operation;
	private HistoryDao historyDao;
	private Label[] labels;
	private TextField[] textFields;
	ArrayList<Formula> formulaList;
	private int oldCaretPosition;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		historyDao = new HistoryDao();
		ToggleGroup group1 = new ToggleGroup();
		ToggleGroup group2 = new ToggleGroup();

		permutation.setToggleGroup(group1);
		permutation.setSelected(true);
		combination.setToggleGroup(group1);
		notAllowed.setToggleGroup(group2);
		notAllowed.setSelected(true);
		allowed.setToggleGroup(group2);

		input.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				oldCaretPosition = input.getCaretPosition();
			}
		});

		//setupFormula(); 	//Needs database running
		//setUpHistory();	//Needs database running


		
	}
	boolean equalsSelected = false;
	boolean degreesSelected = false;
	String value = "";




	public void checkForWipe() {
		if(equalsSelected == true) {
			chooseCancel();
			if(input.getText().equals("")) {
				equalsSelected = false;
			}
		}
	}

	public void addText(String s) {
		try {
			if(oldCaretPosition >= 0)
				input.insertText(oldCaretPosition, s);
			else
				input.appendText(s);
		}catch(Exception e) {
			input.appendText(s);
		}
		oldCaretPosition = -1;
	}

	public void choosePoint() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = ".";
		value += choice;
		input.insertText(oldCaretPosition, choice);
		addText(choice);
		//input.setText(value);
	}

	public void chooseOne() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "1";
		addText(choice);
	}

	public void chooseTwo() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "2";
		addText(choice);
	}

	public void chooseThree() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "3";
		addText(choice);
	}

	public void chooseFour() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "4";
		addText(choice);
	}

	public void chooseFive() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "5";
		addText(choice);
	}

	public void chooseSix() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "6";
		addText(choice);
	}

	public void chooseSeven() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "7";
		addText(choice);
	}
	public void chooseEight() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "8";
		addText(choice);
	}

	public void chooseNine() {
		checkForWipe();
		String firstValue =  input.getText();
		String choice = "9";
		addText(choice);
	}
	public void chooseZero() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "0";
		addText(choice);
	}

	public void chooseSin() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "sin(";
		addText(choice);

	}

	public void chooseCos() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "cos(";
		addText(choice);

	}

	public void chooseTan() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "tan(";
		addText(choice);

	}

	public void chooseArcSin() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "arcsin(";
		addText(choice);

	}

	public void chooseArcCos() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "arccos()";
		addText(choice);

	}

	public void chooseArcTan() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "arctan(";
		addText(choice);

	}

	public void choosePI() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "π";
		addText(choice);

	}

	public void chooseSqrroot() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "√(";
		addText(choice);
	}

	public void chooseLeftParen() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = "(";
		addText(choice);
	}

	public void chooseRightParen() {
		checkForWipe();
		//String firstValue =  input.getText();
		String choice = ")";
		addText(choice);
	}

	public void chooseXSquared() {
		checkForWipe();
		//String firstValue =  input.getText();
		if(input.getText().length() > 0) {
			String choice = "^2";
			addText(choice);
		}
	}

	public void chooseXCubed() {
		checkForWipe();
		//String firstValue =  input.getText();
		if(input.getText().length() > 0) {
			String choice = "^3";
			addText(choice);
		}
	}

	public void chooseXPowerOf() {
		checkForWipe();
		//String firstValue =  input.getText();
		if(input.getText().length() > 0) {
			String choice = "^";
			addText(choice);
		}
	}

	public void choose10PowerOfX() {
		checkForWipe();
		//String firstValue =  input.getText();

		String choice = "10^";
		addText(choice);

	}

	public void chooseOneOver() {
		checkForWipe();
		String choice = "1/";
		String before = input.getText();
		input.setText(choice+before);
	}

	public void chooseRecursion() {
		checkForWipe();
		String choice = "!";
		addText(choice);
	}

	public void chooseEularsConstant() {
		checkForWipe();
		addText("ℇ");
	}
	public void chooseNaturalLog() {
		checkForWipe();
		addText("ln(");
	}
	public void chooseLog() {
		checkForWipe();
		addText("log(");
	}

	//Produces a Random double value >= 0.0 and <= 1.0
	public void chooseRand() {
		checkForWipe();
		addText(Math.random()+"");
	}

	public void chooseCubeRoot() {
		checkForWipe();
		addText("³√(");
	}



	public void choosePlus() {
		checkForWipe();
		//String firstValue =  input.getText();
		//long valueNum = Integer.parseInt(firstValue);
		//this.numOne = valueNum;
		addText(" + ");

		//operation = "+";
	}

	public void chooseMinus() {
		checkForWipe();
		//String firstValue =  input.getText();
		//long valueNum = Integer.parseInt(firstValue);
		//this.numOne = valueNum;
		addText(" - ");
		//operation = "-";
	}
	public void chooseMultiply() {
		checkForWipe();
		//String firstValue =  input.getText();
		//long valueNum = Integer.parseInt(firstValue);
		//this.numOne = valueNum;
		addText(" * ");
		//operation = "*";
	}

	public void chooseDivision() {
		checkForWipe();
		//String firstValue =  input.getText();
		//long valueNum = Integer.parseInt(firstValue);
		//this.numOne = valueNum;
		addText(" / ");
		//operation = "/";
	}
	public void chooseCancel() {

		input.setText("");
		//equation.setText("");
		//this.numOne = 0;
		//this.numTwo = 0;
	}

	public void choosePlusMinus() {
		checkForWipe();
		addText("-");
		//String firstValue =  input.getText();
		//long valueNum = Integer.parseInt(firstValue);
		//this.numOne = valueNum;
		//equation.setText("-" + firstValue);
		//operation = "+/-";

	}
	public void chooseModulus() {
		checkForWipe();
		//String firstValue =  input.getText();
		//long valueNum = Integer.parseInt(firstValue);
		//this.numOne = valueNum;
		//equation.setText(" % ");
		operation = "%";
		addText(operation);
	}


	public void chooseEquals() {
		String inputFromCalc = input.getText();
		Calculator.degrees = degreesSelected;
		String result = Calculator.calculate(inputFromCalc);		
		input.setText(result);
		equalsSelected = true;
		
		new Thread(new Runnable(){
			public void run(){
				//historyDao.addEquation(inputFromCalc, result); //Needs database running
				//setUpHistory();	//Needs database running
		}
		}).start();
		
	}

	public void chooseRadians() {
		degreesSelected = false;

		equation.setText("Rad");

	}

	public void chooseDegrees() {
		degreesSelected = true;

		equation.setText("Deg");

	}
	
	public void chooseLog10() {
		checkForWipe();
		operation = "log10(";
		addText(operation);
	}

	public void fibonacciSequence(ActionEvent event) {
		
		Recursions recursion = new Recursions();
		double inputFromCalc = Double.parseDouble(input.getText());
		double result = 0.0;
		if(inputFromCalc < 0) {
			input.setText("[ Error ] Value should be a positive number.");			
		} else if(inputFromCalc > 40) {
			input.setText("[ Error ] n is too large.");		
			result = recursion.fibonacci(inputFromCalc);
		}else {
			result = recursion.fibonacci(inputFromCalc);
			equalsSelected = true;
			input.setText(""+result);
		}
		System.out.println("Input from Calc: " + inputFromCalc);
		System.out.println("Fibonacci Result: " + result);
	}
	
	public void chooseSecant() {
		checkForWipe();
		addText("sec(");
	}
	
	public void chooseCosecant() {
		checkForWipe();
		addText("cosec(");
	}
	
	public void chooseCotangent() {
		checkForWipe();
		addText("cotan(");
	}

	/******
	 * Tab 2 - Equations
	 */

	private void setupFormula() {
		labels = new Label[]{varLbl1, varLbl2, varLbl3, varLbl4, varLbl5, varLbl6};
		textFields = new TextField[]{varInput1, varInput2, varInput3, varInput4, varInput5, varInput6};

		FormulaDao formulaDao = new FormulaDao();
		formulaList = formulaDao.getFormula();
		for (Formula formula : formulaList) {
			choices.add(formula);
		}
		choicebox.setItems(choices);

		choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Formula>() {

			@Override
			public void changed(ObservableValue<? extends Formula> arg0, Formula arg1, Formula arg2) {
				listItemChanged();
			}
		});

		choicebox.getSelectionModel().select(0);

	}

	protected void listItemChanged() {
		hideAllVariables();
		Formula f = formulaList.get(choicebox.getSelectionModel().getSelectedIndex());
		equationText.setText("");
		resultText.setText("");
		formulaText.setText(f.getEquation());
		String[] variables = f.getVariables();
		String[] variableNames = f.getVariableNames();

		for (int i = 0; i < variables.length; i++) {
			labels[i].setVisible(true);
			labels[i].setText(variableNames[i]+":");
			textFields[i].setVisible(true);
		}
	}

	private void hideAllVariables() {
		for (Label label : labels) {
			label.setVisible(false);
			label.setText("");
		}

		for (TextField textField : textFields) {
			textField.setVisible(false);
			textField.setText("");
		}
	}



	@FXML
	ObservableList<Formula> choices = FXCollections.observableArrayList();
	@FXML
	public ChoiceBox<Formula> choicebox;
	@FXML
	public TextField varInput1;
	public TextField varInput2;
	public TextField varInput3;
	public TextField varInput4;
	public TextField varInput5;
	public TextField varInput6;
	public TextField formulaText;
	public TextField equationText;
	public TextField resultText;
	public Button calculateBttn;
	public Label varLbl1;
	public Label varLbl2;
	public Label varLbl3;
	public Label varLbl4;
	public Label varLbl5;
	public Label varLbl6;

	/*
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // All work which must happen when the GUI boots has to be done here.
		choicebox.setItems(choices);
		choicebox.setValue("Choice One");
	}*/

	public void calForm(){
		Formula selectedFormula = choicebox.getSelectionModel().getSelectedItem();
		String equation = selectedFormula.getEquation();
		String[] variables = selectedFormula.getVariables();
		for(int i = 0; i<variables.length; i++){
			equation = equation.replace(variables[i], textFields[i].getText());
		}
		equation = equation.replace("pi", Math.PI+"");
		equationText.setText(equation);
		String calcString = equation;
		String result = Calculator.calculate(equation);
		resultText.setText(result);
		
		new Thread(new Runnable(){
			public void run(){
				//historyDao.addEquation(calcString, result); //Needs database running
				//setUpHistory();	//Needs database running
		}
		}).start();
	}

	/***
	 * Tab 3 - Graph with Pop up
	 */

	@FXML
	public Button popUp;
	public TextField fxEnter;
	public TextField minX;
	public TextField maxX;

	public boolean TextsFilled(){
		if(minX.getText().isEmpty()){
			minX.setText("Enter value");
			return false;
		}
		else if(maxX.getText().isEmpty()){
			maxX.setText("Enter value");
			return false;
		}
		else if(fxEnter.getText().isEmpty()){
			fxEnter.setText("Enter value");
			return false;
		}
		else{
			return true;
		}
	}

	public boolean checkNumbers(String min,String max){
		try{
			Double.valueOf(min);
			try{
				Double.valueOf(max);
				try{
					if(Double.valueOf(min)<Double.valueOf(max)){
						return true;
					}
					else{
						minX.setText("Not < max");
						return false;
					}
				}catch(Exception e){}
			//	return true;
			}catch(Exception e){
				maxX.setText("Enter number");
				return false;
			}

		}catch(Exception e){
			minX.setText("Enter number");
			return false;
		}
		return false;
	}




	public boolean checkAlgebra(String function){

		boolean containsX=false;
		boolean lettersOK=true;

		ArrayList<String> functions=new ArrayList<String>();
		functions.add("sin");
		functions.add("cos");
		functions.add("tan");

		char[] values=function.toCharArray();
		for(char c:values){
			Character.toLowerCase(c);
			System.out.println(c);
		}

		for(int i=0;i<function.length();i++){


			if (Character.isAlphabetic(function.charAt(i))){


				if(function.charAt(i)=='x'){
					containsX=true;
					continue;
				}

				else{
					String checkString=function.substring(i, i+3);
					if(functions.contains(checkString)){
						i+=2;
						continue;
					}
					else{
						fxEnter.setText("invalid entry");
						lettersOK=false;
						return false;
					}
				}}
			else{continue;
			}}

		if(containsX&&lettersOK){
			return true;}
		else {
			if(!containsX)
				fxEnter.setText("x missing");
			return false;}}









	public void popUpWindow(ActionEvent event) {
		LineChart<Number,Number> lineChart;


		if(TextsFilled()&&checkNumbers(minX.getText(),maxX.getText())&&checkAlgebra(fxEnter.getText())){
			//	if(checkNumbers(minX.getText(),maxX.getText()))

			{

				try {
					String function=fxEnter.getText();
					double min=Double.valueOf(minX.getText());
					double max=Double.valueOf(maxX.getText());

					GraphController.Plotting(function, min, max);

					Stage stage=new Stage();

					stage.setTitle("\t\t"+function+"\t\t");
					final NumberAxis xAxis=new NumberAxis();
					final NumberAxis yAxis= new NumberAxis();




					lineChart=
							new LineChart<Number,Number>(xAxis,yAxis);

					lineChart.setTitle(GraphController.getFunction());

					//Line to remove points/ dots from the graph
					lineChart.setCreateSymbols(false);
					lineChart.setLegendVisible(false);
					XYChart.Series series=new XYChart.Series<>();




					for(PlotPoint p:GraphController.plotPoints){

						if(p.getX()==0.12343256724356724&&p.getY()==0.12343256724356724){
							lineChart.getData().add(series);
							series=new XYChart.Series<>();
							continue;
						}

						else{
							series.getData().add(new XYChart.Data(p.getX(),p.getY()));
						}
					}

					Scene scene= new Scene(lineChart,800,600);
					lineChart.setTitle("\t\t"+function+"\t\t for range "+min+"<= x <="+max);
					lineChart.getData().add(series);
					GraphController.plotPoints.clear();
					lineChart.setStyle("-fx-background-color: rgb(25,29,50);");
					stage.setScene(scene);
					stage.show();


				} catch(Exception e) {
					fxEnter.setText("Enter valid equation");
			
				}

			}	}
	}

	/***
	 * Tab 4 - FFT
	 */
	@FXML
	public Button fftFromFile;
	public Button fftFromMic;
	public Button dctAudio;

	@FXML
	public TextField fileChooser;

	public void fftFromFileAction() {
		//Work Goes Here
		String fileName = fileChooser.getText();

		if(fileName.isEmpty()) {
			fileName = "prodigy.wav";
		}

		AudioInit.audioStart(true, fileName);
	}

	public void fftFromMicAction() {
		//Work Goes Here
		AudioInit.audioStart(false, "");
	}

	public void dctAudioAction() {
		//Work Goes Here
		String input = fileChooser.getText();

		if(!input.isEmpty()) {
			StringTokenizer st = new StringTokenizer(input, " ");
			String fileName = st.nextToken();
			int qLevel; 

			if(st.hasMoreTokens()) {
				qLevel = Integer.parseInt(st.nextToken());
			} else {
				qLevel = 1;
			}

			AudioInit.audioCompressor(fileName, qLevel);
		}
	}

	public void fileChoiceAction() {
		//Work Goes Here
	}

	/***
	 * Tab 5 - Permutations and Combinations
	 */
	@FXML
	public Button calculatePerm;
	@FXML
	public TextField resultsOfPerm;
	public TextField nNumber;
	public TextField rNumber;

	@FXML
	public RadioButton permutation;
	public RadioButton combination;
	public RadioButton notAllowed;
	public RadioButton allowed;

	public void calculateSets(ActionEvent event) {
		Sets sets = new Sets();
		int n = Integer.parseInt(nNumber.getText());
		int r = Integer.parseInt(rNumber.getText());
		if(n < 0 || r < 0) {
			resultsOfPerm.setText("[ Error ] n and r should be greater than zero.");
		} else if(n == 0 && r == 0) {
			resultsOfPerm.setText("[ Error ] n and r are zero.");
		} else if(n == 0) {
			resultsOfPerm.setText("[ Error ] n is zero.");
		} else if(r == 0) {
			resultsOfPerm.setText("[ Error ] r is zero.");		
		} else {
			if(permutation.isSelected() && allowed.isSelected()) {
				resultsOfPerm.setText(""+sets.permutationWithRepeat(n, r));
			} else if(permutation.isSelected() && notAllowed.isSelected()) {
				if(n < r) {
					resultsOfPerm.setText("[ Error ] r > n");
				} else {
					resultsOfPerm.setText(""+sets.permutationWithOutRepeat(n, r));
				}
			} else if(combination.isSelected() && allowed.isSelected()) {
				resultsOfPerm.setText(""+sets.combinationWithRepeat(n, r));
			} else {
				if(n < r) {
					resultsOfPerm.setText("[ Error ] r > n");
				} else {
					resultsOfPerm.setText(""+sets.combinationWithOutRepeat(n, r));
				}
			}		
		}
	}

	/***	 
	 * Tab 6 - Compression 
	 */


	// *********************extra code added here
	@FXML
	public Button matrixFourier, plotFourier, resetFourier1, resetFourier2, resetFourier3;
	@FXML
	public TextField x1Fourier, x2Fourier, x3Fourier, x4Fourier, x5Fourier, x6Fourier, f1Fourier, f2Fourier, f3Fourier, axFourier, bxFourier, lFourier, a0Fourier, termsFourier, xMinFourier, xMaxFourier;
	@FXML
	public LineChart<Double,Double> chartFourier;
	@FXML
	public ImageView imageFourier;

	public void clickPlotFourier(ActionEvent event){
		try{
			System.out.println("plot button clicked");
			FourierSeriesChart fourier = new FourierSeriesChart(lFourier.getText(),xMinFourier.getText(),xMaxFourier.getText(),a0Fourier.getText(),termsFourier.getText(),axFourier.getText(),bxFourier.getText());
			ArrayList<PlotPoint> plotPoints = new ArrayList<PlotPoint>();
			plotPoints = fourier.getPlotPoints();

			chartFourier.getData().clear();
			XYChart.Series<Double,Double> series = new XYChart.Series<Double,Double>();

			for(PlotPoint plotPoint: plotPoints){
				series.getData().add(new XYChart.Data<Double,Double>(plotPoint.getX(),plotPoint.getY()));				
			}

			XYChart.Series<Double,Double> series1 = new XYChart.Series<Double,Double>();
			if(f1Fourier.getText().length()>0){
				FourierFunctionChart fourier1 = new FourierFunctionChart(x1Fourier.getText(),x2Fourier.getText(),f1Fourier.getText());
				plotPoints = fourier1.getPlotPoints();
				for(PlotPoint plotPoint: plotPoints){
					series1.getData().add(new XYChart.Data<Double,Double>(plotPoint.getX(),plotPoint.getY()));				
				}
			}
			XYChart.Series<Double,Double> series2 = new XYChart.Series<Double,Double>();
			if(f2Fourier.getText().length()>0){
				FourierFunctionChart fourier2 = new FourierFunctionChart(x3Fourier.getText(),x4Fourier.getText(),f2Fourier.getText());
				plotPoints = fourier2.getPlotPoints();
				for(PlotPoint plotPoint: plotPoints){
					series2.getData().add(new XYChart.Data<Double,Double>(plotPoint.getX(),plotPoint.getY()));				
				}
			}
			XYChart.Series<Double,Double> series3 = new XYChart.Series<Double,Double>();
			if(f3Fourier.getText().length()>0){
				FourierFunctionChart fourier3 = new FourierFunctionChart(x5Fourier.getText(),x6Fourier.getText(),f3Fourier.getText());
				plotPoints = fourier3.getPlotPoints();
				for(PlotPoint plotPoint: plotPoints){
					series3.getData().add(new XYChart.Data<Double,Double>(plotPoint.getX(),plotPoint.getY()));				
				}
			}

			chartFourier.setCreateSymbols(false); 
			chartFourier.getData().addAll(series,series1,series2,series3);

		}catch(Exception e) {
			e.printStackTrace();
		}
	} // end clickplot

	public void clickResetFourier1(ActionEvent event){
		try{
			System.out.println("reset button clicked");
			x1Fourier.setText("-3");
			x2Fourier.setText("-1");
			x3Fourier.setText("-1");
			x4Fourier.setText("1");
			x5Fourier.setText("1");
			x6Fourier.setText("3");
			f1Fourier.setText("2");
			f2Fourier.setText("0");
			f3Fourier.setText("-2");
			axFourier.setText("0");
			bxFourier.setText("4/(k*p)*(cos(k*p)-cos(k*p/3))");
			lFourier.setText("3");
			a0Fourier.setText("0");
			termsFourier.setText("10");
			xMinFourier.setText("-9");
			xMaxFourier.setText("9");	
			chartFourier.getData().clear();

			File file = new File("fourier.png");
			Image image = new Image(file.toURI().toString());
			imageFourier.setImage(image);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void clickResetFourier2(ActionEvent event){
		try{
			System.out.println("reset button clicked");
			x1Fourier.setText("-2");
			x2Fourier.setText("0");
			x3Fourier.setText("0");
			x4Fourier.setText("2");
			x5Fourier.setText("0");
			x6Fourier.setText("0");
			f1Fourier.setText("2+3x");
			f2Fourier.setText("-2+3x");
			f3Fourier.setText("0");
			axFourier.setText("0");
			bxFourier.setText("4/(k*p)*(3/(k*p)*sin(k*p)-2*cos(k*p)-1)");
			lFourier.setText("2");
			a0Fourier.setText("0");
			termsFourier.setText("10");
			xMinFourier.setText("-8");
			xMaxFourier.setText("8");	
			chartFourier.getData().clear();

			File file = new File("fourier.png");
			Image image = new Image(file.toURI().toString());
			imageFourier.setImage(image);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	public void clickResetFourier3(ActionEvent event){
		try{
			System.out.println("reset button clicked");
			x1Fourier.setText("-2");
			x2Fourier.setText("-1");
			x3Fourier.setText("-1");
			x4Fourier.setText("1");
			x5Fourier.setText("1");
			x6Fourier.setText("2");
			f1Fourier.setText("0");
			f2Fourier.setText("1");
			f3Fourier.setText("0");
			axFourier.setText("2/(k*p)*sin(k*p/2)");
			bxFourier.setText("0");
			lFourier.setText("2");
			a0Fourier.setText("1");
			termsFourier.setText("10");
			xMinFourier.setText("-10");
			xMaxFourier.setText("10");	
			chartFourier.getData().clear();

			File file = new File("fourier.png");
			Image image = new Image(file.toURI().toString());
			imageFourier.setImage(image);

		}catch(Exception e) {
			e.printStackTrace();
		}
	} // end clickreset


	// ********************extra code ended here

	@FXML
	public Button popUpJFrame;

	public void popJFrame(ActionEvent event) { //Put All JFrame Work inside this method
		try {

			JFrame frame = new JFrame(); 
			frame.setSize(400,400);
			frame.setVisible(true);

			/*			JPanel panel = new JPanel();
			Label label = new Label();
			JButton jbttn = new JButton("Hello");


			label.setText("Hello");*/

			JPanel matrixPanel = new MatrixPanel();
			frame.add(matrixPanel);

			//panel.add(jbttn);
			//frame.add(panel);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/***	 
	 * Tab 7 - History
	 */

	@FXML
	ListView<HistoricalEquation> historyList;
	@FXML
	ObservableList<HistoricalEquation> history = FXCollections.observableArrayList();

	private void setUpHistory() {
		ArrayList<HistoricalEquation> he = historyDao.getEquations();
		for (HistoricalEquation historicalEquation : he) {
			history.add(historicalEquation);
		}
		historyList.setItems(history);

	}
}
