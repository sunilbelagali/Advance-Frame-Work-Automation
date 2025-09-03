package com.smartcare.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;

import com.smartcare.dataprovider.ConfigReader;
import com.smartcare.factory.BrowserFactory;

public class Sample {


	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("I am launching the Browser");
		WebDriver driver = BrowserFactory.startBrowser("FireFox", "https://freelance-learn-automation.vercel.app/login");
		Thread.sleep(2000);
		 System.out.println("I am continue with Login page");
		 driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("admin@email.com");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("admin@123");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(2000);
		 BrowserFactory.closeAllSession();
		 System.out.println("Browser Session expired");
	}

}
