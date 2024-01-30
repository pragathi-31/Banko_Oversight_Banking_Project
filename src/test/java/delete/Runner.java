package delete;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.generic.libraries.WebDriverUtils;

public class Runner{
	@Test
	public void irctcTest() {
		WebDriverUtils wLib=new WebDriverUtils();
		EdgeOptions option=new EdgeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new EdgeDriver(option);
		driver.get("https://www.irctc.co.in/");
		wLib.windowMaximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
		String pw = driver.getWindowHandle();
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh) {
			
			driver.switchTo().window(wh);
			if(!(pw.equals(wh))) {
				
				driver.findElement(By.id("departFrom")).sendKeys("bangalore");
				
				WebElement bangalore = driver.findElement(By.xpath("//div[text()='Bangalore']"));
				wLib.waitUntilTheElementIsLocated(driver, 10, bangalore);
				bangalore.click();
				
				driver.findElement(By.id("goingTo")).sendKeys("Goa");
				WebElement goa = driver.findElement(By.xpath("//div[text()='Goa']"));
				wLib.waitUntilTheElementIsLocated(driver, 10, goa);
				goa.click();
				
				driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='25']")).click();
				driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
				driver.findElement(By.xpath("//h4[text()='Departure Time']/../descendant::label[text()='After 6 pm']")).click();
				driver.findElement(By.xpath("//label[text()='Anand Travels']/../following-sibling::div[@class='SearchCard SearchCard07']/button")).click();
				driver.findElement(By.xpath("//span[contains(@title,'Seat No. : L3')]")).click();			
				driver.findElement(By.xpath("//td[contains(text(),' Koramangala')]/preceding-sibling::td//input[@name='bordTime']")).click();
				driver.findElement(By.xpath("//td[contains(text(),' Canacona')]/preceding-sibling::td//input[@name='debordTime']")).click();
				driver.findElement(By.xpath("//button[text()='Proceed to Book']")).click();
				driver.findElement(By.xpath("//a[text()='Guest User Login ']")).click();
				
				driver.findElement(By.id("emailLogin")).sendKeys("vpragathi@gmail.com");
				driver.findElement(By.id("phoneLogin")).sendKeys("9876789871");
		
				driver.findElement(By.xpath("//div[@id='profile']/descendant::button[text()='Login']")).click();
				
				driver.findElement(By.name("mobileno")).sendKeys("9876789871");
				driver.findElement(By.name("address")).sendKeys("hsk halli bengaluru");
				driver.findElement(By.name("pincode")).sendKeys("560085");
				
				WebElement country = driver.findElement(By.name("country"));
				wLib.select("India", country);
				WebElement state = driver.findElement(By.name("state"));
				wLib.select("KARNATAKA", state);
				
				driver.findElement(By.xpath("//input[@placeholder='Traveller Name']")).sendKeys("pragathi");
				WebElement gender = driver.findElement(By.name("select"));
				wLib.select("Female", gender);
				
				driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("25");
				
				driver.findElement(By.name("agree")).click();
				
				driver.findElement(By.xpath("//button[text()='Continue to Book ']")).click();
				
				
		
				
			}
		}
		
	
	}
}
