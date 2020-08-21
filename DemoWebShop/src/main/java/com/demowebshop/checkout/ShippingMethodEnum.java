package com.demowebshop.checkout;

public enum ShippingMethodEnum {
	
	GROUND("Ground"),
	NEXTDAYAIR("Next Day Air"),
	SECONDDAYAIR("2nd Day Air");
	
	private String value;
	
	ShippingMethodEnum(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
