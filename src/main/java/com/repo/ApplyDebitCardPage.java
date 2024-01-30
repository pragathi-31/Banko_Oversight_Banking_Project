package com.repo;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.ExcelUtils;
import com.generic.libraries.WebDriverUtils;

public class ApplyDebitCardPage {
	
	//Declaration
	@FindBy(name = "dbt_crd_submit")
	private WebElement submitButton;
	
	@FindBy(name = "dob")
	private WebElement dateOfBirth;
	
	//initialization
	public ApplyDebitCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public String[] applyDebitCard(WebDriver driver) throws Throwable {
		
		ExcelUtils eLib=new ExcelUtils();
		int lastCell = eLib.getLastCellNum("DebitCardApply", 0);
		
		HashMap<String, String> map1 = eLib.hashMapData("DebitCardApply", lastCell-1);
		
		for(Entry<String, String> set:map1.entrySet()) {
			
			if(set.getKey().contains("dob"))
			{
				JavascriptExecutor js=(JavascriptExecutor) driver;
				String script="arguments[0].setAttribute('value','"+set.getValue()+"');";
				js.executeScript(script, dateOfBirth);
			}else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			}
			
		}
//		dateOfBirth.click();
//		Robot rob=new Robot();
//		rob.keyPress(KeyEvent.VK_2);
//		rob.keyPress(KeyEvent.VK_TAB);
//		rob.keyRelease(KeyEvent.VK_TAB);
//		rob.keyPress(KeyEvent.VK_4);
//		Thread.sleep(500);
//		rob.keyPress(KeyEvent.VK_1);
//		Thread.sleep(500);
//		rob.keyPress(KeyEvent.VK_9);
//		Thread.sleep(500);
//		rob.keyPress(KeyEvent.VK_9);
//		Thread.sleep(500);
//		rob.keyPress(KeyEvent.VK_9);
		
		submitButton.click();
		
		WebDriverUtils wLib=new WebDriverUtils();
		String debitText = wLib.alertGetText(driver);
		String debit="";
		char[] ch1 = debitText.toCharArray();
		for(int i=0;i<debitText.length();i++) {
		
			if(Character.isDigit(ch1[i])) {
				debit=debit+ch1[i];
			}
		}
		char[] ch2 = debit.toCharArray();
		String debitCardNumber="";
		String debitCardPin="";
		
		for(int i=0;i<ch2.length;i++) {
			if(i>=0&&i<=11) {
				debitCardNumber=debitCardNumber+ch2[i];
			}else {
				debitCardPin=debitCardPin+ch2[i];
			}
		}
		wLib.alertAccept(driver);
		String[]s=new String[2];
		s[0]=debitCardNumber;
		s[1]=debitCardPin;
		return s;
	}
	
}
