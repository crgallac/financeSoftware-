package model;


import java.util.ArrayList;

/**
 * An interface for the atomic expense elements that make up the list of expenses.
 * @version     1
 * @since       1          
 */
public interface AtomicExpense extends Expenses{


	
	
	 /* Sets the dollar value of the expense amount
	 * @param  amount dollar value of expense amount      
	 * @return void
	 */
	public void setAmount(Double amount);
	 /* Sets the identifying name of the expense
	 * @param  expenseName name of the expense
	 * @return void
	 */
	public void setExpenseName(String expenseName) ;
	 /* Sets the payment status 
	 * @param  paymentStatus true if paid false if unpaid
	 * @return void
	 */
	public void setPaid(Boolean paymentStatus);


	 /* Sets the type of atomic expense (PURCHASE,BILL) 
	 * @param  expenseType the type of expense to either one time purchase or recurring
	 * @return void
	 */
	public void setExpenseType  (ExpenseType expenseType);
	
	 /* Gets the dollar amount of the expense
	 *     
	 * @return dollar amount of the expense 
	 */
	public Double getAmount() ;
	
	 /* Gets the name of the expense
		 *     
		 * @return name of the expense
		 */
	public String getExpenseName() ;
	
	 /* Gets the Expense Type of the expense
		 *     
		 * @return one time purchase or recurring bill
		 */
	public ExpenseType getExpenseType() ;
	
	 /* Gets the payment status of the expense
		 *     
		 * @return payment status true if paid false if unpaid
		 */
	public Boolean getPaymentStatus() ;
	

	



	
	

}
