package model;


/**
 * The Expense Factory is a design pattern to create concrete expenses at runtime
 * @version     1
 * @since       1          
 */
public class ExpenseFactory {
	
	
	public Expenses createExpense(ExpenseType expenseType) {


		switch(expenseType) {
			case BILL:
				return new PeriodicExpense();
			case PURCHASE:
				return new SingleExpense();
			case COMPOSITE:
			return new CompositeExpenses();
		}
		return null; 
		
		
		
	}

}
