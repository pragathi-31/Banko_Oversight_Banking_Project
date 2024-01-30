package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingLoginPage {
	
	//Declaration
	@FindBy(name = "customer_id")
	private WebElement customerID;

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "login-btn")
	private WebElement loginButton;
	
	@FindBy(xpath = "//label[text()='FORGET PASSWORD ?']")
	private  WebElement forgotPassword;
	
	//initialization
	public InternetBankingLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	
	public void customerLogin(String custID,String Password) {
		
		customerID.sendKeys(custID);
		password.sendKeys(Password);
		loginButton.click();
	}
	
	public WebElement getForgotPassword() {
		return forgotPassword;
	}
}
