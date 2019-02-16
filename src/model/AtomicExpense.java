package model;



public abstract class AtomicExpense {

	protected double amount = 0.0f; 
	protected String expenseName; 
	protected boolean paymentStatus; 
	protected Date dateOfExpense; 
	
	public void setAmount(double amount) {
		this.amount = amount; 
	}
	
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName; 
	}
	public void setAmount(boolean paymentStatus) {
		this.paymentStatus = paymentStatus; 
	}
	public void setAmount(Date dateOfExpense) {
		this.dateOfExpense = dateOfExpense; 
	}
	
	public double getAmount() {
		return amount; 
	}
	
	public String getExpenseName() {
		return expenseName; 
	}
	
	public boolean getPaymentStatus() {
		return paymentStatus; 
	}
	
	public Date getDate() {
		return dateOfExpense; 
	}
	
	

}