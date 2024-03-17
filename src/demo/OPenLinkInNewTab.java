package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OPenLinkInNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("wedriver.chrome.driver", "C:\\Users\\Pooja\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		int footerLinks=footer.findElements(By.tagName("a")).size();
		System.out.println("Footer Links="+footerLinks);
		
		WebElement firstColumn=footer.findElement(By.tagName("td"));
		System.out.println(firstColumn.findElements(By.tagName("a")).get(0).getText());
		String ctrlEnter=Keys.chord(Keys.CONTROL,Keys.ENTER);
		for(int i=0;i<firstColumn.findElements(By.tagName("a")).size();i++)
		{
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(ctrlEnter);
			
		}
//		String ctrlEnter=Keys.chord(Keys.CONTROL,Keys.ENTER);
//		driver.findElement(By.xpath("//a[@href='http://www.restapitutorial.com/']")).sendKeys(ctrlEnter);
		
	}

}
