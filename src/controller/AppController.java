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
    public void markPaid(int rowID) {
        AtomicExpense currentExpense = this.expenseData.getByRow(rowID);//get Expense unit from int
        currentExpense.setPaid(true);//set the Paid boolean of that Expense unit to paid
        this.expenseData.setByRow(rowID, currentExpense);//put it back to the data list
       
    }
    //need row index from UI
    public void unMarkPaid(int rowID) {
        AtomicExpense currentExpense = this.expenseData.getByRow(rowID);//get Expense unit from int
        currentExpense.setPaid(false);//set the Paid boolean of that Expense unit to unpaid
        this.expenseData.setByRow(rowID, currentExpense);//put it back to the data list
     
    }
    //for window 2, put all data together to form a unit of expense, then add it to the list
    public void add(String name,double amount,ExpenseType type,boolean paid){
        AtomicExpense expense= expenseFactory.createExpense(type);//create a new expense with all information from  window 2
        expense.setExpenseName(name);
        expense.setAmount(amount);
        expense.setPaid(paid);
        
        this.expenseData.add(expense);
     
    }
    

    //need row index from UI
    public void edit(int rowID, String name,double amount,ExpenseType type,boolean paid){
        AtomicExpense expense= expenseFactory.createExpense(type);//create a new expense with all information from  window 2
        expense.setExpenseName(name);
        expense.setAmount(amount);
        expense.setPaid(paid);
        
        this.expenseData.setByRow(rowID,expense); //change it according to row index
        
    }
    //need row index from UI
    public void delete(int rowID){
        this.expenseData.deleteByRow(rowID);
  
    }
    
    
    //for window 2, put all data together to form a unit of expense, then add it to the list
    public ExpenseList getExpenseList(){

    	return this.expenseData;
    }
}