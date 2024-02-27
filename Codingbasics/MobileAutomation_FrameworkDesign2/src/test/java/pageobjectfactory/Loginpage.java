package pageobjectfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Android_Gestures;

public class Loginpage extends Android_Gestures {
	AndroidDriver driver;
	public Loginpage(AndroidDriver driver)
	{
		//Explanation in Section 16-79(udemy)
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nikhita");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement NameField;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femalebutton;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
		private WebElement malebutton;
		
		//driver.findElement(By.id("android:id/text1"))
		@AndroidFindBy(id="android:id/text1")
		private WebElement Countryselection;
		
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))
		@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
		private WebElement Shopbutton;
	
	public void EnterName(String name)
	{
		NameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void Selectgender(String gender)
	{
		if(gender.contains("Female"))
		{
			femalebutton.click();
		}else
		{
			malebutton.click();
		}
	}
	
	public void setCountrySelection(String countryname)
	{
		Countryselection.click();
		scrollToText(countryname);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryname+"']")).click();
		
	}
	
	public void SubmitShopbutton()
	{
		Shopbutton.click();
	}
	
	
}
