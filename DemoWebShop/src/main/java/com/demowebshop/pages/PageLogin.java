package com.demowebshop.pages;

import com.demowebshop.login.LoginActController;

public class PageLogin {
	
	private LoginActController act;
	
	public LoginActController act() {
		return act;
	}
	
	private PageLogin(LoginActController act) {
		this.act = act;
	}
	
	private PageLogin() {
		//
	}
	
	//static factory method
	public static PageLogin getPageLogin() {
		return new PageLogin(new LoginActController());
	}

}
