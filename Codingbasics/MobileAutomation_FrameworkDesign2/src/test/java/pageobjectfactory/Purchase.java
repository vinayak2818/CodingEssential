package pageobjectfactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Android_Gestures;

public class Purchase extends Android_Gestures{
	public AndroidDriver driver;
	public Purchase(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	//driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement TermsandCondition;
	
	//driver.findElement(By.id("android:id/button1"))
	@AndroidFindBy(id="android:id/button1")
	private WebElement TermsandConditionclosebutton;
	
	//driver.findElement(By.className("android.widget.CheckBox"))
	@AndroidFindBy(className ="android.widget.CheckBox")
	private WebElement Checkbox;
	
	
	//	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement SubmitButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")
	private List<WebElement> Pricelist;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']")
	private WebElement totalAmount;
	
	public void TermsandCondition()
	{
		longPressAction(TermsandCondition);
		TermsandConditionclosebutton.click();
	}
	
	
	
	public void FinalSubmit()
	{
		Checkbox.click();
		SubmitButton.click();
		
	}
	
	public List<WebElement> getProductList()
	{
		
		return Pricelist;
	}
	
	public double getProductsSum()
	{
		int count = Pricelist.size();
		double totalSum =0;
		for(int i =0; i< count; i++)
		{
			String amountString =Pricelist.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;  //160.97 + 120 =280.97
				
		}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed()
	{
		return getFormattedAmount(totalAmount.getText());
	}
	
	
	
	
	
}
