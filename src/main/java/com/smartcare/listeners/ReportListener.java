package com.smartcare.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.smartcare.dataprovider.ConfigReader;
import com.smartcare.factory.BrowserFactory;
import com.smartcare.helper.Utility;

public class ReportListener implements ITestListener 
{
	ExtentReports extent=ExtentManager.getInstance();
	
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Starting Test");
		
		extentTest=extent.createTest(result.getMethod().getMethodName());
		
		test.set(extentTest);
		
	}

	public void onTestSuccess(ITestResult result) 
	{
			if(ConfigReader.takingPropertyFromConfigReader("screenshotOnSuccess").equalsIgnoreCase("true"))
			{
				test.get().pass("Test Passed ",MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.GetScreenShotAsBase64(BrowserFactory.getDriver())).build());
			}
			else
			{
				test.get().pass("Test Passed");
			}
	}

	public void onTestFailure(ITestResult result) 
	{
			if(ConfigReader.takingPropertyFromConfigReader("screenshotOnFailure").equalsIgnoreCase("true"))
			{
		
			test.get().fail("Test Failed "+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.GetScreenShotAsBase64(BrowserFactory.getDriver())).build());
			}
			else
			{
				test.get().fail("Test Failed "+result.getThrowable().getMessage());
			}
	}

	public void onTestSkipped(ITestResult result) {
		
			if(ConfigReader.takingPropertyFromConfigReader("screenshotOnSkip").equalsIgnoreCase("true"))
			{
			test.get().skip("Test Skipped ",MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.GetScreenShotAsBase64(BrowserFactory.getDriver())).build());
			}
			else
			{
				test.get().skip("Test Skipped ");
			}
		
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}