package resources_test;

public enum API_Resource {

	
	AddplaceAPI("/maps/api/place/add/json"),
	getplaceAPI("/maps/api/place/get/json"),
	deleteplaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	API_Resource(String resource)
	{
		this.resource=resource;
	}
	
	public String getresource()
	{
		return resource;
	}
	
}
