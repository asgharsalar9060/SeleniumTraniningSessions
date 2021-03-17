package SeleniumSessionPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTestPractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1");
		driver.findElement(By.xpath("//button[@id='btndropdown']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//label"));
		
		System.out.println(list.size());
		for(int i=0; i<5; i++) {
			System.out.println(list.get(i).getText());
			list.get(i).click();
			Thread.sleep(2000);
//			if(list.get(i).getText().contains("jQuery") & list.get(i).getText().contains("JavaScript") & list.get(i).getText().contains("CSS")){
//				list.get(i).click();
//			}
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//label//input[@value='jQuery']")).click();
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//label//input[@value='JavaScript']")).click();
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//label//input[@value='CSS']")).click();
			
		}
	
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
