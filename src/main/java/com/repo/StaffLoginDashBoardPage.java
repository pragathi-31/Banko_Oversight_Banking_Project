package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginDashBoardPage {
	
	//Declaration
	@FindBy(name = "home")
	private WebElement homeButton;
	
	@FindBy(name = "logout_btn")
	private WebElement logoutButton;
	
	//initialization
		public StaffLoginDashBoardPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
	//utilization
		public void clickOnHomeButton() {
			homeButton.click();
		}
		
		public void clickOnLogoutButton() {
			logoutButton.click();
		}
		
}
