package com.demowebshop.test;

import static com.demowebshop.DriverFactory.getChromeDriver;
import static com.demowebshop.DriverFactory.getWebDriverWait;
import static com.demowebshop.utils.TestUtils.explicitWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Condiciones {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeSuite
	public void startUpBrowser() {
		driver = getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
		wait = getWebDriverWait();
	}
	
	@BeforeMethod
	public void goToHome() {
		driver.get("chrome://settings/clearBrowserData");
		explicitWait();
		driver.get("http://demowebshop.tricentis.com/");
	}


	
	@AfterSuite(alwaysRun = true)
	public void close() {
		driver.quit();
	}


}
