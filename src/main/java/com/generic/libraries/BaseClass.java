package com.generic.libraries;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public DataBaseUtils dLib=new DataBaseUtils();
	public ExcelUtils eLib=new ExcelUtils();
	public Fileutils fLib=new Fileutils();
	public JavaUtils jLib=new JavaUtils();
	public WebDriverUtils wLib=new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	/**
	 * this method is used to connect to the database
	 * @throws SQLException
	 */
	@BeforeSuite(alwaysRun = true )
	public void dbConnection() throws SQLException {
		dLib.registerDriver();
	}
	/**
	 * this method will open the browser, maximize and enter the url 
	 * @throws IOException
	 */
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws IOException {
//		if(value.equals("chrome")) {
//		driver=new ChromeDriver();
//		}else if(value.equals("edge")) {
//		driver=new EdgeDriver();
//		}

		driver=new ChromeDriver();
		sdriver=driver;
		wLib.windowMaximize(driver);
		String URL = fLib.readDataFromProperty("url");
		driver.get(URL);
 		wLib.waitForPageLoadTimeOut(driver, 20);
	}
//	@BeforeMethod
//	public void Login() {
//		System.out.println("--login--");
//	}
//	@AfterMethod
//	public void Logout() {
//		System.out.println("--logout--");
//	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void closedbConnection() throws SQLException {
		dLib.closeConnection();
	}
}
