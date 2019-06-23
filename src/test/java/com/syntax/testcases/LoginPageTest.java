package com.syntax.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass {

		
    @Test(groups="smoke")
    public void loginToOrangeHRM() throws InterruptedException {
    	test=report.createTest("Positive login");
        LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();
        test.info("Logging with valid credentials");
     Thread.sleep(6000);
        login.username.sendKeys(ConfigsReader.getProperty("username"));
        login.password.sendKeys(ConfigsReader.getProperty("password"));
        login.btnLogin.click();	
        test.info("Verifying element test is displayed");
        HomePage home=new HomePage();
       boolean isDisplayed= home.dashboardText.isDisplayed();
       Assert.assertTrue(isDisplayed);
      
}
    @Test(groups="smoke")
    public void doLogin() {
    LoginPage login=new LoginPage();
    CommonMethods.sendText(login.username,ConfigsReader.getProperty("username"));
    CommonMethods.sendText(login.password,  ConfigsReader.getProperty("password"));
    login.loginBtn.click();
    HomePage home=new HomePage();
    boolean isDisplayed = home.dashboardText.isDisplayed();
    Assert.assertTrue(isDisplayed); 
    
    }
    @Test(groups="regression")
    public void wrongLogin() {
    	LoginPage login=new LoginPage();
        CommonMethods.sendText(login.username,ConfigsReader.getProperty("username"));
        CommonMethods.sendText(login.password,"123");
        login.loginBtn.click();
        boolean isDisplayed=login.wrongCredentials.isDisplayed();
        Assert.assertTrue(false);
    }
   
 
  

}
    
