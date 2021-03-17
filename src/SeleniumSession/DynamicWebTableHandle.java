package SeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		List<WebElement> totalRow = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowCount = totalRow.size();
		System.out.println("Total number of rows is " +rowCount);
		
		System.out.println("=================================");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath = "//*[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[1]";
		
		for (int i=2; i<=rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
				if(element.getText().equals("Island Trading")) {
					System.out.println("Company name: " + element.getText() + " is found " + "at position " + (i-1));
					break;
				}
		}
		
		System.out.println("===================================");
		
		String afterXpathContact = "]/td[2]";
		
		for (int i=2; i<=rowCount; i++) {
			String actualXpath = beforeXpath+i+afterXpathContact;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		System.out.println("===================================");
		
		String afterXpathCountry = "]/td[3]";
		
		for (int i=2; i<=rowCount; i++) {
			String actualXpath = beforeXpath+i+afterXpathCountry;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		System.out.println("===================================");
		
		//Handling webtable columns
		
		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[1]/th[2]  	
		//*[@id="customers"]/tbody/tr[1]/th[3]
		
		String beforeColXpath = "//*[@id='customers']/tbody/tr[1]/th[";
		String afterColXpath = "]";
		List<WebElement> totalCol = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
		int colCount = totalCol.size();
		System.out.println("Total number of columns is "+colCount);
		System.out.println("Column values are: ");
		for (int i=1; i<=colCount; i++) {
			WebElement element = driver.findElement(By.xpath(beforeColXpath+i+afterColXpath));
			String colText = element.getText();
			System.out.println(colText);
		}
		
		
		Thread.sleep(2000);
		driver.quit();

		
		
		
		
		
		
	}

}
