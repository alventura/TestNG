package com.syntax.testcases;

import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class WeqasTest extends BaseClass {

	@Test
	public void tryAddEmployee() {
		 LoginPage log=new LoginPage();
		 CommonMethods.login(log.username, log.password, log.loginBtn, "admin", "admin");
		 
		 }
}
