package com.syntax.testcases;

import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.AddLocations;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.ConfigsReader;

public class AddLocationsTest extends BaseClass {
	
	@Test
	
	public void addLocation() {
		 LoginPage log=new LoginPage();
		 HomePage home =new HomePage();
		 AddLocations addlocation=new AddLocations();
		 AddEmployeePage addEmp= new AddEmployeePage();
		 
		log.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		home.admin.click();
		home.organization.click();
		home.locations.click();
		addlocation.add.click();
		addlocation.name.sendKeys("location 1");
		
		
		
	}

}
