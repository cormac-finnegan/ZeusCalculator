package com.ait.calc.model;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Queue;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




public class MatrixPanel extends JPanel implements ActionListener{
	
	//private JLabel information;
	private JTextField information2;
	private JPanel panel1, panel2, panel3, panelOperator, panelEqual,panelRow1,panelRow2,panelRow3,panelRow4;
	private Border lineBorder;
	private static JTextField[][] tfArray1;
	private static JTextField[][] tfArray2;
	private JTextField[][] tfArray3;
	private JTextField tfInput;	
	private JComboBox operatorBox = new JComboBox();
	private JComboBox rgbBox, rowBox, columnBox;
	private JButton equal,equal2,reset,haarButton,dctButton,bmpButton;
	private int clickCount=0;
	private double[][] inputArray={{230,127,127,200,200,127,127,230},{127,230,127,230,230,127,230,127},{127,127,230,230,230,230,127,127},{200,230,230,255,255,230,230,200},
			 					   {200,230,230,255,255,230,230,200},{127,127,230,230,230,230,127,127},{127,230,127,230,230,127,230,127},{230,127,127,200,200,127,127,230}};
	private double[][] inputArray2={{16,8,23,16,5,14,7,22},{20,14,22,7,14,22,24,6},{15,23,24,23,9,6,6,20},{14,8,11,14,12,12,25,10},{10,9,11,9,13,19,5,17},
            						{8,22,20,15,12,8,22,17},{24,22,17,12,18,11,23,14}, {21,25,15,16,23,14,22,22}};
	private HaarPanel haar; 
	private DctAndIdctPanel dct;
	public static JSlider qSlider;
	private JLabel quantizationLabel;
	
	public MatrixPanel(){	
		
		lineBorder = BorderFactory.createEtchedBorder(15, Color.red, Color.black);
		
		panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createTitledBorder(lineBorder, "1st Matrix"));
		panel1.setLayout(new GridLayout(8,8));
		tfArray1 = new JTextField[8][8];
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				tfArray1[i][j] = new JTextField(3);
				tfArray1[i][j].setBackground(Color.LIGHT_GRAY);
				panel1.add(tfArray1[i][j]);				
			}			
		}
		
		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createTitledBorder(lineBorder, "2st Matrix"));
		panel2.setLayout(new GridLayout(8,8));
		tfArray2 = new JTextField[8][8];
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				tfArray2[i][j] = new JTextField(3);
				tfArray2[i][j].setBackground(Color.LIGHT_GRAY);
				panel2.add(tfArray2[i][j]);				
			}			
		}
		
		panel3 = new JPanel();
		panel3.setBorder(BorderFactory.createTitledBorder(lineBorder, "Result Matrix"));
		panel3.setLayout(new GridLayout(8,8));
		tfArray3 = new JTextField[8][8];
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				tfArray3[i][j] = new JTextField(3);
				tfArray3[i][j].setBackground(Color.LIGHT_GRAY);
				tfArray3[i][j].setEditable(false);
				panel3.add(tfArray3[i][j]);				
			}			
		}
		
	    operatorBox.addItem("+");
	    operatorBox.addItem("-");
	    operatorBox.addItem("*");
	    operatorBox.addItem("^");
	    operatorBox.addItem("v");
	    operatorBox.addItem("O");
	    operatorBox.addItem("T");
	    operatorBox.setFont(new Font("Courier", Font.BOLD,14));
	    panelOperator = new JPanel();
	    panelOperator.add(operatorBox);
	    
	    equal = new JButton("=");
	    equal.addActionListener(this);
	    panelEqual = new JPanel();
	    panelEqual.add(equal);	    
				
		panelRow1 = new JPanel();
		panelRow1.add(panel1);
		panelRow1.add(panelOperator);
		panelRow1.add(panel2);
		panelRow1.add(panelEqual);
		panelRow1.add(panel3);		
		
		tfInput = new JTextField(88);
		equal2 = new JButton("Equal");
		equal2.addActionListener(this);
		panelRow2 = new JPanel();
		panelRow2.add(tfInput);
		panelRow2.add(equal2);
		
		//information = new JLabel(" ");
		information2 = new JTextField(25);
		information2.setOpaque(false);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		haarButton = new JButton("Haar");
		haarButton.addActionListener(this);
		dctButton = new JButton("DCT");
		dctButton.addActionListener(this);
		qSlider = new JSlider(1,99,50);
		ListenForSlider lForSlider = new ListenForSlider();
		qSlider.addChangeListener(lForSlider);
		quantizationLabel = new JLabel("Quantization:50");
		haar = new HaarPanel(inputArray);
		dct = new DctAndIdctPanel(inputArray2,qSlider.getValue());
		bmpButton = new JButton("ImageDCT");
		bmpButton.addActionListener(this);
		rgbBox = new JComboBox(new String[]{"Red","Green","Blue"});
		rowBox = new JComboBox(new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19});
		columnBox = new JComboBox(new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19});		
		
		panelRow3 = new JPanel();
		panelRow3.add(rowBox);
		panelRow3.add(columnBox);
		panelRow3.add(rgbBox);
		panelRow3.add(bmpButton);
		panelRow3.add(quantizationLabel);
		panelRow3.add(qSlider);
		
		panelRow3.add(dctButton);
		panelRow3.add(haarButton);
		panelRow3.add(reset);
		
		panelRow4 = new JPanel();
		panelRow4.add(information2);
		
		this.add(panelRow1);
		this.add(panelRow2);
		this.add(panelRow3);
		this.add(panelRow4);
				
		
	}//end constructor()
	
	@Override
	public void actionPerformed(ActionEvent e){
		 Object target=e.getSource();
		 //add extra button function
		 if(target == equal){
			 //System.out.println("equal pressed");		
			double[][] resultArray = calculate(convert(tfArray1), convert(tfArray2), (String)operatorBox.getSelectedItem());
			repaint(tfArray3,resultArray);
			
		 }
		 
		 if(target == equal2){
			 //System.out.println("equal2 pressed");
			 convertStringToArray(tfInput);
			 double[][] resultArray = calculate(convert(tfArray1), convert(tfArray2), (String)operatorBox.getSelectedItem());
			 repaint(tfArray3,resultArray);
			 
		 }
		 
		 if(target == reset){
			 //System.out.println("reset pressed");
			 repaint(tfArray1,null);
			 repaint(tfArray2,null);
			 repaint(tfArray3,null);
			 information2.setText(" ");
			 tfInput.setText("");	
			 clickCount=0;
			 	equal.setEnabled(true);
			 	equal2.setEnabled(true);
			 	haarButton.setEnabled(true);
			 	qSlider.setEnabled(true);
			 	dctButton.setEnabled(true);
			 	bmpButton.setEnabled(true);
		 }
		 
		 if(target == bmpButton){
		 		repaint(tfArray1, null);
				repaint(tfArray2, null);
				repaint(tfArray1, null);			 
				BmpPanel.start();
				
				int row = rowBox.getSelectedIndex();
				int column = columnBox.getSelectedIndex();
				String color = (String) rgbBox.getSelectedItem();
								
				repaint(tfArray1, convertToDouble( BmpPanel.returnOriginArray(row, column, color) ));
				repaint(tfArray3, convertToDouble( BmpPanel.returnDecompressedArray(row, column, color) ));
				
		 }
		 
		 if(target == dctButton){
			 switch(clickCount){
			 case 0:
				 	equal.setEnabled(false);
				 	equal2.setEnabled(false);
				 	haarButton.setEnabled(false);
				 	qSlider.setEnabled(false);
				 	bmpButton.setEnabled(false);
			 		repaint(tfArray1, inputArray2);
					repaint(tfArray2, null);
					repaint(tfArray3, null);
					dct= new DctAndIdctPanel(inputArray2, qSlider.getValue());
					clickCount++;
					information2.setText("Start DCT");
					break;
			 	case 1:
			 		repaint(tfArray3, dct.returnT());	
			 		clickCount++;
			 		information2.setText("This is T");
			 		break;
			 	
			 	case 2:
			 		repaint(tfArray3, dct.returnTMT());	
			 		clickCount++;
			 		information2.setText("This is T * M * T', DCT is done.");
			 		break;
			 	case 3:
			 		repaint(tfArray3, dct.returnQ50());	
			 		clickCount++;
			 		information2.setText("This is Q50");
			 		break;
			 	case 4:
			 		repaint(tfArray3, dct.returnQActual());	
			 		clickCount++;
			 		information2.setText("This is Q"+qSlider.getValue());
			 		break;
			 	case 5:
			 		repaint(tfArray3, dct.returnDQ());	
			 		clickCount++;
			 		information2.setText("Quantization Step: c=round(D/Q)");
			 		break;
			 	case 6:
			 		repaint(tfArray3, dct.returnQC());	
			 		clickCount++;
			 		information2.setText("Decompression Starts: R = Q * C");
			 		break;

			 	case 7:
			 	 	equal.setEnabled(true);
				 	equal2.setEnabled(true);
				 	haarButton.setEnabled(true);
				 	qSlider.setEnabled(true);
				 	bmpButton.setEnabled(true);
			 		repaint(tfArray3, dct.returnTRT());	
			 		clickCount=0;
			 		information2.setText("Decompression: T' * R * T, IDCT is done.");
			 		break;
			 					 
			 }
			 
			 
			 
		 }
		 
		 if(target == haarButton){
			 switch(clickCount){
			 	case 0:
			 	 	equal.setEnabled(false);
				 	equal2.setEnabled(false);
				 	dctButton.setEnabled(false);
				 	qSlider.setEnabled(false);
				 	bmpButton.setEnabled(false);
			 		repaint(tfArray1, inputArray);
					repaint(tfArray2, null);
					repaint(tfArray3, null);
					haar = new HaarPanel(inputArray);
					clickCount++;
					information2.setText("Start Haar");
					break;
			 	case 1:
			 		repaint(tfArray3, haar.decomposeColumn1());	
			 		clickCount++;
			 		information2.setText("decompose column 1/5,2/6,3/7,4/8");
			 		break;
			 	case 2:
			 		repaint(tfArray3, haar.decomposeColumn2());	
			 		clickCount++;
			 		information2.setText("decompose column 1/3,2/4");
			 		break;
			 	case 3:
			 		repaint(tfArray3, haar.decomposeColumn3());	
			 		clickCount++;
			 		information2.setText("decompose column 1/2");
			 		break;
			 	case 4:
			 		repaint(tfArray3, haar.decomposeRow1());	
			 		clickCount++;
			 		information2.setText("decompose row 1/5,2/6,3/7,4/8");
			 		break;
			 	case 5:
			 		repaint(tfArray3, haar.decomposeRow2());	
			 		clickCount++;
			 		information2.setText("decompose row 1/3,2/4");
			 		break;
			 	case 6:
			 		repaint(tfArray3, haar.decomposeRow3());	
			 		clickCount++;
			 		information2.setText("decompose row 1/2.Done!");
			 		break;
			 	case 7:
			 		repaint(tfArray3, haar.recomposeColumn1());	
			 		clickCount++;
			 		information2.setText("Start, recompose column 1/2");
			 		break;
			 	case 8:
			 		repaint(tfArray3, haar.recomposeColumn2());	
			 		clickCount++;
			 		information2.setText("recompose column 1/3,2/4");
			 		break;
			 	case 9:
			 		repaint(tfArray3, haar.recomposeColumn3());	
			 		clickCount++;
			 		information2.setText("recompose column 1/5,2/6,3/7,4/8");
			 		break;
			 	case 10:
			 		repaint(tfArray3, haar.recomposeRow1());	
			 		clickCount++;
			 		information2.setText("recompose row 1/2");
			 		break;
			 	case 11:
			 		repaint(tfArray3, haar.recomposeRow2());	
			 		clickCount++;
			 		information2.setText("recompose row 1/3,2/4");
			 		break;
			 	case 12:
			 	 	equal.setEnabled(true);
				 	equal2.setEnabled(true);
				 	dctButton.setEnabled(true);
				 	qSlider.setEnabled(true);
				 	bmpButton.setEnabled(true);
			 		repaint(tfArray3, haar.recomposeRow3());	
			 		clickCount=0;
			 		information2.setText("recompose column 1/5,2/6,3/7,4/8.Done!");
			 		break;	 				 
			 }
			 
			 
		 }
	}//end actionperformed()		 


	public double[][] convert(JTextField[][] jTextField){		
		int row=0,column=8;
		for(int j=0; j<8; j++){
			try{
				Double.parseDouble(jTextField[0][j].getText());
			}catch(Exception e){
				e.printStackTrace();
				column = j;
				break;	
			}
		}
		
		label1:
		for(int i=1; i<8; i++){
			for(int j=0; j<column; j++){
				try{
					Double.parseDouble(jTextField[i][j].getText());
				}catch(Exception e){
					e.printStackTrace();
					row=i;
					break label1;
				}
			}
		}
		
		double valueArray[][] = new double[row][column];
		if(column*row == 0){
			return null;
		}else{
			for(int i=0; i<row; i++){
				for(int j=0; j<column; j++){
					try{
						valueArray[i][j] = Double.parseDouble(jTextField[i][j].getText());
					}catch(Exception e){
						e.printStackTrace();						
					}
				}
			}
			return valueArray;
		}
	
		
	}//end convert()
 
	public static double[][] calculate(double[][] array1, double[][] array2, String operator){
		//repaint(tfArray1,null);
		//repaint(tfArray2,null);
		
		double[][] resultArray = new double[8][8];
		if(array1 == null){
			return null;
		}
		switch(operator){
			case "+":
				if( array1.length==array2.length && array1[0].length==array2[0].length){
					repaint(tfArray1,array1);
					repaint(tfArray2,array2);
					resultArray = new double[array1.length][array1[0].length];
					for(int i=0; i<array1.length; i++){
						for(int j=0; j<array1[0].length; j++){
							resultArray[i][j] = array1[i][j]+array2[i][j];
						}
					}
				}else{
					resultArray = null;
				}
				break;
			case "-":		
				if( array1.length==array2.length && array1[0].length==array2[0].length){
					repaint(tfArray1,array1);
					repaint(tfArray2,array2);
					resultArray = new double[array1.length][array1[0].length];
					for(int i=0; i<array1.length; i++){
						for(int j=0; j<array1[0].length; j++){
							resultArray[i][j] = array1[i][j]-array2[i][j];
						}
					}
				}else{
					resultArray = null;
				}
				break;
			case "*":
				if( array1[0].length==array2.length ){
					repaint(tfArray1,array1);
					repaint(tfArray2,array2);
					resultArray = new double[array1.length][array2[0].length];
					for(int i=0; i<array1.length; i++){
						for(int j=0; j<array2[0].length; j++){
							double sum = 0;
							for(int k=0; k<array2.length; k++){
								sum += array1[i][k]*array2[k][j];
							}							
							resultArray[i][j] = sum;
						}
					}
				}else{
					resultArray = null;
				}
				break;
			case "T":
				repaint(tfArray2,null);
				repaint(tfArray1,array1);
				resultArray = new double[array1[0].length][array1.length];
				for(int i=0; i<array1.length; i++){
					for(int j=0; j<array1[0].length; j++){
						resultArray[j][i] = array1[i][j];
					}
				}
				break;
			case "^":
				if( array1.length==array2.length && array1[0].length==array2[0].length){	
					resultArray = new double[array1.length][array1[0].length];
					for(int i=0; i<array1.length; i++){
						for(int j=0; j<array1[0].length; j++){
							if(array1[i][j]!=0 && array1[i][j]!=1){
								return null;
							}
							if(array2[i][j]!=0 && array2[i][j]!=1){
								return null;
							}
							resultArray[i][j] = array1[i][j]*array2[i][j];
						}
					}
					repaint(tfArray1,array1);
					repaint(tfArray2,array2);
				}else{
					resultArray = null;
				}
				break;
			case "v":
				if( array1.length==array2.length && array1[0].length==array2[0].length){	
					resultArray = new double[array1.length][array1[0].length];
					for(int i=0; i<array1.length; i++){
						for(int j=0; j<array1[0].length; j++){
							if(array1[i][j]!=0 && array1[i][j]!=1){
								return null;
							}
							if(array2[i][j]!=0 && array2[i][j]!=1){
								return null;
							}
							resultArray[i][j] = array1[i][j]+array2[i][j];
							if(resultArray[i][j]>1){
								resultArray[i][j] = 1;
							}
						}
					}
					repaint(tfArray1,array1);
					repaint(tfArray2,array2);
				}else{
					resultArray = null;
				}
				break;
			case "O":
				if( array1[0].length==array2.length ){
					for(int i=0; i<array1.length; i++){
						for(int j=0; j<array1[0].length; j++){
							if(array1[i][j]!=0 && array1[i][j]!=1){
								return null;
							}
						}
					}
					for(int i=0; i<array2.length; i++){
						for(int j=0; j<array2[0].length; j++){
							if(array2[i][j]!=0 && array2[i][j]!=1){
								return null;
							}
						}
					}
					
					resultArray = new double[array1.length][array2[0].length];
					for(int i=0; i<array1.length; i++){
						for(int j=0; j<array2[0].length; j++){
							double sum = 0;
							for(int k=0; k<array2.length; k++){
								sum += array1[i][k]*array2[k][j];
							}							
							if(sum>0){
								resultArray[i][j] = 1;
							}else{
								resultArray[i][j] = 0;
							}
						}
					}
					repaint(tfArray1,array1);
					repaint(tfArray2,array2);
					
					
				}else{
					resultArray = null;
				}
				break;
				
				
		}
		
		
		return resultArray;
	}//end calculate()
	
	public static void repaint(JTextField[][] tfArray,double[][] valueArray){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				tfArray[i][j].setText("");
			}
		}
		
		if(valueArray != null){
			for(int i=0; i<valueArray.length; i++){
				for(int j=0; j<valueArray[0].length; j++){
					if(valueArray[i][j]<1&&valueArray[i][j]>-1){
						String result = String.format("%.2f", valueArray[i][j]);
						tfArray[i][j].setText(result);
					}else{
						tfArray[i][j].setText(Integer.toString((int)valueArray[i][j]));
					}
				}
			}
		}
		
	}//end repaint()
	
	public void convertStringToArray(JTextField textField) {
		String input = textField.getText();
		//Queue charQueue = (Queue) new ArrayList<Character>();
		int operatorCount = 0;
		ArrayList<Character> charList = new ArrayList<>();		
		int row=0, column=0;
		
		for(int i=0; i<input.length(); i++){
			//charQueue.add(input.charAt(i));
			char currentChar = input.charAt(i);
			switch(currentChar){
				case '[':
					charList.clear();
					break;
				case ' ':
					charList.clear();
					break;
				case ',':
					charList.clear();
					column +=1;;
					break;
				case ']':
					charList.clear();
					column=0;
					row +=1;
					break;
				case '+':
					operatorCount +=1;
					row=0;
					column=0;
					operatorBox.setSelectedIndex(0);
					break;
				case '-':
					operatorCount +=1;
					row=0;
					column=0;
					operatorBox.setSelectedIndex(1);
					break;
				case '*':
					operatorCount +=1;
					row=0;
					column=0;
					operatorBox.setSelectedIndex(2);
					break;
				case '^':
					operatorCount +=1;
					row=0;
					column=0;
					operatorBox.setSelectedIndex(3);
					break;
				case 'v':
					operatorCount +=1;
					row=0;
					column=0;
					operatorBox.setSelectedIndex(4);
					break;
				case 'T':
					operatorCount +=1;
					row=0;
					column=0;
					operatorBox.setSelectedIndex(5);
					break;
				case 'O':
					operatorCount +=1;
					row=0;
					column=0;
					operatorBox.setSelectedIndex(6);
					break;
				default:
					charList.add(currentChar);			
				
			}
			StringBuilder sb = new StringBuilder();
			for(Character c:charList){
				sb.append(c);
			}
			if(operatorCount==0 && row<8 && column<8 ){
				tfArray1[row][column].setText(sb.toString());
			}else if(operatorCount==1 && row<8 && column<8 ){
				tfArray2[row][column].setText(sb.toString());
			}
			
		}		
		
	}//end convertStringtoArray()
	
	private class ListenForSlider implements ChangeListener{

		// Called when the spinner is changed
			public void stateChanged(ChangeEvent e) {
						
				// Check if the source of the event was the button
						
				if(e.getSource() == qSlider){
					
					// Change the value for the label next to the spinner
							
					quantizationLabel.setText("Quantization:" + qSlider.getValue() );
							
								
				}
						
			}
				
				
				
	}//end of listenforslider class
	
	public double[][] convertToDouble(int[][] intArray){
    	double[][] doubleArray=new double[intArray.length][intArray[0].length];
    	for(int i=0; i<doubleArray.length; i++){
    		for(int j=0; j<doubleArray[0].length; j++){
    			doubleArray[i][j] = (double)intArray[i][j];
    		}
    	}
    	return doubleArray;    	
    }//end of converToDouble()
}//end of class
