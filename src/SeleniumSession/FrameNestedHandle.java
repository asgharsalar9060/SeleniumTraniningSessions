package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FrameNestedHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello");
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		
		driver.switchTo().frame(driver.findElement(By.id("frm2")));
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Salar");
		
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("frame3");
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("main WebPage!");
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
