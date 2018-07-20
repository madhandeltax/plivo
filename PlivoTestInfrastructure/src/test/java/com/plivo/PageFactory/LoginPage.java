package com.plivo.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	
	@FindBy(xpath="//small[text()='MySiteXYZ']")
	WebElement loginFormHeader;
	
	@FindBy(id="username")
    WebElement userName;
	
	@FindBy(id="password")
    WebElement password;
	
	@FindBy(id="captcha")
    WebElement captcha;
	
	@FindBy(id="login")
	WebElement login;
	
	
	//Initialize Pagefactory
	public LoginPage(WebDriver driver)
	{
		this.driver = driver; 
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Verify Login page load
	public boolean verifyLoginPageLoad()
	{		
		return  verifyElementPresent(loginFormHeader);
	}
	
	//Clear and Enter User Name
	public void clearAndEnterUserName(String input)
	{
		 clearText(userName);
		 sendKeys(userName, input);
	}
	
	//Clear and Enter Password
	public void clearAndEnterPassword(String input)
	{
		 clearText(password);
		 sendKeys(password, input);
	}
	
	//Clear and Enter Captcha
	public void clearAndEnterCaptcha(String input)
	{
		 clearText(captcha);
		 sendKeys(captcha, input);
	}
	
	//Hit Login
	public void hitLogin(String input)
	{
		 click(login);
	}
	
}