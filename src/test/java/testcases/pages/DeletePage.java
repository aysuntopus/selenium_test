package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.components.AbstractComponent;

public class DeletePage extends AbstractComponent {

	public DeletePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[normalize-space()='Account Created!'")
	private WebElement deleteSuccessTitle;

	@FindBy(css = "a[data-qa = 'continue-button']")
	private WebElement deleteContinue;

	public WebElement getSuccessMessage() {
		return deleteSuccessTitle;
	}

	public WebElement getDeleteContinueButton() {
		return deleteContinue;
	}
}
