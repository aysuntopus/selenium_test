package testcases.tests;

import org.testng.annotations.Test;
import testcases.pages.CartPage;
import testcases.pages.CheckOutPage;
import testcases.pages.PaymentPage;

public class PlaceOrder extends BaseTest {
	private ProductsInCart carttest;
	private CartPage cartpage;
	private CheckOutPage checkoutpage;
	private RegisterUser registerUser;
	private LoginUser loginUser;
	private Logout logout;
	private PaymentPage paymentpage;
	private DeleteAccount deleteAccount;

	public PlaceOrder() {
		carttest = new ProductsInCart();
		cartpage = new CartPage();
		registerUser = new RegisterUser();
		loginUser = new LoginUser();
		checkoutpage = new CheckOutPage();
		paymentpage = new PaymentPage();
		deleteAccount = new DeleteAccount();
		logout = new Logout();
	}

	@Test(dependsOnMethods = { "registerWhileCheckout" })
	public void loginWhileCheckout() throws InterruptedException {
		getCartLink().click();
		cartpage.getProductsButton().click();
		carttest.addProducts();
		cartpage.getCheckOutButton().click();
		cartpage.getCartRegisterLoginButton().click();
		loginUser.loginUser("ceylily@gmail.com", "123", "ceylin");

		getCartLink().click();
		cartpage.getCheckOutButton().click();
		checkoutpage.getPlaceOrderButton().click();
		paymentpage.getCardNumber().sendKeys("1234");
		paymentpage.getNameOnCard().sendKeys("lily");
		paymentpage.getCardYear().sendKeys("2050");
		paymentpage.getCardMonth().sendKeys("12");
		paymentpage.getCvvNumber().sendKeys("123");
		paymentpage.getConfirmOrder().click();
		deleteAccount.deleteAccount();
	}

	@Test
	public void registerWhileCheckout() throws InterruptedException {
		carttest.addProducts();
		cartpage.getCheckOutButton().click();
		cartpage.getCartRegisterLoginButton().click();
		registerUser.signUp("ceylin", "ceylily@gmail.com");

		getCartLink().click();
		cartpage.getCheckOutButton().click();
		checkoutpage.getPlaceOrderButton().click();
		paymentpage.getCardNumber().sendKeys("1234");
		paymentpage.getNameOnCard().sendKeys("lily");
		paymentpage.getCardYear().sendKeys("2050");
		paymentpage.getCardMonth().sendKeys("12");
		paymentpage.getCvvNumber().sendKeys("123");
		paymentpage.getConfirmOrder().click();
		logout.getLogoutButton().click();
	}
}
