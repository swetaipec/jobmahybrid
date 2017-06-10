package exportexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiExcel
{


	//String filepath="C://Comps_workspace//TestCase.xlsx";
	public XSSFSheet readexcel(String filepath,String filename, String sheetname) throws IOException
	{
		File file=new File(filepath+"\\"+filename);
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet(sheetname);
		return sheet;
	}
}









