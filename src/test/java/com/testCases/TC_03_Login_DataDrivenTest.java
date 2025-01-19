package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageFactory.HomePage;
import com.pageFactory.LoginPage;
import com.pageFactory.MyAccountPage;
import com.utilities.DataProviders;
import com.utilities.GeneralUtilities;

public class TC_03_Login_DataDrivenTest extends BaseCase {

	@Test(groups = "dataDriven", dataProvider = "loginData" , dataProviderClass = DataProviders.class)
	void login_DDT(String email, String password, String exp) throws InterruptedException {
		
	logger.info("*** Starting TC_02_Login ***");

	HomePage hp = new HomePage(driver);
	
	hp.clickOnMyAccount();
	logger.info("Clicked on MyAccount");

	hp.clickOnLogin();
	logger.info("Clicked on Login");

	LoginPage lp = new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(password);
	Thread.sleep(3000);
	lp.clickOnLoginButton();

	MyAccountPage ap = new MyAccountPage(driver);
    boolean textPresent = ap.myAccountText();
    
    
	/*
	 * Valid Data - login success - test pass - logout login failed - test fail
	 * 
	 * Invalid Data - login success - test fail - logout Invalid Data - login failed
	 * - test pass
	 */
	
	if (exp.equalsIgnoreCase("Valid")) {

		if (textPresent == true) {

			Assert.assertTrue(true);
			logger.info("Test Case Passed");
			hp.clickOnMyAccount();
			ap.clickOnLogoutButton();

		} else {

			logger.info("Test Case Failed");
			Assert.assertTrue(false);
		}
	}

	if (exp.equalsIgnoreCase("Invalid")) {

		if (textPresent == true) {

			ap.clickOnLogoutButton();
			logger.info("Test Case Failed");
			Assert.assertTrue(false);

		} else {

			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}

	}

 }
}
