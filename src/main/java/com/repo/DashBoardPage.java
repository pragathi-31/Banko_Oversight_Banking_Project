package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	//Declaration
	@FindBy(linkText = "Home")
	private WebElement homeButton;
	
	@FindBy(linkText = "About Us")
	private WebElement aboutUsButton;
	
	@FindBy(linkText = "Contact Us")
	private WebElement contactUsButton;
	
	@FindBy(linkText = "Staff Login")
	private WebElement staffLoginButton;
	
	//initialization
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void clickOnHomeButton() {
		homeButton.click();
	}

	public void clickOnAboutUsButton() {
		 aboutUsButton.click();
	}

	public void clickOnContactUsButton() {
		contactUsButton.click();;
	}

	public void clickOnStaffLoginButton() {
		 staffLoginButton.click();;
	}

}
