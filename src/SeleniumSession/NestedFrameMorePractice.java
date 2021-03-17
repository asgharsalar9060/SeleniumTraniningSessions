package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrameMorePractice {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hey there");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		driver.switchTo().frame(driver.findElement(By.id("frm2")));
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Asghar");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Salar");
		driver.findElement(By.xpath("//input[@id='englishchbx']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Frame 3");
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Back to WebPage");
		
		Thread.sleep(6000);
		
		
		driver.quit();
	}

}
