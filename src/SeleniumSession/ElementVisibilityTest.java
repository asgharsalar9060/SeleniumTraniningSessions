package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.jacars.net/profile/login/");
		
		//1. isDisplayed() method: applicable for all elements
		boolean b1 = driver.findElement(By.xpath("//button[contains(text(),'Sign in by an SMS')]")).isDisplayed();//sign in button
		System.out.println(b1); //true
		
		//2. isEnabled() method:
		boolean b2 = driver.findElement(By.xpath("//button[contains(text(),'Sign in by an SMS')]")).isEnabled();
		System.out.println(b2);//false
		
		
		//select i agree checkbox
		driver.findElement(By.xpath("//label[contains(text(),'I confirm that I am at least 18 years old.')]")).click();
		Thread.sleep(3000);
		boolean b3 = driver.findElement(By.xpath("//button[contains(text(),'Sign in by an SMS')]")).isEnabled();
		System.out.println(b3);//true

		//isSelected() method: applicable only for checkbox, dropdown and radio button
		boolean b4 = driver.findElement(By.xpath("//label[contains(text(),'I confirm that I am at least 18 years old.')]")).isSelected();
		System.out.println(b4);//true
		
		//de-select the checkbox button
		driver.findElement(By.xpath("//label[contains(text(),'I confirm that I am at least 18 years old.')]")).click();
		boolean b5 = driver.findElement(By.xpath("//label[contains(text(),'I confirm that I am at least 18 years old.')]")).isSelected();
		System.out.println(b5);//false
		
		Thread.sleep(2000);
		driver.quit();
	}

}
