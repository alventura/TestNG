package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReview {
	
	@Test
	public void readExcell() throws IOException {
	
	String xlPath="src/test/resources/testdata/OrangeHMData.xlsx";
	//Open workbook
	FileInputStream fis =new FileInputStream(xlPath);
	//Open specified sheet
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	XSSFSheet sheet =workbook.getSheet("Employees");
	
	String value=sheet.getRow(5).getCell(0).toString();
	System.out.println(value);
	
	//close workbook and stream
	workbook.close();
	fis.close();
	
	}
}
