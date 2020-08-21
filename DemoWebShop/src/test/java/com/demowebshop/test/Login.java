package com.demowebshop.test;

import static com.demowebshop.cart.PageShoppingCart.getPageShoppingCart;
import static com.demowebshop.pages.CommonVerification.getCommonVerification;
import static com.demowebshop.checkout.PageCheckout.getPageCheckout;
import static com.demowebshop.header.ViewHeader.getViewHeader;
import static com.demowebshop.pages.PageLogin.getPageLogin;
import static com.demowebshop.productgrid.PageProductGrid.getProductGridPage;
import static com.demowebshop.productoverview.PageProductOverView.getPageProductOverview;
import static com.demowebshop.header.PageHeader.*;
import static com.demowebshop.checkout.CheckoutActController.*;

import org.testng.annotations.Test;

import com.demowebshop.cart.PageShoppingCart;
import com.demowebshop.checkout.PageCheckout;
import com.demowebshop.checkout.PaymentInformationEnum;
import com.demowebshop.checkout.PaymentMethodEnum;
import com.demowebshop.checkout.ShippingMethodEnum;
import com.demowebshop.header.CategoriesEnum;
import com.demowebshop.header.PageHeader;
import com.demowebshop.header.SortByEnum;
import com.demowebshop.header.ViewHeader;
import com.demowebshop.pages.CommonVerification;
import com.demowebshop.pages.PageEnum;
import com.demowebshop.pages.PageLogin;
import com.demowebshop.productgrid.PageProductGrid;
import com.demowebshop.productoverview.PageProductOverView;

public class Login extends Condiciones{
	
	PageLogin pageLogin = getPageLogin();
	PageHeader pageHeader = getPageHeader();
	ViewHeader viewHeader = getViewHeader();
	PageProductGrid productGridPage = getProductGridPage();
	PageProductOverView pageProductOverview = getPageProductOverview();
	PageShoppingCart pageShoppingCart = getPageShoppingCart();
	PageCheckout pageCheckout = getPageCheckout();
	CommonVerification commonVerification = getCommonVerification();
	
	@Test(enabled=true)
	public void loginTest() {
		pageHeader.pressLogin();
		commonVerification.verifyEquals(PageEnum.LOGIN.toString()); //toString since verify takes a string
		pageLogin.act()
					.emailInput("diablo1@diablo.test")
					.passwordInput("Diablo123!")
					.pressLogin();
		commonVerification.verifyEquals(PageEnum.HOME.toString()); 
		pageHeader.logOut(); //log out for the next tests
	}
	
	@Test(enabled=true, description = "test mouse hover to show a menu displayed when mouse is over it")
	public void hoverTest() {
		pageHeader.mouseHover(CategoriesEnum.COMPUTERS);
		commonVerification.verifyIsDisplayed(subCategoryElement(CategoriesEnum.ACCESORIES));
		pageHeader.clickOptionAfterHover(CategoriesEnum.ACCESORIES);
	}
	
	@Test(enabled = true, description = "select a dropwdown and chose a sort option")
	public void sortByTest() {
		pageHeader.mouseHover(CategoriesEnum.COMPUTERS)
					.clickOptionAfterHover(CategoriesEnum.DESKTOPS);
		viewHeader.clickSortBy()
					.selectSortBy(SortByEnum.NAMEASCENDANT) //position / name a to z / name z to a / price low to high / price high to low / created on
					.clickDisplayPerPage()
					.selectDisplayPerPage(12)
					.clickViewAs()
					.selectViewAs("List") //List o Grid
					.selectComputerGammaFilter("Under");
	}
	@Test(enabled = true)
	public void deleteFromShoppingCartTest() {
		pageHeader.mouseHover(CategoriesEnum.COMPUTERS)
					.clickOptionAfterHover(CategoriesEnum.NOTEBOOKS);
		productGridPage.act()
						.selectProduct("Laptop");
		pageProductOverview.act()
						.selectQuantity(5)
						.addToCartButton();
		pageHeader.goToShoppingCart();
		pageShoppingCart.act()
						.checkBox()
						.updateCart();
	}
	
	
	@Test(enabled = true, description = "")
	public void purchaseProductCashOnDeliveryTest() {
		pageHeader.pressLogin();
		pageLogin.act()
					.emailInput("diablo1@diablo.test")
					.passwordInput("Diablo123!")
					.pressLogin();
		pageHeader.mouseHover(CategoriesEnum.ELECTRONICS)
					.clickOptionAfterHover(CategoriesEnum.CELLPHONES);
		productGridPage.act()
						.selectProduct("Smartphone");
		pageProductOverview.act()
						.selectQuantity(1)
						.addToCartButton();
		pageHeader.goToShoppingCart();
		pageShoppingCart.act()
						.acceptTermsOfService()
						.checkoutPurchase();
		pageCheckout.act()
						.billingAddressContinue()
						.shippingAddressContinue();
						//verify shipping options are displayed
		commonVerification.verifyIsDisplayed(shippingMethodSelectElement(ShippingMethodEnum.GROUND))
							.verifyIsDisplayed(shippingMethodSelectElement(ShippingMethodEnum.NEXTDAYAIR))
							.verifyIsDisplayed(shippingMethodSelectElement(ShippingMethodEnum.SECONDDAYAIR));
		pageCheckout.act()
						.selectShippingMethod(ShippingMethodEnum.NEXTDAYAIR)
						.shippingMethodContinue();
						//verify payment method
		commonVerification.verifyIsDisplayed(paymentMethodSelectElement(PaymentMethodEnum.CASHONDELIVERY))
							.verifyIsDisplayed(paymentMethodSelectElement(PaymentMethodEnum.CHECKMONEYORDER))
							.verifyIsDisplayed(paymentMethodSelectElement(PaymentMethodEnum.CREDITCARD))
							.verifyIsDisplayed(paymentMethodSelectElement(PaymentMethodEnum.PURCHASEORDER));
		pageCheckout.act()
						.selectPaymentMethod(PaymentMethodEnum.CASHONDELIVERY)
						.paymentMethodContinue()
						.paymentInformationContinue();
		pageHeader.logOut();
	}

	@Test(description= "incomplete due to missing valid card number for the test", enabled = true)
	public void purchaseProductCreditCardTest() {
		pageHeader.pressLogin();
		pageLogin.act()
					.emailInput("diablo1@diablo.test")
					.passwordInput("Diablo123!")
					.pressLogin();
		pageHeader.mouseHover(CategoriesEnum.ELECTRONICS)
					.clickOptionAfterHover(CategoriesEnum.CELLPHONES);
		productGridPage.act()
						.selectProduct("Smartphone");
		pageProductOverview.act()
						.selectQuantity(1)
						.addToCartButton();
		pageHeader.goToShoppingCart();
		pageShoppingCart.act()
						.acceptTermsOfService()
						.checkoutPurchase();
		pageCheckout.act()
						.billingAddressContinue()
						.shippingAddressContinue()
						.selectShippingMethod(ShippingMethodEnum.NEXTDAYAIR)
						.shippingMethodContinue()
						.selectPaymentMethod(PaymentMethodEnum.CREDITCARD)
						.paymentMethodContinue()
						.selectCreditCardDropDown()
						.selecCreditCard(PaymentInformationEnum.MASTERCARD)
						.cardholderName("Diablo")
						.cardNumber("1111222233334444")
						.expireMonthDopDown()
						.expireMonthSelect(6) 
						.expireYearDropDown()
						.expireYearSelect(2033)
						.cardCode(665)
						.paymentInformationContinue();
	}

}
