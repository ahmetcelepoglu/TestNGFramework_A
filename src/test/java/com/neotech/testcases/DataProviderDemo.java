package com.neotech.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.ExcelUtility;

public class DataProviderDemo {

	
	@Test(dataProvider="excelData")
	public void printInformation(String name, String lastName, String age)
	{
		System.out.println("Full Name and Age: " + name + " " + lastName + " " + age );
	}
	
	@DataProvider(name="myData")
	public Object[][] createData()
	{
		Object[][] data = {{"Harun", "Bicakci", 22},
							{"Betim", "Lusha", 23}};
		
		return data;
	}
	
	@DataProvider(name="excelData")
	public Object[][] getExcelData()
	{
		String path = System.getProperty("user.dir") 
				+ "/src/test/resources/testdata/DataProviderDemo.xlsx";
		String sheet = "Data";

		
//		Object[][] data = ExcelUtility.excelIntoArray(path, sheet);
//		return data;
		
		 return ExcelUtility.excelIntoArray(path, sheet);
		
	}
	
	
	
	
	
}
