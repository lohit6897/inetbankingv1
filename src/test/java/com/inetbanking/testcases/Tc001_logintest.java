package com.inetbanking.testcases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;

public class Tc001_logintest extends Baseclass
{
	@Test
	public void login() throws InterruptedException, IOException
	{
		
		logger.info("URL is opened");
		Loginpage lp=new Loginpage(driver);
		lp.setusername(username);
		logger.info("User name entered");
		lp.setpassword(password);
		logger.info("password entered");
		lp.clicksubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login pass");
		}
		else
		{
			Capturescreen(driver, "login");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
	}
	
	

}
