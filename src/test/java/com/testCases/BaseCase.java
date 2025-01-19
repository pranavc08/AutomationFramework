package com.testCases;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.GeneralUtilities;


public class BaseCase {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@Parameters({ "browser" })
	@BeforeClass(groups = {"Sanity","Regression","Master","dataDriven"})
	public void setup(String browserName) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		p = new Properties();
		p.load(fis);
		
		logger = LogManager.getLogger(this.getClass());

		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("no matching browser");
			return;

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("qaURL"));            //reading URL from properties file
		driver.manage().window().maximize();
	}

	public String captureScreenshot(String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = "./screenshots/"+tname+"_"+GeneralUtilities.getCurrentDateTime()+".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master","dataDriven"})
	public void tearDown() {

		driver.quit();
	}
}
