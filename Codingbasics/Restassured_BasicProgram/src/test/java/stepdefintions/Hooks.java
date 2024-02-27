package stepdefintions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {


	@Before("@DeleteAPI")
	public void beforescenario() throws IOException
	{
		Step_defintions sd=new Step_defintions();
		if(Step_defintions.place_id==null)
		{
		
		sd.add_place_payload_with("Vinayak","Gadag", "hindi", "+9199399993");
		sd.user_calls_with_post_http_request("AddplaceAPI", "POST");
		sd.verify_place_id_cfeated_maps_to_using("Vinayak", "getplaceAPI");
		}
	}
}
