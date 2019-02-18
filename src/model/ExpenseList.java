package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;


/**
 * The Expense List class stores the relevant data for the finance tracking program. The expense list is observed by the main window view. 
 * @version     1
 * @since       1          
 */
public class ExpenseList extends Observable{
	
	private ArrayList<AtomicExpense> expenseList;
	
	public ExpenseList() {
		
		expenseList = new ArrayList<AtomicExpense>(); 
	}
	
	
	 /* Gets the list of expenses   
		 * @return the list of the expenses 
		 */
	public ArrayList<AtomicExpense> getExpenseList(){
		
		return this.expenseList; 
	}
	
	 /* Gets an individual expense by the specified row   
	  * @param rowId the row within the list
	 * @return the individual atomic expense located within the list 
	 */
		    public AtomicExpense getByRow(int rowId){
		        return this.expenseList.get(rowId);
		        
		    }
		
		    /* Sets an expense into the list at a specified row location 
			  * @param rowId the row within the list to place the expense
			  * @param expense the expense to place within the list
			 */
		    public void setByRow(int rowId,AtomicExpense expense){
		        this.expenseList.set(rowId,expense);
		        this.setChanged();
		        this.notifyObservers(this);
		    }
		    
		    /* Deletes an expense from the list 
					  * @param rowId the row which to delete from the list
					 */
		    public void deleteByRow(int rowId){
		        this.expenseList.remove(rowId);
		        this.setChanged();
		        this.notifyObservers(this);
		    }
		
		    /* Adds an expense to the end of the list
			  * @param expense the expense to add to the end of the list
			 */
		    public void add(AtomicExpense expense){
		        this.expenseList.add(expense);
		        this.setChanged();
		        this.notifyObservers(this);
		    }

			 /* Gets the size of the expense list   
			 * @return the size of the expense list
			 */
		    public int getSize(){
		        return this.expenseList.size();
		    }
			 /* Prints the contents of the list  
			 * @return void
			 */
		    public void printList(){
		        
		    	for (AtomicExpense ex : expenseList) {
		    		
		    		System.out.print(ex.expenseName + ", ");
		    		System.out.print(ex.amount + ", ");
		    		System.out.print(ex.expenseType.toString() + ", ");
		    		System.out.println(ex.paymentStatus);
		    		
		    		
		    	}
		    	System.out.println(); 
		    
		    }
	
	
	
	
}
