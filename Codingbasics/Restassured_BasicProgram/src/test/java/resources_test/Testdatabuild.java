package resources_test;

import java.util.ArrayList;
import java.util.List;

import pojo.Get_Maps;
import pojo.Location;

public class Testdatabuild {
	
	public Get_Maps Testdata(String name,String address,String language,String phone_number)
	{
		Get_Maps m=new Get_Maps();
		m.setAccuracy(50);
		m.setName(name);
		m.setPhone_number(phone_number);
		m.setAddress(address);
		m.setLanguage(language);
		m.setWebsite("https://www.rahulshettyacademy.com/");
		List<String> mylist=new ArrayList<>();
		mylist.add("Shoe park");
		mylist.add("shop");
		m.setTypes(mylist);		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);		
		m.setLocation(l);
		
		return m;
	}
	
	public String deleteplacepayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}\r\n";
	}

}
