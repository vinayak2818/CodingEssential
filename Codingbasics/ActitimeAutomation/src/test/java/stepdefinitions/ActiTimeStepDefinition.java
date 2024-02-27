package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import utility.ApplicationDependent;
import utility.ApplicationIndependent;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActiTimeStepDefinition {
	public static WebDriver oBrowser=null;
	public static String firstname=null;
	public static String lastname=null;
	public static ActiTimePages actiTimePage=null;
	
	public static Logger log=LogManager.getLogger(ActiTimeStepDefinition.class);

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Given("^Launch the application$")
	public void Launch_the_application()
	{
		try
		{
			log.info("Launch the application");
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			oBrowser=new ChromeDriver(options);
			actiTimePage=new ActiTimePages(oBrowser);
			ApplicationIndependent.waitFor(2L);
			log.info("The Application has launched successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Launch Application "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@And("^Navigate to the url of the application$")
	public void Navigate_to_the_url_of_the_application()
	{
		try
		{
			log.info("Navigate to the url of the application");
			oBrowser.get("http://localhost:81/login.do");
			ApplicationIndependent.waitFor(5L);
			ApplicationDependent.getScreenshot(oBrowser, "E:\\EXAMPLE\\ActTime.jpg");
			log.info("Navigate to the url of the application has performed successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Navigate_to_the_url_of_the_application "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Login using valid credentials$")
	public void Login_using_valid_credentials(DataTable credentials)
	{  
		try
		{
			log.info("Login using valid credentials");
			List<Map<String,String>> data=credentials.asMaps(String.class, String.class);
			for (int i=0;i<data.size();i++)
			{
				actiTimePage.getUserName().sendKeys(data.get(i).get("username"));
				actiTimePage.getPassword().sendKeys(data.get(i).get("password"));
				actiTimePage.getLoginBtn().click();
				ApplicationIndependent.waitFor(5L);
			}
			log.info("Login using valid credentials by providing valid credentails");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Login_using_valid_credentials "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^the Home page should display$")
	public void the_Home_page_should_display()
	{
		try
		{
			log.info("the Home page should display");
			Assert.assertTrue(ApplicationDependent.isObjectPresent(oBrowser,By.xpath("//td[text()='Enter Time-Track']")));
			ApplicationIndependent.waitFor(2L);
			log.info("The Validation of Display of Home Page has matched successfulyy");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of the_Home_page_should_display "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Perform logout action$")
	public void Perform_logout_action()
	{
		try
		{
			log.info("Perform logout action");
			actiTimePage.getLogoutLink().click();
			ApplicationIndependent.waitFor(2L);
			log.info("Performing logout action has done successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Perform_logout_action "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^the login page should display$")
	public void the_login_page_should_display()
	{
		String expected,actual;
		try
		{
			log.info("the login page should display");
			expected="actiTIME - Login";
			actual=oBrowser.getTitle();
			ApplicationIndependent.waitFor(2L);
			Assert.assertEquals(expected, actual);
			log.info("Validation of login page display");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of the_login_page_should_display "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@And("^Close Application Browser$")
	public void Close_Application_Browser()
	{
		try
		{
			log.info("Close Application Browser");
			oBrowser.close();
			log.info("Close Application has done succesfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Close_Application_Browser "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Create an User$")
	public void Create_an_User(DataTable userdetails)
	{
		try
		{
			log.info("Create an User");
			List<Map<String,String>> data=userdetails.asMaps(String.class, String.class);
			firstname=data.get(0).get("firstname");
			lastname=data.get(0).get("lastname");
			String email=data.get(0).get("email");
			String username=data.get(0).get("username");
			String password=data.get(0).get("userpassword");
			String repassword=data.get(0).get("userretypepasword");

			oBrowser.findElement(By.xpath("html/body/div[4]/table/tbody/tr[1]/td[5]/a/div[2]")).click();
			ApplicationIndependent.waitFor(5L);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			ApplicationIndependent.waitFor(5L);
			oBrowser.findElement(By.name("firstName")).sendKeys(firstname);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("lastName")).sendKeys(lastname);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("email")).sendKeys(email);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("username")).sendKeys(username);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("password")).sendKeys(password);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(repassword);
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.xpath(".//*[@id='userDataLightBox_commitBtn']/div/span")).click();
			ApplicationIndependent.waitFor(5L);
			log.info("Create an User action has performed successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Create_an_User "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^User should create successfully$")
	public void User_should_create_successfully()
	{
		String expected;
		try
		{
			log.info("User should create successfully");
			expected=lastname+","+" "+firstname;
			WebElement oUser=oBrowser.findElement(By.xpath("//span[text()='"+expected+"']"));
			Assert.assertTrue(oUser.isDisplayed());
			log.info("Validation of User Creation has performed successfully ");

		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of User_should_create_successfully "+e);
		}
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^delete the user$")
	public void delete_the_user()
	{
		String username;
		try
		{
			log.info("delete the user");
			username=lastname+","+" "+firstname;
			oBrowser.findElement(By.xpath("//span[text()='"+username+"']")).click();
			ApplicationIndependent.waitFor(2L);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			ApplicationIndependent.waitFor(2L);
			Alert alert=oBrowser.switchTo().alert();
			alert.accept();
			ApplicationIndependent.waitFor(2L);
			log.info("delete the user step has performed successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of delete_the_user "+e);
		}
	}

	/**
	 * Created By:
	 * Created Date:
	 * Description:
	 */
	@Then("^the user should delete$")
	public void the_user_should_delete()
	{
		String expected,actual;
		try
		{
			log.info("the user should delete");
			expected="actiTIME - User List";
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
			log.info("the user should delete, action has performed successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of the_user_should_delete "+e);
		}
	}

	/**
	 * Created By:
	 * Created Date:
	 * Description:
	 */
	@Given("^connect to Oracle Database$")
	public void connect_to_Oracle_Database()
	{
		System.out.println("Connect to Oracle Datbase 11g !!!");
	}

	/**
	 * Created By:
	 * Created Date:
	 * Description:
	 */
	@And("^Fetch records from Database$")
	public void fetch_records_from_database()
	{
		System.out.println("Fetch records from Database !!!");
	}

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@Then("^minimize the flyout Window$")
	public void minimize_the_flyout_Window()
	{
		try
		{
			log.info("minimize the flyout Window");
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			ApplicationIndependent.waitFor(2L);
			log.info("minimize the flyout Window has performed successfully");
		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of minimize_the_flyout_Window "+e);
		}
	}
	

	/**
	 * Author:
	 * Reviewed By:
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	@When("^Login using (.*) and (.*) credentials$")
	public void Login_using_valid_credentials_new(String username,String password)
	{  
		try
		{
			actiTimePage.getUserName().sendKeys(username);
			actiTimePage.getPassword().sendKeys(password);
			actiTimePage.getLoginBtn().click();
			ApplicationIndependent.waitFor(4L);

		}catch(Exception e)
		{
			log.error("There is an error occurance during the execution of Login_using_valid_credentials_new "+e);
		}
	}
}
