package SeleniumSessionPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		
		//Finding number of rows
		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
		int rowCount = row.size();
		System.out.println("Number of rows are: " + rowCount);
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeRowXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterRowXpath = "]/td[1]";
		
		System.out.println("Companies: ");
		for (int i=2; i<=rowCount; i++) {
			String actualXpath = beforeRowXpath + i + afterRowXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			
		}
		System.out.println("===========================");
		
		String afterRowContactXpath = "]/td[2]";
		
		System.out.println("Contacts: ");
		for (int i=2; i<=rowCount; i++) {
			String actualXpath = beforeRowXpath + i + afterRowContactXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		System.out.println("===========================");
		
		String afterRowCountryXpath = "]/td[3]";
		
		System.out.println("Countries: ");
		for (int i=2; i<=rowCount; i++) {
			String actualXpath = beforeRowXpath + i + afterRowCountryXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		System.out.println("===============================");
		
		//Handle columns
		
		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[1]/th[3]
		
		
		List<WebElement>  column = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th"));
		int colCount = column.size();
		
		System.out.println("Number of columns are: "+colCount);
		System.out.println("Column values are: ");
		
		String beforeColXpath = "//*[@id=\"customers\"]/tbody/tr[1]/th[";
		String afterColXpath = "]";
		
		for(int i=1; i<=colCount; i++) {
			String actualXpath = beforeColXpath + i + afterColXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
