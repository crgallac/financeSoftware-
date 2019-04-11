package controller;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.*;
import view.*;



public class AppController{
    private ExpenseList expenseData;
    private ExpenseFactory expenseFactory; 
    private MainWindow view;  

    public AppController() {
    	
    	expenseData = new ExpenseList();
    	expenseFactory = new ExpenseFactory(); 
    	view  = new MainWindow(this);
    	
    	
    	expenseData.addObserver(view);
    	
    }; 
    
    
    public void startApplication() {
        // View the application's GUI
        
        view.createMainWindow(view);
    }
    
 
    //need row index from UI
    public void markPaid(int rowID,boolean paid) {
        Expenses currentExpense = this.expenseData.getByRow(rowID);//get Expense unit from int
        currentExpense.setPaid(paid);//set the Paid boolean of that Expense unit to paid
        this.expenseData.setByRow(rowID, currentExpense);//put it back to the data list
    }
    public void markPaidSub(int rowID,int subRowID,boolean paid) {
        Expenses expense = this.expenseData.getByRow(rowID).toCompositeExpenses().getByRow(subRowID);
        expense.setPaid(paid);
        CompositeExpenses temp=this.expenseData.getByRow(rowID).toCompositeExpenses();
        temp.setByRow(subRowID, expense);
        this.expenseData.setByRow(rowID,temp);
    }



    //for window 2, put all data together to form a unit of expense, then add it to the list
    public void add(String name,double amount,ExpenseType type,boolean paid){
        Expenses expense= expenseFactory.createExpense(type);//create a new expense with all information from  window 2
        expense.setExpenseName(name);
        expense.setAmount(amount);
        expense.setPaid(paid);
        
        this.expenseData.add(expense);
     
    }

    public Expenses getSub(int rowID){
        return expenseData.getByRow(rowID);
    }
    public void addComposite(String name){
        Expenses expense= expenseFactory.createExpense(ExpenseType.COMPOSITE);
        expense.setExpenseName(name);
        this.expenseData.add(expense);
    }

    public void addSub( int rowID, String name,double amount,ExpenseType type,boolean paid){
        Expenses expense= expenseFactory.createExpense(type);
        expense.setExpenseName(name);
        expense.setAmount(amount);
        expense.setPaid(paid);

        CompositeExpenses temp=this.expenseData.getByRow(rowID).toCompositeExpenses();
        temp.add(expense);
        this.expenseData.setByRow(rowID,temp);
    }

    public void editSub(  int subRowID,int rowID,String name,double amount,ExpenseType type,boolean paid){
        Expenses expense= expenseFactory.createExpense(type);
        expense.setExpenseName(name);
        expense.setAmount(amount);
        expense.setPaid(paid);

        CompositeExpenses temp=this.expenseData.getByRow(rowID).toCompositeExpenses();
        temp.setByRow(subRowID, expense);
        this.expenseData.setByRow(rowID,temp);
    }

    //need row index from UI
    public void edit(int rowID, String name,double amount,ExpenseType type,boolean paid){
        Expenses expense= expenseFactory.createExpense(type);//create a new expense with all information from  window 2
        expense.setExpenseName(name);
        expense.setAmount(amount);
        expense.setPaid(paid);
        
        this.expenseData.setByRow(rowID,expense); //change it according to row index
        
    }
    //need row index from UI
    public void delete(int rowID){
        this.expenseData.deleteByRow(rowID);
  
    }

    public void deleteSub(int subRowID,int rowID){
        CompositeExpenses temp=this.expenseData.getByRow(rowID).toCompositeExpenses();
        temp.deleteByRow(subRowID);
    }
    
    //for window 2, put all data together to form a unit of expense, then add it to the list
    public ExpenseList getExpenseList(){

    	return this.expenseData;
    }
    
    public void connectToDataBase() {
    	
    	//USE HTTP to establish connection between client and server 
    	
    }
    
    
    public void disconnectFromDataBase() {
    	
    	//Disconnect after data is transferred. 
    	
    }
    
    
    public void push(String path) {
    	//Set up server with cURL and use http to transfer the data 
    	//SET REQUEST 
    	this.getExpenseList().save(path);
		 
    }
    
    public void pull(String path) {
    	//Set up server with cURL and use http to transfer the data 
    	//GET REQUEST 
		 this.getExpenseList().read(path);
    }
    
    
}