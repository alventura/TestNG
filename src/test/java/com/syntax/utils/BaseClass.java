package com.syntax.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static Select name;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeMethod(alwaysRun = true)
	public static void setUp()  {
		
		ConfigsReader.readProperties(Constant.CREDENTIALS_FILEPATH);
		htmlReport=new ExtentHtmlReporter(Constant.REPORT_FILEPATH);
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		String browser=ConfigsReader.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		
		} else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		driver.quit();
}
	
	@BeforeTest(alwaysRun=true)
	public void generateReport() {
		ConfigsReader.readProperties(Constant.CREDENTIALS_FILEPATH);
		//create an object of extentReport and htmlReporter
		htmlReport= new ExtentHtmlReporter(Constant.REPORT_FILEPATH);
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("OS",Constant.OS_NAME);
		report.setSystemInfo("Enviornment","Test");
		report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
		report.setSystemInfo("QA Engineer", Constant.USER_NAME);
		
		
				
	}
	@AfterTest(alwaysRun=true)
	public void flushReport() {
		report.flush();
	}

}
