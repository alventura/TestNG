package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constant;
import com.syntax.utils.ExcelUtility;


public class AddEmployeePageTest1 extends BaseClass{

	 @Test(enabled=false,groups="smoke",dataProvider="Employee Data")
	 
		public void addEmployee(String fName, String mName,String lName, String location) throws InterruptedException {
			 LoginPage log=new LoginPage();
			 HomePage home =new HomePage();
			 AddEmployeePage addEmp= new AddEmployeePage();
			 //login to OrangeHRM
			log.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
			addEmp.PIM.click();
			//enter employee details
			addEmp.addEmployee.click();
			CommonMethods.sendText(addEmp.firstName, fName);
			CommonMethods.sendText(addEmp.middleName, mName);
			CommonMethods.sendText(addEmp.lastName, lName);
			
			
			CommonMethods.click(addEmp.location);
			
			//1 identify list
			//2 get all children with li tags
			//loop through each li tag and get text
			//if text is matching then we click
			//break
			
		CommonMethods.selectList(addEmp.locationList, location);
			Thread.sleep(3000);
			addEmp.next.click();
			String verify=addEmp.personalDetails.getText();
			System.out.println(verify);
			Assert.assertEquals(verify, "Personal Details");
		}
	 
	 @DataProvider(name="employee details")
	 public Object[] [] getData(){
		 Object [] [] data= new Object[3][4];
		 data[0][0]="John";
		 data[0][1]="Snow";
		 data[0][2]="White";
		 data[0][3]="Canadian Regional";
		 
		 data[1][0]="Mary";
		 data[1][1]="Lee";
		 data[1][2]="Rivas";
		 data[1][3]="Australian Regional";
		 
		 data[2][0]="Rose";
		 data[2][1]="Mae";
		 data[2][2]="Wilson";
		 data[2][3]="Canadian Regional";
		 
		 return data;
		 
	 }
	
	 @DataProvider(name="Employee Data")
	 public Object[][] getEmpData() {
		 
		 ExcelUtility obj=new ExcelUtility();
		 obj.openExcel(Constant.XL_FILEPATH, "Employees");
		 
		 int rows=obj.getRowNum();
		 int cols=obj.getColNum(0)*-1;
		 System.out.println(cols);
		 
		 Object [] [] data= new Object[rows-1][cols];//new Object[10][4]
		 
		 for(int i=1; i<rows; i++) {
			 for (int j=0; j<cols; j++) {
				 
				 String value=obj.getCellData(i, j);
				 data[i-1][j]=value;
				 
			 }
		 }
		 return data;
		 
	 }
	}

