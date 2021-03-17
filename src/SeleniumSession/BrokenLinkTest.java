package SeleniumSession;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrokenLinkTest {

	/*
	 * How do you verify the broken links? How do you find the broken links?
	 */
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("https://makemysushi.com/404?");
	}

	@Test(expectedExceptions = ClassCastException.class)
	public void BrokenLinkAndImgTest() throws MalformedURLException, IOException {
		//1. Get the list of all links and images
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Size of all links and images==>"+linkList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. Iterate linklist: exclude all the links/images that don't have href attribute
		for (int i=0; i<linkList.size(); i++) {
			System.out.println(linkList.get(i).getAttribute("href"));
			if (linkList.get(i).getAttribute("href") != null && (!linkList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linkList.get(i));
			}
		}
		
		System.out.println("Size of active links and images==>"+activeLinks.size());
		
		//3. Check the href URL with httpconnection api
		//200 --> Ok
		//404 --> Not found
		//500 --> internal error
		//400 --> bad request
		
		for(int j=0; j<activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();//ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "---->" + response);
			
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
