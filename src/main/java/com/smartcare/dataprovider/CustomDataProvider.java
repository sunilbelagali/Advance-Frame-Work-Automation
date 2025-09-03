package com.smartcare.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	//mediator btw ExcelReader and TestCases
	@DataProvider(name="LoginCredentials")
	public static Object[][] getLoginCredentials() 
	{
		Object[] [] arr= ExcelReader.getDataFromExcel("LoginSheet");
		return arr;
	}
	@DataProvider(name="CreateUser")
	public static Object[][] getNewUserDetails()
	{
		Object[] [] arr= ExcelReader.getDataFromExcel("CreateUser");
		return arr;
	}
}
