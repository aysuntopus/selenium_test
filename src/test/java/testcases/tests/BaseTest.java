package testcases.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import testcases.components.AbstractComponent;
import org.apache.commons.io.FileUtils;

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
