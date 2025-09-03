package com.smartcare.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	public static String CaptureCurrentDateAndTime() 
	{
		Date D = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		String date = simpleDate.format(D);
		return date;
		
		//String value = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
	}

	public static String GetScreenShotAsBase64(WebDriver driver) 
	{
		TakesScreenshot Ts = (TakesScreenshot) driver;
		String screenshot = Ts.getScreenshotAs(OutputType.BASE64);
		return screenshot;
	}
	
	
	public static void selectByVisibleText(WebElement element, String text) 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
}
