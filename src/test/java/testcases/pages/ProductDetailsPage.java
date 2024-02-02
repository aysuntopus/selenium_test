package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class ProductDetailsPage extends AbstractComponent {	
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='product-information']/h2")
	private WebElement productName;
	
	@FindBy(xpath = "(//div[@class='product-information']/p)[1]")
	private WebElement productCategory;
	
	@FindBy(xpath = "//div[@class='product-information']/span/span")
	private WebElement productPrice;
	
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getProductCategory() {
		return productCategory;
	}
	
	public WebElement getProductPrice() {
		return productPrice;
	}
}
