package SeleniumSessionPractice;

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

	public static void main(String[] args) throws IOException, InterruptedException {

		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\User\\OneDrive\\Documents\\JavaTraining\\SeleniumTrainingSessios\\src\\Practice\\config.properties");
		
		prop.load(ip);
		
		String url = prop.getProperty("URL");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		
		driver.findElement(By.xpath(prop.getProperty("department_xpath"))).sendKeys(prop.getProperty("department"));
		driver.findElement(By.xpath(prop.getProperty("searchBar_xpath"))).sendKeys(prop.getProperty("searchBar"));
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("searchBttn_xpath"))).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		

		
		
		
		
		
	}

}
