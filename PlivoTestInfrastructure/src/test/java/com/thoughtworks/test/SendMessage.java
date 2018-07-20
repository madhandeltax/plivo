package com.thoughtworks.test;

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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.PageFactory.CartPage;
import com.thoughtworks.PageFactory.HomePage;
import com.thoughtworks.PageFactory.LoginPage;
import com.thoughtworks.dataProvider.TestDataProviderSource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class SendMessage extends BaseClass {
	
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
			
			List <NameValuePair> nameValuePairs = new ArrayList <NameValuePair> ();
            nameValuePairs.add(new BasicNameValuePair("src", firstNumber));
            nameValuePairs.add(new BasicNameValuePair("dst", secondNumber));
            nameValuePairs.add(new BasicNameValuePair("text", "Hi, this is a message!"));
            
            HttpPost post = new HttpPost("https://api.plivo.com/v1/Account/MAODUZYTQ0Y2FMYJBLOW/Message/");
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			response = client.execute(post);
			
			
            
 
            //response = client.execute(post);
			 
			int statusCode = response.getStatusLine().getStatusCode();
			
			System.out.println(statusCode);
			
			HttpEntity entity = response.getEntity();

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity);
            System.out.println(content);
            
            JsonReader reader = Json.createReader(new StringReader(content));
            
            JsonObject completeObject = reader.readObject();
            
            JsonArray jsonarray = completeObject.getJsonArray("message_uuid");
            
            messageUUID = jsonarray.get(0).toString().replaceAll("\"", "");
            
            System.out.println("UUId   : " + messageUUID);
             
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
