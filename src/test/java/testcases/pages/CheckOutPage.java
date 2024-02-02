package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
	public CheckOutPage(){
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(css =".btn.btn-default.check_out")
	private WebElement placeOrderButton;
	
	public WebElement getPlaceOrderButton() {
		return placeOrderButton;
	}
}
