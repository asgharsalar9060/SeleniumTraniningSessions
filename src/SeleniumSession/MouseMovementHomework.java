package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementHomework {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.daraz.lk/#");
		
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Electronic Devices')]"))).build().perform();
//		
//		Thread.sleep(2000);
//		
//		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Mobiles')]"))).build().perform();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//span[contains(text(),'Samsung Mobiles')]")).click();
//		
//		Thread.sleep(2000);
//		
//		driver.quit();
		
		//More Practice
		
		WebElement eleDevice = driver.findElement(By.xpath("//span[contains(text(),'Electronic Devices')]"));
		
		Thread.sleep(2000);
		
		WebElement mobile = driver.findElement(By.xpath("//span[contains(text(),'Mobiles')]"));
		
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		action.moveToElement(eleDevice).build().perform();
		action.moveToElement(mobile).build().perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Samsung Mobiles')]")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
