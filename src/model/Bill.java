package model;

public class Bill extends AtomicExpense{

	private String companyName; 
	private PaymentInterval repetitionInterval; 
	
	
	public Bill() {
		this.expenseType = ExpenseType.BILL; 
	}
	
	public void setCompanyName(String name) {
		this.companyName = name; 
	}
	
	public String getCompanyName() {
		return this.companyName; 
	}
	
	public void setPaymentInterval(PaymentInterval interval) {
		this.repetitionInterval = interval; 
}
	
	public PaymentInterval getPaymentInterval() {
		return this.repetitionInterval; 
	}
	
}
