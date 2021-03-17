package com.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.jacars.net/");
	}
	
	@Test
	public void BrokenLinkAndImageTest() throws MalformedURLException, IOException {
		//1. get list of all links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of all links: "+allLinks.size());
		
		//2. get list of all active links
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for(int i=0; i<allLinks.size(); i++) {
			if(allLinks.get(i).getAttribute("href") !=null) 
				activeLinks.add(allLinks.get(i));
		}
		
		System.out.println("Number of active links " +activeLinks.size());
		
		//3. get list of links with httpconnection
		for(int j=0; j<activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();//sending OK message
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + " " + response);
		}
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
