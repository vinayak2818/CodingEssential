package utility;

import java.io.File;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.*;
public class ApplicationDependent {
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	public static boolean isObjectPresent(WebDriver oBrowser,By by)
	{
		boolean status=false;
		try
		{
			oBrowser.findElement(by);
			status=true;
		}catch(Exception e)
		{
			status=false;
		}
		return status;
	}

	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	public static boolean isAlertPresent(WebDriver oBrowser)
	{
		boolean status=false;
		try
		{
			oBrowser.switchTo().alert();
			status=true;
		}catch(Exception e)
		{
			status=false;
		}
		return status;
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Reviewed Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 * Purpose:
	 */
	public static void getScreenshot(WebDriver oBrowser,String destFileName)
	{
		try
		{
			TakesScreenshot obj=(TakesScreenshot) oBrowser;
			File sourceFile=obj.getScreenshotAs(OutputType.FILE);
			
			File destinationFile=new File(destFileName);
			org.apache.commons.io.FileUtils.copyFile(sourceFile, destinationFile);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
}
