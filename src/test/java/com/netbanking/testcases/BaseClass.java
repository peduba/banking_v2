package com.netbanking.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.netbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig config=new ReadConfig();
	
	public String url=config.getApplicationUrl();
	public String username=config.getUserName();
	public String password=config.getPassword();
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
		driver= new ChromeDriver();
		}
		else if(br.equals("ie"))
		{
			driver= new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
