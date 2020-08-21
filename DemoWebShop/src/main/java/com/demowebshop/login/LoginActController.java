package com.demowebshop.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.demowebshop.DriverFactory.getChromeDriver;

public class LoginActController {

	private WebDriver driver = getChromeDriver();
	
	//Actions
	public LoginActController emailInput(String email) {
		driver.findElement(emailField())
				.sendKeys(email);
		return this;
	}
	
	public LoginActController passwordInput(String pass) {
		driver.findElement(passwordField())
				.sendKeys(pass);
		return this;
	}
	
	public void pressLogin() {
		driver.findElement(loginButton())
				.click();
	}
	
	//Elements
	public By emailField() {
		return By.id("Email");
	}
	
	public By passwordField() {
		return By.id("Password");
	}
	
	public By loginButton() {
		return By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");
	}
}
