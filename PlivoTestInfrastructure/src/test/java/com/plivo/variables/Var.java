package com.plivo.variables;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.plivo.configuration.ReadProperties;
import com.plivo.configuration.ReadTestData;

public class Var {
	
	public static ReadProperties rcp;
	public static ReadProperties rmp;
	public static ReadTestData rtd;
	public static String genericName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	
	public static String reportPath;
	public static String extentReportFilePath;
	public static String extentReportImagePath;// = "/reports/screenshots/extentReportImage.png";
	
	public static LinkedHashMap resultMap = new LinkedHashMap<Object, Object>();
	
	//public static ExecutorService executor = Executors.newFixedThreadPool(4);
	
	public static String dynamicName() 
	{	
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	}

}
