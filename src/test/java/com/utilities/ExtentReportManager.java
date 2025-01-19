package com.utilities;

import java.io.IOException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testCases.BaseCase;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest test;

	String reportName;

	@Override
	public void onStart(ITestContext context) {

		reportName = "Test-Report-" + GeneralUtilities.getCurrentDateTime() + ".html";
		sparkReporter = new ExtentSparkReporter("./reports/" + reportName);

		sparkReporter.config().setDocumentTitle("openCart Automation Report"); // Title of report
		sparkReporter.config().setReportName("openCart Functional Testing"); // Name of report
		sparkReporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		reports.setSystemInfo("Application", "opencart");
		reports.setSystemInfo("Module", "Admin");
		reports.setSystemInfo("User Name", System.getProperty("user.name"));
		reports.setSystemInfo("Environment", "QA");

		String browser = context.getCurrentXmlTest().getParameter("browser");
		reports.setSystemInfo("Browser", browser);

		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			reports.setSystemInfo("Groups", includedGroups.toString());

		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "Successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, result.getName() + "got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseCase().captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);

		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext context) {

		reports.flush();
	}
	
}
