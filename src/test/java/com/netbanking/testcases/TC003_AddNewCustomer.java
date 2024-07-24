package com.netbanking.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPagePageObjects;
import com.netbanking.pageobjects.NewCustomerPageObjects;

public class TC003_AddNewCustomer extends BaseClass {
	
	@Test
	public void Test_NewCustomer() throws InterruptedException
	{
		driver.get(url);
		driver.manage().window().maximize();
	LoginPagePageObjects li= new LoginPagePageObjects(driver);
	li.setUsername(username);
	li.setPassword(password);
	li.setLogin();
	//Thread.sleep(10000);
	NewCustomerPageObjects nc= new NewCustomerPageObjects(driver);
	nc.click_newcustomerLink();
	nc.setcustomerName("Kiran");
	nc.click_gender();
	nc.setCalendar("07","12","1984");
	nc.setAddress("Hyd");
	nc.setCity("Guntur");
	nc.setState("Andhra");
	nc.setPin("500072");
	String mobnum=randomNumerics();
	nc.setMobileNumber(mobnum);
	String email=randomAlphabets()+"@gmail.com";
	nc.setEmail(email);
	nc.setPassword("Qssi@123");
	nc.clickSubmit();
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(res==true)
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	}

}
