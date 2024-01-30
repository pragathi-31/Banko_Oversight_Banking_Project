package com.generic.libraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtils {
	
	/**
	 * this method is used to maximize the browser
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to minimize the browser
	 * @param driver
	 */
	public void windowMinimize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to wait till the page gets loaded
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoadTimeOut(WebDriver driver, int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	/**
	 * this method is used to wait until the element is present
	 * @param driver
	 * @param sec
	 * @param element
	 */
	
	public void waitUntilTheElementIsPresent(WebDriver driver,int sec, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.presenceOfElementLocated((By)element));
	}
	/**
	 * this method is used to wait until the element is present
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilTheElementIsLocated(WebDriver driver,int sec, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method returns the instance of actions class
	 * @param driver
	 * @return
	 */
	public Actions actionClassObject(WebDriver driver) {
		Actions a=new Actions(driver);
		return a;
	}
	/**
	 * This method will double click on the target
	 * @param driver
	 * @param target
	 */
	public void actionDoubleClickOnTarget(WebDriver driver, WebElement target) {
		
		actionClassObject(driver).doubleClick(target).perform();;
	}
	/**
	 * this method will double click on the active element
	 * @param driver
	 */
	public void actionDoubleClick(WebDriver driver) {
		actionClassObject(driver).click().perform();;
	}
	/**
	 * this method will drag and drop from a particular source to destination
	 * @param driver
	 * @param source
	 * @param destination
	 */
	public void actionDragAndDrop(WebDriver driver, WebElement source, WebElement destination) {
		
		actionClassObject(driver).dragAndDrop(source, destination).perform();;
	}
	/**
	 * this method is used to move an element to a particular target
	 * @param driver
	 * @param target
	 */
	public void actionMoveToElement(WebDriver driver, WebElement target) {
		actionClassObject(driver).moveToElement(target).perform();;
	}
	/**
	 * this method will do right click on a active element
	 * @param driver
	 */
	public void contextClick(WebDriver driver)
	{
		actionClassObject(driver).perform();
	}
	/**
	 * this method will do right click on a target element
	 * @param element
	 * @param driver
	 */
	public void contextClickElement(WebElement element,WebDriver driver)
	{
		actionClassObject(driver).contextClick(element).perform();
	}
	/**
	 * this method is used to press enter using actions class
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		actionClassObject(driver).sendKeys(Keys.ENTER).perform();
	}
	/**
	 * this method is used scroll to a particular element
	 * @param element
	 * @param driver
	 */
	public void scroll(WebElement element,WebDriver driver) {
		actionClassObject(driver).scrollToElement(element).perform();
	}
	/**
	 * this method is used to scroll from one coordinate to another
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scroll(WebDriver driver, int x, int y) {
		actionClassObject(driver).scrollByAmount(x, y).perform();
	}
	/**
	 * this method will click on a target element
	 * @param driver
	 */
	public void actionClick(WebDriver driver, WebElement target) {
		actionClassObject(driver).click(target).perform();
	}
	//---------------Select----------------------------
	/**
	 * this method will return select class object
	 * @param element
	 * @return
	 */
	public Select selectClassObject(WebElement element) {
		 Select s=new Select(element);
		 return s;
	}
	/**
	 * this method will select based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		selectClassObject(element).selectByIndex(index);
	}
	/**
	 * this method will select based on value
	 * @param element
	 * @param Data
	 */
	public void select(WebElement element, String Data)
	{
		selectClassObject(element).selectByValue(Data);
	}
	/**
	 * this method will select based on visible text
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element)
	{
		selectClassObject(element).selectByVisibleText(text);
	}										
	
	//-----------------Robot-------------------
	
//	public void enterKeyUsingRobot() throws AWTException
//	{
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_ENTER);
//	}
//	public void enterRelease() throws AWTException
//	{
//		Robot r=new Robot();
//		r.keyRelease(KeyEvent.VK_ENTER);
//	}
	/**
	 * This method is used to switch the frame using index value
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame using element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	
	}
	/**
	 * This method is used to switch the frame using frame name or id
	 * @param driver
	 * @param name
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch the frame using frame address
	 * @param address
	 * @param driver
	 */
	public void switchToFrame(String address,WebDriver driver)
	{
		driver.switchTo().frame(address);
	}
	public Alert alert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	/**
	 * This method is used to click on ok button on alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		alert(driver).accept();
	}
	
	/**
	 * This method is used to click on cancel button on alert popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		alert(driver).dismiss();
	}
	/**
	 * This method is used to enter data on  alert popup
	 * @param driver
	 * @param data
	 */
	public void alertSendKeys(WebDriver driver,String data)
	{
		alert(driver).sendKeys(data);
	}
	
	/**
	 * This method is used to get the text from  alert popup
	 * @param driver
	 */
	public String alertGetText(WebDriver driver)
	{
		return alert(driver).getText();
	}
	
	/**
	 * This method switch between windows
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//Use getWindowHandles to capture all the windows
		Set<String> windows = driver.getWindowHandles();
		
		//iterate over all the windows
		Iterator<String> it = windows.iterator();
		
		//check whether next window is there or not
		while(it.hasNext())
		{
			//capture current window ID
			String winId = it.next();
			
			//iterate over window based on that ID and capture the title
			String CurrentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//check whether current window is as expected
			if(CurrentWinTitle.contains(partialWinTitle))
			{
				break;
			}	
		}
	}
	
	/**
	 * This method will take  screenshot and stored it into a folder called as screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException 
	 */
	
	public String getScreenShot(WebDriver driver, String screenShotName) throws IOException
	{	
		JavaUtils jLib=new JavaUtils();
		TakesScreenshot t=(TakesScreenshot)BaseClass.sdriver;
		 File src = t.getScreenshotAs(OutputType.FILE);
		String path=".\\src\\test\\resources\\ScreenShot\\"+screenShotName+jLib.getSystemDateInFormat()+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
			}
		/**
		 * This method is used to get the location of particular element
		 * @param driver
		 */
	public void scroll(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}	
	
	public void waitTillAlertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
}
