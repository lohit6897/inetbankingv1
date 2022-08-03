package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class Baseclass {
	
	Readconfig readconfig=new Readconfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		//getProperty("user.dir")+"\\Drivers\\chromedriver.exe"
		//driver=new ChromeDriver();
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
			//getProperty("user.dir")+"\\Drivers\\chromedriver.exe"
			driver=new ChromeDriver();
			
		}

		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
			//getProperty("user.dir")+"\\Drivers\\chromedriver.exe"
			driver=new InternetExplorerDriver();
			
		}

		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			//getProperty("user.dir")+"\\Drivers\\chromedriver.exe"
			driver=new FirefoxDriver();
			
		}
		driver.get(baseURL);
		
		
	}
	
	@AfterClass
	
	public void teardown() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.quit();
		
	}
	
	
	public void Capturescreen(WebDriver driver, String tname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken");
	}

}
