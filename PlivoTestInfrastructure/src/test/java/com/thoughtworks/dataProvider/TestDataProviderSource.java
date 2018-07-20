package com.thoughtworks.dataProvider;

import org.testng.annotations.DataProvider;

public class TestDataProviderSource {
	
	public static Object[][] launchTestData, loginTestData, cartTestData;
	
	 @DataProvider
	 public static Object[][] launchDataProvider() 
	 {	 
		 return launchTestData;
	 }
	 
	 @DataProvider
	 public static Object[][] loginDataProvider() 
	 {	 
		 return loginTestData;
	 }
	 
	 @DataProvider
	 public static Object[][] cartDataProvider() 
	 {	 
		 return cartTestData;
	 }
	 
}