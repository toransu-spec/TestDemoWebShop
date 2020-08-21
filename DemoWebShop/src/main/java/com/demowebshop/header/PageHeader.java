package com.demowebshop.header;

import static com.demowebshop.DriverFactory.getChromeDriver;
import static com.demowebshop.DriverFactory.getAction;
import static com.demowebshop.utils.TestUtils.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageHeader {
	
	private WebDriver driver = getChromeDriver();
	private Actions action = getAction();
	
	public static PageHeader getPageHeader() {
		return new PageHeader();
	}
	
	//Actions 
	public void pressLogin() {
		driver.findElement(loginElement())
				.click();
	}
	
	public PageHeader logOut() {
		driver.findElement(logOutElement())
				.click();
		return this;
	}
	
	public void goToShoppingCart() {
		driver.findElement(shoppingCartElement())
				.click();
	}
	
	//mousehover
	public PageHeader mouseHover(CategoriesEnum category) {
		action.moveToElement(driver.findElement(subCategoryElement(category))).build().perform();
		explicitWait();
		return this;
	}
	
	public PageHeader clickOptionAfterHover(CategoriesEnum option) {
		driver.findElement(subCategoryElement(option)).click();
		return this;
	}

	//WebElements
	public static By loginElement() {
		return By.xpath("/html/body/div[4]//a[contains(text(), 'Log in')]");
	}
	
	public static By subCategoryElement(CategoriesEnum category) {
		return By.xpath("/html/body/div[4]/div[1]/div[2]/ul//a[contains(text(),'"+category+"')]");
	}	
	
	public static By shoppingCartElement() {
		return By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
	}
	
	public static By logOutElement() {
		return By.xpath("/html/body/div[4]//a[contains(text(), 'Log out')]");
	}

}
