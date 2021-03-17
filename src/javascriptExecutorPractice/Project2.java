package javascriptExecutorPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project2 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.larixon.com/");
		
		
		WebElement contactUs = driver.findElement(By.xpath("//strong[contains(text(),'Contact us')]"));
		
		scrollIntoView(contactUs, driver);
		
		driver.findElement(By.cssSelector("#input-750783941983149909")).sendKeys("Asghar");
		driver.findElement(By.cssSelector("#input-750783941983149909-1")).sendKeys("Salar");
		driver.findElement(By.cssSelector("#input-620952700863990633")).sendKeys("example@gmail.com");
		driver.findElement(By.cssSelector("#input-913785301845698646")).sendKeys("This is a comment");
		Thread.sleep(2000);
		
		WebElement submitBttn = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
		
		flash(submitBttn, driver);
		
		drawBorder(submitBttn, driver);
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\User\\OneDrive\\Documents\\JavaTraining\\SeleniumTrainingSessios\\src\\javascriptExecutorPractice\\submitBttn.png"));
		
		generateAlert(driver, "The submit button has an issue!");
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgColor = element.getCssValue("backgroundColor");
		for(int i=0; i<100; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'" , element);
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}

}
