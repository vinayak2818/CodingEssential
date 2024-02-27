package stepdefintions;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources_test.API_Resource;
import resources_test.Testdatabuild;
import resources_test.Utils;

public class Step_defintions extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	static String place_id;

	Testdatabuild m=new Testdatabuild();


	@Given("Add Place payload with {string} {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String language, String phone_number) throws IOException {


		res=given().spec(Requestspecifications()).body(m.Testdata(name, address, language, phone_number));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resorce,String method) {
		API_Resource resource=	API_Resource.valueOf(resorce);
		System.out.println(resource.getresource());

		resspec=  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if(method.equalsIgnoreCase("POST"))
			resp=res.when().post(resource.getresource());
		else if(method.equalsIgnoreCase("GET"))
			resp=res.when().get(resource.getresource());

	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(resp.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {

		assertEquals(getJsonpath(resp, string),string2);

	}

	@Then("verify place_ID cfeated maps to {string} using {string}")
	public void verify_place_id_cfeated_maps_to_using(String string, String string2) throws IOException {
	 place_id=getJsonpath(resp,"place_id");
		res=given().spec(Requestspecifications()).queryParam("place_id", place_id);
		user_calls_with_post_http_request(string2, "GET");
		String name=getJsonpath(resp,"name");
		assertEquals(name, string);
	}
	
	@Given("Deleteplace Payload")
	public void deleteplace_payload() throws IOException {
	  res=given().spec(Requestspecifications()).body(m.deleteplacepayload(place_id));
	  
	}

}
