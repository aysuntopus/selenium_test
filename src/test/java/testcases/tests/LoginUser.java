package testcases.tests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcases.pages.SignupLoginPage;

public class LoginUser extends BaseTest {

	private class LoginUserInfo {
		private String email;
		private String password;
		private Boolean expect;
		private String name;

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public Boolean getExpect() {
			return expect;
		}

		public String getName() {
			return name;
		}

		public LoginUserInfo(String email, String password, String name, Boolean expect) {
			this.email = email;
			this.password = password;
			this.expect = expect;
			this.name = name;
		}
	}

	private SignupLoginPage loginPage;

	public LoginUser() {
		super();
		loginPage = new SignupLoginPage();
	}

	public void loginUser(String email, String password, String name) throws InterruptedException {
		loginUser(new LoginUserInfo(email, password, name, true));
	}

	@Test(dataProvider = "getUserData")
	public void loginUser(LoginUserInfo input) throws InterruptedException {
		Thread.sleep(1000);
		closeChild();
		navigateMainPage();

		getSignupLoginButton().click();
		Map<Object, String> m = Map.of(loginPage.getloginEmail(), input.getEmail(), loginPage.getloginPassword(),
				input.getPassword());
		sendKeys(m);

		click(loginPage.getloginButton());

		if (input.getExpect()) {
			Assert.assertEquals(getuserName().getText(), input.getName());
		} else {
			Assert.assertEquals(loginPage.getUnsuccesLoginMsg().getText(), "Your email or password is incorrect!");
		}
	}

	@DataProvider
	public Object[] getUserData() {
		return new Object[] { new LoginUserInfo("g@gmail.com", "123", "george", false),
				new LoginUserInfo("gusto@gmail.com", "123", "aysun", true), };
	}
}
