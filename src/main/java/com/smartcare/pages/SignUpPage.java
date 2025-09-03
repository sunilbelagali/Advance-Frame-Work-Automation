package com.smartcare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smartcare.helper.Utility;

public class SignUpPage {
	WebDriver driver;
	public SignUpPage(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	
		private By name = By.xpath("//input[@name='name']");
		private By email = By.xpath("//input[@name='email']");
		private By password = By.xpath("//input[@name='password']");
		private By interest = By.xpath("//label[.='Java']");
		private By gender = By.xpath("//input[@id='gender2']");
		private By state = By.xpath("//select[@name='state']");
		private By hobbies = By.xpath("//select[@id='hobbies']");
		private By signup = By.xpath("//button[.='Sign up']");

	public LoginPage createNewUser(String name1, String email1, String password1, String dropdowntext, String hobbiesdropdowntext) 
	{
		driver.findElement(name).sendKeys(name1);
		driver.findElement(email).sendKeys(email1);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(interest).click();
		driver.findElement(gender).click();
		WebElement stateDropDown = driver.findElement(state);
		WebElement hobbiesDropDown = driver.findElement(hobbies);
		Utility.selectByVisibleText(stateDropDown, dropdowntext);
		Utility.selectByVisibleText(hobbiesDropDown, hobbiesdropdowntext);
		driver.findElement(signup).click();
		LoginPage login = new LoginPage(driver);
		return login;
	}

}

