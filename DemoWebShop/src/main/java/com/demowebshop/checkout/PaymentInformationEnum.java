package com.demowebshop.checkout;

public enum PaymentInformationEnum {
	
	VISA("Visa"),
	MASTERCARD("Master card"),
	DISCOVER("Discover"),
	AMEX("Amex");
	
	private String value;
	
	PaymentInformationEnum(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
