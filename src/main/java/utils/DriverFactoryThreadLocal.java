package utils;

import org.openqa.selenium.WebDriver;

/*
This class is created to set driver object as threadlocal driver for parallel execution.
Advantage-1. multithreaded parallel test execution through xml file with individual instance for each thread.
2.This class makes variables thread safe. Each thread of same object will have separate copy of object variables.
 */

public class DriverFactoryThreadLocal {

	private static final DriverFactoryThreadLocal instance = new DriverFactoryThreadLocal();
	final int waitForFiveSec = 5000;
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); //driver object of threadlocal class

	private DriverFactoryThreadLocal() {

	}

	public static DriverFactoryThreadLocal getInstance() {
		return instance;
	}
	/*
    getDriver() :- Returns the value in the current thread's copy of this thread-local variable.
	 */
	public WebDriver getDriver() {
		return driver.get();
	}

	public WebDriver setDriver(WebDriver driverParm) {
		driver.set(driverParm);
		return driverParm;
	}

	public void closeBrowser() throws InterruptedException {
		if (driver.get() != null) {
			//driver.get().close();
			driver.get().quit();
			driver.remove();
		} else
			for (int i = 0; i <= 3; i++) {
				Thread.sleep(waitForFiveSec);
				//driver.get().close();
				driver.get().quit();
				driver.remove();
			}

	}
}