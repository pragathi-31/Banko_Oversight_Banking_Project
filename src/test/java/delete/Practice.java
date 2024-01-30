package delete;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.generic.libraries.BaseClass;
import com.repo.ApplyDebitCardPage;
import com.repo.ConfirmRegistrationPage;
import com.repo.DashBoardPage;
import com.repo.HomePage;
import com.repo.InternetBankingLoginPage;
import com.repo.InternetBankingRegisterPage;
import com.repo.PendingCustomerPage;
import com.repo.RegistrationPage;
import com.repo.StaffLoginPage;



public class Practice extends BaseClass{
	
	@Test
	public void practice() throws Throwable {

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
		hp.clickOnApplyDebitcard();
		ApplyDebitCardPage apply=new ApplyDebitCardPage(driver);
		String[] debitCardDetails = apply.applyDebitCard(driver);


		//writing data into excel to send the data into Internet banking page
		eLib.setExcelData("DebitCardDetails", registrationDate[0],0);
		eLib.setExcelData("DebitCardDetails", accountNumber,1);
		eLib.setExcelData("DebitCardDetails",debitCardDetails[0],2);
		eLib.setExcelData("DebitCardDetails",debitCardDetails[1],3);
		eLib.setExcelData("DebitCardDetails", registrationDate[2],4);
		eLib.setExcelData("DebitCardDetails", registrationDate[1],5);
		eLib.setExcelData("DebitCardDetails", "0", 6);
		eLib.setExcelData("DebitCardDetails", "password", 7);
		eLib.setExcelData("DebitCardDetails", "password", 8);
		eLib.setExcelData("DebitCardDetails", registrationDate[3], 9);

		//click on home button and then click on internet banking register
		db.clickOnHomeButton();
		hp.clickOnInternetBankingRegister(driver);


		//enter Internet banking details
		InternetBankingRegisterPage register=new InternetBankingRegisterPage(driver);
		String customerID=register.registerForInternetBanking(driver);

		//get the customer id 
		eLib.setExcelData("customerDetails", customerID,0);
		eLib.setExcelData("customerDetails", "password", 1);


		//login to internet banking

		int lastCell = eLib.getLastCellNum("customerDetails", 0);
		String custID = eLib.getExcelData("customerDetails", 0,lastCell-1 );
		String customerPassword = eLib.getExcelData("customerDetails", 1, lastCell-1);
		db.clickOnHomeButton();
		hp.clickOnInternetBankingLogin(driver);
		InternetBankingLoginPage IBlogin=new InternetBankingLoginPage(driver);
		IBlogin.customerLogin(custID, customerPassword);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Fileutils fLib=new Fileutils();
//	String BROWSER = fLib.readDataFromProperty("browser");
//	String URL = fLib.readDataFromProperty("url");
//	
//	if(BROWSER.equals("edge")) {
//	 driver=new EdgeDriver();
//	}
//	driver.get(URL);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@BeforeTest
//	public void bt() {
//		System.out.println("bt");
//	}
//	@AfterTest
//	public void at() {
//		System.out.println("at");
//	}
//	@BeforeSuite
//	public void dbConnection() {
//		System.out.println("--open connection---");
//	}
//	
//	@BeforeClass
//	public void openBrowser() {
//		System.out.println("--launch the browser--");
//	}
//	
//	@BeforeMethod
//	public void loginOne() {
//		System.out.println("--login one to the application--");
//	}
//	
//	@Test
//	public void testScriptOneTest() {
//		System.out.println("--one executing--");
//	}
//	@Test
//	public void testScriptTwoTest() {
//		System.out.println("--two executing--");
//	}
//	@AfterMethod
//	public void logoutOne() {
//		System.out.println("--logout one from the application--");
//	}
//	
//	@AfterClass
//	public void closeBrowser() {
//		System.out.println("--close the browser--");
//	}
//	@AfterSuite
//	public void closeDBConnection() {
//		System.out.println("--close connection--");
//	}
//	
//	
//	
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
//	@Test(priority = 1, invocationCount = 2)
//	public void openAcc() {
//		System.out.println("customer opened an account");
//	}
//	@Test(priority = 2)
//	public void applyDebitCard() {
//		System.out.println("customer applied for debit card");
//	}
//	@Test(priority = 3,dependsOnMethods = "applyDebitCard")
//	public void internetBankingRegister() {
//		System.out.println("Register successfull");
//	}
//	@DataProvider
//	public Object[][] dataPro() {
//		  Object[][] obj = new Object[3][2];
//		  obj[0][0]="pragathi";
//		  obj[0][1]="selenium";
//		  
//		  obj[1][0]="suyasha";
//		  obj[1][1]="java";
//		  
//		  obj[2][0]="niveditha";
//		  obj[2][1]="manual";
//		  
//		  return obj;
//	}
//	@Test(dataProvider = "dataPro")
//	public void subjects(String name,String subj) {
//		System.out.println(name+"---->"+subj);
//	}
}
