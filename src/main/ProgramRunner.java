package main;

import controller.*; 

   /**
    * This program is intended to act as a basic personal financial management tool. The program uses an MVC architecture. 
    *
    * @author  Colin Gallacher
    * @author  Yuatian Lan
    * @author  Laura Thomson
    * @since   1.2
    */

public class ProgramRunner {
	
	/**
	 * Program Runner                          
	 * @param  args Standard
	 */
	public static void main(String[] args) {

	
	AppController appController = new AppController(); 
	
	appController.startApplication(); 
	
	}
	
}
