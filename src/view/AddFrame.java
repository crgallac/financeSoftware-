package view;

import javax.swing.*;

import controller.Expense;
import controller.ExpenseData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

public class AddFrame {
	
	private JFrame addExp = new JFrame("Add an expense");
	private JTextField textField;
	private JTextField textField_1;
	
	public AddFrame() {
	
		//addExp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addExp.setSize(300,300);
		addExp.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(141, 47, 130, 26);
		addExp.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 85, 130, 26);
		addExp.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblExpenseName = new JLabel("Expense Name");
		lblExpenseName.setBounds(20, 52, 93, 16);
		addExp.getContentPane().add(lblExpenseName);
		//lblExpenseName.addActionListener(new ActionListener(){
		//	public void action event
		//}
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(20, 90, 61, 16);
		addExp.getContentPane().add(lblAmount);
		
		String[] categories = {"Restaurant", "Rent", "Utilities", "Car", "Groceries", "Miscellaneous"};
		
		JComboBox comboBox = new JComboBox(categories);
		comboBox.setBounds(141, 120, 130, 27);
		addExp.getContentPane().add(comboBox);				
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(20, 124, 61, 16);
		addExp.getContentPane().add(lblNewLabel);
		
		JCheckBox chckbxExpensePaid = new JCheckBox("Expense Paid");	
		chckbxExpensePaid.setBounds(89, 160, 128, 23);
		addExp.getContentPane().add(chckbxExpensePaid);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(154, 206, 117, 29);
		addExp.getContentPane().add(btnCancel);
		btnCancel.addActionListener (new ActionListener(){
			
			private void CloseFrame() {
				addExp.dispose();
			}
			public void actionPerformed(ActionEvent cancel) {
			  CloseFrame();
			}

			
		});
		//submit button
		JButton btnSubmit = new JButton("Add Item");
		btnSubmit.setBounds(20, 206, 117, 29);
		addExp.getContentPane().add(btnSubmit);
		addExp.setVisible(true);
		
		//making an arrayList to check functionality of add/delete/edit
		ArrayList<String> expensesTest = new ArrayList<String>();
		
		//takes text from Expense Name text box and prints it out when submit button is pushed
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String expenseName = textField.getText();
				//System.out.println(expenseName);
				expensesTest.add(expenseName);
		
			//checking contents of arrayList
			ListIterator<String> ltr = expensesTest.listIterator();
			   	while(ltr.hasNext()){
			    System.out.println(ltr.next()); 
			};
			
	
		};
		
	});	
}}