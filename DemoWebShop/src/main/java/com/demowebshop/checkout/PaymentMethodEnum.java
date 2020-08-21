package com.demowebshop.checkout;

public enum PaymentMethodEnum {
	
	CASHONDELIVERY("CashOnDelivery"),
	CHECKMONEYORDER("CheckMoneyOrder"),
	CREDITCARD("Manual"),
	PURCHASEORDER("PurchaseOrder");
	
	private String value;
	
	PaymentMethodEnum(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
