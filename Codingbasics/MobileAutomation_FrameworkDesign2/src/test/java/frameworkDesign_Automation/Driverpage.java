package frameworkDesign_Automation;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageobjectfactory.Loginpage;
import pageobjectfactory.Product_to_cart;
import pageobjectfactory.Purchase;

public class Driverpage extends ConnectionProgram {
	
	ExtentReports extent;
	@Test(dataProvider = "getdata")
	public void logintosubmit(String name,String gender,String Country) throws InterruptedException
	{
		extent.createTest("Demo Test");
		Loginpage page=new Loginpage(driver);
		page.EnterName(name);
		page.Selectgender(gender);
		page.setCountrySelection(Country);
		page.SubmitShopbutton();
		Product_to_cart prod=new Product_to_cart(driver);
		prod.Addtocart(0);
		prod.Addtocart(0);
		prod.GotoCart();
		Purchase pur=new Purchase(driver);
		double totalSum = pur.getProductsSum();
		double displayFormattedSum = pur.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		pur.TermsandCondition();	
		pur.FinalSubmit();
		extent.flush();
	}
	@DataProvider
	public Object[][] getdata()
	{
		return new Object[][] {{"Vinayak","male","Argentina"},{"Nikhita","female","Angola"}};
	}
	
	@BeforeTest
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
