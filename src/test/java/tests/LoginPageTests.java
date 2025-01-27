package tests;

import java.lang.reflect.Method;
import java.time.Duration;
import pages.LoginPage;
import org.testng.annotations.Test;

import pages.LoginPage;
import tests.BaseTest;
import pages.landingPage.LandingPage;
//import pageEvents.LandingPageEvents;
//import pageEvents.LoginPageEvents;
//import pageObjects.LoginPageElements;
//import pageEvents.HomePageEvents;
//import pages.homePage.*;
import utils.Constants;
import utils.ElementFetch;
public class LoginPageTests extends BaseTest{

	ElementFetch ele = new ElementFetch();


	@Test ()
	public void loginTest1() {

		ele.getWebElement("XPATH", LandingPage.signInButtonText).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   	String curUrl = driver.getCurrentUrl();
	  	System.out.println(curUrl);
	   	driver.get(curUrl);
	   	driver.getCurrentUrl();
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ele.elementExists("XPATH", LoginPage.loginText);		
		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			ele.getWebElement("XPATH", LoginPage.emailAddress).sendKeys("jdeluxe@1");
			
	}


}
