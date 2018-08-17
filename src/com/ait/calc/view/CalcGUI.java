package com.ait.calc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.ait.calc.controller.Calculator;

public class CalcGUI {

	private JFrame frame;
	private JTextField displayTextField;
	private JTextField displayAllTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcGUI window = new CalcGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 333, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayTextField.setText(displayTextField.getText()+"7");
			}
		});
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText("");
				displayAllTextField.setText("");
			}
		});
		
		JButton button_8 = new JButton("^");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllTextField.setText(displayAllTextField.getText()+displayTextField.getText()+"^");
				displayTextField.setText("");
			}
		});
		
		JButton button_7 = new JButton("+/-");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(displayTextField.getText().startsWith("-")){
					displayTextField.setText(displayTextField.getText().substring(1));
				}else{
					displayTextField.setText("-"+displayTextField.getText());
				}
			}
		});
		
		JButton button_6 = new JButton("/");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllTextField.setText(displayAllTextField.getText()+displayTextField.getText()+"/");
				displayTextField.setText("");
			}
		});
		
		JButton button = new JButton("8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"8");
			}
		});
		
		JButton btnNewButton_3 = new JButton("9");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"9");
			}
		});
		
		JButton button_5 = new JButton("*");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllTextField.setText(displayAllTextField.getText()+displayTextField.getText()+"*");
				displayTextField.setText("");
			}
		});
		
		JButton btnNewButton_1 = new JButton("4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"4");
			}
		});
		
		JButton btnNewButton_2 = new JButton("5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"5");
			}
		});
		
		JButton btnNewButton_4 = new JButton("6");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"6");
			}
		});
		
		JButton button_4 = new JButton("-");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllTextField.setText(displayAllTextField.getText()+displayTextField.getText()+"-");
				displayTextField.setText("");
			}
		});
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"1");
			}
		});
		
		JButton btnNewButton_6 = new JButton("2");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"2");
			}
		});
		
		JButton btnNewButton_7 = new JButton("3");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"3");
			}
		});
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllTextField.setText(displayAllTextField.getText()+displayTextField.getText()+"+");
				displayTextField.setText("");
			}
		});
		
		JButton btnNewButton_8 = new JButton("0");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayTextField.setText(displayTextField.getText()+"0");
			}
		});
		
		JButton button_1 = new JButton(".");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+".");
			}
		});
		
		JButton button_2 = new JButton("=");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllTextField.setText(displayAllTextField.getText()+displayTextField.getText());
				displayTextField.setText(Calculator.calculate(displayAllTextField.getText()));
			}
		});
		
		displayTextField = new JTextField();
		displayTextField.setColumns(10);
		
		JButton button_9 = new JButton("(");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+"(");
			}
		});
		
		JButton btnNewButton_5 = new JButton(")");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTextField.setText(displayTextField.getText()+")");
			}
		});
		
		displayAllTextField = new JTextField();
		displayAllTextField.setEditable(false);
		displayAllTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(displayAllTextField, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnC)
							.addGap(6)
							.addComponent(button_8)
							.addGap(6)
							.addComponent(button_7)
							.addGap(6)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(6)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(6)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btn1)
							.addGap(6)
							.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnNewButton_7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_3))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_8, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_2))
						.addComponent(displayTextField, Alignment.LEADING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_5)
						.addComponent(button_9))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(displayAllTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(displayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnC)
						.addComponent(button_8)
						.addComponent(button_7)
						.addComponent(button_6))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(button)
						.addComponent(btnNewButton_3)
						.addComponent(button_5))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_4)
						.addComponent(button_4))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn1)
						.addComponent(btnNewButton_6)
						.addComponent(btnNewButton_7)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_3)
							.addComponent(button_9)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_8)
						.addComponent(button_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_2)
							.addComponent(btnNewButton_5)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
