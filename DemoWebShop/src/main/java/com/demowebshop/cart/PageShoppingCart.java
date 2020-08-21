package com.demowebshop.cart;

public class PageShoppingCart {
	
	private ShoppingCartActController act;
	
	public ShoppingCartActController act() {
		return act;
	}
	
	private PageShoppingCart(ShoppingCartActController act) {
		this.act = act;
	}
	
	private PageShoppingCart() {
		//
	}
	
	public static PageShoppingCart getPageShoppingCart() {
		return new PageShoppingCart(new ShoppingCartActController());
	}

}
