package com.openAccount.module;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.generic.libraries.BaseClass;
import com.repo.ConfirmRegistrationPage;
import com.repo.HomePage;
import com.repo.InternetBankingLoginPage;
import com.repo.RegistrationPage;
@Listeners(com.generic.libraries.ListenerImplementation.class)
public class OpenAccountSmokeTest extends BaseClass {
	@Test(retryAnalyzer =  com.generic.libraries.RetryAnalyzer.class)
	public void OpenAccSmokeTest() throws Exception {
				
				//click on open account
				HomePage hp=new HomePage(driver);
				hp.clickOnOpenAcc();
			
				//to send multiple data to multiple text fields
				
				HashMap<String, String> map = eLib.hashMapData("OpenAccount", 1);
				
				//enter the required data and click on submit button and return the data required for applying debit card
				RegistrationPage page=new RegistrationPage(driver);
				page.enterDataIntoForm(map, driver, "Female", "Texas", "San Diego", "Saving");
				 
				//verify the details and click on confirm button it will generate a customer application number
				ConfirmRegistrationPage confirm=new ConfirmRegistrationPage(driver);
				String applicationNumber = confirm.clickOnConfirmButton(driver);	
				System.out.println("Application Number "+applicationNumber);
				
				
				}	
	@Test
public void internetBankingSmokeTest() throws Exception {
		
		//click on Internet Banking login
		HomePage hp=new HomePage(driver);
		hp.clickOnInternetBankingLogin(driver);
		
		//login using customer id and password
		InternetBankingLoginPage login=new InternetBankingLoginPage(driver);
		int lastCell = eLib.getLastCellNum("customerDetails", 0);
		String customerID = eLib.getExcelData("customerDetails", 0, lastCell-1);
		String customerPassword = eLib.getExcelData("customerDetails", 1, lastCell-1);
		login.customerLogin(customerID, customerPassword);
		
		String etitle="My Profile";
		String atitle=driver.getTitle();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(atitle, etitle, "Customer login page is not displayed");
		
				
	}

	}

