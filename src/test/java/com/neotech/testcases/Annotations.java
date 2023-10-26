package com.neotech.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations{

	/*
	 * public static void main(String[] args) { System.out.println("Abril"); }
	 */
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Start keeping logs...");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Save the logs to file...");
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Load the browser, get ready for test!");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Quit the browser after performing the test");
		
	}
	
	
	
	@Test
	public void test1()
	{
		System.out.println("Adding employee in Annotations");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Removing employee");
	}

}
