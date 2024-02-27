package resources_test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification rs;
	public  RequestSpecification Requestspecifications() throws IOException
	
	{
		if(rs==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
				
		rs=new RequestSpecBuilder().setBaseUri(getbaseurl("baseURI")).addQueryParam("key","qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON).build();
		return rs;
		}
		return rs;
	}
	
	public static String getbaseurl(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fin=new FileInputStream("E:\\GitRepo\\CurrentWorkspace\\Codingbasics\\Restassured_BasicProgram\\resources\\Pproperties\\global.properties");
		prop.load(fin);
	
		return prop.getProperty(key);		
	
	}
	
	public String getJsonpath(Response response,String key)
	{
		String respstat=response.asString();
		JsonPath  js=new JsonPath(respstat);
		return js.get(key).toString();
	}
}
