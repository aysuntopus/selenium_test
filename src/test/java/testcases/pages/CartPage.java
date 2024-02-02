package testcases.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tbody/tr/td[2]/h4/a")
	private List<WebElement> productsInCart;
	
	@FindBy(xpath = "//tbody//tr//td[4]//button")
	private List<WebElement> quantity;
	
	@FindBy(css = ".btn.btn-default.check_out")
	private WebElement checkOutButton;
	
	@FindBy(xpath = "//div[@class='modal-body']//p[2]//a")
	private WebElement cartRegisterLoginButton;
	
	@FindBy(xpath = "//p[@class='text-center']//a")
	private WebElement products;
	
	@FindBy(xpath = "//a[@class='cart_quantity_delete']")
	private List<WebElement> removeInCartButton;
	 	
	public List<WebElement> getProductsInCart() {
		return productsInCart;
	}
	
	public WebElement getCheckOutButton() {
		return checkOutButton;
	}
	
	public WebElement getCartRegisterLoginButton() {
		return cartRegisterLoginButton;
	}
	
	public WebElement getProductsButton() {
		return products;
	}

	public List<WebElement> getRemoveFromCart() {
		return removeInCartButton;
	}
	
	public List<WebElement> getProductQuantity() {
		return quantity;
	}
}
