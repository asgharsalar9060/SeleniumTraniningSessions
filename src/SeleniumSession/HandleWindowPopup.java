package SeleniumSession;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//Using iterator to switch between windows
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> handler = driver.getWindowHandles();
	
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent window id is " + parentWindowId);
	
		String childWindowId = it.next();
		System.out.println("Child window id is" + childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		driver.findElement(By.id("firstName")).sendKeys("Asghar");
		System.out.println("Child window popup title: " + driver.getTitle());
		driver.close();
	
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title"+ driver.getTitle());
		
		
		//More practice --> Using for loop to switch between windows
		
		//Get handle
//		String parentWindowHandle = driver.getWindowHandle();
//		System.out.println("Parent window handle: " + parentWindowHandle);
//		
//		//Find open window button
//		driver.findElement(By.id("newWindowBtn")).click();
//		
//		//Get all handles
//		Set<String> handles = driver.getWindowHandles();
//		
//		//Switching between handles
//		for(String childWindowHandle: handles) {
//			System.out.println(childWindowHandle);
//			if(!childWindowHandle.equals(parentWindowHandle)) {
//				driver.switchTo().window(childWindowHandle);
//				Thread.sleep(3000);
//				WebElement chineseLanBttn = driver.findElement(By.id("chinesechbx"));
//				chineseLanBttn.click();
//				Thread.sleep(2000);
//				driver.close();
//				break; 
//			}
//		}
//		
//		//Switch back to the parent window
//		driver.switchTo().window(parentWindowHandle);
//		WebElement name = driver.findElement(By.id("name"));
//		name.sendKeys("Salar");
//		
//		Thread.sleep(2000);
//		
//		driver.quit();
	
		
		//Get handle
//		String parentWindowHandle = driver.getWindowHandle();
//		System.out.println("Parent window handle is: " + parentWindowHandle);
//		
//		
//		//Find open window button
//		WebElement web = driver.findElement(By.id("newWindowBtn"));
//		web.click();
//		
//		
//		//Get all handles
//		Set<String> handles = driver.getWindowHandles();
//		
//		
//		//Switching between handles
//		for(String handle: handles) {
//			System.out.println(handle);
//			if(!handle.equals(parentWindowHandle)) {
//				driver.switchTo().window(handle);
//				Thread.sleep(2000);
//				driver.findElement(By.id("femalerb")).click();
//				Thread.sleep(2000);
//				driver.close();
//			}
//		}
//		
//		
//		
//		//Switch back to the parent window
//		driver.switchTo().window(parentWindowHandle);
//		driver.findElement(By.linkText("Home")).click();
//		
//		Thread.sleep(2000);
//		driver.quit();
		

	}

}
