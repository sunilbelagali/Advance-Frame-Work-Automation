package com.smartcare.testcases;

import java.sql.Driver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.smartcare.base.BaseClass;
import com.smartcare.dataprovider.CustomDataProvider;
import com.smartcare.pages.HomePage;
import com.smartcare.pages.LoginPage;

public class LoginToApplication extends BaseClass
{
	@Test(dataProvider = "LoginCredentials", dataProviderClass = CustomDataProvider.class)
	public void LoginAsaAdminUser(String username,String password) 
	{
		LoginPage login = new LoginPage(driver); //whenever we create an object, a constructor will get invoked
		HomePage home = login.loginToApplication(username, password);
		Assert.assertTrue(home.getWelcomeMessage().contains("Welcome"),"Welcome message did not appear");
		
	}
}
