package testcases;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import operations.UIoperations;
import operations.Readobject;
import exportexcel.PoiExcel;

public class HybridExecuteTest
{
	WebDriver webdriver;

	@Test(dataProvider="hybridData")
	public void testlogin(String testcasename,String keyword, String objectname,String objectType,String value) throws Exception
	{
		if(testcasename!=null&&testcasename.length()!=0)
		{

			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
			//System.setProperty("webdriver.gecko.driver", "C://Users//chaman.preet//Downloads//geckodriver.exe");

			System.setProperty("webdriver.gecko.driver", "C://Users//SK//latest selenium//geckodriver.exe");

			webdriver=new FirefoxDriver(fp);
		}
		Readobject robject=new Readobject();
		Properties allobjects=robject.getobjectrepository();
		UIoperations Uoperation=new UIoperations(webdriver);
		Uoperation.perform(allobjects, keyword, objectname, objectType, value);
	}

	@DataProvider(name="hybridData")
	public Object[][] getDatafromDataprovider() throws IOException
	{
		Object[][] object=null;
		PoiExcel file=new PoiExcel();

		XSSFSheet sheet=file.readexcel("C://Users//SK//workspace//jobma_hybrid", "TestCase.xlsx", "Comps");


		//	XSSFSheet sheet=file.readexcel("C://Comps_workspace//Comps_project//test-output", "TestCase.xlsx", "Comps");
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("row count is" +rowcount);
		object=new Object[rowcount][5];
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				XSSFCell cell=row.getCell(j);
				object[i][j] = cell.toString();	
				// System.out.println("values are" +object[i][j]);
			}
		}
		System.out.println("");
		return object;    
	}
     @AfterMethod
	public void screenshot(ITestResult result)
	{
		//DateFormat format=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//Date date=new Date();
		//String date1=format.format(date);
		//System.out.println("Current time is" +date1);
		String methodname1=result.getName().toString().trim();
		String methodname= result.getName()+ "-" + Arrays.toString(result.getParameters());

		if(ITestResult.SUCCESS==result.getStatus())
		{

			utility.capturescreenshot(webdriver, methodname,"C:\\Users\\SK\\workspace\\jobma_hybrid\\ScreenShotOfPassTestCases\\");
		}

		else if(ITestResult.FAILURE==result.getStatus())
		{
			utility.capturescreenshot(webdriver, methodname,"C:\\Users\\SK\\workspace\\jobma_hybrid\\ScreenShotOfFailTestCases\\");
		}

		else if(ITestResult.SKIP==result.getStatus())
		{
			utility.capturescreenshot(webdriver, methodname,"C:\\Users\\SK\\workspace\\jobma_hybrid\\ScreenShotOfSkipTestCases\\");
		}
		

	}




}
