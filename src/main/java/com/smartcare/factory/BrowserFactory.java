package com.smartcare.factory;

import java.io.ObjectInputFilter.Config;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.smartcare.dataprovider.ConfigReader;

public class BrowserFactory 

{

	static WebDriver driver;
	
	public static void closeAllSession() 
	{
		driver.quit();
	}
	public static void closeCurrentSession() 
	{
		driver.close();
	}
	public static WebDriver getDriver() 
	{
		// to capture the ScreenShots
		
		return driver;
	}
	public static WebDriver startBrowser(String Browser, String appURL) 
	{
		//Writing a logic to choose and invoke a browser and URL that are required
		//I am passing browser and url to this method
		
		//I may take either Chrome nor Edge
		
		if (Browser.equalsIgnoreCase("Chrome"))
		{
			 driver = new ChromeDriver();
		}
		
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			 driver = new EdgeDriver();
		}
		else if (Browser.equalsIgnoreCase("FireFox")) 
		{
			 driver = new FirefoxDriver();	
		}
		else
		{
			System.out.println("Currently we are not supported " +Browser+ "Browser");
		}
		
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.takingPropertyFromConfigReader("pageLoadTimeout"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.takingPropertyFromConfigReader("scriptTimeout"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.takingPropertyFromConfigReader("implicitlyWait"))));
		
		return driver;
		
	}
	
}
