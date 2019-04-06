package test_controller;

import junit.framework.Assert;
import junit.framework.TestCase;
import controller.AppController;
import model.ExpenseType;
import model.ExpenseList; 

import org.junit.Before;
import org.junit.Ignore;

/**
 * This is a sample JUnit test case for controller/AppController
 * 

 */
public class TestAppController extends TestCase {
	
	private AppController ac;
	
	String name = "test"; 
	double amount = 20.0; 
	ExpenseType type = ExpenseType.BILL; 
	boolean paid = true; 
	
	


	public void testAdd() {
	
		ac= new AppController();
		
		ac.add(name, amount, type, paid);
		
		assertEquals(ac.getExpenseList().getSize(), 1); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getAmount(), amount); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getExpenseName(), name); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus(), paid); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getExpenseType(), type);
		
		ac.add(name, amount, type, paid);
		
		assertEquals(ac.getExpenseList().getSize(), 2);
		
ac.add(name, amount, type, paid);
		
		assertEquals(ac.getExpenseList().getSize(), 3); 
		
		
		
	}
	
	
	public void testDelete() {
		
		ac= new AppController();
		
		ac.add(name, amount, type, paid);
		ac.add(name, amount, type, paid);
		
		ac.delete(0);
		
//		System.out.println(ac.getExpenseList().getSize());
		assertEquals(ac.getExpenseList().getSize(), 1); 
		
	ac.delete(0);
		
//		System.out.println(ac.getExpenseList().getSize());
		assertEquals(ac.getExpenseList().getSize(), 0); 
		
	}
	
	public void testEdit() {
		
		ac= new AppController();
		ac.add(name, amount, type, paid);
		
		ac.edit(0, name+"hi", amount+2.0, type.PURCHASE, !paid);
		
		assertEquals(ac.getExpenseList().getSize(), 1); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getAmount(), 22.0); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getExpenseName(), "testhi"); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus(), false); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getExpenseType(), ExpenseType.PURCHASE);
		
	}

	public void markPaid() {
		ac= new AppController();
		ac.add(name, amount, type, paid);
		
		ac.markPaid(0,false);
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus(), false); 

		ac.markPaid(0,true);
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus(), true); 

		
	}

}
