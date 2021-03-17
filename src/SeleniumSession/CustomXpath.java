		package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Baby jacket");
		//driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Winter coat");
		//driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]")).sendKeys("rain coat");
		
		//Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
//		
//		Thread.sleep(2000);
//		driver.quit();
		
		//How to handle dynamic ids? We should use 'contains' function or 'starts-with' key
		//dynamic id: input
		//By.id("test_123")
		
		//starts-with
		//id = test_123
		//id = test_456
		//id = test_789
		
		//ends-with
		//id = 1234_test_t
		//id = 123_test_t
		//id = 3456_test_t
		
		//EXAMPLES
		
		//driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Jumper");
		//driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Jumper");
		//driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("Jumper");
		
		
		//for links: custom xpath
		//all the links are represented by <a> html tag
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();

		Thread.sleep(2000);
		driver.quit();
	}

}
