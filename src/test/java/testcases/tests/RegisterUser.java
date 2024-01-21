package testcases.tests;

import java.util.Map;
import org.testng.annotations.Test;
import testcases.pages.HomePage;
import testcases.pages.RegisterPage;
import testcases.pages.SignupLoginPage;

public class RegisterUser extends BaseTest {

	private HomePage homepage;
	private RegisterPage registerpage;
	private SignupLoginPage signuploginpage;

	public RegisterUser() {
		super();
		homepage = new HomePage();
		registerpage = new RegisterPage();
		signuploginpage = new SignupLoginPage();
	}

	@Test
	public void visibleVerify() {
		try {
			navigateMainPage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertVisible(homepage.getBanner(), "It didn't respond in 1 seconds.");
	}

	@Test(dependsOnMethods = { "visibleVerify" })
	public void signUp(){
		super.getSignupLoginButton().click();
		assertVisible(super.getSignupLoginButton(), "Signup button isn't visible");

		Map<Object, String> m = Map.of(signuploginpage.getSignupName(), "aysun", signuploginpage.getSignupEmail(),
				"gusto@gmail.com");
		sendKeys(m);
		signuploginpage.clickSignupButton();
		assertVisible(registerpage.getFormTitle(), "Singup button isn't visible");

		click(registerpage.getNewsletter(), registerpage.getOfferOption());
		sendKeys(Map.of("address1", "123", "first_name", "123", "last_name", "123", "password", "123", "state", "123",
				"city", "123", "zipcode", "123", "mobile_number", "123"));
		registerpage.getCreateAccountButton().click();
		
		// verify account is created
		assertVisible(registerpage.getCreatedMessage(), "account isn't created");
		registerpage.getContinueButton().click();

		// handle extensions windows and close it.
		closeChild();
		Logout logout = new Logout();
		logout.logout();
		
	}
}
