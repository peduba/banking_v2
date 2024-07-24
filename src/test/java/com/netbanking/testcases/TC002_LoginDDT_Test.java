package com.netbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPagePageObjects;
import com.netbanking.utilities.ExcelUtilityFile;

public class TC002_LoginDDT_Test extends BaseClass {
	@Test(dataProvider="testdata")
	public void ddt_Test(String user,String pwd) throws IOException
	{
	driver.get(url);
	logger.info("launched url");
	driver.manage().window().maximize();
	LoginPagePageObjects li= new LoginPagePageObjects(driver);
	li.setUsername(user);
	logger.info("Entered username");
	li.setPassword(pwd);
	logger.info("Entered password");
	li.setLogin();
	logger.info("Clicked on login button");
	if(isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		
	}
	else {
		Assert.assertTrue(true);
		li.clickLogout();
		logger.info("clicked on logout link");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
		
	}
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] loginData() throws IOException
	{

		String filepath= System.getProperty("user.dir")+"/src/test/java/com/netbanking/testdata/TestData.xlsx";
	int rowCount=ExcelUtilityFile.getRowCount(filepath, "sheet1");
	int colcount=ExcelUtilityFile.getCellCount(filepath, "sheet1", 0);
	Object[][] logindata = new Object[rowCount][colcount];
	for(int i=1;i<=rowCount;i++)
	{
	for(int j=0;j<colcount;j++)
	{
		logindata[i-1][j]=ExcelUtilityFile.getCellData(filepath, "sheet1", i, j);
	}
	}
	return logindata;
	
}
}
