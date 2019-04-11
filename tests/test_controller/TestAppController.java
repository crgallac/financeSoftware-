package test_controller;

import controller.AppController;
import junit.framework.TestCase;
import model.ExpenseType;

/**
 * This is a sample JUnit test case for controller/AppController
 * 

 */
public class TestAppController extends TestCase {
	
	private AppController ac;
	
	String name = "test";
	String nameC = "testC";
	double amount = 20.0; 
	ExpenseType type = ExpenseType.BILL;
	ExpenseType typeC = ExpenseType.COMPOSITE;
	boolean paid = true; 
	
	


	public void testAdd() {
	
		ac= new AppController();
		
		ac.add(name, amount, type, paid);
		
		assertEquals(ac.getExpenseList().getSize(), 1); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getAmount(), amount); 
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getExpenseName(), name); 
		
		assertEquals((boolean)(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus()), paid);
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getExpenseType(), type);
		
		ac.add(name, amount, type, paid);
		
		assertEquals(ac.getExpenseList().getSize(), 2);
		
ac.add(name, amount, type, paid);
		
		assertEquals(ac.getExpenseList().getSize(), 3); 
		
		
		
	}

	public void testAddComp() {

		ac= new AppController();
		ac.addComposite(nameC);
		ac.addSub(0,name, amount, type, paid);


		assertEquals(ac.getExpenseList().getSize(), 1);

		assertEquals(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getAmount(), amount);

		assertEquals(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getExpenseName(), name);

		assertEquals((boolean)(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getPaymentStatus()), paid);

		assertEquals(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getExpenseType(), type);

	}
	public void testDelete() {
		
		ac= new AppController();
		
		ac.add(name, amount, type, paid);
		ac.addComposite(nameC);
		
		ac.delete(1);
		
//		System.out.println(ac.getExpenseList().getSize());
		assertEquals(ac.getExpenseList().getSize(), 1); 
		
	ac.delete(0);
		
//		System.out.println(ac.getExpenseList().getSize());
		assertEquals(ac.getExpenseList().getSize(), 0); 
		
	}

	public void testDeleteComp(){
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
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus(),Boolean.FALSE);
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getExpenseType(), ExpenseType.PURCHASE);
		
	}
	public void testEditComp() {

		ac= new AppController();
		ac.addComposite(nameC);
		ac.addSub(0,name, amount, type, paid);
		ac.editSub(0,0, name+"hi", amount+2.0, type.PURCHASE, !paid);
		assertEquals(ac.getExpenseList().getSize(), 1);

		assertEquals(ac.getExpenseList().getSize(), 1);
		assertEquals((int)(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().size()), 1);

		assertEquals(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getAmount(), amount, 22.0);

		assertEquals(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getExpenseName(), "testhi");

		assertEquals(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getPaymentStatus(),Boolean.FALSE);

		assertEquals(ac.getExpenseList().getExpenseList().get(0).toCompositeExpenses().getByRow(0).getExpenseType(), ExpenseType.PURCHASE);


	}

	public void testMarkPaid() {
		ac= new AppController();
		ac.add(name, amount, type, paid);
		
		ac.markPaid(0,false);
		
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus(), Boolean.FALSE);

		ac.markPaid(0,true);
		assertEquals(ac.getExpenseList().getExpenseList().get(0).getPaymentStatus(), Boolean.TRUE);

		
	}

}
