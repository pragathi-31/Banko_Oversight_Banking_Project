package delete;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mock {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+Keys.ENTER);
		
		
		 List<WebElement> allele = driver.findElements(By.xpath("//span[text()='Apple']/ancestor::div[@data-cy='title-recipe']/descendant::span[text()='iPhone 13 (128GB) - Starlight']/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row']/descendant::a[@class='a-link-normal']"));
		 System.out.println(allele.size());
	for(WebElement ele:allele) {
		String color = ele.getAttribute("aria-label");
		System.out.println(color);
	}
	driver.quit();
	}
}


//div[@class='break-words h-10 w-full']//h3[contains(text(),'Watermelon')]//ancestor::a[@class='h-full']/..//following-sibling::div[@class='flex flex-col gap-0.5']//span[1]