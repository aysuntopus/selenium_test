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
	
	@FindBy(xpath ="//tbody/tr/td[2]/h4/a")
	private List<WebElement> productsInCart;
	
	public List<WebElement> getProductsInCart() {
		return productsInCart;
	}
}
