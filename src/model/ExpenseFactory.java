package model;


/**
 * The Expense Factory is a design pattern to create concrete expenses at runtime
 * @version     1
 * @since       1          
 */
public class ExpenseFactory {
	
	
	public AtomicExpense createExpense(ExpenseType expenseType) {
		
		
		switch(expenseType) {
		case BILL: 
				return new Bill(); 
		case PURCHASE: 
			return new Purchase(); 
			
		}
	
		return null; 
		
		
		
	}

}
