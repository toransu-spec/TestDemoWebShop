package com.demowebshop.productoverview;

public class PageProductOverView {
	
	private ProductOverviewActController act;
	
	public ProductOverviewActController act() {
		return act;
	}
	
	private PageProductOverView(ProductOverviewActController act) {
		this.act= act;
	}
	
	private PageProductOverView() {
		//
	}
	
	public static PageProductOverView getPageProductOverview() {
		return new PageProductOverView(new ProductOverviewActController());
	}

}
