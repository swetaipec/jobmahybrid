package operations;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UIoperations extends Getobjectclass
{

	WebDriver driver;
	public UIoperations(WebDriver driver)
	{
		this.driver=driver;
	}

	public void perform(Properties p,String operation,String objectname,String objectType,String value) throws Exception
	{
	System.out.println("manage value " +p.getProperty("managecomps"));
	switch(operation.toUpperCase())
	{
	case "CLICK":
	driver.findElement(this.getObject(p, objectname, objectType)).click();
	break;
	case "SETTEXT":
		driver.findElement(this.getObject(p, objectname, objectType)).sendKeys(value);
	break;
	case "GOTOURL":
		driver.get(p.getProperty(value));
		break;
	case "WAIT":
		Thread.sleep(100000);
		break;
	
		
		
		
		
		default:
			break;
	}
		}

	
}
