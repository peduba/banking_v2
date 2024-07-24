package com.netbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.netbanking.testcases.BaseClass;

public class Reporting extends BaseClass implements ITestListener{
	
    public ExtentSparkReporter SparkReporter;  //UI of the report
    
    public ExtentReports extent;  //populate common information of the report
    public ExtentTest test;  //creating test case entries in the report and update status of the test methods
    
	
	 public void onStart(ITestContext context) {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		 SparkReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);
		 SparkReporter.config().setDocumentTitle("Automation Report");
		 SparkReporter.config().setTheme(Theme.DARK);
		 SparkReporter.config().setReportName("Functional Testing");
		 extent=new ExtentReports();
		 extent.attachReporter(SparkReporter);
		 extent.setSystemInfo("Computername", "localhost");
		 extent.setSystemInfo("Env", "QA");
		 extent.setSystemInfo("TesterName", "Kiran");
		 extent.setSystemInfo("OS", "Windows10");
		 extent.setSystemInfo("Browsername", "chrome");
	 }
	public void onTestSuccess(ITestResult result) {
		 
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test case passed:" + result.getName());
	  }
	public void onTestFailure(ITestResult result) {
		 
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test case failed:" + result.getName());
		test.log(Status.FAIL,"Test case failed:" + result.getThrowable());
		try {
			test.log(Status.FAIL,MediaEntityBuilder.createScreenCaptureFromPath(takeScrenshot(result.getName())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			takeScrenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(takeScrenshot(result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	  }
	 public void onTestSkipped(ITestResult result) {
		 
		 test=extent.createTest(result.getName());
			test.log(Status.SKIP,"Test case skipped:" + result.getName());
		 
		  }
	 public void onFinish(ITestContext context) {
		 
		 extent.flush();
		  }

}

