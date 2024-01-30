package com.repo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.ExcelUtils;
import com.generic.libraries.WebDriverUtils;

public class InternetBankingRegisterPage {
	
	//Declaration
	@FindBy(name="dob")
	private WebElement dateOfBirth;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	//initialization
	public InternetBankingRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String registerForInternetBanking(WebDriver driver) throws EncryptedDocumentException, IOException, AWTException, InterruptedException {
		ExcelUtils eLib=new ExcelUtils();
		int lastCellDigit = eLib.getLastCellNum("DebitCardDetails",0);
		HashMap<String, String> map3 = eLib.hashMapData("DebitCardDetails", lastCellDigit-1);
		
		for(Entry<String, String> set:map3.entrySet()) {
			
			
			if(set.getKey().contains("dob"))
			{
//				
				JavascriptExecutor js=(JavascriptExecutor) driver;
				String script="arguments[0].setAttribute('value','"+set.getValue()+"');";
				js.executeScript(script, dateOfBirth);
			}else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			}
			
		}
//		dateOfBirth.click();
//		Robot robo=new Robot();
//		robo.keyPress(KeyEvent.VK_2);
//		robo.keyPress(KeyEvent.VK_TAB);
//		robo.keyRelease(KeyEvent.VK_TAB);
//		robo.keyPress(KeyEvent.VK_4);
//		Thread.sleep(500);
//		robo.keyPress(KeyEvent.VK_1);
//		Thread.sleep(500);
//		robo.keyPress(KeyEvent.VK_9);
//		Thread.sleep(500);
//		robo.keyPress(KeyEvent.VK_9);
//		Thread.sleep(500);
//		robo.keyPress(KeyEvent.VK_9);
//	
		submitButton.click();
		
		WebDriverUtils wLib=new WebDriverUtils();
		String custID="";
		
			wLib.waitTillAlertIsPresent(driver);
			String text1=wLib.alertGetText(driver);			
			
			char[] ch1 = text1.toCharArray();
			for(int i=0;i<text1.length();i++) {

				if(Character.isDigit(ch1[i])) {
					custID=custID+ch1[i];
				}
			}
			wLib.alertAccept(driver);
			return custID;
	}
}
