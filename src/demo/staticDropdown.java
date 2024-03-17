package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("wedriver.chrome.driver", "C:\\Users\\Pooja\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}
