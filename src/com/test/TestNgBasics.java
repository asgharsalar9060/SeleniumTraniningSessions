 package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	/*
	 * @BeforeMethod
	 * @Test 1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test 2
	 * @AfterMethod
	 */
	
	//Pre-condition annotations -- starting with @Before
	@BeforeSuite
	public void setUp() {
		System.out.println("Setup system property for Chrome");
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launch Chrome browser");
	}
	
	@BeforeClass
	public void login(){
		System.out.println("login to app");
	}
	
	@BeforeMethod
		public void enterUrl(){
		System.out.println("Enter URL");
	}
	
	//Test cases -- starting with @Test
	@Test
	public void googleTitleTest() {
		System.out.println("Google title test");
	}
	
	@Test
	public void search() {
		System.out.println("Search test");
	}
	
	//Post condition annotations -- starting with @After
	@AfterMethod
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close browser");
	}
	
	@AfterTest
	public void logout() {
		System.out.println("Logout from app");
	}
	
//	@AfterSuite
//	public void generateTestReport() {
//		System.out.println("Generate test report");
//	}
	
}
