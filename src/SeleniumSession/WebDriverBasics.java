package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//launch chrome
		//String baseURL = "http://www.google.com";
		//driver.get(baseURL);
		driver.get("http://www.google.com");//enter url
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\geckodriver.exe");
		//WebDriver driver1 = new FirefoxDriver();//launch firefox
		//driver1.get("http://www.facebook.com");//enter url
		
		String title = driver.getTitle();//get title
		System.out.println(title);
		
		//validation point
		if (title.equals("Google")) {
			System.out.println("Correct title");
		}else {
			System.out.println("Incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		driver.quit();
		

	}

}
