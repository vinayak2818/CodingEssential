package pageobjectfactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Android_Gestures;

public class Product_to_cart extends Android_Gestures {
	AndroidDriver driver;
	public Product_to_cart(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> Addtocart;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement Clickoncart;
		
	public void Addtocart(int index)
	{
		Addtocart.get(index).click();
	}
	
	public void GotoCart()
	{
		Clickoncart.click();
	}
	
	

}
