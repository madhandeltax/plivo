package com.plivo.test;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.plivo.PageFactory.CartPage;
import com.plivo.PageFactory.HomePage;
import com.plivo.PageFactory.LoginPage;
import com.plivo.dataProvider.TestDataProviderSource;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class VerifyPricingAndRate extends BaseClass {
	
	boolean firstTime = true;

	@BeforeClass
	public void preCondition()
	{	
		//CartPageObject = new CartPage(driver);
	}	
	
	@Test(description = "Cart screen")
	public void cart()
	{	
		assertTrue(totalRate.equals(outboundRate));
		
		if(!totalRate.equals(outboundRate)) {
			org.testng.Assert.fail("totalRate is not equal to outboundRate");
		}
		
	}
	
	public void validation()
	{	

	}
}
