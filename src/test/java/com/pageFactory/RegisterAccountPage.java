package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GeneralUtilities;

public class RegisterAccountPage extends BasePage {

	WebDriver driver;
	
    public RegisterAccountPage(WebDriver driver) {
		
    	super(driver);
	}
    
    @FindBy(xpath="//input[@placeholder = 'First Name']")
	WebElement txtfFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtfLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtfEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtfPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btnPrivacyPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
    
	public void enterFirstName() {
		
		txtfFirstName.sendKeys(GeneralUtilities.generateDynamicFirstname());
	}
	
	public void enterLastname() {
		
		txtfLastName.sendKeys(GeneralUtilities.generateDynamicLastname());
	}
	
    public void enterEmail() {
		
		String email = (GeneralUtilities.generateDynamicEmail());
		txtfEmail.sendKeys(email);
//    	System.out.println(email);
		GeneralUtilities.rEmail=email;
		
	}
    
    public void enterPassword() {
		
		String password = (GeneralUtilities.generateDynamicPassword());
		txtfPassword.sendKeys(password);
//		System.out.println(password);
		GeneralUtilities.rPassword=password;
		
    }
    
    public void clickOnPrivacyPolicy() {
		
    	btnPrivacyPolicy.click();
	}
    
    public void clickOnContinue() {
		
		btnContinue.click();
	}
}
