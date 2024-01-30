package com.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtils;

public class HomePage {
	
	//Declaration
	
	@FindBy(linkText="Open Account")
	private WebElement openAcc;
	
	@FindBy(xpath ="//li[text()='Apply Debit Card']")
	private WebElement applyDebitcard;
	
	@FindBy(xpath = "//div[@class='ebanking']//a[contains(text(),'Internet Banking')]")
	private WebElement IBanking;
	
	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundTransfer;
	
	@FindBy(xpath = "//li[text()='Login ']")
	private WebElement IBLogin;
	
	@FindBy(xpath = "//li[text()='Register']")
	private WebElement IBRegister;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization


	

	public WebElement getFundTransfer() {
		return fundTransfer;
	}

	//business Login
	public void clickOnOpenAcc() {
		openAcc.click();;
	}
	
	public void clickOnInternetBankingLogin(WebDriver driver) throws InterruptedException {
		WebDriverUtils wLib=new WebDriverUtils();
		wLib.actionMoveToElement(driver, IBanking);
		wLib.actionClick(driver, IBLogin);
	}
	
	public void clickOnInternetBankingRegister(WebDriver driver) throws InterruptedException {
		WebDriverUtils wLib=new WebDriverUtils();
		wLib.actionMoveToElement(driver, IBanking);
		wLib.actionClick(driver, IBRegister);
	}
	public void clickOnApplyDebitcard() {
		applyDebitcard.click();
	}
}
