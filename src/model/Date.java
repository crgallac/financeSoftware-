package model;

public class Date {
	
	private int year; 
	private int month; 
	private int day; 
	
	public Date(int month, int day, int year) {
		
		this.month = month; 
		this.day = day; 
		this.year = year; 
	}
	
	public void setDate(int month, int day, int year) {
		
		this.month = month; 
		this.day = day; 
		this.year = year; 
	}
	
	public int getYear() {
		return this.year; 
}
	public int getMonth() {
		return this.month; 
	}
	
	public int getDay() {
		return this.day; 
	}
}