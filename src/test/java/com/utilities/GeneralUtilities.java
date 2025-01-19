package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GeneralUtilities {

    static String firstName;
	public static String rEmail;
	public static String rPassword;

	public static String generateDynamicFirstname() {

		firstName = RandomStringUtils.randomAlphabetic(6);
		return firstName;
	}

	public static String generateDynamicLastname() {

		String lastName = RandomStringUtils.randomAlphabetic(5);
		return lastName;
	}

	public static String generateDynamicEmail() {

		String Email = firstName + "@gmail.com";
		return Email;
	}

	public static String generateDynamicPassword() {

		String password = firstName + "123";
		return password;

	}
	
	public static String getCurrentDateTime() {
		
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return df.format(currentDate);
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" window.scrollBy(0, document.body.scrollHeight) ");
	}
	
	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" window.scrollBy(0, -document.body.scrollHeight) ");
	}

	public static void getScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File f1 = ts.getScreenshotAs(OutputType.FILE);
		File f2 = new File("./screenshots/openCart_"+getCurrentDateTime()+".png");
		f1.renameTo(f2);
 }
}
