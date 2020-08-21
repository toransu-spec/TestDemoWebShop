package com.demowebshop.pages;

public enum PageEnum {
	
	HOME("http://demowebshop.tricentis.com/"),
	LOGIN("http://demowebshop.tricentis.com/login"),
	DESKTOPS("http://demowebshop.tricentis.com/desktops"),
	NOTEBOOKS("http://demowebshop.tricentis.com/notebooks"),
	ACCESSORIES("http://demowebshop.tricentis.com/accessories"),
	CELLPHONES("http://demowebshop.tricentis.com/cell-phones"),
	CART("http://demowebshop.tricentis.com/cart"),
	CHECKOUT("http://demowebshop.tricentis.com/onepagecheckout");
	
	private String value;
	
	PageEnum(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
