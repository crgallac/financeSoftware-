package model;


/**
 * An concrete class of the Atomic Expense class. The Bill represents a recurring payment. 
 * @version     1
 * @since       1          
 */
public class Bill extends AtomicExpense{

	private String companyName; 
	private PaymentInterval repetitionInterval; 
	
	
	public Bill() {
		this.expenseType = ExpenseType.BILL; 
	}
	
	
	 /* Sets the name of the company that the expense is owed to 
		 * @param  name company or organization name to be paid      
		 * @return void
		 */
	public void setCompanyName(String name) {
		this.companyName = name; 
	}
	
	 /* Gets the name of the company that the expense is owed to     
		 * @return the name of the company being paid 
		 */
	public String getCompanyName() {
		return this.companyName; 
	}
	
	 /* Sets the Payment interval between recurring payments
		 * @param  interval the time between payments     
		 * @return void
		 */
	public void setPaymentInterval(PaymentInterval interval) {
		this.repetitionInterval = interval; 
}
	 /* Gets the interval for the subsequent recurring payments 
	 * @return the interval between payments
	 */
	public PaymentInterval getPaymentInterval() {
		return this.repetitionInterval; 
	}
	
}
