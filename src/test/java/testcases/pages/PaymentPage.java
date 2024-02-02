package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class PaymentPage extends AbstractComponent {	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="input[name='name_on_card']")
	private WebElement nameOnCard;
	
	@FindBy(css ="input[name='card_number']")
	private WebElement cardNumber;
	
	@FindBy(xpath ="//input[@placeholder='ex. 311']")
	private WebElement cvvNumber;
	
	@FindBy(xpath ="//input[@placeholder='MM']")
	private WebElement cardMonth;
	
	@FindBy(xpath ="//input[@placeholder='YYYY']")
	private WebElement cardYear;
	
	@FindBy(xpath ="//button[@id='submit']")
	private WebElement confirmOrder;
	
	@FindBy(xpath ="//div[@id='success_message']//div")
	private WebElement successMessage;
	
	public WebElement getNameOnCard() {
		return nameOnCard;
	}
	
	public WebElement getCardNumber() {
		return cardNumber;
	}
	
	public WebElement getCvvNumber() {
		return cvvNumber;
	}
	
	public WebElement getCardMonth() {
		return cardMonth;
	}
	
	public WebElement getCardYear() {
		return cardYear;
	}
	
	public WebElement getConfirmOrder() {
		return confirmOrder;
	}
	
	public WebElement getSuccessMessage() {
		return successMessage;
	}	
}
