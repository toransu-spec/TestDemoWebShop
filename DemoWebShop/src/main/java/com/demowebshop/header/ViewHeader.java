package com.demowebshop.header;

import static com.demowebshop.DriverFactory.getChromeDriver;
import static com.demowebshop.utils.TestUtils.explicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewHeader {
	
	private WebDriver driver = getChromeDriver();
	
	private ViewHeader() {
		//No instantiate
	}
	
	public static ViewHeader getViewHeader() {
		return new ViewHeader(); //static factory method
	}
	
	
	//Acciones
	public ViewHeader clickSortBy() {
		driver.findElement(sortyByElement())
				.click();
		explicitWait();
		return this;
	}
	
	public ViewHeader selectSortBy(SortByEnum option) {
		driver.findElement(sortByOptionsElement(option))
				.click();
		return this;
	}
	
	public ViewHeader clickDisplayPerPage() {

		driver.findElement(displayPerPageElement())
				.click();
		explicitWait();
		return this;
	}
	
	public ViewHeader selectDisplayPerPage(int option) {
		driver.findElement(displayPerPageOptionsElement(option))
				.click();
		return this;
	}
	
	public ViewHeader clickViewAs() {
		driver.findElement(viewAsElement())
				.click();
		return this;
	}
	
	public ViewHeader selectViewAs(String option) {
		driver.findElement(viewAsOptionElement(option))
				.click();
		return this;
	}
	
	public ViewHeader selectComputerGammaFilter(String option) {
		driver.findElement(filterComputerGamma(option))
				.click();
		return this;
	}
	
	//Elements
	public static By sortyByElement() {
		return By.id("products-orderby");
	}
	
	public static By displayPerPageElement() {
		return By.id("products-pagesize");
	}
	
	public static By viewAsElement() {
		return By.id("products-viewmode");
	}
	
	//despues cambiar por un ENUM para hacerlo mas bonito. ahora lo dejo medio cabeza.
	public static By sortByOptionsElement(SortByEnum option) {
		return By.xpath("//*[@id=\"products-orderby\"]/option[text()='"+option+"']");
	}		
	
	public static By displayPerPageOptionsElement(int option) {
		return By.xpath("//*[@id=\"products-pagesize\"]/option[text()="+Integer.toString(option)+"]");
	}

	public static By viewAsOptionElement(String option) {
		return By.xpath("//*[@id=\"products-viewmode\"]/option[text()='"+option+"']");
	}				
	
	public By filterComputerGamma(String option) {
		return By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/ul//a[contains(text(), '"+option+"')]");
	}					

}
