package base;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver ;

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		return options;
	}

	@BeforeSuite
	public void startDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOption());

		driver.manage().deleteAllCookies();
		driver.navigate().to("http://automationpractice.com/index.php");
		System.out.println("Navigated to URL [" + "http://automationpractice.com/index.php" +"]");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}


	@AfterSuite
	public void stopDriver() {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.quit();
		System.out.println("Driver Closed Successfully");
	}

}