package com.repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetailsPage {
	
	//Declaration
	@FindBy(name = "account_no")
	private WebElement customerAccountNo;
	
	@FindBy(name = "submit_view")
	private WebElement submitButton;
	
	//initialization
	public CustomerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//business Logic
	public String viewCustomerDetails(WebDriver driver, String accNum) {
		StaffHomePage shp=new StaffHomePage(driver);
		shp.clickOnViewCustomerByAccnum();
		customerAccountNo.sendKeys(accNum);
		submitButton.click();
		
		String amount = driver.findElement(By.xpath("//div[@class='cust_details']/label[7]")).getText();
		return amount;
	}
}
