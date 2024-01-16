package testcases.components;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static DriverManager instance = null;

	private final WebDriver driver;

	private DriverManager() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File(".//extensions//AdBlock.crx"));
		driver = new ChromeDriver(opt);
	}

	public static DriverManager getInstance() {
		if (instance == null) {
			instance = new DriverManager();
		}
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
