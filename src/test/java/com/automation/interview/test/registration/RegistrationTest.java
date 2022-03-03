package com.automation.interview.test.registration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.interview.page.registration.RegistrationPage;
import com.automation.interview.utill.Configaration;

public class RegistrationTest extends  Configaration{
	RegistrationPage rp;
	@BeforeClass
	public void setUp() throws Exception{
		getDriver();
		 rp = new RegistrationPage();
	}

	@Test (priority = 0)
	private void registrationTest() throws InterruptedException {
		rp.chekforElementPrecence();
		rp.signInButton();
		String authenticationPage = rp.autheticationText();
		
		Assert.assertEquals(authenticationPage, "AUTHENTICATION");
		
	}
	
	@Test (priority = 1)
	private void enterEmialID() throws InterruptedException {
		
		rp.emaiLTextBox("abc.xyz.com");
		
	}

}
