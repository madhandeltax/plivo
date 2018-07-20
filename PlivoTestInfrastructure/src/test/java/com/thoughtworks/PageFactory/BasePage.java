package com.thoughtworks.PageFactory;

import java.awt.Toolkit;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.functions.MyEventListener;
import com.thoughtworks.variables.Var;

public class BasePage {	
	
	public static WebDriver driver;
	public static WebElement element;
	public static Action action;
	public static MyEventListener eventListener;
	public static EventFiringWebDriver edriver;
	
	
	//Launching browser instance
	@SuppressWarnings("deprecation")
	public static WebDriver setupDriver(WebDriver driver, String browserType){
			
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		
		if(Var.rcp.prop.getProperty("headless").equals("true") ) chromeOptions.put("args", Arrays.asList("headless"));
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);
		
		edriver = new EventFiringWebDriver(driver);
		
		eventListener = new MyEventListener();

		edriver.register(eventListener);
		
		return edriver;
	}	
	
	//Launching browser instance
	public static void lauchBrowser(WebDriver driver){

		BasePage.maximizeScreen(driver);
	    	driver.manage().timeouts().implicitlyWait(Long.parseLong(Var.rcp.prop.getProperty("implicitwait")), TimeUnit.SECONDS);
	}	
	
	//Maximize browser workaround on mac
	public static void maximizeScreen(WebDriver driver) {
		
	    java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Point position = new Point(0, 0);
	    driver.manage().window().setPosition(position);
	    Dimension maximizedScreenSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
	    driver.manage().window().setSize(maximizedScreenSize);
	}
	
	//Opening a praticular URL
	public static void openPage(WebDriver driver, String url){

		driver.get(url);
	}
	
	
	//Close the current active tab on the same browser window
	public static void closeActiveBrowserTab(WebDriver driver)
	{		
		driver.close();		
	}
	
	//Clearing any field
	public static void clearText(WebElement we)
	{	
		we.clear();
	}
	
	
	//Typing in a text field
	public static void sendKeys(WebElement we, String input){
		
		//we.sendKeys(Keys.chord(Keys.COMMAND, "a"), input);
		we.sendKeys(input);	
	}
	
	//Typing in a text field
	public static void sendKeys(WebDriver driver, WebElement we, String input)
	{	
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.click();
		actions.sendKeys(input);
		actions.build().perform();
	}
	
	//Typing in a text field
	public static void sendKeysAction(WebElement we, String input) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.sendKeys(input);
		actions.build().perform();
	}
	
	//Clear the Text field
	public static void clear(WebElement we){
		
		we.clear();
	}

	//Click via ID reference
	public static void click(WebElement we){
		
		we.click();
	}
	
	//Click
	public static void click(WebDriver driver, WebElement we){

		Actions action= new Actions(driver);
		action.moveToElement(we).perform();
		//action.contextClick(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ESCAPE).sendKeys(Keys.ENTER).build().perform();	
		action.click(we).build().perform();	
	}
	
	//Select from dropdown
	public static void  selectFromDropDown(WebElement we, int index) 
	{
		Select dropDownBox = new Select(we);
		dropDownBox.selectByIndex(index);
	}
	
	//Verify text on the page
	public static boolean verifyText(String text){

		if(driver.getPageSource().contains(text)) return true;
			return false;		
	}
	
	//Wait for a specified time period
	public static void waitPeriod(int time){
		
		long l = time * 1000;
		
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//verify if xpath is present
	public static boolean verifyElementPresent(WebElement we)
	{
		boolean result = false;
		
		try{
		if(we.isDisplayed()) {
			result = true;
		} 
		}catch(NoSuchElementException e) 
		{
			return result;
		}

		return result;
	}
	
	//verify text of element
	public static boolean verifyTextOfElement(WebElement we, String text)
	{	
		return we.getText().contains(text);
	}
	
	//verify if element is visible
	public static boolean verifyElementVisible(WebElement we)
	{
		boolean result = false;
		if(ExpectedConditions.visibilityOf(we) != null) {
			result = true;
		} 

		return result;
	}
	
	//verify if element is visible
	public static boolean waitTillElementVisible(WebDriver driver, WebElement we)
	{
		boolean result = false;
		
		WebDriverWait wait = new WebDriverWait(driver,Long.parseLong(Var.rcp.prop.getProperty("implicitwait")));
	    
		wait.until(ExpectedConditions.visibilityOf(we));   
		
		if(wait.until(ExpectedConditions.visibilityOf(we)) != null) {
			result = true;
		} 

		return result;
	}
	
	//verify if element is visible
	public static boolean waitTillElementVisible(WebDriver driver, WebElement we, int time)
	{
		boolean result = false;
		
		try {
			
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, time);
	    
		wait.until(ExpectedConditions.visibilityOf(we));   
		
		if(wait.until(ExpectedConditions.visibilityOf(we)) != null) {
			result = true;
		} 
		
		}catch(TimeoutException e)
		{
			result = false;
		}

		driver.manage().timeouts().implicitlyWait(Long.parseLong(Var.rcp.prop.getProperty("implicitwait")), TimeUnit.SECONDS);
		
		return result;
	}
	
	//verify if element is invisible
	public static boolean waitTillElementInvisible(WebDriver driver, WebElement we)
	{
		boolean result = false;
		
		WebDriverWait wait = new WebDriverWait(driver,Long.parseLong(Var.rcp.prop.getProperty("implicitwait")));
		
		wait.until(ExpectedConditions.invisibilityOf(we));
		
		if(wait.until(ExpectedConditions.invisibilityOf(we)) != null) {
			
			result = true;
		} 

		return result;
	}
	
	//Refresh the browser page
	public static void refreshPage(WebDriver driver){
			
		driver.navigate().refresh();
	}
		
	//Navigate to URL
	public static void goToUrl(String url){
				
		driver.navigate().to(url);
	}
	
	//Close the browser instance
	public static void closeBrowser(){
		
		driver.close();
	}
	
    public static String takeSnapShot(WebDriver driver, String filePath, String fileName) {
    	
    		//takeSnapShot(driver, "c://test.png") ; 
    	
        //Convert web driver object to TakeScreenshot

    			TakesScreenshot scrShot = ((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

             File DestFile=new File(filePath+"/"+fileName+".jpg");

             //Copy file at destination
             
             try {

			 FileUtils.copyFile(SrcFile, DestFile);
			 
			} catch (Exception e) {
				
				e.printStackTrace();
			}
    		
    			return DestFile.getAbsolutePath();
    		}

}