package com.demowebshop.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.demowebshop.DriverFactory.getChromeDriver;
import static com.demowebshop.utils.TestUtils.explicitWait;

public class CheckoutActController {

	private WebDriver driver = getChromeDriver();
	
	//Acciones
	public CheckoutActController billingAddressContinue() {
		driver.findElement(billingAddressContinueElement())
				.click();
		explicitWait();
		return this;
	}
	
	public CheckoutActController shippingAddressContinue() {
		driver.findElement(shippingAddressContinueElement())
				.click();
		explicitWait();
		return this;
	}
	
	public CheckoutActController selectShippingMethod(ShippingMethodEnum method) {
		driver.findElement(shippingMethodSelectElement(method))
				.click();
		return this;
	}
	
	public CheckoutActController shippingMethodContinue() {
		driver.findElement(shippingMethodContinueElement())
				.click();
		return this;
	}
	
	public CheckoutActController selectPaymentMethod(PaymentMethodEnum method) {
		driver.findElement(paymentMethodSelectElement(method))
				.click();
		return this;		
	}
	
	public CheckoutActController paymentMethodContinue() {
		driver.findElement(paymentMethodContinueElement())
				.click();
		return this;
	}
	
	public CheckoutActController paymentInformationContinue() {
		driver.findElement(paymentInformationContinueElement())
				.click();
		return this;
	}
	
	public CheckoutActController confirmOrderContinue() {
		driver.findElement(confirmOrderContinueElement())
				.click();
		return this;
	}
	
	//select credit card
	public CheckoutActController selectCreditCardDropDown() {
		driver.findElement(creditCardDropDownElement())
				.click();
		return this;
	}

	public CheckoutActController selecCreditCard(PaymentInformationEnum card) {
		driver.findElement(selectCreditCardElement(PaymentInformationEnum.MASTERCARD))
				.click();
		return this;
	}
	
	public CheckoutActController cardholderName(String name) {
		driver.findElement(cardholderNameElement())
				.sendKeys(name);
		return this;
	}
	
	public CheckoutActController cardNumber(String number) {
		driver.findElement(cardNumerElement())
				.sendKeys(number);
		return this;
	}
	
	public CheckoutActController expireMonthDopDown() {
		driver.findElement(expireMonthDropDownElement())
				.click();
		return this;
	}
	
	public CheckoutActController expireMonthSelect(int month) {
		driver.findElement(expireMontSelectElement(month))
				.click();
		return this;
	}
	
	public CheckoutActController expireYearDropDown() {
		driver.findElement(expireYearDropDownElement())
				.click();
		return this;
	}
	
	public CheckoutActController expireYearSelect(int year) {
		driver.findElement(expireYearSelectElement(year))
				.click();
		return this;
	}
	
	public CheckoutActController cardCode(int code) {
		driver.findElement(cardCodeElement())
				.sendKeys(Integer.toString(code));
		return this;
	}
	
	//Elements
	public static By billingAddressContinueElement() {
		return By.xpath("//*[@id=\"billing-buttons-container\"]/input");
	}
	
	public static By shippingAddressContinueElement() {
		return By.xpath("//*[@id=\"shipping-buttons-container\"]/input");
	}
	
	public static By shippingMethodContinueElement() {
		return By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input");
	}
	
	public static By paymentMethodContinueElement() {
		return By.xpath("//*[@id=\"payment-method-buttons-container\"]/input");
	}
	
	public static By paymentInformationContinueElement() {
		return By.xpath("//*[@id=\"payment-info-buttons-container\"]/input");
	}
	
	public static By confirmOrderContinueElement() {
		return By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");
	}
	
	//option elements
	public static By inStorePickupElement() {
		return By.id("PuckUpInStore");
	}
	
	//que crack este xpath
	public static By shippingMethodSelectElement(ShippingMethodEnum method) {
		return By.xpath("//*[contains(@id, 'shippingoption') and contains(@value, '"+method+"')]");
	}
	
	public static By paymentMethodSelectElement(PaymentMethodEnum method) {
		return By.xpath("//*[contains(@id, 'paymentmethod') and contains(@value, '"+method+"')]");
	}
	
	//credit card elements
	public static By creditCardDropDownElement() {
		return By.id("CreditCardType");
	}
	
	public static By selectCreditCardElement(PaymentInformationEnum card) {
		return By.xpath("//*[@id=\"CreditCardType\"]/option[text()='"+card+"']");
	}
	
	public static By cardholderNameElement() {
		return By.id("CardholderName");
	}
	
	public static By cardNumerElement() {
		return By.id("CardNumber");
	}
	
	public static By expireMonthDropDownElement() {
		return By.id("ExpireMonth");
	}
	
	public static By expireYearDropDownElement() {
		return By.id("ExpireYear");
	}
	
	public static By expireMontSelectElement(int month) {
		return By.xpath("//*[@id=\"ExpireMonth\"]/option[@value= '"+month+"']");
	}//*[@id="ExpireMonth"]/option[1]
	
	public static By expireYearSelectElement(int year) {
		return By.xpath("//*[@id=\"ExpireYear\"]/option[text()='"+year+"']");
	}
	
	public static By cardCodeElement() {
		return By.id("CardCode");
	}
	
}
