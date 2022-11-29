package ai.ds.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import ai.ds.testBase.TestBase;

public class UtilClass extends TestBase{
	
	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}
	
	//screenshot
	public static void takeScreenShot(String filename) 
	{
		String path = "C:\\Users\\232338\\eclipse-workspace\\18JuneMBDalalStrreet\\sceenshots\\";
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			System.out.println("Exception found please check");
			e.printStackTrace();
		}	
	}
	
	public static String getDateAndTime()
	{
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		   String local_dateAndTime = dtf.format(now);
		   return local_dateAndTime;
	}
	
}
