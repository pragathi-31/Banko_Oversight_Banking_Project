package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtils;

public class CreditCustomerPage {
	
	//Declaration
	@FindBy(name = "customer_account_no")
	private WebElement customerAccNum;
	
	@FindBy(name = "credit_amount")
	private WebElement amount;
	
	@FindBy(name = "credit_btn")
	private WebElement creditButton;
	
	//initialization
		public CreditCustomerPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Business logic
		
		public void creditCustomer(WebDriver driver,String accNum) {
			StaffHomePage shp=new StaffHomePage(driver);
			shp.clickOnCreditCustomer();
			customerAccNum.sendKeys(accNum);
			amount.sendKeys("1000");
			creditButton.click();
			WebDriverUtils wLib=new WebDriverUtils();
			wLib.alertAccept(driver);
			StaffLoginDashBoardPage db=new StaffLoginDashBoardPage(driver);
			db.clickOnHomeButton();
			
		}
	

}
