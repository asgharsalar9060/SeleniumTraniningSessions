package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello");
		
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		
		Select select =  new Select(driver.findElement(By.xpath("//select[@id='course']")));
		select.selectByVisibleText("Java");
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(" World");
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
