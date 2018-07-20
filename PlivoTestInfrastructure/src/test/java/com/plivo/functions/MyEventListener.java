package com.plivo.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.plivo.reporting.ExtentManager;

public class MyEventListener implements WebDriverEventListener {
	
	public void logMessage(String stepName, Object object) {
		
		try {
			
			//String event = new Object(){}.getClass().getEnclosingMethod().getName();
			String event = Thread.currentThread().getStackTrace()[2].getMethodName();

			if(stepName == null) ExtentManager.log("info", object.toString());
			else	 ExtentManager.logWithStepName("info", stepName, object.toString());

			//ExtentManager.log("info","clicked on ["+element.toString());		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub		
		
	}
	
	public void afterNavigateTo(String url, WebDriver driver)
	{
		// TODO Auto-generated method stub	
		//logMessage(url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		//logMessage("");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		//logMessage("");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		//logMessage("");
		
	}



	public void afterClickOn(WebElement element, WebDriver driver)
	{
		
		
		String trace="";
		StackTraceElement[] arr = Thread.currentThread().getStackTrace();
		for(int i=0;i<arr.length;i++){
			//System.out.println(arr[i]);
			if(arr[i].getClassName().contains("com.numberz.test")){
				trace = "[class name: "+arr[i].getClassName()+" Method name: "+arr[i].getMethodName()+" line number: "+arr[i].getLineNumber()+"]";
			}
			else if(arr[i].getClassName().contains("com.numberz") && !arr[i].getClassName().contains("com.numberz.test")){
				trace = trace+"[class name: "+arr[i].getClassName()+" Method name: "+arr[i].getMethodName()+" line number: "+arr[i].getLineNumber()+"]";
			}
		}
		try {

			logMessage(null, "clicked on ["+element.toString().split("-> ")[1]+" <span style='color:#C70039'>"+trace+"</span>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) 
	{
		//extentTest.log(LogStatus.INFO,"Typing into ["+element.toString().split("->")[1]);
	}


	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		//logMessage(script);
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		//extentTest.log(LogStatus.ERROR,"There is an error. The message is "+throwable.getMessage());		
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		//logMessage("");
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		//logMessage("");
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
		String trace="";
		StackTraceElement[] arr = Thread.currentThread().getStackTrace();
		for(int i=0;i<arr.length;i++){
			//System.out.println(arr[i]);
			if(arr[i].getClassName().contains("com.numberz.test")){
				trace = "[class name: "+arr[i].getClassName()+" Method name: "+arr[i].getMethodName()+" line number: "+arr[i].getLineNumber()+"]";
			}
			else if(arr[i].getClassName().contains("com.numberz") && !arr[i].getClassName().contains("com.numberz.test")){
				trace = trace+"[class name: "+arr[i].getClassName()+" Method name: "+arr[i].getMethodName()+" line number: "+arr[i].getLineNumber()+"]";
			}
		}
		//ExtentTestManager.getTest().log(LogStatus.INFO,"HTML","Typed <span style='color:#bbbbbb'>"+element.getAttribute("value")+"</span> into ["+element.toString().split("-> ")[1]+" <span style='color:#C70039'>"+trace+"</span>");

		logMessage("HTML","Typed <span style='color:#bbbbbb'>"+arg0.getAttribute("value")+"</span> into ["+arg0.toString().split("-> ")[1]+" <span style='color:#C70039'>"+trace+"</span>");
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		//logMessage("");
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
}
