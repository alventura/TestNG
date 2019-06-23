package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(linkText="Admin")
	public WebElement admin;
	
	@FindBy(linkText="Organization")
	public WebElement organization;
	
	@FindBy(linkText="Locations")
	public WebElement locations;
	

	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
}
