package test_controller;

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
		suite.addTestSuite(TestAppController.class);
		//$JUnit-END$
		return suite;
	}

}
