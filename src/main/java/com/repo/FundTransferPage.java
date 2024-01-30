package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	@FindBy(name="add_beneficiary")
	private  WebElement addBeneficiaryButton;
	
	@FindBy(name="delete_beneficiary")
	private  WebElement deleteBeneficiaryButton;
	
	@FindBy(name="view_beneficiary")
	private  WebElement viewBeneficiaryButton;
	
	@FindBy(name="beneficiary")
	private  WebElement selectBeneficiaryDropdown;
	
	@FindBy(name="Amount")
	private  WebElement amountTextField;
	
	@FindBy(name="Remark")
	private  WebElement remarkTextField;
	
	//initialization
			public FundTransferPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			
	//business Logic
			public void transferFund() {
				
			}
			
}
