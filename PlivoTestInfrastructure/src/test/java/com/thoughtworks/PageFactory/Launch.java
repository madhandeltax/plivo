package com.thoughtworks.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Launch extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	
	public Launch(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver lauchBrowser(String browserType) 
	{	
		driver =  setupDriver(driver, browserType);
		 lauchBrowser(driver);		
		return driver;
	}
	
	//Opening a praticular URL
	public void openPage(String url){

		 openPage(driver, url);	
	}
	
	
	//Switch to a browser tab
	public void closeCurrentBrowserTab(){

		 closeActiveBrowserTab(driver);	
	}
	
	//Refresh browser page
	public void refreshPage()
	{
		 refreshPage(driver);
	}

    public void waitForSometime(int timeInSeconds) 
	{
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
	
}
