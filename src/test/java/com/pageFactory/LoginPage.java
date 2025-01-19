package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GeneralUtilities;

public class LoginPage extends BasePage{

public WebDriver driver;

    public LoginPage(WebDriver driver) {
	
    	super(driver);
}
	
	@FindBy(xpath="//input[@placeholder='E-Mail Address']")
	WebElement txtfEmailAddress;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtfPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	

	public void enterEmail() {

		txtfEmailAddress.sendKeys(GeneralUtilities.rEmail);
	}

	public void enterPassword() {

		txtfPassword.sendKeys(GeneralUtilities.rPassword);
	}

	public void setEmail(String email) {

		txtfEmailAddress.sendKeys(email);
	}

	public void setPassword(String password) {

		txtfPassword.sendKeys(password);
	}

	public void clickOnLoginButton() throws InterruptedException {

		btnLogin.click();

	}
}