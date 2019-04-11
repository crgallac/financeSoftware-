package model;

/**
 * The Expense Type enumerated class describes the types of expenses, either one time "purchases" or recurring cost "bills" 
 * @version     1
 * @since       1          
 */
public enum ExpenseType {
	
	BILL, PURCHASE, COMPOSITE;
	
	 /* Converts a String to an Expense Type
	  * @param type the type of the expense 
	 * @return the enumerated equivalent type of the expense
	 */
	public static ExpenseType StringToType(String type){
		switch(type) {
			case "Compound":
				return ExpenseType.COMPOSITE;
			case "Purchase":
				return  ExpenseType.PURCHASE;
			case "Bill":
				return ExpenseType.BILL;

		}
		
		return null; 
		
	}
	
	 /* Converts an ExpenseType enumeration to a String. 
	  * @param expenseType	the enumerated type of expense
	 * @return the string equivalent of the enumerated expense type
	 */
	public static String TypeToString(ExpenseType exT){
		
		switch(exT) {
			case COMPOSITE:
				return  "Compound";
			case BILL:
				return  "Bill";
			case PURCHASE:
				return "Purchase";
		}
		
		return ""; 
		
	}

}
