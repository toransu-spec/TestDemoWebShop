package com.demowebshop.productgrid;

public class PageProductGrid {
	
	private ProductGridActController act;
	
	public ProductGridActController act() {
		return act;
	}
	
	private PageProductGrid(ProductGridActController act) {
		this.act = act;
	}
	
	private PageProductGrid() {
		//
	}
	
	public static PageProductGrid getProductGridPage() {
		return new PageProductGrid(new ProductGridActController());
	}

}
