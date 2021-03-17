package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://passport.alibaba.com/icbu_login.htm?tracelog=hd_signin");
		
		//handle drop box --> used for dropdown
		Select select = new Select(driver.findElement(By.id("language-switch")));
		select.selectByVisibleText("Deutsch");
		
	}

}
