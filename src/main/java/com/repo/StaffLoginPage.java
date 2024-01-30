package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	@FindBy(name = "staff_id")
	private WebElement staffID;
	
	@FindBy(name = "password")
	private WebElement staffPassword;
	
	@FindBy(name = "staff_login-btn")
	private WebElement loginButton;
	
	//initialization
	public StaffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business logic
	
	public void staffLogin(String sID,String Password) {
		staffID.sendKeys(sID);
		staffPassword.sendKeys(Password);
		loginButton.click();
	}
}
