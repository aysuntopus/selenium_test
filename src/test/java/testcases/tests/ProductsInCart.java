package testcases.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.pages.CartPage;
import testcases.pages.HomePage;
import testcases.pages.ProductsPage;

public class ProductsInCart extends BaseTest {
	private ProductsPage productspage;
	private CartPage cartpage;
	private HomePage homepage;

	public ProductsInCart() {
		productspage = new ProductsPage();
		cartpage = new CartPage();
		homepage = new HomePage();
	}

	@Test
	public void addProducts() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		navigateMainPage();

		closeChild();
		getProductsButton().click();
		assertVisible(productspage.getProductsPageTitle(), "Products page isn't showed");
		scrollDown(600);

		action.moveToElement(productspage.getHooverProduct()).build().perform();
		String firstProductName = productspage.getfirstProductName().getText();
		productspage.getFirstProductAddChart().click();
		waitUntilVisible(productspage.getContinueShoppingButton());
		productspage.getContinueShoppingButton().click();

		action.moveToElement(productspage.getHooverSecondProduct()).build().perform();
		String secondProductName = productspage.getsecondProductName().getText();
		productspage.getSecondProductAddChart().click();
		waitUntilVisible(productspage.getViewCartButton());
		productspage.getViewCartButton().click();

		Thread.sleep(1000);
		Assert.assertEquals((CheckProductInCart(firstProductName)), true);
		Assert.assertEquals((CheckProductInCart(secondProductName)), true);
	}

	@Test
	public void addRecommendedProductsInCart() throws InterruptedException {
		Thread.sleep(1000);
		navigateMainPage();
		closeChild();

		getHomePage().click();
		scrollBottom();
		Thread.sleep(1000);

		Assert.assertTrue(homepage.getRecommendedProducts().getText().equals("RECOMMENDED ITEMS"));
		String recommendedProduct = homepage.getProductName().getText();

		homepage.getAddrecommendedProduct().click();
		Thread.sleep(2000);
		homepage.getViewCart().click();
		CheckProductInCart(recommendedProduct);
	}

	@Test
	public void removeProductsInCart() throws InterruptedException {
		getCartLink().click();
		String productBeforeRemove = cartpage.getProductsInCart().get(0).getText();
		int quantity = Integer.parseInt(cartpage.getProductQuantity().get(0).getText());
		cartpage.getRemoveFromCart().get(0).click();
		Thread.sleep(1000);
		if (CheckProductInCart(productBeforeRemove)) {
			int quantityAfter = Integer.parseInt(cartpage.getProductQuantity().get(0).getText());
			Assert.assertEquals(quantityAfter, quantity - 1);
		} else {
			Assert.assertFalse(CheckProductInCart(productBeforeRemove));
		}
		removeAllCart();
	}

	public void removeAllCart() {
		List<WebElement> products = cartpage.getRemoveFromCart();
		for (WebElement i : products) {
			i.click();
		}
	}

	public boolean CheckProductInCart(String productName) {
		return cartpage.getProductsInCart().stream().anyMatch(x -> x.getText().equals(productName));
	}
}