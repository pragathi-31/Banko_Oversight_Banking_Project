package com.applyDebitCard.module;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.generic.libraries.BaseClass;
import com.repo.ApplyDebitCardPage;
import com.repo.ConfirmRegistrationPage;
import com.repo.DashBoardPage;
import com.repo.HomePage;
import com.repo.PendingCustomerPage;
import com.repo.RegistrationPage;
import com.repo.StaffLoginPage;
@Listeners(com.generic.libraries.ListenerImplementation.class)
public class ApplyDebitCardTest extends BaseClass {
	@Test
	public void applyDebitCardEndToEnd() throws Throwable {
				//click on open account
				HomePage hp=new HomePage(driver);
				hp.clickOnOpenAcc();
				
				//to send multiple data to multiple text fields
				
				HashMap<String, String> map = eLib.hashMapData("OpenAccount", 1);
				
				
				//enter the required data and click on submit button and return the data required for applying debit card
				RegistrationPage page=new RegistrationPage(driver);
				String[] registrationDate = page.enterDataIntoForm(map, driver, "Female", "Texas", "San Diego", "Saving");
			
				//verify the details and click on confirm button it will generate a customer application number
				ConfirmRegistrationPage confirm=new ConfirmRegistrationPage(driver);
				String applicationNumber = confirm.clickOnConfirmButton(driver);	
				
				//click on staff login and enter valid username and password and login
				DashBoardPage db=new DashBoardPage(driver);
				db.clickOnStaffLoginButton();
				String sID = fLib.readDataFromProperty("staffid");
				String pwd = fLib.readDataFromProperty("password");
				StaffLoginPage login=new StaffLoginPage(driver);
				login.staffLogin(sID, pwd);
				
				//approve account
				
				PendingCustomerPage pcPage=new PendingCustomerPage(driver);
				String accountNumber = pcPage.approveCustomer(driver, applicationNumber);
		
		
		
		//write data into excel to use while applying for debitcard
		eLib.setExcelData("DebitCardApply", registrationDate[0],0);
		eLib.setExcelData("DebitCardApply", registrationDate[1],1);
		eLib.setExcelData("DebitCardApply", registrationDate[2],2);
		eLib.setExcelData("DebitCardApply", accountNumber,3);
		eLib.setExcelData("DebitCardApply", registrationDate[3],4);
		
		
		//click on home major tab
		db.clickOnHomeButton();
		//apply debit card
		Thread.sleep(2000);
		hp.clickOnApplyDebitcard();
		ApplyDebitCardPage apply=new ApplyDebitCardPage(driver);
		String[] debitDetails = apply.applyDebitCard(driver);
		System.out.println("Debit card number: "+debitDetails[0]);
		System.out.println("Debit card pin: "+debitDetails[1]);
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(driver.getTitle(), "Apply Debit Card", "apply debit card page is not dislayed");
	
	}
}
