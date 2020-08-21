package com.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	private DriverFactory() {
		//
	}
	
	public static WebDriver getChromeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static Actions getAction() {
		action = new Actions(driver);
		return action;
	}
	
	public static WebDriverWait getWebDriverWait() {
		if (wait == null) {
			wait = new WebDriverWait(getChromeDriver(), 5);
		}
		return wait;
	}

}
