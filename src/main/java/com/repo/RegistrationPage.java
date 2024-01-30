package com.repo;

import java.awt.AWTException;
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
import org.testng.Assert;

import com.generic.libraries.JavaUtils;
import com.generic.libraries.WebDriverUtils;

public class RegistrationPage {
	
	//Declaration
	@FindBy(name="submit")
	private WebElement submitButton;
	
	@FindBy(name="gender")
	private WebElement gender;
	
	@FindBy(name = "state")
	private WebElement state;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(name = "acctype")
	private WebElement accountType;
	
	@FindBy(name="dob")
	private WebElement dateOfBirth;
	//initialization
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//business logic
	/**
	 * This method will return the necessary details to apply for debitcard
	 * @param map
	 * @param driver
	 * @param enter_gender
	 * @param enter_state
	 * @param enter_city
	 * @param enter_accountType
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public String [] enterDataIntoForm(HashMap<String, String> map,WebDriver driver, String enter_gender,String enter_state, String enter_city, String enter_accountType) throws InterruptedException, AWTException {
		JavaUtils jLib=new JavaUtils();
		int random = jLib.getRandomNumber();
		String holder_name="";
		String pan="";
		String mob="";
		String DateOfBirth="";
		String [] s=new String[4];
		for(Entry<String, String> set:map.entrySet()) {
				if(set.getKey().equals("name")) {
					holder_name=set.getValue()+random;
					s[0]=holder_name;
					driver.findElement(By.name(set.getKey())).sendKeys(holder_name);
				}else if(set.getKey().contains("pan")) {
					pan = set.getValue();
					driver.findElement(By.name(set.getKey())).sendKeys(pan);
					s[1]=pan;
				}else if(set.getKey().contains("mob")) {
					mob = set.getValue();
					driver.findElement(By.name(set.getKey())).sendKeys(mob);
					s[2]=mob;
				}else if(set.getKey().contains("dob")) {
					DateOfBirth=set.getValue();
					JavascriptExecutor js=(JavascriptExecutor) driver;
					String script="arguments[0].setAttribute('value','"+set.getValue()+"');";
					js.executeScript(script, dateOfBirth);
					s[3]=DateOfBirth;
				}
				else {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
			
		}
		//to select dropdown and their respective data
		WebDriverUtils wLib=new WebDriverUtils();
		wLib.select(enter_gender, gender);
		wLib.select(enter_state, state);
		wLib.select(enter_city, city);
		wLib.select(enter_accountType, accountType);
	

		
		submitButton.click();
		return s;
	}
}

//dateOfBirth.click();
//Robot r=new Robot();
//r.keyPress(KeyEvent.VK_2);
//r.keyPress(KeyEvent.VK_TAB);
//r.keyRelease(KeyEvent.VK_TAB);
//r.keyPress(KeyEvent.VK_4);
//Thread.sleep(500);
//r.keyPress(KeyEvent.VK_1);
//Thread.sleep(500);
//r.keyPress(KeyEvent.VK_9);
//Thread.sleep(500);
//r.keyPress(KeyEvent.VK_9);
//Thread.sleep(500);
//r.keyPress(KeyEvent.VK_9);
