package delete;

import java.io.FileInputStream;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.libraries.DataBaseUtils;
import com.generic.libraries.Fileutils;
import com.generic.libraries.WebDriverUtils;

public class Delete {
	@Test
	public void deleteaccTest() throws Exception {
		

	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//entering the url
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p=new Properties();
		p.load(fi);
		String URL = p.getProperty("url");
		driver.get(URL);
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Fileutils u=new Fileutils();
		driver.findElement(By.linkText("Staff Login")).click();
		String staffID = u.readDataFromProperty("staffid");
		String staffPassword = u.readDataFromProperty("password");		
		driver.findElement(By.name("staff_id")).sendKeys(staffID);
		driver.findElement(By.name("password")).sendKeys(staffPassword);
		driver.findElement(By.name("staff_login-btn")).click();
		for(int i=400;i>=0;i--) {
		driver.findElement(By.name("viewdet")).click();
		
		String cust_id = driver.findElement(By.xpath("//div[@class='active_customers_container']/descendant::tr["+i+"]/td[3]")).getText();
		String acc_num = driver.findElement(By.xpath("//div[@class='active_customers_container']/descendant::tr["+i+"]/td[4]")).getText();
		
		driver.findElement(By.name("home")).click();
		
		driver.findElement(By.name("del_cust")).click();
		driver.findElement(By.name("Cust_ac_no")).sendKeys(acc_num);
		driver.findElement(By.name("Cust_ac_Id")).sendKeys(cust_id);
		driver.findElement(By.name("reason")).sendKeys("relocation");
		
		Thread.sleep(500);
		driver.findElement(By.name("delete")).click();
		
		try{
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}catch (Exception e) {
		}
		driver.findElement(By.name("home")).click();
		System.out.println(i);
		
		}
		
	
		
		
		
		
		
		
		
		
	}
}
