package com.plivo.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.plivo.PageFactory.BasePage;
import com.plivo.PageFactory.CartPage;
import com.plivo.PageFactory.HomePage;
import com.plivo.PageFactory.Launch;
import com.plivo.PageFactory.LoginPage;
import com.plivo.configuration.ReadProperties;
import com.plivo.configuration.ReadTestData;
import com.plivo.mail.SendEmail;
import com.plivo.reporting.ExtentManager;
import com.plivo.variables.Var;

public class BaseClass {
	
	public static String firstNumber;
	public static String secondNumber;
	public static String messageUUID;
	public static String totalRate;
	public static String outboundRate;
	public static String cashCredits;
	
	WebDriver driver;
	String url;
	String browserType;
	String testClassName = "test";
	String testName = "test";
	String testDescription = "test";
	String configProp = "properties/config.properties";
	String mailProp = "properties/mail.properties";
	String testDataXlsx = "data/test-data.xlsx";
	Launch launch;
	LoginPage LoginPageObject;
	HomePage HomePageObject;
	CartPage CartPageObject;
	
	String authId = "MAODUZYTQ0Y2FMYJBLOW";
	String authToken = "Mzk0MzU1Mzc3MTc1MTEyMGU2M2RlYTIwN2UyMzk1";
	
	
	@BeforeSuite(alwaysRun = true)
	public void SuiteLevelSetup(){

//		Var.rcp = new ReadProperties();
//		Var.rcp.readProp(configProp);
//		
//		Var.rmp = new ReadProperties();
//		Var.rmp.readProp(mailProp);
//		
//		Var.rtd = new ReadTestData();
//		Var.rtd.populateDataSource(testDataXlsx);
//	
//		Var.reportPath = "reports/Report_"+Var.genericName;		
//		Var.extentReportImagePath = Var.reportPath+"/screenshots/";
	}

	@BeforeClass(alwaysRun = true)
	public void ClassLevelSetup(){
		
//		Method[] methods = this.getClass().getDeclaredMethods();
//			
//			for(int i=0; i<methods.length ;i++) {
//				
//				try {
//					if (!methods[i].getAnnotation(Test.class).description().equals(null)) 
//					{						
//						testDescription = methods[i].getAnnotation(Test.class).description();
//						testClassName = methods[i].getDeclaringClass().getName();
//					}
//				} catch (Exception e) {
//					//System.out.println(e);
//				}				
//			}
//			
//		testName = this.getClass().getSimpleName();
//		
//		launch = new Launch(driver);
//			
//		driver = launch.lauchBrowser("web");	
//		
//		launch.openPage(Var.rcp.prop.getProperty("url"));
	}
	
	@BeforeMethod
	public void beforeMethod(Method caller) 
	{
//		ExtentManager.getTest(testName, testDescription);
	}
	
	@AfterMethod(alwaysRun = true)
	public void SuiteLevelTestPostProcessing(ITestResult result, Method caller)throws IOException
	{
//		Object errorMessage;
//		
//		try 
//		{
//			errorMessage = result.getThrowable();
//		}
//		catch(Error e) 
//		{
//			errorMessage = "Error!";
//		}
//		
//		if (result.getStatus() == ITestResult.FAILURE) ExtentManager.log("fail", errorMessage.toString(), BasePage.takeSnapShot(driver, Var.extentReportImagePath, result.getTestClass().getRealClass().getSimpleName() + Var.dynamicName()));
//		
//		ExtentManager.closeTest(testName);
	}
	
	@AfterClass(alwaysRun = true)
	public void ClassLevelCleanup()
	{			
//		driver.close();	
	}
	
	@AfterSuite(alwaysRun = true)
	public void SuiteLevelCleanup()
	{
//		ExtentManager.closeReport();
//		SendEmail.sendReportByMail(Var.rmp.prop.getProperty("from"), Var.rmp.prop.getProperty("password"), Var.rmp.prop.getProperty("to"), Var.rmp.prop.getProperty("cc"), Var.rmp.prop.getProperty("subject"), Var.rmp.prop.getProperty("body"), Var.reportPath+"/Report.html");
	}
	
}
