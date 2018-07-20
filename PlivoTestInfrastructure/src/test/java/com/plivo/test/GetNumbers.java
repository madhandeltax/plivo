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

public class GetNumbers extends BaseClass {
	
	boolean firstTime = true;

	@BeforeClass
	public void preCondition()
	{	
		//CartPageObject = new CartPage(driver);
	}	
	
	@Test(description = "Cart screen")
	public void cart()
	{	
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("MAODUZYTQ0Y2FMYJBLOW", "Mzk0MzU1Mzc3MTc1MTEyMGU2M2RlYTIwN2UyMzk1");
		provider.setCredentials(AuthScope.ANY, credentials);
		  
		HttpClient client = HttpClientBuilder.create()
		  .setDefaultCredentialsProvider(provider)
		  .build();
		 
		HttpResponse response;
		try {
			response = client.execute(
			  new HttpGet("https://api.plivo.com/v1/Account/MAODUZYTQ0Y2FMYJBLOW/Number/"));
			
			int statusCode = response.getStatusLine().getStatusCode();
			
			System.out.println(statusCode);
			
			HttpEntity entity = response.getEntity();

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity);
            System.out.println(content);
            
            JsonReader reader = Json.createReader(new StringReader(content));
            
            JsonObject completeObject = reader.readObject();
            
            JsonArray jsonarray = completeObject.getJsonArray("objects");
            
            JsonObject firstObject = jsonarray.getJsonObject(0);
            
            firstNumber = firstObject.getString("number");
            
            JsonObject secondObject = jsonarray.getJsonObject(1);
            
            secondNumber = secondObject.getString("number");

            reader.close();
            
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
		//assertThat(statusCode, equalTo(HttpStatus.SC_OK));
		
	}
	
	public void validation()
	{	

	}
}
