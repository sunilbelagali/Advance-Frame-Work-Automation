package com.smartcare.base;

import java.io.ObjectInputFilter.Config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.smartcare.dataprovider.ConfigReader;
import com.smartcare.factory.BrowserFactory;

public class BaseClass

{
	public WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		//Before the class 
	 driver = BrowserFactory.startBrowser(ConfigReader.takingPropertyFromConfigReader("Browser"), 
				ConfigReader.takingPropertyFromConfigReader("appURL")); // This will return the WebDriver driver
	}
	
	@AfterClass
	public void tearDown()
	{
		//after the Class
		BrowserFactory.closeAllSession();
	}
}
