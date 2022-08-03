package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;
import com.inetbanking.utilities.XLUtility;

public class Tc002_LoginDDT extends Baseclass
{

	@Test(dataProvider="logindata")
	public void loginddt(String username, String password)
	{
		Loginpage lp=new Loginpage(driver);
		lp.setusername(username);
		logger.info("user name entered");
		lp.setpassword(password);
		logger.info("password entered");
		lp.clicksubmit();
		
		if(isAlertpresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.logoutb();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			
		}
	}
	
	
	public boolean isAlertpresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name="logindata")
	String[][] getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/loginDDT.xlsx";
		
		int rownum=XLUtility.getRowCount(path, "Sheet1");
		int colcount=XLUtility.getCellCount(path, "Sheet1", 1);
		String LoginData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				LoginData[i-1][j]=XLUtility.getCellData(path, "Sheet1", i, j);
			}
		}
		return LoginData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
