package SeleniumSessionPractice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowPopupMorePractice {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent window id is: "+parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child window id is "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Selenium Practice')]"))).build().perform();
		Thread.sleep(4000);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Broken Links')]"))).build().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Link1')]")).click();
		Thread.sleep(5000);
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\User\\OneDrive\\Documents\\JavaTraining\\SeleniumTrainingSessios\\src\\Practice\\windowPopop.png"));
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		

	}

}
