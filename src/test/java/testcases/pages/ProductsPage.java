package testcases.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class ProductsPage extends AbstractComponent {	
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='features_items'])/h2")
	private WebElement productsPageTitle;
	
	@FindBy(xpath = "//div[@class='features_items']")
	private WebElement productList;
	
	@FindBy(css = "a[href='/product_details/1']")
	private WebElement firstProductDetails;
	
	@FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
	private WebElement firstProductAddChartButton;
	
	@FindBy(xpath = "(//a[contains(text(),'Add to cart')])[3]")
	private WebElement secondProductAddChartButton;
	
	@FindBy(xpath = "(//div[@class='productinfo text-center'])[1]")
	private WebElement hooverProduct;
	
	@FindBy(xpath = "(//div[@class='productinfo text-center'])[1]/p")
	private WebElement firstProductName;
	
	@FindBy(xpath = "(//div[@class='productinfo text-center'])[2]")
	private WebElement hooverSecondProduct;
	
	@FindBy(xpath = "(//div[@class='productinfo text-center'])[2]/p")
	private WebElement secondProductName;
	
	@FindBy(css = ".modal-content")
	private WebElement continueShoppingDiv;

	@FindBy(id = "search_product")
	private WebElement searchBar;
	
	@FindBy(id = "submit_search")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
	private List<WebElement> searchProductsList;	
	
	@FindBy(xpath = "(//h4//a)[1]")
	private WebElement womenCategory;
	
	@FindBy(xpath = "//a[@href='/brand_products/Polo']")
	private WebElement poloBrand;
	
	@FindBy(xpath = "(//div[@id='Women']//ul//li//a)[1]")
	private WebElement womenCategoryDress;
	
	@FindBy(xpath = "(//h2[normalize-space()='Women - Dress Products'])[1]")
	private WebElement womenCategoryTitle;
	
	@FindBy(xpath = "(//h2[normalize-space()='Brand - Polo Products'])[1]")
	private WebElement BrandPoloTitle;
		
	private By continueShoppingButton = By.cssSelector(".btn.btn-success.close-modal.btn-block");
	private By viewCartButton = By.xpath("//div[@class='modal-body']//a");
	
	public WebElement getProductsPageTitle() {
		return productsPageTitle;
	} 
	
	public WebElement getProductsList() {
		return productList;
	}
	
	public WebElement getFirstProductDetails() {
		return firstProductDetails;
	}
	
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public List<WebElement> getSearchProductsList() {
		return searchProductsList;
	}
	
	public WebElement getFirstProductAddChart() {
		return firstProductAddChartButton;
	}
	
	public WebElement getSecondProductAddChart() {
		return secondProductAddChartButton;
	}
	
	public WebElement getHooverProduct() {
		return hooverProduct;
	}
	
	public WebElement getHooverSecondProduct() {
		return hooverSecondProduct;
	}
	
	public WebElement getContinueShoppingButton() {
		return getContinueShoppingDiv().findElement(continueShoppingButton);
	}
	
	public WebElement getViewCartButton() {
		return getContinueShoppingDiv().findElement(viewCartButton);
	}
	
	public WebElement getContinueShoppingDiv() {
		return continueShoppingDiv;
	}
	
	public WebElement getfirstProductName() {
		return firstProductName;
	}
	
	public WebElement getsecondProductName() {
		return secondProductName;
	}
	
	public WebElement getWomenCategory() {
		return womenCategory;
	}
	
	public WebElement getWomenCategoryDress() {
		return womenCategoryDress;
	}
	
	public WebElement getWomenCategoryTitle() {
		return womenCategoryTitle;
	}
	
	public WebElement getPoloBrand() {
		return poloBrand;
	}
	
	public WebElement getPoloBrandTitle() {
		return BrandPoloTitle;
	}
}
