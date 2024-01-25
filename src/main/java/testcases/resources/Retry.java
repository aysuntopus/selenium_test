package testcases.resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	private int count = 0;
	private int maxRetry = 1;
	
	public boolean retry(ITestResult result) {
		return count++ < maxRetry;
	}
}
