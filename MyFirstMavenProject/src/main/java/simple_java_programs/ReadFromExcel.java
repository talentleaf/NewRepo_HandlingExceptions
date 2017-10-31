package simple_java_programs;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadFromExcel {

@Test	
	public Object[][] readExcelData(String workbookname) throws InvalidFormatException, IOException
	{
		//Filepath to get workbook
	
	File f=new File("./Datafile/"+workbookname+".xlsx");
	                 
	XSSFWorkbook workBook=new XSSFWorkbook(f);
	
	//to get the sheetname
	XSSFSheet sheetname=workBook.getSheet("CLData");
	
	int rowcount=sheetname.getLastRowNum();
	
	int colcount=sheetname.getRow(1).getLastCellNum();
	
	Object[][] data=new Object[rowcount][colcount];
	
	//to access rows
	
	for (int i = 1; i <=rowcount; i++) {
		XSSFRow row = sheetname.getRow(i);
		for (int j = 0; j < colcount; j++) {
			//to get cell value	
			XSSFCell cell = row.getCell(j);
			String value = cell.getStringCellValue();
			
			data[i-1][j]=value;
			//System.out.print(value+"   ||||");
			
			
		}
		//System.out.println("");
	}
	return data;	
	
	}
}
