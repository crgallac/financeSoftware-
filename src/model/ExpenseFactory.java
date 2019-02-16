package model;

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
