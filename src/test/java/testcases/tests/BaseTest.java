package testcases.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import testcases.components.AbstractComponent;

public class BaseTest extends AbstractComponent {

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

	public void navigateMainPage() throws InterruptedException {
		Thread.sleep(2000);
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
	}

	@Test
	public void checkBrokenLinks() throws InterruptedException, MalformedURLException, IOException {
		navigateMainPage();
		Object[] result = findBrokenLinks(getheaderLinks());
		if (result.length > 1) {
			Assert.assertEquals(result.length, 1, result[1] + "is broken");
		} else {
			Assert.assertEquals(result.length, 1);
		}
	}
}
