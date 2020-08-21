package com.demowebshop.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.demowebshop.DriverFactory.getChromeDriver;
import static com.demowebshop.utils.TestUtils.explicitWait;

public class ShoppingCartActController {
	
	private WebDriver driver = getChromeDriver();
	
	//Actions
	public ShoppingCartActController checkBox() {
		driver.findElements(removeCheckboxElement())
				.get(0)
				.click();
		return this;
	}
	
	public ShoppingCartActController updateCart() {
		driver.findElement(updateCartElement())
				.click();
		explicitWait();
		return this;
	}
	
	public ShoppingCartActController acceptTermsOfService() {
		driver.findElement(termsOfServiceElement())
				.click();
		return this;
	}
	
	public void checkoutPurchase() {
		driver.findElement(checkoutElement())
				.click();
	}
	
	//Elements
	public static By removeCheckboxElement() {
		return By.name("removefromcart");
	}
	
	public static By updateCartElement() {
		return By.name("updatecart");
	}
	
	public static By termsOfServiceElement() {
		return By.id("termsofservice");
	}
	
	public static By checkoutElement() {
		return By.id("checkout");
	}

}
