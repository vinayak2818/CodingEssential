package driverScript;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/FeatureFiles",
					plugin="json:target/JsonReports/cucmber-report.json",
					glue={"stepdefintions"})


public class Driver_Script {

} 
