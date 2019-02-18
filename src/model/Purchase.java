package model;

/**
 * An concrete class of the Atomic Expense class. The Payment represents a one-time purchase
 * @version     1
 * @since       1          
 */
public class Purchase extends AtomicExpense{
	
	private String name; 
	private String location; 
	private String additionalDetials; 
	
	
	public Purchase() {
		this.expenseType = ExpenseType.PURCHASE; 
	}
	
	 /* Sets the name of the shop that the expense is owed to 
		 * @param  name shop or organization name to be paid      
		 * @return void
		 */
	public void setName  (String name) {
		this.name = name; 
	}

	/* Sets the location of the shop that the expense is owed to 
	 * @param  location name of the geographical location of the shop  
	 * @return void
	 */
	public void setLocation  (String location) {
		this.location = location ; 
	}

	/* Sets additional pertinent details
	 * @param  additionalDetails a description of important purchase details
	 * @return void
	 */
	public void setAdditionalDetials  (String additionalDetails) {
		this.additionalDetials = additionalDetials; 
	}
	
	/* Gets the name of the expense 
	 * 
	 * @return the name of the expense
	 */
	public String getName() {
		return this.name; 
	}
	/* Gets the location of the expense 
	 * 
	 * @return the location of the expense
	 */
	public String getLocation() {
		return this.location; 
	}
	/* Gets any additional details associated with the expense 
	 * 
	 * @return the additional details associated with the expense
	 */
	public String getAdditionalDetials() {
		return this.additionalDetials; 
	}

}
