package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;

public class currentDate {

	
	public String returnDate()
{
	Date d = new Date();
	String dateToReturn = (d.toString().replace(" ", "_").replace(":", "_"));
	return dateToReturn;
}



// Create a excel file in local and paste in src/main/java/testData package

public static Object[][] readExcelData(String sheet) throws IOException
{
	
	File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\testData.xlsx");
	FileInputStream fis = new FileInputStream(f);
	
	
	
	XSSFWorkbook xw = new XSSFWorkbook(fis); // read the excel workbook 
	XSSFSheet xs = xw.getSheet(sheet); // retrieve the tab of excel workbook
	
	int r = xs.getLastRowNum(); // calculate total data rows
	int c = xs.getRow(0).getLastCellNum(); // calculate total data columns
	
	Object[][] obj = new Object[r][c]; // 2-D array for rows and columns
	
	for (int i=0; i<r ; i++) 
	{
	XSSFRow xr = xs.getRow(i+1); // "i+1" as i=0 is column hedaers and actual data is from row 1
	for (int j=0; j<c; j++)
	{
		XSSFCell cv = xr.getCell(j); // get cell value
		CellType ct = cv.getCellType(); // get data type of cell data
		
		switch(ct)
		{
		
		case STRING:
			obj[i][j] = cv.getStringCellValue(); // string data to string only 
			break;
			
		case NUMERIC:
			obj[i][j] = Integer.toString((int)cv.getNumericCellValue()); // string data to string only, first get its int then convert int to String 
			break;
			
		case BOOLEAN:
			obj[i][j] = cv.getBooleanCellValue();
			break;
		
		}
	}	
}
	return obj;

}
}