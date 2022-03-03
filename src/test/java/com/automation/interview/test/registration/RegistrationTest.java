package com.automation.interview.test.registration;

import org.testng.annotations.Test;

import com.automation.interview.page.registration.RegistrationPage;
import com.automation.interview.utill.AutomationBase;

public class RegistrationTest extends  AutomationBase{
	

	@Test
	private void registrationTest() throws Exception {
		
		
		RegistrationPage rp = new RegistrationPage();
	
		rp.signInButton();

	}

}
