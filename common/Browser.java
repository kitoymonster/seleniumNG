package org.knh.pds.utility;

import java.util.Arrays;

import org.knh.pds.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Browsers {
	String URL;
	
	public Browsers(String URL) {
		this.URL = URL;
	}

	public EventFiringWebDriver Drivers() {
		WebDriver driver = null;
		TraceLog.output("Browser: Chrome");
		System.setProperty(Constants.SYSKEY_WEB_DRIVER_CHROME,
				System.getProperty(Constants.SYSKEY_USER_DIR) + "\\BrowserDrivers\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
		driver = new ChromeDriver(capabilities);
		driver.get(URL);
		driver.manage().window().maximize();
	    EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
	       
	    WebEventListener handler = new WebEventListener();
	    eventDriver.register(handler);
		return eventDriver;
	}

}
