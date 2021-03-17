package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();//launch chrome
		//driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F#");//enter url
		driver.get("https://www.amazon.com/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		
		//1. xpath: --> xpath hierarchy-based MUST not be used --> otherwise, it is 2nd priority after id
		//Absolute xpath should not be used --> hierarchy-based e.g: (/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[6]/a[1])
		//Relative epath should be used e.g: (//a[@class='a-link-emphasis'])
		
//		  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Tom");
//		  
//		  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Peter");
//		  
//		  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("example@gmail.com");
		
		//2. id: --> most useful --> should be first used if available
		
//		 driver.findElement(By.id("firstname")).sendKeys("Tom");
//		 driver.findElement(By.id("lastname")).sendKeys("Peter");
//		 driver.findElement(By.id("Email")).sendKeys("example@gmail.com");
		 
		 //3. name: is 3rd priority after xpath
		 
//		driver.findElement(By.name("customerName")).sendKeys("Tom");
//		driver.findElement(By.name("email")).sendKeys("example@gmail.com");
		
		//4. LinkText - this is only for links
		
//		driver.findElement(By.linkText("Privacy Notice")).click();
		
		//5. PartialLinkText - only used for partial links - not recommended
		
//		driver.findElement(By.partialLinkText("Sign-")).click();
		
		//6. CSS Selector: --> is also 2nd priority like xpath
		
		driver.findElement(By.cssSelector("#ap_customer_name")).sendKeys("Tom");
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("example@gmail.com");
		driver.findElement(By.cssSelector("#ap_password")).sendKeys("123456");
		driver.findElement(By.cssSelector("#ap_password_check")).sendKeys("123456");
		
		
		//7. Class name: not useful --> 4th priority
		
		driver.findElement(By.className("a-button-input")).click();
		 
	}

}
