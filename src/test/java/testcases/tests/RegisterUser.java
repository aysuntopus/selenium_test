package testcases.tests;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.testng.annotations.Test;
import testcases.pages.HomePage;
import testcases.pages.RegisterPage;

public class RegisterUser extends BaseTest {

	private HomePage homepage;
	private RegisterPage registerpage;

	public RegisterUser() {
		super();
		homepage = new HomePage();
		registerpage = new RegisterPage();
	}

	@Test
	public void visibleVerify() {
		navigateMainPage();
		assertVisible(homepage.getBanner(), "It didn't respond in 1 seconds.");
	}

	@Test(dependsOnMethods = { "visibleVerify" })
	public void signUp() throws InterruptedException {
		homepage.clickSignupButton();
		assertVisible(homepage.getSignupButton(), "Singup button isn't visible");

		Map<Object, String> m = Map.of(registerpage.getSignupName(), "aysun", registerpage.getSignupEmail(),
				"gusto@gmail.com");
		sendKeys(m);
		registerpage.clickSignupButton();
		assertVisible(registerpage.getFormTitle(), "Singup button isn't visible");

		click(registerpage.getNewsletter(), registerpage.getOfferOption());
		sendKeys(Map.of("address1", "123", "first_name", "123", "last_name", "123", "password", "123", "state", "123",
				"city", "123", "zipcode", "123", "mobile_number", "123"));
		registerpage.getCreateAccountButton().click();
		
		// verify account is created
		assertVisible(registerpage.getCreatedMessage(), "account isn't created");
		registerpage.getContinueButton().click();

		// handle extensions windows and close it.
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.close();
				driver.switchTo().window(parent);
			}
		}
	}
}
