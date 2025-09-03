package com.smartcare.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.smartcare.base.BaseClass;
import com.smartcare.dataprovider.CustomDataProvider;
import com.smartcare.pages.LoginPage;
import com.smartcare.pages.SignUpPage;

public class CreateNewUser extends BaseClass
{
	@Test(dataProvider = "CreateUser", dataProviderClass = CustomDataProvider.class)
	public void name(String name1, String email1, String password1, String dropdowntext, String hobbiesdropdowntext) 
	{
		LoginPage login = new LoginPage(driver);
		SignUpPage signup= login.clickOnSignUpLink();
		LoginPage login1 = signup.createNewUser(name1, email1, password1, dropdowntext, hobbiesdropdowntext);
		Assert.assertTrue(login1.getSignUpSuccessfullMessage().contains("Signup successfully"),"User not Created");
		
	}
}
