

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "beforeNavigateTo: '" + " " + url + " " + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "afterNavigateTo: '" + " " + url + " " + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "beforeChangeValueOf: " + " " + element.toString() + " " + "getText: " + " " + element.getText());
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") 
				+ Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " 
				+ "afterChangeValueOf: " + " " + element.toString() + " " + "getText: " + " | " + element.getText());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") 
				+ Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " 
				+ "beforeClickOn: " + " " + element.toString() + " | " + "getText: " + element.getText());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") 
				+ Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " 
				+ "afterClickOn: " + " " + element.toString() + " | " + "getText: " + element.getText());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "Navigating back to previous page." + " " + driver.getCurrentUrl());
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "Navigated back to previous page" + " " + driver.getCurrentUrl());
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "Navigating forward to next page" + " " + driver.getCurrentUrl());
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "Exception occured" + "\n\n" + " " + error + " " + "\n");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "Trying to find Element By: " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "Found Element By: " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "beforeScript");
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "afterScript");
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "afterAlertAccept");
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "afterAlertDismiss\n");
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "afterChangeValueOf\n");
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "afterNavigateRefresh\n");
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "beforeAlertAccept\n");
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "beforeAlertDismiss\n");
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "beforeChangeValueOf\n");
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println(Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + "beforeNavigateRefresh\n");
		
	}

}
