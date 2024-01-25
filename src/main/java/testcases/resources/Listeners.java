package testcases.resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import testcases.components.AbstractComponent;

public class Listeners extends AbstractComponent implements ITestListener {
	ExtentReports extent = ExtentReporter.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread ID		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String filePath = null;
		extentTest.get().fail(result.getThrowable());		
		try {	
			WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			filePath = takeScreenShot(result.getMethod().getMethodName(), driver);
			
		} catch (Exception e) {
			e.printStackTrace();			
		} 
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
		
	@Override
	public void onStart(ITestContext context) {
		// not implemented
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
