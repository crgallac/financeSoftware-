package model;


/**
 * An interface for the atomic expense elements that make up the list of expenses.
 * @version     1
 * @since       1          
 */
public abstract class AtomicExpense {

	protected double amount = 0.0f; 
	protected String expenseName; 
	protected boolean paymentStatus; 
	protected Date dateOfExpense;
	protected PaymentType paymentType; 
	protected ExpenseType expenseType; 
	
	
	 /* Sets the dollar value of the expense amount
	 * @param  amount dollar value of expense amount      
	 * @return void
	 */
	public void setAmount(double amount) {
		this.amount = amount; 
	}
	 /* Sets the identifying name of the expense
	 * @param  expenseName name of the expense
	 * @return void
	 */
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName; 
	}
	 /* Sets the payment status 
	 * @param  paymentStatus true if paid false if unpaid
	 * @return void
	 */
	public void setPaid(boolean paymentStatus) {
		this.paymentStatus = paymentStatus; 
	}
	 /* Sets the date of the expense 
	 * @param  dateOfExpense sets the date at which the expense is to be paid     
	 * @return void
	 */
	public void setDate(Date dateOfExpense) {
		this.dateOfExpense = dateOfExpense; 
	}
	 /* Sets the type of payment (CASH,CREDIT,DEBIT)
	 * @param  paymentType Cash, credit, debit     
	 * @return void
	 */
	public void setPaymentType  (PaymentType paymentType) {
		this.paymentType = paymentType; 
	}
	 /* Sets the type of atomic expense (PURCHASE,BILL) 
	 * @param  expenseType the type of expense to either one time purchase or recurring
	 * @return void
	 */
	public void setExpenseType  (ExpenseType expenseType) {
		this.expenseType = expenseType; 
	}
	
	 /* Gets the dollar amount of the expense
	 *     
	 * @return dollar amount of the expense 
	 */
	public double getAmount() {
		return amount; 
	}
	
	 /* Gets the name of the expense
		 *     
		 * @return name of the expense
		 */
	public String getExpenseName() {
		return expenseName; 
	}
	
	 /* Gets the Expense Type of the expense
		 *     
		 * @return one time purchase or recurring bill
		 */
	public ExpenseType getExpenseType() {
		return expenseType; 
	}
	
	 /* Gets the payment status of the expense
		 *     
		 * @return payment status true if paid false if unpaid
		 */
	public boolean getPaymentStatus() {
		return paymentStatus; 
	}
	
	 /* Gets the due date of the expense
		 *     
		 * @return due date of expense to be paid 
		 */
	public Date getDate() {
		return dateOfExpense; 
	}
	
	
	 /* Gets the type of payment used for the expense
		 *     
		 * @return cash, debit, or credit depending 
		 */
	public PaymentType getPaymentType() {
		return paymentType; 
	}
	


	
	

}
