package testcases.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.pages.ProductDetailsPage;
import testcases.pages.ProductsPage;

public class ProductList extends BaseTest {
	private ProductsPage productspage;
	private ProductDetailsPage productsdetailspage;

	public ProductList() {
		super();
		productspage = new ProductsPage();
		productsdetailspage = new ProductDetailsPage();
	}

	@Test
	public void viewProducts() throws InterruptedException {
		Thread.sleep(2000);
		closeChild();
		navigateMainPage();

		getProductsButton().click();
		assertVisible(productspage.getProductsPageTitle(), "Products page isn't shown");
		assertVisible(productspage.getProductsList(), "Products lists aren't loaded");

		productspage.getFirstProductDetails().click();
		assertVisible(productsdetailspage.getProductName(), "Product name isn't shown");
		assertVisible(productsdetailspage.getProductCategory(), "Product category isn't shown");
	}

	@Test
	public void viewCategoryProducts() throws InterruptedException {
		Thread.sleep(2000);
		closeChild();
		navigateMainPage();

		getProductsButton().click();
		scrollDown(300);

		productspage.getWomenCategory().click();
		waitUntilVisible(productspage.getWomenCategoryDress());
		productspage.getWomenCategoryDress().click();
		Assert.assertTrue(productspage.getWomenCategoryTitle().isDisplayed());
		Assert.assertEquals(productspage.getWomenCategoryTitle().getText(), "WOMEN - DRESS PRODUCTS");
		Assert.assertTrue(productspage.getfirstProductName().getText().contains("Dress"));
	}

	@Test
	public void viewBrandsProducts() throws InterruptedException {
		Thread.sleep(2000);
		closeChild();
		navigateMainPage();

		getProductsButton().click();
		scrollDown(600);

		productspage.getPoloBrand().click();
		Assert.assertTrue(productspage.getPoloBrandTitle().isDisplayed());
		Assert.assertEquals(productspage.getPoloBrandTitle().getText(), "BRAND - POLO PRODUCTS");
	}
}
