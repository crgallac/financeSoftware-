package model;

/**
 * A class to keep track of the due dates for expenses  
 * @version     1
 * @since       1          
 */
public class Date {
	
	private int year; 
	private int month; 
	private int day; 
	
	public Date(int month, int day, int year) {
		
		this.month = month; 
		this.day = day; 
		this.year = year; 
	}
	
	 /* Sets the Date for the payment 
		 * @param  month the month of the payment     
		 *  @param  day the day of the payment 
		 *  @param  year the year of the payment 
		 * @return void
		 */
	public void setDate(int month, int day, int year) {
		
		this.month = month; 
		this.day = day; 
		this.year = year; 
	}
	
	 /* Gets the year for the payment 
		 * @return the year of the payment
		 */
	public int getYear() {
		return this.year; 
}
	 /* Gets the month for the payment 
		 * @return the month of the payment
		 */
	public int getMonth() {
		return this.month; 
	}
	
	 /* Gets the day for the payment 
		 * @return the day of the payment
		 */
	public int getDay() {
		return this.day; 
	}
}