package com.smartcare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;	
	}
	
	private By WelComeMessage=By.xpath("//h4[@class='welcomeMessage']");
	
	public String getWelcomeMessage() 
	{
		String WelcomeText = driver.findElement(WelComeMessage).getText();
		return WelcomeText;
	}
}
