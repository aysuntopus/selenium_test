package testcases.components;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractComponent {
	public WebDriver driver;

	@FindBy(css = "a[href='/delete_account']")
	private WebElement deleteButton;

	public AbstractComponent() {
		this.driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void assertVisible(WebElement element, String errorMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 1 /* Seconds */);
		Exception exception = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			exception = e;
		}
		Assert.assertNull(exception, errorMessage);
	}

	public void assertVisible(By locator, String errorMessage) {
		WebDriverWait wait = new WebDriverWait(driver, 1 /* Seconds */);
		Exception exception = null;
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch (TimeoutException e) {
			exception = e;
		}
		Assert.assertNull(exception, errorMessage);
	}

	public void sendKeys(Map<Object, String> map) {
		for (Object key : map.keySet()) {
			if (key.getClass() == String.class) {
				driver.findElement(By.id((String) key)).sendKeys(map.get(key));
			} else if (By.class.isAssignableFrom(key.getClass())) {
				driver.findElement((By) key).sendKeys(map.get(key));
			} else if (WebElement.class.isAssignableFrom(key.getClass())) {
				((WebElement) key).sendKeys(map.get(key));
			}
		}
	}

	public void click(Object... elements) {
		for (Object key : elements) {
			if (key.getClass().equals(String.class)) {
				driver.findElement(By.id((String) key)).click();
			} else if (By.class.isAssignableFrom(key.getClass())) {
				driver.findElement((By) key).click();
			} else if (WebElement.class.isAssignableFrom(key.getClass())) {
				((WebElement) key).click();
			}
		}
	}
}
