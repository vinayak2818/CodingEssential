package utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.imageio.ImageIO;

public class ApplicationIndependent {
	
	
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
	public static void waitFor(long seconds)
	{
		long miliseconds;
		try
		{
			miliseconds=seconds*1000;
			Thread.sleep(miliseconds);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Modified By:
	 * Reviewed By:
	 * Parameters:
	 * Return Type:
	 * Purpose:
	 * Description:
	 */
	public static Properties properties(String FilePath)
	{
		Properties prop=null;
		FileInputStream fin=null;
		try
		{
			prop=new Properties();
			fin=new FileInputStream(FilePath);
			prop.load(fin);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return prop;
	}

	/**
	 * Created By:
	 * Created Date:
	 * Modified By:
	 * Reviewed By:
	 * Parameters:
	 * Return Type:
	 * Purpose:
	 * Description:
	 */
	public static String getReportConfigPath()
	{
		String reportConfigPath=null;
		try
		{
			 String path=System.getProperty("user.dir");
			 Properties properties1 = properties(path+"\\Configs\\Configuration.properties");
			 reportConfigPath=properties1.getProperty("reportConfigPath");
			 if(reportConfigPath!= null) return reportConfigPath;
			 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return reportConfigPath;
	}

}
