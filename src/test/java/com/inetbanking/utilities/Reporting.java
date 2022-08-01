package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter

{
	
	public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="Test-Report-"+timestamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\"+repname);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    extent =  new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","lohit");

		htmlReporter.config().setDocumentTitle("InetBanking Automation Report");
	    htmlReporter.config().setReportName("report");
	    //htmlReporter.config().setTestViewChartLocation();
	    htmlReporter.config().setTheme(Theme.STANDARD);

		
	}
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger=extent.createTest(result.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger=extent.createTest(result.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		String SCpath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		File f=new File(SCpath);
		if(f.exists())
		{
			try
			{
			logger.fail("screeshot is below:"+logger.addScreenCaptureFromPath(SCpath));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger=extent.createTest(result.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
	
	
	
	
}
