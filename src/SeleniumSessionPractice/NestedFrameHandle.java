package SeleniumSessionPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrameHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.id("name")).sendKeys("Hello");
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.id("frm2")));
		driver.findElement(By.id("firstName")).sendKeys("Asghar");
		driver.findElement(By.id("lastName")).sendKeys("Salar");
		
		Thread.sleep(2000);
		
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Frame 3");
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Hello again");
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}

}
