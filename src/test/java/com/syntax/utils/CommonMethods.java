package com.syntax.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods extends BaseClass {

public static Select name;
	
	public static void setUpDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}

    public static void selectValueFromDD(WebElement element, String text) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals(text)) {
                select.selectByVisibleText(text);
                break;
            }else {
                System.out.println("Option with text “+text+” is not available");
            }
        }
    }

    public static void selectValueFromDD(WebElement element, int index) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        if (options.size() > index) {
            select.selectByIndex(index);
        }else {
            System.out.println("Invalid index has been passed");
        }
    }
    
    
    public static void checkBox(WebDriver driver, WebElement webElement) {
		WebElement chckbox= webElement;
	   // chckbox.isDisplayed();// true
		//chckbox.isEnabled();// true
		//chckbox.isSelected();// false
		chckbox.click();
		//chckbox.isSelected();
    
    }
    
    public static void sendText2(String locator, String element, String value) {
    	if (locator.equalsIgnoreCase("css")) {
        driver.findElement(By.cssSelector(element)).sendKeys(value);
    	}
    	else if(locator.equalsIgnoreCase("xpath")) {
    		 driver.findElement(By.xpath(element)).sendKeys(value);
    	}else {
    		System.out.println("OH NO! Something went wrong");
    	}
    }
    public static void selectByValue(WebElement element,String value) {
        name=new Select(element);
       List<WebElement> list=name.getOptions();
       for(WebElement ele:list) {
           System.out.println(ele.getText());
           if(value.equals(ele.getAttribute("value"))) {
                name.selectByValue(value);
           }
       }
   }
    public static void sendText1(String locator, String element, String value) {
    	if (locator.equalsIgnoreCase("css")) {
    	driver.findElement(By.cssSelector(element)).clear();
        driver.findElement(By.cssSelector(element)).sendKeys(value);
    	}
    	else if(locator.equalsIgnoreCase("xpath")) {
    		 driver.findElement(By.xpath(element)).clear();
    		 driver.findElement(By.xpath(element)).sendKeys(value);
    	}else {
    		System.out.println("OH NO! Something went wrong");
    	}
    }
    
    //my method for Dropdown
    public static void dropDown(String pathOrCss, String location, String text) {
		
		if (pathOrCss.equalsIgnoreCase("css")) {
	       WebElement element=driver.findElement(By.cssSelector(location));
	        
	        Select select = new Select(element);
	        List<WebElement> options = select.getOptions();
	        for (WebElement option : options) {
	            String optionText = option.getText();
	            if (optionText.equals(text)) {
	                select.selectByVisibleText(text);
	                break;
	            }
	      }
	        }else if(pathOrCss.equalsIgnoreCase("xpath")) {
	    		WebElement element=driver.findElement(By.xpath(location));
	    		Select select = new Select(element);
		        List<WebElement> options = select.getOptions();
		        for (WebElement option : options) {
		            String optionText = option.getText();
		            if (optionText.equals(text)) {
		                select.selectByVisibleText(text);
		                break; 
		            }else {
		            	System.out.println("OH NO! Something went wrong");   
		            	}
		        }
		     }else {
	    		System.out.println("OH NO! Something went wrong");
	    	}
    }

    //my method to click
    public static void clicking(String cssOrXpath,String location) {
    	if(cssOrXpath.equalsIgnoreCase("css")) {
    	WebElement element=driver.findElement(By.cssSelector(location));
    	element.click();
    }else if(cssOrXpath.equalsIgnoreCase("xpath")) {
    	WebElement element=driver.findElement(By.xpath(location));
    	element.click();
    	}
    }
    
    public static String takeScreenshot( String fileName) {
        TakesScreenshot ts=(TakesScreenshot)driver;
       File scr=ts.getScreenshotAs(OutputType.FILE);
       
      String dest=System.getProperty("user.dir")+"/target/screenshots/"+fileName+".png"; 
       try {
            FileUtils.copyFile(scr, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to take screesnhot");
        }
       	return dest;
    }
    
    
    public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}


	public static void click(WebElement element) {
		element.click();
}
	public static void selectList(WebElement element, String text) {

		List<WebElement> listLocations = element.findElements(By.tagName("li"));
		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(text)) {
				li.click();
				break;
			}
		}
	}
}