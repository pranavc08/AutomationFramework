package com.testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageFactory.AccountCreatedPage;
import com.pageFactory.HomePage;
import com.pageFactory.RegisterAccountPage;
import com.utilities.GeneralUtilities;

public class TC_01_AccountRegistration extends BaseCase {

	
	@Test(groups = {"Sanity","Regression","Master"})
	void Register() throws InterruptedException {

		logger.info("*** Starting TC_01_AccountRegistration ***");

		HomePage hp = new HomePage(driver);

		hp.clickOnMyAccount();
		logger.info("Clicked on MyAccount");

		hp.clickOnRegister();
		logger.info("Clicked on Register");

		RegisterAccountPage rp = new RegisterAccountPage(driver);
		rp.enterFirstName();
		rp.enterLastname();
		rp.enterEmail();
		Thread.sleep(1000);

		GeneralUtilities.scrollPageDown(driver);
		logger.info("Page Scrolled");

		rp.enterPassword();
		rp.clickOnPrivacyPolicy();
		Thread.sleep(3000);
		rp.clickOnContinue();

		AccountCreatedPage ap = new AccountCreatedPage(driver);

		logger.info("Validating account created text");
		String actualText = ap.accountCreatedText();
		Assert.assertEquals(actualText, "Your Account Has Been Created!");

		logger.info("Test Case Passed");

	}

}
