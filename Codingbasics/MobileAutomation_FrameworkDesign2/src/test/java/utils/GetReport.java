package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GetReport {
	static ExtentReports extent;
	public static  ExtentReports Configdemo()
	{
		//ExtentReports . ExtentSparkREporter
		String path=System.getProperty("user.dir")+"\\reports\\indes.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("MobileAutomation_Results");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Vinayak");
		return extent;
	}
}
