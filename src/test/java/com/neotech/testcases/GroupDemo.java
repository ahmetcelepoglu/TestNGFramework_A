package com.neotech.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupDemo {

	/*
	 * public static void main(String[] args) { System.out.println("Abril"); }
	 */
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest()
	{
		System.out.println("Start keeping logs...");
	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest()
	{
		System.out.println("Save the logs to file...");
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod()
	{
		System.out.println("Load the browser, get ready for test!");
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod()
	{
		System.out.println("Quit the browser after performing the test");
		
	}
	
	@Test(priority=2, groups= {"group1","group2"})
	public void test1()
	{
		System.out.println("Adding employee");
	}
	
	@Test(priority = 1, groups="group1", dependsOnMethods="test1")
	public void test2()
	{
		System.out.println("Removing employee");
	}

}
