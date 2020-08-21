package com.demowebshop.productgrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.demowebshop.DriverFactory.getChromeDriver;
import static com.demowebshop.utils.TestUtils.explicitWait;

public class ProductGridActController {

	private WebDriver driver = getChromeDriver();
	
	//Actions
	public void selectProduct(String product) {
		driver.findElement(selectProductElement(product))
				.click();
		explicitWait();
	}
	
	//esto todavia tampoco funca. chau
	public ProductGridActController addToCart() {
		//driver.findElement();
		return this;
	}
	
	//Elements
	public static By selectProductElement(String product) {
		return By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]//a[contains(text(),'"+product+"')]");
	}					
	
	//esto todavia no. no tocar
	public static By addToCartElemetn() {
		return By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/h2/a");
	}					
}
