package testcases.components;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	private WebDriverWait wait;
	public AbstractComponent() {
		this.driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1 /* Seconds */);
	}

	@FindBy(css = "a[href='/delete_account']")
	private WebElement deleteButton;

	@FindBy(css = "a[href='/logout']")
	private WebElement logoutButton;

	@FindBy(css = "a[href ='/login']")
	private WebElement signupButton;

	@FindBy(xpath = "(//li)[10]//a//b")
	private WebElement userName;
	
	@FindBy(css = "a[href ='/products']")
	private WebElement products;

	public WebElement getuserName() {
		return userName;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getSignupLoginButton() {
		return signupButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	public WebElement getProductsButton() {
		return products;
	}

	public void assertVisible(WebElement element, String errorMessage) {
		
		Exception exception = null;
		try {
			//wait.until(ExpectedConditions.visibilityOf(element));
			waitUntilVisible(element);
		} catch (TimeoutException e) {
			exception = e;
		}
		Assert.assertNull(exception, errorMessage);
	}
	
	public void waitUntilVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));		
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

	public void closeChild() {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.close();
				driver.switchTo().window(parent);
			}
		}
	}
}
