package SeleniumSession;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
//		driver.get("https://www.amazon.com/");
		
		//1. Get the total number of links on the page
		//2. Get the text of each link on the page
		
//		List <WebElement> linkList = driver.findElements(By.tagName("a"));
//		
//		//Size of linkList
//		System.out.println(linkList.size());
//		
//		for(int i=0; i<linkList.size(); i++) {
//			String linkText = linkList.get(i).getText();
//			System.out.println(linkText);
//		}
//		
		driver.get("http://www.ebay.com");
		
		List <WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		
		for(int i=0; i<linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
		}
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
