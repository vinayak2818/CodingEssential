package frameworkDesign_Automation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageobjectfactory.Loginpage;
import pageobjectfactory.Product_to_cart;
import pageobjectfactory.Purchase;

public class Driverpage2 extends ConnectionProgram {
	
	
	@Test(dataProvider = "getdata_test")
	public void logintosubmit(HashMap<String, String> input) throws InterruptedException
	{
		
		Loginpage page=new Loginpage(driver);
		page.EnterName(input.get("name"));
		page.Selectgender(input.get("gender"));
		page.setCountrySelection(input.get("Country"));
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
	
	}
	
	@DataProvider
	public Object[][] getdata_test() throws IOException
	{
		
		List<HashMap<String, String>>	data = getJsonData("E:\\GitRepository\\CurrentWorkSpace\\ExampleAugust26th2022Repository\\MobileAutomation_FrameworkDesign\\eCommerce.json");
		//return new Object[][] {{"Vinayak","male","Argentina"},{"Nikhita","female","Angola"}};
		return new Object[][] { {data.get(0)},{data.get(1)}  };
	}
	
	public void Configdemo()
	{
		ExtentReports extent;
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
