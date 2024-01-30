package com.repo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.ExcelUtils;
import com.generic.libraries.WebDriverUtils;

public class CustomerProfilePage {
	//declaration
	@FindBy(xpath = "//li[text()='Change Password']")
	private WebElement changePasswordButton;
	
	@FindBy(xpath = "//li[text()='My Account']")
	private WebElement myAccountButton;
	
	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myProfileButton;
	
	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundTransferButton;
	
	@FindBy(xpath = "//li[text()='Statement']")
	private WebElement statementButton;
	
	@FindBy(name = "home")
	private WebElement homeButton;
	
	@FindBy(name = "logout_btn")
	private WebElement logoutButton;
	
	//initialization
		public CustomerProfilePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	//utilization
		public String changePassword(WebDriver driver,String newPass) throws EncryptedDocumentException, IOException {
			changePasswordButton.click();
			ExcelUtils eLib=new ExcelUtils();
			int lastCell = eLib.getLastCellNum("DebitCardDetails", 7);
			String oldpass = eLib.getExcelData("DebitCardDetails", 7, lastCell-1);
			CustomerChangePasswordPage change=new CustomerChangePasswordPage(driver);
			change.getOldpass().sendKeys(oldpass);
			change.getConfirmOldPassword().sendKeys(oldpass);
			change.getNewPassword().sendKeys(newPass);
			int lastCell1 = eLib.getLastCellNum("customerDetails", 1);
			eLib.setExcelData("customerDetails", newPass, 1, lastCell1-1);
			change.getSubmitButton().click();
			WebDriverUtils wLib=new WebDriverUtils();
			String popupText = wLib.alertGetText(driver);
			return popupText;
					
		}
		
		public void fundTransfer() {
			fundTransferButton.click();
			
		}
}
