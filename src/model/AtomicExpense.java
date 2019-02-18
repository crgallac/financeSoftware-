package model;



public abstract class AtomicExpense {

	protected double amount = 0.0f; 
	protected String expenseName; 
	protected boolean paymentStatus; 
	protected Date dateOfExpense;
	protected PaymentType paymentType; 
	protected ExpenseType expenseType; 
	
	public void setAmount(double amount) {
		this.amount = amount; 
	}
	
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName; 
	}
	public void setPaid(boolean paymentStatus) {
		this.paymentStatus = paymentStatus; 
	}
	public void setAmount(Date dateOfExpense) {
		this.dateOfExpense = dateOfExpense; 
	}
	
	public void setPaymentType  (PaymentType paymentType) {
		this.paymentType = paymentType; 
	}
	public void setExpenseType  (ExpenseType expenseType) {
		this.expenseType = expenseType; 
	}
	
	public double getAmount() {
		return amount; 
	}
	
	public String getExpenseName() {
		return expenseName; 
	}
	
	public ExpenseType getExpenseType() {
		return expenseType; 
	}
	
	public boolean getPaymentStatus() {
		return paymentStatus; 
	}
	
	public Date getDate() {
		return dateOfExpense; 
	}
	
	public PaymentType getPaymentType() {
		return paymentType; 
	}
	


	
	

}
