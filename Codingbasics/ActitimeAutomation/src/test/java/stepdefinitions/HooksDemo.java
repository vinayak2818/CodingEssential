package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksDemo {

	@Before
	public void connectDB()
	{
		System.out.println("Before Execution of Each Scenario, The DB connection should be successful!!");
	}
	
	@After
	public void disConnectDB()
	{
		System.out.println("After Execution of Each Scenario, The DB connection should be disconnected!!");
	}
	

}
