package frameworkDesign_Automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.AppiumUtils;

public class ConnectionProgram extends AppiumUtils{

	AndroidDriver driver;
	@BeforeClass
	public void Desiredcapabilitiesprogram() throws MalformedURLException
	{
		DesiredCapabilities capabilty=new DesiredCapabilities();

		/*capabilty.setCapability("platformName", "Android");
		capabilty.setCapability("platformVersion", "12");
		capabilty.setCapability("deviceName", "15e0c279");
		capabilty.setCapability("appPackage", "com.androidsample.generalstore");
		capabilty.setCapability("appActivity", "com.androidsample.generalstore.MainActivity");*/
		
		
		capabilty.setCapability("platformName", "Android");
		capabilty.setCapability("platformVersion", "10");
		capabilty.setCapability("deviceName", "bc8ec434");
		capabilty.setCapability("appPackage", "com.androidsample.generalstore");
		capabilty.setCapability("appActivity", "com.androidsample.generalstore.MainActivity");
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilty);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		UiAutomator2Options options=new UiAutomator2Options();
		options.setChromedriverExecutable("E:\\Mobile_Automation\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
	}
	@BeforeMethod
	public void SetupActivity()
	{
		
		Activity act=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		driver.startActivity(act);
		
	
	}
	
	

}



