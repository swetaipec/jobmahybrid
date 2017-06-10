package operations;
import java.util.Properties;

import org.openqa.selenium.By;

public class Getobjectclass 
{
	
	public  By getObject(Properties p,String objectname,String objectType) throws Exception
	{
	    //Find by xpath
	    if(objectType.equalsIgnoreCase("XPATH")){
	        
	        return By.xpath(p.getProperty(objectname));
	    }
	    //find by class
	    else if(objectType.equalsIgnoreCase("CLASSNAME")){
	        
	        return By.className(p.getProperty(objectname));
	        
	    }
	    
	  //find by id
	    else if(objectType.equalsIgnoreCase("ID")){
	        
	        return By.id(p.getProperty(objectname));
	        
	    }
	    //find by name
	    else if(objectType.equalsIgnoreCase("NAME")){
	        
	        return By.name(p.getProperty(objectname));
	        
	    }
	    //Find by css
	    else if(objectType.equalsIgnoreCase("CSS")){
	        System.out.println("test");
	        return By.cssSelector(p.getProperty(objectname));
	        
	    }
	    //find by link
	    else if(objectType.equalsIgnoreCase("LINK")){
	        
	        return By.linkText(p.getProperty(objectname));
	        
	    }
	    //find by partial link
	    else if(objectType.equalsIgnoreCase("PARTIALLINK")){
	        
	        return By.partialLinkText(p.getProperty(objectname));
	        
	    }
	    else
	    {
	        throw new Exception("Wrong object type");
	    }
	}

}
