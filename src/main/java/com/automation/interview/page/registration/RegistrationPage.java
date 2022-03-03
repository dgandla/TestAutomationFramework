package com.automation.interview.page.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.interview.utill.AutomationBase;
import com.automation.interview.utill.Configaration;

public class RegistrationPage extends Configaration {

	public RegistrationPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	@CacheLookup
	private WebElement signInButton;

	@FindBy(xpath = "//input[@id='email_create']")
	@CacheLookup
	private WebElement emaiLTextBox;

	@FindBy(xpath = "//h1[contains(text(),'Authentication')]")
	@CacheLookup
	private WebElement AuthnticationText;

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	@CacheLookup
	private WebElement creatAccountButton;

	@FindBy(xpath = "//li[contains(text(), 'Invalid email address.')]")
	@CacheLookup
	private WebElement inValidEmailErrorMassage;
	
	@FindBy(xpath = "//li[contains(text(), 'An account using this email')]")
	@CacheLookup
	private WebElement exsistingEmailIdErrorMessage;

	@FindBy(xpath = "//div[@id='center_column']")
	@CacheLookup
	private WebElement createAccountForm;
	
	
	public void chekforElementPrecence() {
		AutomationBase.waitForElementPresence(driver, signInButton, 15);
	}

	public void signInButton() {
		signInButton.click();
	}

	public String autheticationText() {
		return AuthnticationText.getText();
	}

	public void emaiLTextBox(String emailID) {
		emaiLTextBox.clear();
		emaiLTextBox.sendKeys(emailID);
	}

	public void createAccountButton() {
		creatAccountButton.click();
	}

	public WebElement inValidEmailErrorMassage() {
		return	AutomationBase.waitForElementPresence(driver, inValidEmailErrorMassage, 15);
		
	}
	
	public WebElement highlatedTextFeild() {
		return	AutomationBase.waitForElementPresence(driver, emaiLTextBox, 15);		
	}
	
	public WebElement exsistingEmailIdErrorMessage() {
		return	AutomationBase.waitForElementPresence(driver, exsistingEmailIdErrorMessage, 15);		
	}
	
	public WebElement displayCreateAnAccountForm() {
		return	AutomationBase.waitForElementPresence(driver, createAccountForm, 15);		
	}
	
}
