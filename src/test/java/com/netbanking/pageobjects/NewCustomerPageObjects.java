package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPageObjects {
	WebDriver driver;
	public NewCustomerPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	} 
	@FindBy(xpath="//a[normalize-space()='New Customer']") WebElement newcustomerLink;
	@FindBy(xpath="//input[@name='name']") WebElement customerName;
	@FindBy(xpath="//input[@value='m']") WebElement male;
	@FindBy(xpath="//input[@id='dob']") WebElement calendar;
	@FindBy(xpath="//textarea[@name='addr']") WebElement address;
	@FindBy(xpath="//input[@name='city']") WebElement city;
	@FindBy(xpath="//input[@name='state']") WebElement state;
	@FindBy(xpath="//input[@name='pinno']") WebElement pin;
	@FindBy(xpath="//input[@name='telephoneno']") WebElement mobilenumber;
	@FindBy(xpath="//input[@name='emailid']") WebElement email;
	@FindBy(xpath="//input[@name='password']")  WebElement password;
	@FindBy(xpath="//input[@name='sub']") WebElement submit;
	
	public void click_newcustomerLink()
	{
		newcustomerLink.click();
	}
	public void setcustomerName(String cname)
	{
		customerName.sendKeys(cname);
	}
	public void click_gender()
	{
		male.click();
	}
	public void setCalendar(String dd,String mm,String yyyy)
	{
		calendar.sendKeys(dd);
		calendar.sendKeys(mm);
		calendar.sendKeys(yyyy);
	}
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	public void setCity(String cit)
	{
		city.sendKeys(cit);
	}
	public void setState(String stat)
	{
		state.sendKeys(stat);
	}
	public void setPin(String pincode)
	{
		pin.sendKeys(pincode);
	}
	public void setMobileNumber(String mob)
	{
		mobilenumber.sendKeys(mob);
	}
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickSubmit()
	{
		submit.click();
	}
	
	
	
	
	
	
	
	

}
