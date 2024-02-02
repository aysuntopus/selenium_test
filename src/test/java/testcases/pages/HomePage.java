package testcases.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class HomePage extends AbstractComponent {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[alt='Website for automation practice']")
	private WebElement homeBanner;

	@FindBy(xpath = "//div[@class='recommended_items']")
	private WebElement recommendedProducts;

	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement continueCartDiv;
	
	private By productName = By.xpath("(//div[@class='productinfo text-center']//p)[1]");
	private By viewCartButton = By.xpath("//div[@class='modal-body']//a");
	private By addrecommendedProduct = By.xpath("(//a[@data-product-id='4'])[1]");
	private By recommendedTitle = By.xpath("//h2[normalize-space()='recommended items']");

	public WebElement getBanner() {
		return homeBanner;
	}
	
	public WebElement getRecommendedProducts() {
		return getRecommendedDiv().findElement(recommendedTitle);
	}
	
	public WebElement getAddrecommendedProduct() {
		return getRecommendedDiv().findElement(addrecommendedProduct);
	}
	
	public WebElement getCartViewDiv() {
		return continueCartDiv;
	}
	
	public WebElement getViewCart() {
		return getCartViewDiv().findElement(viewCartButton);
	}
	
	public WebElement getProductName() {
		return getRecommendedDiv().findElement(productName) ;
	}	
	
	public WebElement getRecommendedDiv() {
		return recommendedProducts;
	}
}
