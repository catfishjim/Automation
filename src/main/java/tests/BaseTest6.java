package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.apache.logging.log4j.*;
//import pageObjects.HomePageElements;
//import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;
import utils.ElementFetch;


//import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.managers.*;

public class BaseTest6 {
   public static WebDriver driver;

   public WebDriver getDriver() {
       return driver;
   }
   
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	ElementFetch ele= new ElementFetch();	
//	public static WebDriverManager webdriver;

	
@BeforeClass
	    public void classStart() {
	extent = new ExtentReports();

	//  private static String logger.info = "initial value";
	//private static Logger logger = Logger.getLogger(getClass());
	
	//this.logger = logger.info("start");
	    //   logger.info("Tests are starting!");
	
	    }

@AfterClass
public void classStop() {
   
}

	@BeforeTest
	public void beforeTestMethod()	{
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator+"reports"+File.separator+"MYExtentReport.html");
		
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("James Results");
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser, Method testMethod)
	{extent = new ExtentReports();
		logger=extent.createTest(testMethod.getName());
		setupDriver(browser);
	//	driver.get(Constants.url1);
		driver.manage().window().maximize();
		//driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	@AfterMethod

	public void afterMethod(ITestResult result)	{
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - test case Failed", ExtentColor.RED)); 
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - test case Failed", ExtentColor.RED)); }
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - test case Skipped", ExtentColor.ORANGE)); }
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - test case Passed", ExtentColor.GREEN)); }
	}
	
	@AfterMethod
	public void flush()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//ele.getWebElement("XPATH", HomePageElements.logoutButton).click();		
		extent.flush();
		driver.quit();
	}
	
	@AfterTest
	public void close()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//ele.getWebElement("XPATH", HomePageElements.logoutButton).click();		
		//driver.quit();
	//	driver.close();
	}
	public void setupDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\James Jones\\chromedriver.exe");
		if(browser.equalsIgnoreCase("chrome")) {
		//	WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
	//		driver.get(Constants.url1);}
	//	else if (browser.equalsIgnoreCase("edge")) {
		//	WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
	}
}
