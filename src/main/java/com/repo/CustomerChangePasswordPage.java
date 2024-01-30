package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerChangePasswordPage {
	//declaration
	@FindBy(name = "oldpass")
	private WebElement oldpass;
	
	@FindBy(name = "cnfrm")
	private WebElement confirmOldPassword;
	
	@FindBy(name = "newpass")
	private WebElement newPassword;
	
	@FindBy(name = "change_pass")
	private WebElement submitButton;
	
	//initialization
	public CustomerChangePasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOldpass() {
		return oldpass;
	}

	public WebElement getConfirmOldPassword() {
		return confirmOldPassword;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
	
	
	
}
