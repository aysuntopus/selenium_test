package testcases.components;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	@FindBy(css = "a[href ='/products']")
	private List<WebElement> headerLinks;

	@FindBy(xpath = "(//li)[3]//a")
	private WebElement cartLink;

	@FindBy(xpath = "(//div[@class='shop-menu pull-right']//ul/li)[1]")
	private WebElement homeLink;

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

	public List<WebElement> getheaderLinks() {
		return headerLinks;
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getHomePage() {
		return homeLink;
	}

	public void assertVisible(WebElement element, String errorMessage) {
		Exception exception = null;
		try {
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

	public String takeScreenShot(String testname, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports" + "testname" + ".png");
		try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return System.getProperty("user.dir") + "//reports" + "testname" + ".png";
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

	public Object[] findBrokenLinks(List<WebElement> links) throws MalformedURLException, IOException {
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (java.net.HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			if (conn.getResponseCode() > 400) {
				return new Object[] { link.getText(), false };
			}
		}
		return new Object[] { true };
	}

	public void scrollDown(int value) {
		JavascriptExecutor Scroll = (JavascriptExecutor) this.driver;
		Scroll.executeScript("window.scrollBy(0," + value + ")", "");
	}

	public void scrollBottom() {
		JavascriptExecutor Scroll = (JavascriptExecutor) this.driver;
		Scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
