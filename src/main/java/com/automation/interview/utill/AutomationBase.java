package com.automation.interview.utill;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationBase {

	public static WebElement waitForElementPresence(WebDriver driver, WebElement webElement, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.visibilityOf(webElement));
		return element;
	}

	public void getBehaviour() {

	}
}
