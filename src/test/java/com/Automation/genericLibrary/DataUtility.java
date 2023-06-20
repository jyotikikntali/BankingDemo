package com.Automation.genericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtility {
	public String getDataFromProperties(String key) throws Exception {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData22-05.Properties");
			Properties Pobj=new Properties();
			Pobj.load(fis);
			String value=Pobj.getProperty(key);
			return value;
			}
	
	
	public String getDataFromExcelSheet(String sheetname,int rownum,int cellnum) throws Exception {
		FileInputStream fos=new FileInputStream("D:\\Selenium\\Automation\\src\\test\\resources\\Actitime.xlsx");
    Workbook book = new XSSFWorkbook(fos);
	Sheet sh = book.getSheet(sheetname);
	DataFormatter format=new DataFormatter();
	String value=format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
	return value;	
	}
	

}
