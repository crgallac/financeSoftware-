package view;
import controller.ExpenseData;
import controller.Expense;

import java.awt.EventQueue;
import java.awt.Label;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.Arrays;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.awt.event.*;


public class MainWindow implements Observer {
	private DefaultTableModel model;
	private ExpenseData list=new ExpenseData();
	private JTable table;
	private JFrame ExpenseList = new JFrame ("Expense Tracker");
	private JTextField expenseNameField;
	private JTextField priceField;
	private String expenseName;
	private double amount;
	private String type;
	private boolean paid;
	// *this part is to check errors from user input
	private boolean isExpenseNameEmpty;
	private boolean isAmountEmpty;
	private boolean isAmountNotDouble;
	private boolean isDataValid;
	//*
	/**
	 * Launch the application.
	 */
	public static void createMainWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.ExpenseList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ExpenseList = new JFrame();
		ExpenseList.setBounds(100, 100, 800, 600);
		ExpenseList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExpenseList.getContentPane().setLayout(null);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(10, 520, 120, 30);
		ExpenseList.getContentPane().add(btnAddItem);

		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(140, 520, 120, 30);
		ExpenseList.getContentPane().add(btnDeleteItem);

		JButton btnEditItem = new JButton("Make Edit");
		btnEditItem.setBounds(270, 520, 120, 30);
		ExpenseList.getContentPane().add(btnEditItem);

		JButton btnMarkPaid = new JButton("Make as Paid");
		btnMarkPaid.setBounds(400, 520, 120, 30);
		ExpenseList.getContentPane().add(btnMarkPaid);


		this.expenseNameField = new JTextField();
		this.expenseNameField.setBounds(141, 47, 130, 26);
		ExpenseList.getContentPane().add(expenseNameField);
		this.expenseNameField.setColumns(10);

		this.priceField = new JTextField();
		this.priceField.setBounds(141, 85, 130, 26);
		ExpenseList.getContentPane().add(priceField);
		this.priceField.setColumns(10);

		JLabel lblExpenseName = new JLabel("Expense Name");
		lblExpenseName.setBounds(20, 52, 93, 16);
		ExpenseList.getContentPane().add(lblExpenseName);
		//lblExpenseName.addActionListener(new ActionListener(){
		//	public void action event
		//}
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(20, 90, 61, 16);
		ExpenseList.getContentPane().add(lblAmount);

		String[] categories = {"Purchase", "Bill"};

		JComboBox comboBox = new JComboBox(categories);
		comboBox.setBounds(141, 120, 130, 27);
		ExpenseList.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(20, 124, 61, 16);
		ExpenseList.getContentPane().add(lblNewLabel);

		JCheckBox chckbxExpensePaid = new JCheckBox("Expense Paid");
		chckbxExpensePaid.setBounds(89, 160, 128, 23);
		ExpenseList.getContentPane().add(chckbxExpensePaid);

		String data[][]={};
		String columnNames[]={"Name", "Price", "Type","Paid"};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable( model );
		//JScrollPane scrollPane = new JScrollPane( table ); 
		//ExpenseList.add( scrollPane );
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(300,50,400,400);
		ExpenseList.getContentPane().add(table);

		//listener
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent add) {
				readExpenseName();
				readAmount();
				type = (String) (comboBox.getSelectedItem());
				validationChecks();
				paid = chckbxExpensePaid.isSelected();
				//System.out.println(expenseName+amount+type+paid);//debug:checking user input data in console
				if (isDataValid == true) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[]{expenseName, amount,type,paid});
				}
			}
		});
		
		
//		btnEditItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent edit) {
//				readExpenseName();
//				readAmount();
//				type = (String) (comboBox.getSelectedItem());
//				validationChecks();
//				paid = chckbxExpensePaid.isSelected();
//				System.out.println(expenseName+amount+type+paid);//debug:checking user input data in console
//				int rowToEdit = table.getSelectedRow();
//				if(rowToEdit <0){
//					JOptionPane.showMessageDialog(null, "No file is selected!");
//				}
//				else if(isDataValid == true) {
//					DefaultTableModel model = (DefaultTableModel) table.getModel();
//					model.setValueat(new Object[]{expenseName, amount, paid}, )
//				
//				}
//			}
//		});
		


		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent del) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowToDel = table.getSelectedRow();
				if(rowToDel<0){
					JOptionPane.showMessageDialog(null, "No file is selected!");
				}
				else {
					model.removeRow(rowToDel);
				}
			}
		});

	}




	//@Override
	//public void update(Observable arg0, Object arg1) {
		// TODO HERE LAURA NEEDS TO UPDATE WHAT IS DISPLAYED INSIDE THE LIST
		

	private void validationChecks() {
		this.isDataValid = false;
		String warningMessage = new String("");
		if (isExpenseNameEmpty == true) {
			warningMessage = warningMessage + "Name can not be emptyp!\n";
		}
		if (isAmountEmpty == true) {
			warningMessage = warningMessage + "Price can not be emptyp!\n";
		}
		if (isAmountNotDouble == true) {
			warningMessage = warningMessage + "Price must be numbers!\n";
		}
		if (isExpenseNameEmpty || isAmountEmpty || isAmountNotDouble) {
			JOptionPane.showMessageDialog(null, warningMessage);
		} else {
			this.isDataValid = true;
		}
	}
	private void readExpenseName(){
		if(expenseNameField.getText().length()==0){
			isExpenseNameEmpty=true;
		}
		else {
			isExpenseNameEmpty=false;
			expenseName=expenseNameField.getText();
		}
	}

	private void readAmount(){
		//if string is empty
		if(priceField.getText().length()==0){
			isAmountEmpty=true;
		}
		//if string is not double
		else if (!isNumeric(priceField.getText())){
			isAmountNotDouble=true;
		}
		//if neither, assign it to amount
		else {
			isAmountEmpty=false;
			isAmountNotDouble=false;
			amount=Double.parseDouble(priceField.getText());
		}
	}



	private boolean isNumeric(String strNum) {
		return strNum.matches("-?\\d+(\\.\\d+)?");

	}
	
//	public boolean isCellEditable(int row, int col) {
//    if (col < 2) {
//        return false;
//    } else {
//        return true;
//    }
//}

}

