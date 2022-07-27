package com.inetbanking.testcases;



import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;

public class Tc001_logintest extends Baseclass
{
	@Test
	public void login() throws InterruptedException
	{
		
		logger.info("URL is opened");
		Loginpage lp=new Loginpage(driver);
		lp.setusername(username);
		logger.info("User name entered");
		lp.setpassword(password);
		logger.info("password entered");
		lp.clicksubmit();
		Thread.sleep(8000);
		
	}
	
	

}
