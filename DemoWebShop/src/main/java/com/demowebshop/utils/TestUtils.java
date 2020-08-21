package com.demowebshop.utils;

public class TestUtils {

	public static void explicitWait() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
