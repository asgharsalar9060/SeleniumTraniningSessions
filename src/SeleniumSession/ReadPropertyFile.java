package SeleniumSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertyFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\User\\OneDrive\\Documents\\JavaTraining\\SeleniumTrainingSessios\\src\\SeleniumSession\\config.properties");
		
		prop.load(ip);
		
//		System.out.println(prop.getProperty("name"));
//		System.out.println(prop.getProperty("age"));
		
		String url = prop.getProperty("URL");
		
//		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
//		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		driver.get(url);
		
		driver.findElement(By.xpath(prop.getProperty("firstName_xpath"))).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath(prop.getProperty("emailAdd_xpath"))).sendKeys(prop.getProperty("emailAdd"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("confirmPass_xpath"))).sendKeys(prop.getProperty("confirmPass"));
		driver.findElement(By.xpath(prop.getProperty("signInBttn_xpath"))).click();
		
	}

}
