package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtils;

public class ConfirmRegistrationPage {
	
	//Declaration
	@FindBy(name="cnfrm-submit")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//input[@value='Go back']")
	private WebElement gobackButton;
	
	
	public ConfirmRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	//BusinessLogic
	/**
	 * this method will return the application number of a customer
	 * @param driver
	 * @return
	 */
	public String clickOnConfirmButton(WebDriver driver) {
		confirmButton.click();
		
		//handle the alert pop up
		WebDriverUtils wLib=new WebDriverUtils();
		wLib.alert(driver);
		String text = wLib.alertGetText(driver);			
		String appl="";
		char[] ch = text.toCharArray();
		for(int i=0;i<text.length();i++) {

			if(Character.isDigit(ch[i])) {
				appl=appl+ch[i];
			}
		}
		wLib.alertDismiss(driver);
		return appl;
		
	}
	public void clickOnGoBackButton() {
		gobackButton.click();
	}
	
}
