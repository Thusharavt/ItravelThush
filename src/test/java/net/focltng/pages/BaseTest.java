package net.focltng.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import net.focltng.helper.LocationsHelper;

public class BaseTest {
	
	protected static ThreadLocal<ChromeDriver> _driver = new ThreadLocal<>();
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", LocationsHelper.getLocaionChromeDriver());
		_driver.set(new ChromeDriver());
		//implicit wait if requIred
		//ssl 
		getDriver().manage().window().maximize();
	}
	
	public static WebDriver getDriver() {				
		return _driver.get();		
	}
	
	@AfterMethod
	public void tearDown()
	{
		getDriver().quit();
		//after execution 
	}

}
