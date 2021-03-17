package SeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdownHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
//		List<WebElement> lists = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li[not(@class='multiselect-item multiselect-group')]//a//label"));
//		for(WebElement list : lists) {
//			if(list.findElement(By.tagName("input")).isSelected()){
//				String listText = list.getText();
//				System.out.println(listText);
//			}
//			
//		}
		
//		List<WebElement> lists = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li[@class='active']//a//label"));
//		for(WebElement list : lists) {
//			//if(list.findElement(By.tagName("input")).isSelected()){
//				String listText = list.getText();
//				System.out.println(listText);
////			}
//			
//		}
//		
		
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li[not(@class='multiselect-item multiselect-group')]//a//label"));
		
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		
		
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Angular")) {
				list.get(i).click();
				break;
			}
		}

		
		Thread.sleep(3000);
		driver.quit();
	}

}
