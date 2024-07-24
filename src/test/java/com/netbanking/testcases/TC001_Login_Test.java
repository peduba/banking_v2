package com.netbanking.testcases;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPagePageObjects;



public class TC001_Login_Test extends BaseClass {
	
	@Test
	public void login_Test() throws IOException
	{
		
		
		driver.get(url);
		driver.manage().window().maximize();
		logger.info("Launched url");
		takeScrenshot("login_Test");
		
		LoginPagePageObjects li= new LoginPagePageObjects(driver);
		
		li.setUsername(username);
		logger.info("Entered username");
		takeScrenshot("login_Test");
		
		li.setPassword(password);
		logger.info("Entered password");
		
	
		li.setLogin();
		
	}

}
