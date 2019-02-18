package model;

/**
 * The interval of payment for recurring bills
 * @version     1
 * @since       1          
 */
public enum PaymentInterval {

	DAILY, WEEKLY, MONTHLY, SEMIANNUALLY, ANNUALLY;

	public int toDays() {
		switch(this) {
			case DAILY: 
				return 1; 
			case WEEKLY: 
				return 7; 
			case MONTHLY: 
				return 30; 
			case SEMIANNUALLY: 
				return 365/2; 
			case ANNUALLY: 
				return 365;  
		
		}
		return 0;
	}


}
