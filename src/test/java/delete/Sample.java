package delete;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.generic.libraries.Fileutils;
import com.repo.HomePage;

public class Sample {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bigbasket.com");
		driver.findElement(By.xpath("//input[@placeholder='Search for Products...']")).sendKeys("watermelon"+Keys.ENTER);
		
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='break-words h-10 w-full']//h3[contains(text(),'Watermelon')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='break-words h-10 w-full']//h3[contains(text(),'Watermelon')]//ancestor::a[@class='h-full']/..//following-sibling::div[@class='flex flex-col gap-0.5']//span[1]"));
		
		System.out.println(names.size());
		System.out.println(prices.size());
//		for(int i=0;i<names.size();i++) {
			//System.out.println(names.get(i).getText());
			//System.out.println(prices.get(i).getText());
//			String eachPrice = prices.get(i).getText();
//			char[] ch = eachPrice.toCharArray();
//			String price="";
//			for(int j=1;j<ch.length;j++) {
//				price=price+ch[j];
//			}
//			
//			double value = Double.parseDouble(price);
//			if(value<=100) {
//				System.out.println(names.get(i).getText());
//			}
//			
			
		//}
	
	
	
	//driver.quit();
		//input[@fdprocessedid='agm1t' and @placeholder='Search for Products...']
	
	
	
	
	
	
	
	
	
	
	}
}
//Fileutils fLib=new Fileutils();
//String URL = fLib.readDataFromProperty("url");
//WebDriver driver=new EdgeDriver();
//driver.get(URL);
//driver.manage().window().maximize();
//HomePage hp=new HomePage(driver);
//hp.clickOnApplyDebitcard();
//String date="10/09/2020";
//WebElement ele = driver.findElement(By.name("dob"));
//JavascriptExecutor js=(JavascriptExecutor) driver;
//String script="arguments[0].setAttribute('value','"+date+"');";
//js.executeScript(script, ele);
////span[text()='iphone']