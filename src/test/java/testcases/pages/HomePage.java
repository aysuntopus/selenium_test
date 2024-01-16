package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class HomePage extends AbstractComponent {
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[alt='Website for automation practice']")
	private WebElement homeBanner;

	@FindBy(css = "a[href ='/login']")
	private WebElement signupButton;

	public WebElement getBanner() {
		return homeBanner;
	}

	public void clickSignupButton() {
		signupButton.click();
	}

	public WebElement getSignupButton() {
		return signupButton;
	}
}
