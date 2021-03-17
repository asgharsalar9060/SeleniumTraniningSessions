package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
//		driver.get("https://www.spicejet.com/");
//		
//		Actions action = new Actions(driver);
//		
//		action.moveToElement(driver.findElement(By.xpath("//a[@id='highlight-addons']"))).build().perform();
//		
//		Thread.sleep(3000);
//		
//		driver.findElement(By.linkText("Visa Services")).click();
//		
//		Thread.sleep(5000);
//		
//		driver.quit();
		
		//More practice
		
		driver.get("https://www.amazon.com/");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"))).build().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Watchlist')]")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
