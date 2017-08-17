import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetElementsBy {
	private static List<WebElement> elements = null;

	public static List<WebElement> byClassName(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byClassName");
		
		elements = driver.findElements(By.className(value));
		
		TraceLog.ended("GetElementsBy.byClassName");
		return elements;
	}

	public static List<WebElement> byCssSelector(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byCssSelector");
		
		elements = driver.findElements(By.cssSelector(value));
		
		TraceLog.ended("GetElementsBy.byCssSelector");
		return elements;
	}

	public static List<WebElement> byId(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byId");
		
		elements = driver.findElements(By.id(value));
		
		TraceLog.ended("GetElementsBy.byId");
		return elements;
	}

	public static List<WebElement> byLinkText(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byLinkText");
		
		elements = driver.findElements(By.linkText(value));
		
		TraceLog.ended("GetElementsBy.byLinkText");
		return elements;
	}

	public static List<WebElement> byName(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byName");
		
		elements = driver.findElements(By.name(value));
		
		TraceLog.ended("GetElementsBy.byName");
		return elements;
	}

	public static List<WebElement> byPartialLinkText(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byPartialLinkText");
		
		elements = driver.findElements(By.partialLinkText(value));
		
		TraceLog.ended("GetElementsBy.byPartialLinkText");
		return elements;
	}

	public static List<WebElement> byTagName(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byTagName");
		
		elements = driver.findElements(By.tagName(value));
		
		TraceLog.ended("GetElementsBy.byTagName");
		return elements;
	}

	public static List<WebElement> byXpath(WebDriver driver, String value) {
		TraceLog.start("GetElementsBy.byXpath");
		
		elements = driver.findElements(By.xpath(value));
		
		TraceLog.ended("GetElementsBy.byXpath");
		return elements;
	}
	
	public static List<WebElement> byXpathThatContainsText(WebDriver driver, String value) throws InterruptedException {
		return driver.findElements(By.xpath("//*[contains(text(), '"+ value +"')]"));
	}
}
