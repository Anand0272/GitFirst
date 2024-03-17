package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StubaAutomate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pooja\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String agencyId="wso";
		String userName="Anand";
		String password="Anand@123";
		String fromDate="August 30th, 2024";
		String toDate="September 3rd, 2024";
		String nationality="United Kingdom";
		
		driver.get("https://stuba.com/");
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("agencyId")).sendKeys(agencyId);
		driver.findElement(By.id("userName")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.switchTo().defaultContent();
		
		//type and select region
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("floatingInput1")));
		driver.findElement(By.xpath("//input[@id='floatingInput1']")).sendKeys("siem reap");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Siem Reap, Cambodia']")));
		driver.findElement(By.xpath("//span[text()='Siem Reap, Cambodia']")).click();
		
		//select from and to dates
		driver.findElement(By.id("floatingInput")).click();
		By fromDateLocator=By.xpath("//div[contains(@aria-label, '"+fromDate+"')]");
		while(true) {
			if(isElementLoaded(driver,fromDateLocator)) {
				driver.findElement(fromDateLocator).click();
				break;
			}
			else {
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			}
		}
		By toDateLocator=By.xpath("//div[contains(@aria-label, '"+toDate+"')]");
		if(isElementLoaded(driver,toDateLocator)) {
			driver.findElement(toDateLocator).click();
		}
		else {
			driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			if(isElementLoaded(driver,toDateLocator)) {
				driver.findElement(toDateLocator).click();
			}
		}
		
		//select guests
		driver.findElement(By.id("floatingInput2")).click();
		Thread.sleep(500);
		Select roomOneAdults=new Select(driver.findElement(By.xpath("(//div[@aria-labelledby='floatingInput2']//div[@class='row room_1']//select)[1]")));
		roomOneAdults.selectByValue("1");
			//scroll to view done button and click
			WebElement doneButton=driver.findElement(By.xpath("//button[text()='Done']"));
			JavascriptExecutor executor=(JavascriptExecutor) driver;
			executor.executeScript("window.scrollBy(0, 100);");
			Thread.sleep(500);
			doneButton.click();
		
		
		//select nationality and search
		driver.findElement(By.id("react-select-2-input")).sendKeys(nationality);
		driver.findElement(By.id("react-select-2-listbox")).click();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		//get ids of all hotels cards
		WebDriverWait searchResultsWait=new WebDriverWait(driver,Duration.ofSeconds(40));
		searchResultsWait.until(ExpectedConditions.urlContains("Stays"));
		By cardLocator=By.xpath("//div[@class='stays-slider-box card']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cardLocator));
		int countHotelCards=driver.findElements(cardLocator).size();
				//get no of curations present
				int numOfCurations=driver.findElements(By.xpath("//li[contains(@class,'icon')]")).size();
				System.out.println("Num of curations: "+numOfCurations);
		System.out.println("Cards present: "+countHotelCards);
		
		
		List<WebElement> elements=driver.findElements(cardLocator);
		List<String> ids=new ArrayList<>();
		
		for(WebElement element:elements) {
			String id=element.getAttribute("id");
			if(ids.contains(id)) {
				continue;
			}
			ids.add(id);
		}
		System.out.println("Num of ids: "+ids.size());
		for(String id:ids) {
			System.out.println(id);
		}
		
		
			
	}
	
	public static boolean isElementLoaded(WebDriver driver, By locator)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	

}
