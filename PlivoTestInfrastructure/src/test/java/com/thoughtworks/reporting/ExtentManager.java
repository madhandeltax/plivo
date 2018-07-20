package com.thoughtworks.reporting;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.variables.Var;

public class ExtentManager {

	public static ExtentReports reporter;
	public static Map<Long, String> threadToExtentTestMap = new HashMap<Long, String>();
	public static Map<String, ExtentTest> nameToTestMap = new HashMap<String, ExtentTest>();
	public static ExtentTest testReporter = ExtentManager.getTest();

	private synchronized static ExtentReports getExtentReport() {
		if (reporter == null) {
			// you can get the file name and other parameters here from a
			// config file or global variables
			reporter = new ExtentReports(Var.reportPath+"/Report.html", false);
			reporter.loadConfig(new File("config/extent-config.xml"));
		}
		return reporter;
	}

	public synchronized static ExtentTest getTest(String testName, String testDescription) {

		// if this test has already been created return
		if (!nameToTestMap.containsKey(testName)) {
			Long threadID = Thread.currentThread().getId();
			ExtentTest test = getExtentReport().startTest(testName, testDescription);
			nameToTestMap.put(testName, test);
			threadToExtentTestMap.put(threadID, testName);
		}
		return nameToTestMap.get(testName);
	}

	public synchronized static ExtentTest getTest(String testName) {
		return getTest(testName, "");
	}

	/*
	 * At any given instance there will be only one test running in a thread. We
	 * are already maintaining a thread to extentest map. This method should be
	 * used after some part of the code has already called getTest with proper
	 * testcase name and/or description.
	 * 
	 * Reason: This method is not for creating test but getting an existing test
	 * reporter. sometime you are in a utility function and want to log
	 * something from there. Utility function or similar code sections are not
	 * bound to a test hence we cannot get a reporter via test name, unless we
	 * pass test name in all method calls. Which will be an overhead and a rigid
	 * design. However, there is one common association which is the thread ID.
	 * When testng executes a test it puts it launches a new thread, assuming
	 * test level threading, all tests will have a unique thread id hence call
	 * to this function will return the right extent test to use
	 */
	public synchronized static ExtentTest getTest() {
		Long threadID = Thread.currentThread().getId();

		if (threadToExtentTestMap.containsKey(threadID)) {
			String testName = threadToExtentTestMap.get(threadID);
			return nameToTestMap.get(testName);
		}	
		//system log, this shouldnt happen but in this crazy times if it did happen log it.
		return null;
	}
	
	public static void log(String logLevel, String details) 
	{	
		try {

			ExtentTest testReporter = ExtentManager.getTest();
			
			if (logLevel == "info") testReporter.log(LogStatus.INFO, "HTML", details);		
			if (logLevel == "pass") testReporter.log(LogStatus.PASS,"HTML", details);		
			if (logLevel == "fail") testReporter.log(LogStatus.FAIL,"HTML", details);		
			if (logLevel == "warning") testReporter.log(LogStatus.WARNING,"HTML", details);
			if (logLevel == "fatal") testReporter.log(LogStatus.FATAL,"HTML", details);		
			if (logLevel == "skip") testReporter.log(LogStatus.SKIP,"HTML", details);		
			if (logLevel == "error") testReporter.log(LogStatus.ERROR,"HTML", details);
			if (logLevel == "unknown") testReporter.log(LogStatus.UNKNOWN,"HTML", details);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void logWithStepName(String logLevel, String stepName, String details) 
	{
		try {
			
			ExtentTest testReporter = ExtentManager.getTest();
			
			if (logLevel == "info") testReporter.log(LogStatus.INFO, stepName, details);		
			if (logLevel == "pass") testReporter.log(LogStatus.PASS, stepName, details);		
			if (logLevel == "fail") testReporter.log(LogStatus.FAIL, stepName, details);		
			if (logLevel == "warning") testReporter.log(LogStatus.WARNING, stepName, details);
			if (logLevel == "fatal") testReporter.log(LogStatus.FATAL, stepName, details);		
			if (logLevel == "skip") testReporter.log(LogStatus.SKIP, stepName, details);		
			if (logLevel == "error") testReporter.log(LogStatus.ERROR, stepName, details);
			if (logLevel == "unknown") testReporter.log(LogStatus.UNKNOWN, stepName, details);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void log(String logLevel, String details, String sanpshot) 
	{	
		try {

			ExtentTest testReporter = ExtentManager.getTest();
			
			if (logLevel == "info") testReporter.log(LogStatus.INFO, "HTML", details+" : "+ testReporter.addScreenCapture(sanpshot));		
			if (logLevel == "pass") testReporter.log(LogStatus.PASS, "HTML", details+"Snapshot : "+ testReporter.addScreenCapture(sanpshot));		
			if (logLevel == "fail") testReporter.log(LogStatus.FAIL, "HTML", details+"Snapshot : "+ testReporter.addScreenCapture(sanpshot));		
			if (logLevel == "warning") testReporter.log(LogStatus.WARNING, "HTML", details+"Snapshot : "+ testReporter.addScreenCapture(sanpshot));		
			if (logLevel == "fatal") testReporter.log(LogStatus.FATAL, "HTML", details+"Snapshot : "+ testReporter.addScreenCapture(sanpshot));		
			if (logLevel == "skip") testReporter.log(LogStatus.SKIP, "HTML", details+"Snapshot : "+ testReporter.addScreenCapture(sanpshot));		
			if (logLevel == "error") testReporter.log(LogStatus.ERROR, "HTML", details+"Snapshot : "+ testReporter.addScreenCapture(sanpshot));
			if (logLevel == "unknown") testReporter.log(LogStatus.UNKNOWN, "HTML", details+"Snapshot : "+ testReporter.addScreenCapture(sanpshot));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized static void closeTest(String testName) {

		if (!testName.isEmpty()) {
			ExtentTest test = getTest(testName);
			getExtentReport().endTest(test);
		}
	}

	public synchronized static void closeTest(ExtentTest test) {
		if (test != null) {
			getExtentReport().endTest(test);
		}
	}

	public synchronized static void closeTest()  {
		ExtentTest test = getTest();
		closeTest(test);
	}

	public synchronized static void closeReport() {
		if (reporter != null) {
			reporter.flush();
			reporter.close();
		}
	}

}
