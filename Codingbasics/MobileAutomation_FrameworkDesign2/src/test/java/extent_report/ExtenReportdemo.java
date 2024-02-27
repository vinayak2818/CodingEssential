package extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import frameworkDesign_Automation.ConnectionProgram;

public class ExtenReportdemo extends ConnectionProgram {
	ExtentReports extent;
	
	public void Configdemo()
	{
		//ExtentReports . ExtentSparkREporter
		String path=System.getProperty("user.dir")+"\\reports\\indes.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("MobileAutomation_Results");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Vinayak");
	}

}
