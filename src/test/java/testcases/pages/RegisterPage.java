package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class RegisterPage extends AbstractComponent {

	public RegisterPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement signupName;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement signupEmail;
	
	@FindBy(css = "button[data-qa='signup-button']")
	private WebElement signButton;
	
	@FindBy(xpath = "(//div[@class = 'login-form']//b)[1]")
	private WebElement formTitle;
	
	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement newsletter;
	
	@FindBy(xpath = "//input[@id='optin']")
	private WebElement optin;
	
	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	private WebElement createAccountButton;
	
	@FindBy(xpath = "//b[normalize-space()='Account Created!']")
	private WebElement createdMessage;
	
	@FindBy(css= ".btn.btn-primary")
	private WebElement createContinueButton;
	
	public WebElement getSignupName() {
		return signupName;
	}

	public WebElement getSignupEmail() {
		return signupEmail;
	}

	public WebElement getFormTitle() {
		return formTitle;
	}

	public void clickSignupButton() {
		signButton.click();
	}

	public WebElement getNewsletter() {
		return newsletter;
	}

	public WebElement getOfferOption() {
		return optin;
	}

	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}

	public WebElement getCreatedMessage() {
		return createdMessage;
	}
	
	public WebElement getContinueButton() {
		return createContinueButton;
	}
}
