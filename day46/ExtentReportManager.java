package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // ui of the report
	public ExtentReports extent; // populate common info/details on the report
	public ExtentTest test; // create test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context) {
		// ui 
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report"); // title of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		// details
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Ana");
		extent.setSystemInfo("OS", "macOS");
		extent.setSystemInfo("Browser Name", "Chrome");
	}
		
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is: " + result.getName()); // update status passed/failed/skipped
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is: " + result.getThrowable());
	}
	 
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
