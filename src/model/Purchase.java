package model;

public class Purchase extends AtomicExpense{
	
	private String name; 
	private String location; 
	private String additionalDetials; 
	
	public Purchase() {
		this.expenseType = ExpenseType.PURCHASE; 
	}
	public void setName  (String name) {
		this.name = name; 
	}

	public void setLocation  (String location) {
		this.location = location ; 
	}

	public void setAdditionalDetials  (String additionalDetails) {
		this.additionalDetials = additionalDetials; 
	}
	
	public String getName() {
		return this.name; 
	}
	
	public String getLocation() {
		return this.location; 
	}
	
	public String getAdditionalDetials() {
		return this.additionalDetials; 
	}

}
