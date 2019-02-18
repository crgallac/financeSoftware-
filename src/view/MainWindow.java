package view;




import java.awt.EventQueue;
import java.awt.Label;
import javax.swing.table.DefaultTableModel;

import controller.AppController;
import model.ExpenseType;

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

	private  AppController appController; 
	private DefaultTableModel model;
	private JTable table;
	private JFrame ExpenseListFrame = new JFrame ("Expense Tracker");
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
	
	/*
	 * Launch the application.
	 * @param window the view associated with a given controller
	 */
	public void createMainWindow(MainWindow window) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.ExpenseListFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application view
	 * @param appController the controller module for the MVC
	 */
	public MainWindow(AppController appController) {
		this.appController = appController; 
		initialize();
	}

	/*
	 * Initialize the contents of the Jframe for the view.
	 */
	private void initialize() {

		ExpenseListFrame = new JFrame();
		ExpenseListFrame.setBounds(100, 100, 800, 600);
		ExpenseListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExpenseListFrame.getContentPane().setLayout(null);
		

		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(10, 520, 120, 30);

		ExpenseListFrame.getContentPane().add(btnAddItem);

		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(140, 520, 120, 30);
		ExpenseListFrame.getContentPane().add(btnDeleteItem);

		
		JButton btnEditItem = new JButton("Make Edit");
		btnEditItem.setBounds(270, 520, 120, 30);
		ExpenseListFrame.getContentPane().add(btnEditItem);

		
		JButton btnMarkPaid = new JButton("Make as Paid");
		btnMarkPaid.setBounds(400, 520, 120, 30);
		ExpenseListFrame.getContentPane().add(btnMarkPaid);


		this.expenseNameField = new JTextField();
		this.expenseNameField.setBounds(141, 47, 130, 26);
		ExpenseListFrame.getContentPane().add(expenseNameField);
		this.expenseNameField.setColumns(10);

	
		this.priceField = new JTextField();
		this.priceField.setBounds(141, 85, 130, 26);
		ExpenseListFrame.getContentPane().add(priceField);
		this.priceField.setColumns(10);
		
	
		JLabel lblExpenseName = new JLabel("Expense Name");
		lblExpenseName.setBounds(20, 52, 93, 16);
		ExpenseListFrame.getContentPane().add(lblExpenseName);
		
		
	
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(20, 90, 61, 16);
		ExpenseListFrame.getContentPane().add(lblAmount);

	
		String[] categories = {"Purchase", "Bill"};
		JComboBox comboBox = new JComboBox(categories);
		comboBox.setBounds(141, 120, 130, 27);
		ExpenseListFrame.getContentPane().add(comboBox);

	
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(20, 124, 61, 16);
		ExpenseListFrame.getContentPane().add(lblNewLabel);

	
		JCheckBox chckbxExpensePaid = new JCheckBox("Expense Paid");
		chckbxExpensePaid.setBounds(89, 160, 128, 23);
		ExpenseListFrame.getContentPane().add(chckbxExpensePaid);

	
		String data[][]={};
		String columnNames[]={"Name", "Price", "Type", "Paid"};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		JTable table = new JTable( model );
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(300,50,400,400);
		ExpenseListFrame.getContentPane().add(table);
		
		table.setPreferredScrollableViewportSize(new Dimension(450,63));
        table.setFillsViewportHeight(true);
        
        //Column labels
        JLabel lblExpense = new JLabel("Expense");
        lblExpense.setBounds(300, 32, 61, 16);
        ExpenseListFrame.getContentPane().add(lblExpense);
        
        JLabel lblAmount_1 = new JLabel("Amount");
        lblAmount_1.setBounds(400, 32, 61, 16);
        ExpenseListFrame.getContentPane().add(lblAmount_1);
        
        JLabel lblCategory = new JLabel("Category");
        lblCategory.setBounds(507, 32, 61, 16);
        ExpenseListFrame.getContentPane().add(lblCategory);
        
        JLabel lblPaid = new JLabel("Paid?");
        lblPaid.setBounds(619, 32, 61, 16);
        ExpenseListFrame.getContentPane().add(lblPaid);
       
		
		
	

		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent add) {
				readExpenseName();
				readAmount();
				type = (String) (comboBox.getSelectedItem());
				validationChecks();
				paid = chckbxExpensePaid.isSelected();
				//System.out.println(expenseName+amount+type+paid);//debug:checking user input data in console
		
				
				if (isDataValid == true) {
					
					appController.add(expenseName, amount, ExpenseType.StringToType(type), paid);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[]{expenseName, amount,type,paid});
					
				}
			}
		});

	
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent del) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowToDel=table.getSelectedRow();
				if(rowToDel<0){
					JOptionPane.showMessageDialog(null, "No file is selected!");
				}
				else {
					appController.delete(rowToDel);
					model.removeRow(rowToDel);
				}
			}
		});
	
		btnEditItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent edit) {
				readExpenseName();
				readAmount();
				type = (String) (comboBox.getSelectedItem());
				validationChecks();
				paid = chckbxExpensePaid.isSelected();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowToEdit=table.getSelectedRow();
				if(rowToEdit<0){
					JOptionPane.showMessageDialog(null, "No file is selected!");
				}
				else if(isDataValid == true){
					appController.edit(rowToEdit, expenseName, amount, ExpenseType.StringToType(type), paid);
					
					model.removeRow(rowToEdit);
					model.insertRow(rowToEdit,  new Object[]{appController.getExpenseList().getByRow(rowToEdit).getExpenseName(), appController.getExpenseList().getByRow(rowToEdit).getAmount(),ExpenseType.TypeToString(appController.getExpenseList().getByRow(rowToEdit).getExpenseType()),appController.getExpenseList().getByRow(rowToEdit).getPaymentStatus()});

				}
			}
		});

		
		
		btnMarkPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pay) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowToEdit=table.getSelectedRow();
				if(rowToEdit<0){
					JOptionPane.showMessageDialog(null, "No file is selected!");
				}
				else if(isDataValid == true){
					
					if(!(appController.getExpenseList().getByRow(rowToEdit).getPaymentStatus())){
					appController.markPaid(rowToEdit);
					}else {
					appController.unMarkPaid(rowToEdit);	
					}
					
					model.removeRow(rowToEdit);
//				
					model.insertRow(rowToEdit, new Object[]{appController.getExpenseList().getByRow(rowToEdit).getExpenseName(), appController.getExpenseList().getByRow(rowToEdit).getAmount(),ExpenseType.TypeToString(appController.getExpenseList().getByRow(rowToEdit).getExpenseType()),appController.getExpenseList().getByRow(rowToEdit).getPaymentStatus()});


				}
			}
		});

	}



	/*
	 * @param updates content of Jtable implemented from Observer interface
	 * @param arg0 the object being observed by this observer
	 * @param arg1 ???
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO HERE LAURA NEEDS TO UPDATE WHAT IS DISPLAYED INSIDE THE LIST

		
		SwingUtilities.updateComponentTreeUI(ExpenseListFrame);
		
		ExpenseListFrame.invalidate();
		ExpenseListFrame.validate();
		ExpenseListFrame.repaint();
		
		
		appController.getExpenseList().printList(); 
		
		

	}



	/*
	 * make sure data entered is valid 
	 * 
	 */
	private void validationChecks() {
		this.isDataValid = false;
		String warningMessage = new String("");
		if (isExpenseNameEmpty == true) {
			warningMessage = warningMessage + "Please enter a name\n";
		}
		if (isAmountEmpty == true) {
			warningMessage = warningMessage + "Please enter a price\n";
		}
		if (isAmountNotDouble == true) {
			warningMessage = warningMessage + "Please ensure that the price field is a number\n";
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

	/*
	 * readAmount
	 * 
	 */
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


	/*
	 * Validates whether the string is numeric
	 * @param strNum the string to check if it is a number
	 * 
	 */
	private boolean isNumeric(String strNum) {
		return strNum.matches("-?\\d+(\\.\\d+)?");

	}
}



