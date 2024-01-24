package testcases.tests;

import org.testng.annotations.AfterSuite;
import testcases.components.AbstractComponent;

public class BaseTest extends AbstractComponent {
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	public void navigateMainPage() throws InterruptedException {
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
	}	
}
