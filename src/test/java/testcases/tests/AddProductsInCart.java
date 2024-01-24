package testcases.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.pages.CartPage;
import testcases.pages.ProductsPage;

public class AddProductsInCart extends BaseTest {
	private ProductsPage productspage;
	private CartPage cartpage;
	
	public AddProductsInCart() {
		productspage = new ProductsPage();
		cartpage = new CartPage();
	}

	@Test
	public void addProducts() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		closeChild();
		navigateMainPage();
		
		getProductsButton().click();
		assertVisible(productspage.getProductsPageTitle(), "Products page isn't shown");
		
		JavascriptExecutor Scrool = (JavascriptExecutor) this.driver;
		Scrool.executeScript("window.scrollBy(0,600)", "");	
		
		action.moveToElement(productspage.getHooverProduct()).build().perform();
		String firstProductName = productspage.getfirstProductName().getText();
		productspage.getFirstProductAddChart().click();	
		waitUntilVisible(productspage.getContinueShoppingButton());
		productspage.getContinueShoppingButton().click();
		
		action.moveToElement(productspage.getHooverSecondProduct()).build().perform();
		String secondProductName = productspage.getsecondProductName().getText();
		System.out.println(secondProductName);
		productspage.getSecondProductAddChart().click();
		waitUntilVisible(productspage.getViewCartButton());
		
		productspage.getViewCartButton().click();
		Assert.assertEquals((CheckProductInCart(firstProductName)), true);
		Assert.assertEquals((CheckProductInCart(secondProductName)), true);
	} 
	
	public boolean CheckProductInCart(String productName) {
		return cartpage.getProductsInCart().stream().anyMatch(x -> x.getText().equals(productName));
	}
}