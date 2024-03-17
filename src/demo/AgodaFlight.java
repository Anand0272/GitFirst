package demo;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgodaFlight {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pooja\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.agoda.com/");
		
		driver.findElement(By.xpath("//a[@data-selenium='header-transportation']")).click();
		driver.findElement(By.xpath("//a[@data-selenium='header-flights']")).click();
		driver.findElement(By.xpath("//input[@data-selenium='flight-origin-search-input']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='autocompleteSearch-origin']//li[@data-text='Mumbai']")).click();
		driver.findElement(By.xpath("//div[@id='autocompleteSearch-destination']//li[@data-text='New Delhi and NCR']")).click();
		
		By locator=By.xpath("//span[@data-selenium-date='2024-09-11']");
		
		while(true) {
			if(isElementLoaded(driver,locator)) {
				driver.findElement(locator).click();
				break;
			}
			else {
				driver.findElement(By.xpath("//button[@data-selenium='calendar-next-month-button']")).click();
			}
		}
		driver.findElement(By.xpath("//button[@data-selenium='plus' and @data-element-name='flight-occupancy-adult-increase']")).click();
		driver.findElement(By.xpath("//div[@data-element-name='flight-cabin-class' and @data-element-object-id='premium-economy']")).click();
		driver.findElement(By.xpath("//button[@data-selenium='searchButton']")).click();

	}
	public static boolean isElementLoaded(WebDriver driver,By locator)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
