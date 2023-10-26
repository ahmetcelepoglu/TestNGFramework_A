package com.neotech.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {

	
	@Test
	public void test1()
	{
		String expected = "Ahmet";
		String actual = "Yildirim";
		
		Assert.assertEquals(actual, expected);
		
		//will this be executed??
		//if the test fails, whatever comes after the assertion, will not execute
		System.out.println("End of code!");
		
	}
	
	@Test
	public void test2()
	{
		int expected = 15;
		int actual = 5;
		
		Assert.assertEquals(actual, expected, "Numbers did NOT match!");
	}
	
	
	@Test
	public void test3()
	{
		//when we log in to the dashboard we have a menu:
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("Admin");
		expectedList.add("PIM");
		expectedList.add("Time");
		expectedList.add("About");
		
		//let us assume that we run the test, and we get the list of the menu elements
		//the list values are these
		ArrayList<String> actualList = new ArrayList<>();
		actualList.add("Admin");
		actualList.add("PIM");
		actualList.add("About");
		actualList.add("Time");
		
		
		Assert.assertEquals(actualList, expectedList);
	}
	
	@Test
	public void test4()
	{
		boolean result = true;
		//we expect it to be false, but it is true ---> test fails
		Assert.assertFalse(result);
	}
	
	@Test
	public void test5()
	{	
		
		//With SoftAssert, we can run multiple independent assertions in the same @Test.
		SoftAssert softAssert = new SoftAssert();
		
		String expected = "Ahmet";
		String actual = "Ahmet";
		
		//this is a soft assert -- assert, then continue the execution, no matter what happened
		softAssert.assertEquals(actual, expected);
		//this line would be always executed
		System.out.println("End of code!");
		
		boolean result = true;
		softAssert.assertFalse(result);

		
		int num1 = 6;
		int num2 = 6;
		
		softAssert.assertEquals(num1, num2);
		
		
		//this is the REAL CHECK!!!
		softAssert.assertAll();
	}
	
}
