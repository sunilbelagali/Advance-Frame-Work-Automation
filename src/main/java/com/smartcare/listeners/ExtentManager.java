package com.smartcare.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.smartcare.helper.Utility;

public class ExtentManager 
{
static ExtentReports extent;
    
    public static ExtentReports getInstance()
    {
        if(extent==null)
        {
            extent=createInstance();
            
            return extent;
        }
        else
        {
            return extent;
        }
    }
    
    public static ExtentReports createInstance()
    {
        
       
    	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Reports/Automation_" + Utility.CaptureCurrentDateAndTime() + ".html");

       // ExtentSparkReporter sparkReporter5 = new ExtentSparkReporter("./Reports/Automation_"+Utility.CaptureCurrentDateAndTime()+".html");

        sparkReporter.config().setTheme(Theme.DARK);
        
        sparkReporter.config().setReportName("Sprint 1 Report");
        
        sparkReporter.config().setDocumentTitle("Automation Report");
        
        ExtentReports extent=new ExtentReports();
        
        extent.attachReporter(sparkReporter);
        
        return extent;
    }
    }