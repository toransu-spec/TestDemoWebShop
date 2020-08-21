package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.demowebshop.DriverFactory.getChromeDriver;

public class CommonVerification {
	
	protected WebDriver driver = getChromeDriver();
	
	private CommonVerification() {
		//
	}
	
	public static CommonVerification getCommonVerification() {
		return new CommonVerification();
	}
	
	public CommonVerification verifyIsDisplayed(By element) {
		Assert.assertTrue(driver.findElement(element).isDisplayed());
		return this;
	}
	
	public CommonVerification verifyEquals(String string) {
		Assert.assertEquals(driver.getCurrentUrl(), string);
		return this;
	}
	
	public CommonVerification verifyEnabled(By element) {
		Assert.assertTrue(driver.findElement(element).isEnabled());
		return this;
	}
	
	public CommonVerification verifyDisabled(By element) {
		Assert.assertTrue(!driver.findElement(element).isEnabled());
		return this;
	}


}
