package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;
	public Readconfig()
	{
		File src=new File("./Configuration/Config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}

	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getusername()
	{
		String username=pro.getProperty("username");
		return username ;
	}
	public String getpassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEpath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getfirefoxpath()
	{
		String firepath=pro.getProperty("firefoxpath");
		return firepath;
	}
	
	
	
	
	
	
	
	
}
