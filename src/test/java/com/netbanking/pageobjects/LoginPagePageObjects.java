package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePageObjects {
	
	WebDriver driver;
	public LoginPagePageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement loginbutton;
	@FindBy(xpath="//a[normalize-space()='Log out']") WebElement logoutbutton;
	
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	
	}
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	
	}
	
	public void setLogin()
	{
		loginbutton.click();
	}
	public void clickLogout()
	{
		logoutbutton.click();
	}
	
	

}
