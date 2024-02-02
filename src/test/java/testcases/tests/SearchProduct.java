package testcases.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.pages.ProductsPage;

public class SearchProduct extends BaseTest {
	private ProductsPage productspage;

	public SearchProduct() {
		productspage = new ProductsPage();
	}

	@Test
	public void searchProduct() throws InterruptedException {
		Thread.sleep(3000);
		closeChild();
		navigateMainPage();

		getProductsButton().click();
		assertVisible(productspage.getProductsPageTitle(), "Products page isn't showed");
		productspage.getSearchBar().sendKeys("jean");
		productspage.getSearchButton().click();
		List<WebElement> searhProductList = productspage.getSearchProductsList();
		Assert.assertEquals(searhProductList.size(), 3, "Search Product doesn't return all of items");
	}
}
