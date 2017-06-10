package testcases;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility 
{

	public static void capturescreenshot(WebDriver driver, String screenshotname,String Filelocation)
	{
		try
		{
			File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File(Filelocation+screenshotname+".png"));
		System.out.println("Screenshot captured");
		}
		catch(Exception e)
		{
			System.out.println("Exception while taking screenshot" +e.getMessage());
		}
	}
	
}
