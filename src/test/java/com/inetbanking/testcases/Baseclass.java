package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	
	public String baseURL="https://www.demo.guru99.com/V4/index.php";
	public String username="mngr425192";
	public String password="qAsEpyp";
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		
	}
	
//	@AfterClass
//	public void teardown()
//	{
//		driver.quit();
//		
//	}

}
