package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class SignupLoginPage extends AbstractComponent {
	
	public SignupLoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@placeholder ='Name']")
	private WebElement signupName;
	
	@FindBy(css = "input[data-qa='login-email']")
	private WebElement loginEmail;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement signupEmail;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement loginPassword;
	
	@FindBy(css = "button[data-qa='signup-button']")
	private WebElement signButton;
	
	@FindBy(css = "button[data-qa='login-button']")
	private WebElement loginButton;
	
	@FindBy(css = "div[class='login-form'] h2")
	private WebElement loginTitle;
	
	@FindBy(xpath = "//div[@class='login-form']//p")
	private WebElement unsuccesLoginMsg;
		
	public WebElement getSignupName() {
		return signupName;
	}

	public WebElement getSignupEmail() {
		return signupEmail;
	}
	
	public void clickSignupButton() {
		signButton.click();
	}
	
	public WebElement getloginEmail() {
		return loginEmail;
	}
	
	public WebElement getloginPassword() {
		return loginPassword;
	}
	
	public WebElement getloginButton() {
		return loginButton;
	}
	
	public WebElement getloginTittle() {
		return loginTitle;
	}
	
	public WebElement getUnsuccesLoginMsg() {
		return unsuccesLoginMsg;
	}
}
