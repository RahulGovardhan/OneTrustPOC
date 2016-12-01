package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Configuration {

	public WebDriver driver;
	public WebDriverWait wait = null;
	public String browser = "chrome";

	@BeforeClass
	public void openBrowser() {
		
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firefox driver Session has Started");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			cap.setBrowserName(browser);
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 60);

		} else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("IE Web Driver Session has Started");
			System.setProperty("webdriver.ie.driver",System.getProperty("webdriver.ie.driver",
							".//src//test//resources//browserDrivers//IEDriverServer.exe"));
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 60);
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome driver Session has Started");
			System.setProperty("webdriver.chrome.driver",System.getProperty("webdriver.chrome.driver",
							".//src//test//resources//browserDrivers//chromedriver.exe"));
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 60);
		}
	}

	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}
}