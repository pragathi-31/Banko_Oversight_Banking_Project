
package com.internetBanking.module;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.generic.libraries.BaseClass;
import com.repo.HomePage;
import com.repo.InternetBankingLoginPage;

public class InternetBankingTest extends BaseClass {
	@Test()
	
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
