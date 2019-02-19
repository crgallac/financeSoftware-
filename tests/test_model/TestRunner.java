package test_model;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Sample test suite includes all the test cases in package tests/test_controller
 * 
 * 
 */
public class TestRunner {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for AppController");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestExpenseList.class);
		suite.addTestSuite(TestBill.class);
		//$JUnit-END$
		return suite;
	}

}
