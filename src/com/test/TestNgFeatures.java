package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {

	@Test
	public void loginTest() {
		System.out.println("Login test");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("Home page test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchPageTest() {
		System.out.println("Searcg page test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void registerPageTest() {
		System.out.println("Register page test");
	}
	
}
