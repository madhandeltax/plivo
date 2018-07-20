package com.plivo.configuration;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	public Properties prop;
	
	public void readProp(String filePath) {
		
		//Initializing properties
		
		prop = new Properties();
		InputStream configInput = null;

		try {			
						
			configInput = new FileInputStream(filePath);
			prop.load(configInput);	
			
		} catch (Exception e) {

					e.printStackTrace();
		}  	
    }
}