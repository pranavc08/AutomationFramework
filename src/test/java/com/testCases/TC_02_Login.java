package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageFactory.LoginPage;
import com.pageFactory.MyAccountPage;
import com.utilities.GeneralUtilities;
import com.pageFactory.HomePage;

public class TC_02_Login extends BaseCase {

	@Test(groups = { "Regression", "Master" })
	void login() throws InterruptedException {

		logger.info("*** Starting TC_02_Login ***");

		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		logger.info("Clicked on MyAccount");

		hp.clickOnLogin();
		logger.info("Clicked on Login");

		LoginPage lp = new LoginPage(driver);
		lp.enterEmail();
		lp.enterPassword();
		Thread.sleep(3000);

		GeneralUtilities.scrollPageDown(driver);
		logger.info("Page Scrolled");

		Thread.sleep(3000);
		lp.clickOnLoginButton();

		MyAccountPage ap = new MyAccountPage(driver);

		logger.info("Validating My Account text");
		boolean textPresent = ap.myAccountText();
		Assert.assertTrue(textPresent);

		logger.info("Test Case Passed");

	}
}
