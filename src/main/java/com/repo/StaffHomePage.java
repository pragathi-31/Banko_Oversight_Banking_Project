package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {
	
	//Declaration
	
	@FindBy(name = "viewdet")
	private WebElement viewActiveCustomer;
	
	@FindBy(name = "view_cust_by_ac")
	private WebElement viewCustomerByAccNum;
	
	@FindBy(name = "apprvac")
	private WebElement approvePendingAccount;
	
	@FindBy(name = "del_cust")
	private WebElement deleteCustomer;
	
	@FindBy(name = "credit_cust_ac")
	private WebElement creditCustomer;
	
	//initialization
	public StaffHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public void clickOnViewActiveCustomer() {
		viewActiveCustomer.click();
	}
	
	public void clickOnViewCustomerByAccnum() {
		viewCustomerByAccNum.click();
	}
	
	public void clickOnApproveAccount() {
		approvePendingAccount.click();
	}
	
	public void clickOnDeleteCustomer() {
		deleteCustomer.click();
	}
	
	public void clickOnCreditCustomer() {
		creditCustomer.click();
	}
}
