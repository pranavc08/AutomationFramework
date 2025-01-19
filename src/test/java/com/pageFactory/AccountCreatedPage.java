package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BasePage {

	public AccountCreatedPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space() = 'Your Account Has Been Created!']")
	WebElement txtaccountCreated;

	public String accountCreatedText() {

		String text = txtaccountCreated.getText();
		return text;
	}

}
