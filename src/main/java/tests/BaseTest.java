package tests;

import pages.ConfigurationReader;
import utils.BrowserFactory;
//import com.rgp.de.test.utils.CaptureConsoleLogs;
//import com.rgp.de.test.utils.CaptureNetworkLogs;
import utils.DriverFactoryThreadLocal;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//BaseTest class holds the methods to initialize and terminate the WebDriver object.
// Since all the Test classes will extend the BaseTest class,then the initialization is done implicitly.
// The Test classes will simply get the WebDriver object by calling the getDriver() method.

public abstract class BaseTest {
	private static final String CONTEXT_ATTRIBUTE_WEB_DRIVER = "WebDriver";
	private static final ConfigurationReader configs = ConfigurationReader.getInstance();
	public static WebDriver driver; //driver variable is used by all test classes.

	public WebDriver getDriver() { return driver;
	}
	/*
    LaunchApplication & teardown method annotated as @BeforeMethod for launching and closing browser before and after test execution.
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters({"incognito"})
	//incognito parameter is used to specify tests to run either in incognito mode or in normal mode of browser.
	// this parameter is specified by true or false boolean value in xml file.
	public void LaunchApplication(ITestContext context, String incognito, ITestResult result) throws Exception {
		//CaptureNetworkLogs captureNetworkLogs = new CaptureNetworkLogs();
		//CaptureConsoleLogs captureConsoleLogs = new CaptureConsoleLogs();
		if (incognito.equals("true")) {
			driver = DriverFactoryThreadLocal.getInstance().setDriver(BrowserFactory.getDriver(BrowserFactory.Browser.getByCode(ConfigurationReader.driverOption), true));
		} else {
			driver = DriverFactoryThreadLocal.getInstance().setDriver(BrowserFactory.getDriver(BrowserFactory.Browser.getByCode(ConfigurationReader.driverOption), false));
		}
		//captureNetworkLogs.captureLogs(driver,result);
		//captureConsoleLogs.captureLogs(driver,result);
		DriverFactoryThreadLocal.getInstance().getDriver().manage().deleteAllCookies();
		Thread.sleep(5000);
		context.setAttribute(CONTEXT_ATTRIBUTE_WEB_DRIVER, driver);

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() throws InterruptedException {
		DriverFactoryThreadLocal.getInstance().closeBrowser();
	}

}
