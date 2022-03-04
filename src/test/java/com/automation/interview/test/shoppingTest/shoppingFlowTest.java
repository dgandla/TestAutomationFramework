package com.automation.interview.test.shoppingTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.interview.ReadXML.DataBean;
import com.automation.interview.ReadXML.ReadXmlData;
import com.automation.interview.page.SignIn.SignInPage;
import com.automation.interview.page.registration.RegistrationPage;
import com.automation.interview.page.shoppingPage.selectClothes;
import com.automation.interview.utill.Configaration;

public class shoppingFlowTest extends Configaration {

	private static final String LoginDataFile = "SignInData.xml";
	private DataBean emailId;
	private DataBean passsword;
	private Actions action;
	RegistrationPage rp;
	SignInPage signInPage;
	selectClothes selectClothesPage;

	@BeforeClass
	public void setUp() throws Exception {
		getDriver();
		signInPage = new SignInPage();
		rp = new RegistrationPage();
		action = new Actions(driver);
		selectClothesPage = new selectClothes();
		ReadXmlData inputData = new ReadXmlData(LoginDataFile);
		emailId = inputData.getDataBean("Login", "email");
		passsword = inputData.getDataBean("Login", "password");
	}

	@AfterClass
	public void close() throws Exception {
		driver.close();
	}

	@Test(priority = 1)
	public void selectClotes() {
		rp.signInButton();
		signInPage.enterEmail(emailId.getValue());
		signInPage.enterPassword(passsword.getValue());
		signInPage.clickLoginButton();
		Assert.assertTrue(signInPage.validateSucessLogin().isDisplayed());
		// Validate options Visbale after hovering on Women category tab
		action.moveToElement(selectClothesPage.womenCategoryButton()).perform();
		Assert.assertTrue(selectClothesPage.displayDropDown().isDisplayed());
		// Validate options Visbale after hovering on dress category tab
		action.moveToElement(selectClothesPage.DressCategoryButton()).perform();
		Assert.assertTrue(selectClothesPage.displayDropDown().isDisplayed());

		action.moveToElement(selectClothesPage.womenCategoryButton()).perform();
		selectClothesPage.clickCasualDressCatagory();
		Assert.assertTrue(selectClothesPage.casualDressCatagoryAssertion().isDisplayed());

		action.moveToElement(selectClothesPage.selectCasualDress()).perform();
		selectClothesPage.clickAddToCratButton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		selectClothesPage.clickContinueShoppingButton();
		String quntity = selectClothesPage.veifyQuantityInCart().getText();
		Assert.assertEquals(quntity, "1");

	}
	

	@Test(priority = 2)
	public void processSucessFullCheckout() {
		action.moveToElement(selectClothesPage.selectShoppingCart()).perform();
		selectClothesPage.clickCheckOutButton();
		selectClothesPage.clickProceedToCheckoutButton();
		selectClothesPage.enterMessage("Ordering my fav");
		selectClothesPage.clickAddressProceedToCheckout();
		selectClothesPage.acceptTermsAndConditions();
		selectClothesPage.clickShippingProceedToCheckout();
		selectClothesPage.DoPayment();
		Assert.assertTrue(selectClothesPage.doValidatePayment().isDisplayed());

		selectClothesPage.clickConfirmOrder();
		Assert.assertTrue(selectClothesPage.validateConformationMessage().isDisplayed());
	}
}