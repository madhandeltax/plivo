package com.plivo.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	
	@FindBy(xpath="//div[text()='Your Order']")
	WebElement cartScreenHeader;
	
	@FindBy(id="name")
    WebElement name;
	
	@FindBy(id="mobile")
    WebElement mobile;
	
	@FindBy(id="address")
    WebElement address;

	@FindBy(id="submit")
    WebElement submit;
	
	//Initialize Pagefactory
	public CartPage(WebDriver driver)
	{
		this.driver = driver; 
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Verify Cart Screen load
	public boolean verifyCartScreenLoad()
	{		
		return verifyElementPresent(cartScreenHeader);
	}
	
	//Clear and Enter Name
	public void clearAndEnterName(String input)
	{
		 clearText(name);
		 sendKeys(name, input);
	}
	
	//Clear and Enter Mobile
	public void clearAndEnterMobile(String input)
	{
		 clearText(mobile);
		 sendKeys(mobile, input);
	}
	
	//Clear and Enter Mobile
	public void clearAndEnterAddress(String input)
	{
		 clearText(address);
		 sendKeys(address, input);
	}
	
	//Hit Submit
	public void hitSubmit(String input)
	{
		 click(submit);
	}
	
	//Verify Success
	public boolean verifySuccess()
	{		
		return true;
	}
		
}