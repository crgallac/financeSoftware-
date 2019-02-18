package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;



public class ExpenseList extends Observable{
	
	private ArrayList<AtomicExpense> expenseList;
	
	public ExpenseList() {
		
		expenseList = new ArrayList<AtomicExpense>(); 
	}
	
	public ArrayList<AtomicExpense> getExpenseList(){
		
		return this.expenseList; 
	}
	
	//for select button, return full information of the unit of expense selected
		    public AtomicExpense getByRow(int rowId){
		        return this.expenseList.get(rowId);
		        
		    }
		//for editor button, changing content of a unit of expense by row index
		    public void setByRow(int rowId,AtomicExpense expense){
		        this.expenseList.set(rowId,expense);
		        this.setChanged();
		        this.notifyObservers(this);
		    }
		//for delete button, remove expense by row index
		    public void deleteByRow(int rowId){
		        this.expenseList.remove(rowId);
		        this.setChanged();
		        this.notifyObservers(this);
		    }
		//for add button, add a unit unit of expense
		    public void add(AtomicExpense expense){
		        this.expenseList.add(expense);
		        this.setChanged();
		        this.notifyObservers(this);
		    }

		    public int getSize(){
		        return this.expenseList.size();
		    }
		    
		    public void printList(){
		        
		    	for (AtomicExpense ex : expenseList) {
		    		
		    		System.out.print(ex.expenseName + ", ");
		    		System.out.print(ex.amount + ", ");
		    		System.out.print(ex.expenseType.toString() + ", ");
		    		System.out.println(ex.paymentStatus);
		    		
		    	}
		    
		    }
	
	
	
	
}
