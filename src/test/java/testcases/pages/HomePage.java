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
	
	

	public WebElement getBanner() {
		return homeBanner;
	}
	
}
