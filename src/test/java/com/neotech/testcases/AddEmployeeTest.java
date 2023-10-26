package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonalDetailsPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "excelData", groups = { "addEmployee", "regression" })
	public void addEmployee(String firstName, String lastName, String username, String password) {
		// Lets start initializing page object models first
		LoginPageElements loginPage = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmployeePageElements addEmployeePage = new AddEmployeePageElements();
		PersonalDetailsPageElements personalDetailsPage = new PersonalDetailsPageElements();

		// log information in test report
		test.info("Test Data:" + firstName + " " + lastName);
		// log information in console
		System.out.println("Test Data:" + firstName + " " + lastName);

		// Login
		test.info("Logging in...");
		loginPage.adminLogin();

		wait(1);

		dashboard.PIM.click();
		dashboard.addEmployeeLink.click();

		wait(1);
		// New employee info
		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);

		// for verification
		String employeeId = addEmployeePage.employeeId.getAttribute("value");

		// select location from drop down
		selectDropdown(addEmployeePage.location, "Canadian Regional HQ");

		wait(1);

		jsClick(addEmployeePage.loginDetailsToggle);

		wait(1);

		// provide credentials:username and password
		sendText(addEmployeePage.username, username);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, password);

		wait(3);
		click(addEmployeePage.saveButton);

		wait(1);
		//we noticed there is significant difference in waiting for the form or the specific element
		//waitForVisibility(personalDetailsPage.personalDetailsForm);		
		//so we will wait for the specific element to show up
		waitForVisibility(personalDetailsPage.firstName);

		// Validation
		test.info("Validation the new employee");
		String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");

		Assert.assertEquals(actualEmployeeId, employeeId, "Employee id's do NOT match!");
	}

	@DataProvider(name = "excelData")
	public Object[][] createData() {
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
		return ExcelUtility.excelIntoArray(path, "Employee");
	}
}
