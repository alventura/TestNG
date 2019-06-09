package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{
	  @Test
		public void addEmployee() {
			 LoginPage log=new LoginPage();
			 HomePage home =new HomePage();
			 AddEmployeePage addEmp= new AddEmployeePage();
			 CommonMethods.login(log.username, log.password, log.loginBtn, "admin", "admin");
			addEmp.PIM.click();
			addEmp.addEmployee.click();

			
		}
    
    @Test(enabled=false)
    public void loginToOrangeHRM() throws InterruptedException {
        LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();
     Thread.sleep(6000);
        login.username.sendKeys(ConfigsReader.getPropertyy("username"));
        login.password.sendKeys(ConfigsReader.getPropertyy("password"));
        login.btnLogin.click();	
       
}
    @Test(enabled=false)
    public void doLogin() {
    LoginPage login=new LoginPage();
    CommonMethods.sendText(login.username,ConfigsReader.getPropertyy("username"));
    CommonMethods.sendText(login.password,  ConfigsReader.getPropertyy("password"));
    login.loginBtn.click();
    HomePage home=new HomePage();
    boolean isDisplayed = home.dashboardText.isDisplayed();
    Assert.assertTrue(isDisplayed); 
    
    }
    @Test(enabled=false)
    public void wrongLogin() {
    	LoginPage login=new LoginPage();
        CommonMethods.sendText(login.username,ConfigsReader.getPropertyy("username"));
        CommonMethods.sendText(login.password,"123");
        login.loginBtn.click();
        boolean isDisplayed=login.wrongCredentials.isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
   
 

}
    
