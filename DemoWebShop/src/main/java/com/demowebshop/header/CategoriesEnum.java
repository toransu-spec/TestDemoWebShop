package com.demowebshop.header;

public enum CategoriesEnum {
	
	BOOKS("Books"),
	COMPUTERS("Computers"),
	ELECTRONICS("Electronics"),
	APPARELSHOES("Apparel & Shoes"),
	DIGITALDOWNLOADS("Digital downloads"),
	JEWELRY("Jewelry"),
	GIFTCARDS("Gift Cards"),
	//Computers sub categories
	DESKTOPS("Desktops"),
	NOTEBOOKS("Notebooks"),
	ACCESORIES("Accessories"),
	//Electronics sub categories
	CAMERAPHOTO("Camera, photo"),
	CELLPHONES("Cell phones");
	
	private String value;
	
	CategoriesEnum(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
