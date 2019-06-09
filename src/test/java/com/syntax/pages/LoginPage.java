package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPage extends BaseClass {
	//locating WebElement using @FindBy annotation
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(name="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(css="img[src*='logopng']")
	public WebElement logo;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement wrongCredentials;
	//initialize all of our variables
	
	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	

}
