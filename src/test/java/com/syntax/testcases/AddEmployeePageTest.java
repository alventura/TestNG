package com.syntax.testcases;

import org.testng.annotations.Test;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class AddEmployeePageTest extends BaseClass{

	@Test(enabled=true)
	public void addEmployeee() {
		 LoginPage log=new LoginPage();
		//// HomePage home =new HomePage();
		 //AddEmployeePage addEmp= new AddEmployeePage();
		 CommonMethods.login(log.username, log.password, log.loginBtn, "admin", "admin");
		//addEmp.PIM.click();
		//addEmp.addEmployee.click();

	}
}
