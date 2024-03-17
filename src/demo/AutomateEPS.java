package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateEPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("wedriver.chrome.driver", "C:\\Users\\Pooja\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String fromDate="June 11, 2024";
		String toDate="June 13, 2024";
		String destination="dubai";
		
		//set implicit wait time of 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//visit expedia.com
		driver.get("https://www.expedia.com/");
		
		//type and select destination
		driver.findElement(By.xpath("//button[@data-stid='destination_form_field-menu-trigger']")).click();
		driver.findElement(By.id("destination_form_field")).sendKeys(destination);
		driver.findElement(By.xpath("//ul[@data-stid='destination_form_field-results']/li[1]")).click();
		
		
		//select check inn and check out date
		driver.findElement(By.xpath("//button[@data-stid='uitk-date-selector-input1-default']")).click();
		By fromDateLocator=By.xpath("//div[contains(@aria-label, '"+fromDate+"')]");
		System.out.println("//div[contains(@aria-label, '"+fromDate+"')]");
		while(true) {
			if(isElementLoaded(driver,fromDateLocator)) {
				driver.findElement(fromDateLocator).click();
				break;
			}
			else {
				driver.findElement(By.xpath("//button[@data-stid='uitk-calendar-navigation-controls-next-button']")).click();
			}
		}
		
		By toDateLocator=By.xpath("//div[contains(@aria-label, '"+toDate+"')]");
		if(isElementLoaded(driver,toDateLocator)) {
			driver.findElement(toDateLocator).click();
		}
		else {
			driver.findElement(By.xpath("//button[@data-stid='uitk-calendar-navigation-controls-next-button']")).click();
			driver.findElement(toDateLocator).click();
		}
		
		
		
		
		
		
		
		
		
		
	}
	public static boolean isElementLoaded(WebDriver driver, By locator)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
			}
			catch(Exception e) {
				return false;
			}
	}

}
