package SeleniumSessionPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("http://www.ebay.com");
		
		System.out.println("Current url is: "+driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		System.out.println("Title is: "+driver.getTitle());
		String title = driver.getTitle();
		if(title.equals("ebay")) {
			System.out.println("Correct tile");
		}else {
			System.out.println("inccorrect title");
		}
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
