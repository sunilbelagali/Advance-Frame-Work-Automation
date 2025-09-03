package com.smartcare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.asm.Advice.This;

public class LoginPage 

{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	private By usernameLoc = By.xpath("//input[@id='email1']");
	private By passwordLoc = By.xpath("//input[@id='password1']");
	private By siginButtonLoc = By.xpath("//button[@type='submit']");
	private By newUser = By.xpath("//a[text()='New user? Signup']");
	private By userCreatedSuccessfully = By.xpath("//div[normalise-space = 'Signup successfully, Please login!']");
	
	public HomePage loginToApplication(String username, String password)
	{
		driver.findElement(usernameLoc).sendKeys(username);
		driver.findElement(passwordLoc).sendKeys(password);
		driver.findElement(siginButtonLoc).click();
		HomePage home = new HomePage(driver);
		return home;
	}
	
	public SignUpPage clickOnSignUpLink()
	{
		driver.findElement(newUser).click();
		SignUpPage SignUp= new SignUpPage(driver);
		return SignUp;
}
	public String getSignUpSuccessfullMessage() 
	{
		String signupmessage = driver.findElement(userCreatedSuccessfully).getText();
		return signupmessage;
		
	}
}
