package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() 
	{
		File file= new File("./configurations/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getApplicationUrl()
	{
		String url=prop.getProperty("url");
		return url;
	}
	
	public String getUserName()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
}
