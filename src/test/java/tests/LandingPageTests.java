package tests;

//import java.lang.reflect.Method;
import java.time.Duration;
//import org.testng.Reporter;
import org.testng.annotations.Test;
//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import extentReports.ExtentManager;
import extentReports.ExtentTestManager;
import tests.BaseTest;
import pages.landingPage.LandingPage;
import utils.Constants;
import utils.ElementFetch;
//import org.testng.annotations.Test;
public class LandingPageTests extends BaseTest{
	//public ExtentTest logger;
	ExtentSparkReporter htmlReporter;
	// extent;
	ExtentTest test;
//	private static final ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest logger;

	ElementFetch ele = new ElementFetch();

	@Test ()
	public void landingPageSmoke() {
		ExtentTest test = ExtentTestManager.getTest();

		driver.get(Constants.landingPageUrl);

		ele.getWebElement("XPATH", LandingPage.signInButtonText).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String curUrl = driver.getCurrentUrl();
		System.out.println(curUrl);
		driver.get(curUrl);
		test.info("verify URL");
		driver.getCurrentUrl();
		//		driver.get(Constants.url2);
	}	

	@Test ()
	public void landingPageSmoke2() {
		ExtentTest test = ExtentTestManager.getTest();
		test.info("verify URL");
		driver.get(Constants.landingPageUrl);
		test.info("verify Login");
		ele.getWebElement("XPATH", LandingPage.signInButtonText2).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String curUrl = driver.getCurrentUrl();
		System.out.println(curUrl);
		//	logger.info("dd");

		driver.get(curUrl);
		test.info("verify URL");
		driver.getCurrentUrl();

	}

	private void startTest(String name, String string) {
		// TODO Auto-generated method stub

	}
}
