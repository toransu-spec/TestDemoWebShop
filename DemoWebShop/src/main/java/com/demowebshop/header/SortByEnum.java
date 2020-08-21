package com.demowebshop.header;

public enum SortByEnum {
	
	POSITION("Position"),
	NAMEASCENDANT("Name: A to Z"),
	NAMEDESCENDANT("Name: Z to A"),
	PRICELOWTOHIGHT("Price: Low to High"),
	PRICEHIGHTTOLOW("Price: High to Low"),
	CREATEDON("Created on");
	
	private String value;
	
	SortByEnum(String value){
		this.value = value;
	}
	
	public String toString() {
		return value;
	}

}
