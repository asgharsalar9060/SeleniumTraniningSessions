package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//HtmlUnitDriver is not available in Selenium 3.x version
		//To use HtmlUnitDriver, we should download it as JAR file
		//Called ghost driver too because the browser is not visible --> headless or ghost driver
		
		//Advantages
		//1. Execution of test cases are super fast --> improve performance
		
		//Disadvantages
		//1. Not suitable for actions class --> such as mouse movement, double click, drag and drop
		//Testing is happening behind the scene - no browser is launched
		
		WebDriver driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com");
		
		System.out.println("Before searching, title is:===" + driver.getTitle());
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Men summer coat");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(2000);
		
		System.out.println("After searching, title is:===" + driver.getTitle());
		
		
		

	}

}
