package com.repo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.Fileutils;
import com.generic.libraries.WebDriverUtils;

public class PendingCustomerPage {
	
	//Declaration
	@FindBy(name = "application_no")
	private WebElement applicationNumber;
	
	@FindBy(name = "search_application")
	private WebElement searchButton;
	
	@FindBy(name = "approve_cust")
	private WebElement approveButton;
	
	//initialization
	public PendingCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getApplicationNumber() {
		return applicationNumber;
	}
	
	//business logic
	/**
	 * this method will approve the customer using their application number and return their account number
	 * @param driver
	 * @param appNumber
	 * @return
	 * @throws IOException
	 */
	public String approveCustomer(WebDriver driver,String appNumber) throws IOException {
		
		StaffHomePage sf=new StaffHomePage(driver);
		sf.clickOnApproveAccount();
		StaffLoginDashBoardPage sdb=new StaffLoginDashBoardPage(driver);
		applicationNumber.sendKeys(appNumber);
		searchButton.click();
		
		String application = null;
		application=driver.findElement(By.xpath("//div[@class='pending_customers_container']//tbody/tr[2]/td[2]")).getText();
		WebDriverUtils wLib=new WebDriverUtils();
		String accnum="";
		if(application!=null) {
			
			approveButton.click();
			wLib.waitTillAlertIsPresent(driver);
			String text1=wLib.alertGetText(driver);			

			char[] ch1 = text1.toCharArray();
			for(int i=0;i<text1.length();i++) {

				if(Character.isDigit(ch1[i])) {
					accnum=accnum+ch1[i];
				}
			}
			wLib.alertAccept(driver);

		}
		else {
			wLib.alertAccept(driver);
			System.out.println("customer not approved");
			sdb.clickOnLogoutButton();
		}
		sdb.clickOnHomeButton();
		return accnum;
	}
	
	
}
