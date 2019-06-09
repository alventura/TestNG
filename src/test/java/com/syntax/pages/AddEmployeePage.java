package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.syntax.utils.BaseClass;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePage extends BaseClass {
	
	@FindBy(partialLinkText="PIM")
    public WebElement PIM;
    @FindBy(partialLinkText="Add Employee")
    public WebElement addEmployee;
    @FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    }
	
	
}
