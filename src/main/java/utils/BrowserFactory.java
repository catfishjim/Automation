package utils;

import pages.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;
/*
A browser factory class specifies sending browser option as a parameter to launch application method in Base Test class.
 This class is having one method getDriver() which specifies browser option and incognito mode as an argument.
 */
public class BrowserFactory {
	public static final String DRIVER_OPTION_START_MAXIMIZED = "start-maximized";
	public static final String DRIVER_OPTION_WINDOW_SIZE_1920_X_1200 = "--window-size=1920x1200";
	private static final ConfigurationReader configs = ConfigurationReader.getInstance();

	public BrowserFactory() {
	}

	/*
    getDriver method specifies tests will run in which browser and which mode by arguments browser and incognito.This method called in launchApplication method in baseTest.
	 */
	public static WebDriver getDriver(Browser browser, boolean incognito) {
		switch (browser) {
		case CHROME: {

			if (System.getProperty("os.name").contains("indo")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\James Jones\\chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\James Jones\\chromedriver.exe");
			}
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--incognito");

			if (incognito) {
				options.addArguments("--incognito");
			}
			//options.addArguments("--auto-open-devtools-for-tabs");
			//options.addArguments("--network");
			//              options.setHeadless(ConfigurationReader.headless);
			//options.addArguments("--user-data-dir==C:\\Users\\de-contractor\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			if (ConfigurationReader.headless) {
				options.addArguments("--no-sandbox"); ////
				options.addArguments("--verbose");
				options.addArguments(DRIVER_OPTION_WINDOW_SIZE_1920_X_1200);
				//options.addArguments("--incognito");
				//options.addArguments("start-maximized"); // start-maximized doesn't work in headless
				options.addArguments("enable-automation"); //
				options.addArguments("--whitelisted-ips");//
				options.addArguments("--disable-infobars"); //
				options.addArguments("--disable-dev-shm-usage"); //
				options.addArguments("--disable-browser-side-navigation"); //
				options.addArguments("--disable-gpu");
				options.addArguments("--disk-cache-size=0");
				//reduce font size
				//options.addArguments("force-device-scale-factor=0.75");
				//options.addArguments("high-dpi-support=0.75");
				if (incognito) {
					options.addArguments("--incognito");
				}

			} else {
				options.addArguments("--no-sandbox"); //
				options.addArguments("--verbose");
				options.addArguments(DRIVER_OPTION_WINDOW_SIZE_1920_X_1200);
				//options.addArguments("--incognito");
				options.addArguments("start-maximized"); //
				options.addArguments("enable-automation"); //
				options.addArguments("--whitelisted-ips"); //
				options.addArguments("--disable-infobars"); //
				options.addArguments("--disable-dev-shm-usage"); //
				options.addArguments("--disable-browser-side-navigation"); //
				options.addArguments("--disable-gpu");
				options.addArguments("--disk-cache-size=0");
				//reduce font size
				//options.addArguments("force-device-scale-factor=0.75");
				//options.addArguments("high-dpi-support=0.75");
				if (incognito) {
					options.addArguments("--incognito");
				}
			}

			return new ChromeDriver(options);
		}
		case EDGE: {
			EdgeOptions options = new EdgeOptions();
			//         options.setHeadless(ConfigurationReader.headless);
			if (ConfigurationReader.headless) {
				options.addArguments(DRIVER_OPTION_WINDOW_SIZE_1920_X_1200); // start-maximized doesn't work in headless
				if (incognito) {
					options.addArguments("--incognito");
				}
			} else {
				options.addArguments(DRIVER_OPTION_START_MAXIMIZED);
				if (incognito) {
					options.addArguments("--incognito");
				}
			}

			return new EdgeDriver(options);
		}
		case FIREFOX: {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			if (ConfigurationReader.headless) {
				options.addArguments(DRIVER_OPTION_WINDOW_SIZE_1920_X_1200); // start-maximized doesn't work in headless
				if (incognito) {
					options.addArguments("--incognito");
				}
			} else {
				options.addArguments(DRIVER_OPTION_START_MAXIMIZED);
				if (incognito) {
					options.addArguments("--incognito");
				}
			}

			return new FirefoxDriver(options);
		}
		default:
			throw new RuntimeException(String.format("Unknown browse option '%s' provided in VM options.", ConfigurationReader.driverOption));
		}
	}

	public enum Browser {
		NONE(""),
		EDGE("edge"),
		CHROME("chrome"),
		FIREFOX("firefox");

		private final String code;

		Browser(String label) {
			this.code = label;
		}

		public static Browser getByCode(String byCode) {
			return Arrays.stream(values()).filter(b -> b.getCode().equals(byCode)).findFirst().orElse(NONE);
		}

		public String getCode() {
			return this.code;
		}
	}
}