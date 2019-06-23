package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {
	
	@Test
	public void excelTest() {
		
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constant.XL_FILEPATH, "Employees");
		//String value = obj.getCellData(2, 3);
		//System.out.println(value);
		
		//retrieve all values from excel and store intoDataProvider (2D Object array)
		
		int row=obj.getRowNum();
		System.out.println(row); //11
		int cell=-obj.getColNum(0);
		System.out.println(cell); //-3
		
		Object [] [] data=new Object[row][cell];
		
		for (int i=1; i<row; i++) {
			for (int y=0; y<cell; y++){
				
				String value=obj.getCellData(i, y);
				data[i][y]=value;
			}
		}
		
		
		System.out.println(data.length);

		
		
	}

}
