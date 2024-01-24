package testcases.tests;

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
		Thread.sleep(3000);
		closeChild();
		navigateMainPage();
		
		getProductsButton().click();
		assertVisible(productspage.getProductsPageTitle(), "Products page isn't shown");
		assertVisible(productspage.getProductsList(),"Products lists aren't loaded");
		
		productspage.getFirstProductDetails().click();
		assertVisible(productsdetailspage.getProductName(), "Product name isn't shown");
		assertVisible(productsdetailspage.getProductCategory(), "Product category isn't shown");
		assertVisible(productsdetailspage.getProductPrice(), "Product price isn't shown");
	}
}
