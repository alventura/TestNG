package com.syntax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageWithoutPageFactory extends BaseClass{

    public WebElement username=driver.findElement(By.id("txtUsername"));
    public WebElement password=driver.findElement(By.id("txtPassword"));
    public WebElement btnLogin=driver.findElement(By.id("btnLogin"));
    
    
}
	
	    
