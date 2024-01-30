package com.creditCustomer.module;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.libraries.BaseClass;
import com.repo.ConfirmRegistrationPage;
import com.repo.CreditCustomerPage;
import com.repo.CustomerDetailsPage;
import com.repo.DashBoardPage;
import com.repo.HomePage;
import com.repo.PendingCustomerPage;
import com.repo.RegistrationPage;
import com.repo.StaffLoginPage;

public class CreditCustomerTest extends BaseClass{
	@Test
	public void creditCustEndToEndTest() throws Exception {

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
				
				//click on stafflogin and login as staff
				
				
				DashBoardPage db=new DashBoardPage(driver);
				db.clickOnStaffLoginButton();
				String STAFFID = fLib.readDataFromProperty("staffid");
				String PASSWORD = fLib.readDataFromProperty("password");
				StaffLoginPage slp=new StaffLoginPage(driver);
				slp.staffLogin(STAFFID, PASSWORD);

				
				//approve account
				
				
				PendingCustomerPage pcPage=new PendingCustomerPage(driver);
				String accountNumber = pcPage.approveCustomer(driver, applicationNumber);


				//credit customer
				CreditCustomerPage credit=new CreditCustomerPage(driver);
				credit.creditCustomer(driver, accountNumber);
				

				//click on view account by customer number and verify
				
				CustomerDetailsPage details=new CustomerDetailsPage(driver);
				String amount = details.viewCustomerDetails(driver, accountNumber);  
				
				Assert.assertEquals(amount, "Available Balance : $1000.00","amount has not been credited");
			
	}
}
