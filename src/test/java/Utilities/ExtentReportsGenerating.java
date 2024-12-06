package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsGenerating implements ITestListener {

	public ExtentReports Reports;
	public ExtentSparkReporter Spark;
	public ExtentTest Test;

	public void onTestStart(ITestResult result) {

		Spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//report.html");
		Spark.config().setDocumentTitle("OrangeHRM");
		Spark.config().setReportName("OrangeHRM Automation");
		Spark.config().setReportName("Shanmukesh");
		Spark.config().setTheme(Theme.DARK);

		Reports = new ExtentReports();
		Reports.attachReporter(Spark);
		Reports.setSystemInfo("Environment", "QA");
		Reports.setSystemInfo("OS", "Windows");
		Reports.setSystemInfo("Browser", "Chrome");
		System.out.println("Starting Test");

	}

	public void onTestSuccess(ITestResult result) {

		Test = Reports.createTest(result.getName());
		Test.log(Status.PASS, "Test Case Passed");
		System.out.println("Congratulations all tests Passed");

	}

	public void onTestFailure(ITestResult result) {
		Test = Reports.createTest(result.getName());
		Test.log(Status.FAIL, "Test Case Failed");
		System.out.println("Test Failed");

	}

	public void onFinish(ITestContext context) {
		Reports.flush();
		System.out.println("Test Finished");
	}
}
