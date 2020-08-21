package com.demowebshop.checkout;

public class PageCheckout {
	
	private CheckoutActController act;
	
	public CheckoutActController act() {
		return act;
	}
	
	private PageCheckout(CheckoutActController act) {
		this.act = act;
	}
	
	private PageCheckout() {
		//
	}
	
	public static PageCheckout getPageCheckout() {
		return new PageCheckout(new CheckoutActController());
	}

}
