package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement txtMyAccount;
	
	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	WebElement lnkLogout;
	

	public boolean myAccountText() {

		try {

			return txtMyAccount.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public void clickOnLogoutButton() {
		
		lnkLogout.click();
	}
}
