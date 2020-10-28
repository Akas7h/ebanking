package com.ebanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	private static ExtentReports extent;

	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir")+"\\Screenshots\\index.html" ;
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Akash Bhattacharjee");
		return extent;
	}

}
