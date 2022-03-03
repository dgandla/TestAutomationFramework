package com.automation.interview.page.registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.interview.utill.AutomationBase;

public class RegistrationPage extends AutomationBase{


	public RegistrationPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInButton;
	
	

	public void signInButton() {
		
		signInButton.click();
		
	}

}
