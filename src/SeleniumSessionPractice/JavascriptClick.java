package SeleniumSessionPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptClick {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/");
		
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("exammple@gmail.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("document.getElementById('persistent').click()");
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='login-username']"));
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", checkbox);
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		

	}

}
