package testcases.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.pages.SignupLoginPage;

public class Logout extends BaseTest {
	private SignupLoginPage loginPage;

	public Logout() {
		super();
		loginPage = new SignupLoginPage();
	}

	@Test
	public void logout() {
		getLogoutButton().click();
		Assert.assertEquals(loginPage.getloginTittle().getText(), "Login to your account");
	}
}
