package com.netbanking.testcases;

import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPagePageObjects;

public class TC001_Login_Test extends BaseClass {
	
	@Test
	public void login_Test()
	{
		driver.get(url);
		driver.manage().window().maximize();
		LoginPagePageObjects li= new LoginPagePageObjects(driver);
		li.setUsername(username);
		li.setPassword(password);
		li.setLogin();
	}

}
