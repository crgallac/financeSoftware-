package view;



import java.awt.EventQueue;

import controller.AppController;
import model.ExpenseType;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;


/**
 * The view class for the MVC model. This displays the graphical user interface and handles inputs to the game controller. 
 * @version     1
 * @since       1          
 */
public class MainWindow implements Observer {

	private  AppController appController; 
	private Table model;
	private SubTable subModel;
	private JTable table;
	private JTable subTable;
	private int mainTableSelection=0;
	private int rowInEditing=-1;
	private boolean isCompsite=false;
	private JScrollPane scrollPane;
	private JScrollPane subScrollPane;
	private JFrame ExpenseListFrame = new JFrame ("Expense Tracker");
	private JTextField fileNameField; 
	private JTextField expenseNameField;
	private JTextField priceField;
	private String fileName; 
	private String expenseName;
	private double amount;
	private String type;
	private boolean paid;
	// *this part is to check errors from user input
	private boolean isFileNameEmpty;
	private boolean isExpenseNameEmpty;
	private boolean isAmountEmpty;
	private boolean isAmountNotDouble;
	private boolean isDataValid;
	private JComboBox comboBox;
	private Button btnOpenItem;
	private Button btnBack;
	private TableColumn colPaidMain;
	private TableColumn colPaidSub;

	String[] mainCategories = {"Purchase", "Bill", "Compound"};
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

		JCheckBox hidePaid = new JCheckBox("Hide/Unhide Paid");
		hidePaid.setBounds(625, 20, 128, 23);
		ExpenseListFrame.getContentPane().add(hidePaid);
		hidePaid.setSelected(true);

		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(10, 520, 120, 30);
		ExpenseListFrame.getContentPane().add(btnAddItem);

		JButton btnOpenItem = new JButton("Open Item");
		btnOpenItem.setBounds(10, 470, 120, 30);
		ExpenseListFrame.getContentPane().add(btnOpenItem);
		btnOpenItem.setVisible(false);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(140, 470, 120, 30);
		ExpenseListFrame.getContentPane().add(btnBack);
		btnBack.setVisible(false);

		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(140, 520, 120, 30);
		ExpenseListFrame.getContentPane().add(btnDeleteItem);

		
		JButton btnEditItem = new JButton("Make Edit");
		btnEditItem.setBounds(270, 520, 120, 30);
		ExpenseListFrame.getContentPane().add(btnEditItem);

		
		JButton btnMarkPaid = new JButton("Mark as Paid");
		btnMarkPaid.setBounds(400, 520, 120, 30);
		ExpenseListFrame.getContentPane().add(btnMarkPaid);
		
		
		this.fileNameField = new JTextField();
		this.fileNameField.setBounds(570, 525, 210, 26);
		ExpenseListFrame.getContentPane().add(fileNameField);
		this.fileNameField.setColumns(10);

		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(660, 455, 120, 30);
		ExpenseListFrame.getContentPane().add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(660, 490, 120, 30);
		ExpenseListFrame.getContentPane().add(btnLoad);
		
		

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



		comboBox = new JComboBox(mainCategories);
		comboBox.setBounds(141, 120, 130, 27);
		ExpenseListFrame.add(this.comboBox);

	
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(20, 124, 61, 16);
		ExpenseListFrame.getContentPane().add(lblNewLabel);

	
		JCheckBox chckbxExpensePaid = new JCheckBox("Expense Paid");
		chckbxExpensePaid.setBounds(89, 160, 128, 23);
		ExpenseListFrame.getContentPane().add(chckbxExpensePaid);

		//Table
        model = new Table(appController);
		table = new JTable( model );

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(300,50,400,400);

		scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300,50,400,400);
		ExpenseListFrame.add(scrollPane);

		table.setPreferredScrollableViewportSize(new Dimension(450,63));
        table.setFillsViewportHeight(true);

        //Sub Table
		subModel = new SubTable(appController,-1);
		subTable = new JTable( subModel );

		subTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		subTable.setBounds(300,50,400,400);

		subScrollPane = new JScrollPane(subTable);
		subScrollPane.setBounds(300,50,400,400);
		ExpenseListFrame.add(subScrollPane);

		subTable.setPreferredScrollableViewportSize(new Dimension(450,63));
		subTable.setFillsViewportHeight(true);
		subScrollPane.setVisible(false);
        //Column labels
        JLabel lblExpense = new JLabel("General Expense");
        lblExpense.setBounds(300, 32, 200, 16);
        ExpenseListFrame.getContentPane().add(lblExpense);

		hidePaid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JCheckBox hidePaid = (JCheckBox) event.getSource();
				if (hidePaid.isSelected()) {
					table.addColumn(colPaidMain);
					subTable.addColumn(colPaidSub);
				} else {
					colPaidMain= table.getColumnModel().getColumn(3);
					colPaidSub= subTable.getColumnModel().getColumn(3);
					subTable.removeColumn(colPaidSub);
					table.removeColumn(colPaidMain);
				}
			}
		});


		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e){
				if(table.getSelectedRow()> -1){
					mainTableSelection=table.getSelectedRow();
					//System.out.println(mainTableSelection);
					String type=(model.getValueAt(mainTableSelection,2)).toString();
					switch(type) {
						case "COMPOSITE":{
							isCompsite=true;
							break;
						}
						default:isCompsite=false;
					}
					btnOpenItem.setVisible(isCompsite);
					btnEditItem.setVisible(!isCompsite);
				}
			}
		});


		btnOpenItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent open) {
				switchToComposite(mainTableSelection);
				lblExpense.setText("Sub Expense");
				btnOpenItem.setVisible(false);
				btnBack.setVisible(true);
				btnEditItem.setVisible(true);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent back) {
				switchToMain();
				lblExpense.setText("General Expense");
				btnBack.setVisible(false);
				
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent save) {
				readFileName();
				validationChecks();
				
				if(isDataValid) {
//				appController.getExpenseList().save(fileName);
				
				appController.connectToDataBase(); 
				appController.push(fileName); 
				appController.disconnectFromDataBase(); 
				
//				System.out.println("saved");
				}
			}
		});
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent load) {
				readFileName();
				validationChecks();
		
				if(isDataValid) {
					appController.connectToDataBase(); 
					appController.pull(fileName); 
					appController.disconnectFromDataBase(); 
					
//					getExpenseList().read(fileName);
					
//					System.out.println("saved");
					model.update(appController);
					}
			}
		});

		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent add) {
				readExpenseName();
				readAmount();
				type = (String) (comboBox.getSelectedItem());
				validationChecks();
				paid = chckbxExpensePaid.isSelected();
				//System.out.println(rowInEditing);//debug:checking user input data in console

				if (isDataValid == true) {
					switch(rowInEditing){
						case -1:{//in main table
							switch(type) {
								case "Compound":{
									appController.addComposite(expenseName);
									break;
								}
								default:appController.add(expenseName, amount, ExpenseType.StringToType(type), paid);
							}
							model.update(appController);
						}
						break;
						default://in sub table
						{
							appController.addSub(rowInEditing,expenseName, amount, ExpenseType.StringToType(type), paid);
							subModel.update(appController,rowInEditing);
						}
					}


					
				}
			}
		});

	
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent del) {
				int rowToDel;
				switch (rowInEditing){
					case -1:{
						rowToDel=table.getSelectedRow();
						if(rowToDel<0){
							JOptionPane.showMessageDialog(null, "No file is selected!");
						}
						else {
							appController.delete(rowToDel);
							model.update(appController);
						}
						break;
					}
					default:{
						rowToDel=subTable.getSelectedRow();
						if(rowToDel<0){
							JOptionPane.showMessageDialog(null, "No file is selected!");
						}
						else {
							appController.deleteSub(rowToDel,rowInEditing);
							subModel.update(appController,rowInEditing);
						}
					}
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
				int rowToEdit;
				switch (rowInEditing){
					case -1:{
						rowToEdit=table.getSelectedRow();
						if(rowToEdit<0){
							JOptionPane.showMessageDialog(null, "No file is selected!");
						}
						else if(isDataValid == true){
							appController.edit(rowToEdit, expenseName, amount, ExpenseType.StringToType(type), paid);

							model.update(appController);
						}
						break;
					}
					default:{
						rowToEdit=subTable.getSelectedRow();
						if(rowToEdit<0){
							JOptionPane.showMessageDialog(null, "No file is selected!");
						}
						else if(isDataValid == true){
							appController.editSub(rowToEdit,rowInEditing, expenseName, amount, ExpenseType.StringToType(type), paid);
							subModel.update(appController,rowInEditing);
						}
					}
				}

			}
		});
		
		btnMarkPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pay) {
				int rowToEdit;
					switch (rowInEditing){
						case -1:{
							rowToEdit=table.getSelectedRow();
							if(rowToEdit<0){
								JOptionPane.showMessageDialog(null, "No file is selected!");
							}
							else if(isDataValid == true) {
								if (!(appController.getExpenseList().getByRow(rowToEdit).getPaymentStatus())) {
									appController.markPaid(rowToEdit,true);
								} else {
									appController.markPaid(rowToEdit,false);
								}
								model.update(appController);
								break;
							}
						}
						default:{
							rowToEdit=subTable.getSelectedRow();
							if(rowToEdit<0){
								JOptionPane.showMessageDialog(null, "No file is selected!");
							}
							else if(isDataValid == true) {
								if (!appController.getExpenseList().getByRow(rowInEditing).toCompositeExpenses().getByRow(rowToEdit).getPaymentStatus()){
									appController.markPaidSub(rowInEditing,rowToEdit,true);
								} else {
									appController.markPaidSub(rowInEditing,rowToEdit,false);
								}
								subModel.update(appController,rowInEditing);
							}
						}
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
		
		
		
//		System.out.println("here"); 

		
//		appController.getExpenseList().printList();
//		appController.getExpenseList().save("");
		
		

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
		if (isFileNameEmpty == true) {
			warningMessage = warningMessage + "Please ensure that the file field is correct\n";
		}
		if (isExpenseNameEmpty || isAmountEmpty || isAmountNotDouble || isFileNameEmpty) {
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
	 * readAmount
	 * 
	 */
	private void readFileName(){
		
		if(fileNameField.getText().length()==0){
			isFileNameEmpty=true;
		}
		else {
			isFileNameEmpty=false;
			fileName=fileNameField.getText();
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

	private void switchToComposite(int rowID){
		comboBox.removeItem("Compound");
		subScrollPane.setVisible(true);
		scrollPane.setVisible(false);
		subModel.update(appController,rowID);
		rowInEditing=rowID;


	}
	private void switchToMain(){
		comboBox.addItem("Compound");

		subScrollPane.setVisible(false);
		scrollPane.setVisible(true);
		model.update(appController);
		rowInEditing=-1;
   	}
}



