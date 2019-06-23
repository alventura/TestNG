package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {

	@Test
	public void writeExcell() throws IOException {
		String xlPath="src/test/resources/testdata/OrangeHMData.xlsx";
		
		FileInputStream fis=new FileInputStream(xlPath);
		// open workbook @sheet
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet sheet =wbook.getSheet("Employees");
		//write some values
		sheet.getRow(0).createCell(4).setCellValue("Result");
		
		sheet.getRow(2).createCell(4).setCellValue("Pass");
		sheet.getRow(1).createCell(4).setCellValue("Failed");
		
		sheet.createRow(11).createCell(0).setCellValue("AV");
		//write to Excel
		FileOutputStream fos=new FileOutputStream(xlPath);
		wbook.write(fos);
		//close file and opened streams
		fos.close();
		wbook.close();
		fis.close();
		
	}
	
}
