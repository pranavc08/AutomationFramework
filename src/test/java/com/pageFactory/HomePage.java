package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) {

		super(driver);
	}

	// locating elements on the page using @FindBy annotations

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;

	// methods to perform actions on web elements of the page

	public void clickOnMyAccount() {

		lnkMyaccount.click();
	}

	public void clickOnRegister() {

		lnkRegister.click();
	}

	public void clickOnLogin() {

		lnkLogin.click();
	}
}
