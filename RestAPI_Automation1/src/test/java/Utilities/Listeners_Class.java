package Utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners_Class extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter("E:\\Selenium\\RestAPI_Automation1\\Reports\\TestReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("AutomationReport");
		htmlReporter.config().setTheme(Theme.DARK);
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Name","Suchismita Majhi");
		extentReport.setSystemInfo("Report","RestAPI");
		extentReport.setSystemInfo("OS","Window");
		}
	public void onTestSuccess(ITestResult result) {
		test = extentReport.createTest(result.getName());
		test.log(Status.PASS, "TestCase Passed "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		test = extentReport.createTest(result.getName());
		test.log(Status.FAIL, "TestCase Failed "+result.getName());
		test.log(Status.FAIL, "TestCase Failed "+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result) {
		test = extentReport.createTest(result.getName());
		test.log(Status.SKIP, "TestCase skipped "+result.getName());
	}
	public void onFinish(ITestContext testContext) {
		extentReport.flush();
	}
	


}
