package com.netbanking.testcases;





import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.netbanking.utilities.ReadConfig;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	ReadConfig config=new ReadConfig();
	
	public String url=config.getApplicationUrl();
	public String username=config.getUserName();
	public String password=config.getPassword();
	public static WebDriver driver;
	public Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	
	{
		
		
		if(br.equals("chrome"))
		{
			
			ChromeOptions options=new ChromeOptions();
			File file= new File("C:\\Users\\Harikrishna Inampudi\\eclipse-workspace\\netbanking\\Extensions\\uBlock-Origin-Lite-Chrome-Web-Store.crx");
			options.addExtensions(file);
			
		driver= new ChromeDriver(options);
		}
		else if(br.equals("ie"))
		{
			driver= new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
	   logger=Logger.getLogger("netbanking");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String takeScrenshot(String methodname) throws IOException
	{
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String screenshot="Test-screenshot-" +this.getClass().getName()+"_"+ methodname+timeStamp+".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination= new File(System.getProperty("user.dir") + "/screenshots/" + screenshot);
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();
	}
	
	public String randomAlphabets()
	{
	 String generatedrandomString = RandomStringUtils.randomAlphabetic(7);
	 return (generatedrandomString);
	 
	}
	public String randomNumerics()
	{
	 String generatedrandomNumber = RandomStringUtils.randomNumeric(10);
	 return (generatedrandomNumber);
	 
	}

}
