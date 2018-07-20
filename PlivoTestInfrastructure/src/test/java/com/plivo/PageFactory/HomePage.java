package com.plivo.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	
	@FindBy(id="//search")
	WebElement search;
	
	@FindBy(xpath="//div[text()='C']")
	WebElement itemC;
	
	@FindBy(xpath="//div[text()='C']/div")
	WebElement addButtonOnC;
	
	@FindBy(id="checkout")
    WebElement checkout;
	
	
	//Initialize Pagefactory
	public HomePage(WebDriver driver)
	{
		this.driver = driver; 
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Verify Home page load
	public boolean verifyHomePageLoad()
	{		
		return  verifyElementPresent(search);
	}
	
	//Verify item C load
	public boolean verifyItemCLoad()
	{		
		return  verifyElementPresent(itemC);
	}
	
	//Add Item C
	public void addItemC()
	{
		 click(addButtonOnC);
	}
	
	//Hit Checkout
	public void hitCheckout()
	{
		 click(checkout);
	}
		
}