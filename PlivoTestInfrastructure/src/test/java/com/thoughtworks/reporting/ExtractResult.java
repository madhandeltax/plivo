package com.thoughtworks.reporting;

import java.io.BufferedReader;
import java.io.FileReader;

import com.thoughtworks.variables.Var;



public class ExtractResult {
		
	public static void execute() {
		
		try {	
					
	        BufferedReader br = new BufferedReader(new FileReader("test-output/testng-results.xml"));
	        String line, testName = null, result = null;
	         
	        while((line = br.readLine()) !=null){
	        	
	        	if(line.contains("<test name=")) {
	        		
	        		testName = line.substring(16, line.indexOf("\"", 16)); 
	        	}
	        	
	        	if(line.contains("<test-method status=")) {

		        	if(line.contains("PASS")) result = "PASSED";	
		        	else result = "FAILED";	
		        	
		        	Var.resultMap.put(testName, result);   
		        }	        	   	
	        }
	        br.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}  	
    }    
}
