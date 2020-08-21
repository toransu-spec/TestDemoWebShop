package com.demowebshop.productoverview;

import static com.demowebshop.DriverFactory.getChromeDriver;
import static com.demowebshop.utils.TestUtils.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductOverviewActController {
	
	private WebDriver driver = getChromeDriver();
	
	//Actions
	public ProductOverviewActController selectQuantity(int qty) {
		driver.findElement(quantityElement()).clear();
		driver.findElement(quantityElement()).sendKeys(Integer.toString(qty));
		return this;
	}
	
	public ProductOverviewActController addToCartButton() {
		driver.findElement(addToCartElement())
				.click();
		explicitWait();
		return this;
	}
	
	//Elements
	public static By quantityElement() {
		return By.cssSelector("[id$=_EnteredQuantity]");
	}
	public static By addToCartElement() {
		return By.cssSelector("[id*=add-to-cart-button]");
	}

}
