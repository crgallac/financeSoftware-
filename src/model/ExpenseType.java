package model;

public enum ExpenseType {
	
	BILL, PURCHASE; 
	
	
	public static ExpenseType StringToType(String type){
		
		switch(type) {
		
		case "Purchase":
			return  ExpenseType.PURCHASE; 
			
		case "Bill": 
			return ExpenseType.BILL; 
		
		}
		
		return null; 
		
	}
	
	public static String TypeToString(ExpenseType exT){
		
		switch(exT) {
		
		case BILL: 
			return  "Bill"; 
			
		case PURCHASE: 
			return "Purchase"; 
		
		}
		
		return ""; 
		
	}

}
