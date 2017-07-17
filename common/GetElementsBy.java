
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetElementsBy {

	public static List<WebElement> byClassName(WebDriver driver, String value) {
		return driver.findElements(By.className(value));
	}

	public static List<WebElement> byCssSelector(WebDriver driver, String value) {
		return driver.findElements(By.cssSelector(value));
	}

	public static List<WebElement> byId(WebDriver driver, String value) {
		return driver.findElements(By.id(value));
	}

	public static List<WebElement> byLinkText(WebDriver driver, String value) {
		return driver.findElements(By.linkText(value));
	}

	public static List<WebElement> byName(WebDriver driver, String value) {
		return driver.findElements(By.name(value));
	}

	public static List<WebElement> byPartialLinkText(WebDriver driver, String value) {
		return driver.findElements(By.partialLinkText(value));
	}

	public static List<WebElement> byTagName(WebDriver driver, String value) {
		return driver.findElements(By.tagName(value));
	}

	public static List<WebElement> byXpath(WebDriver driver, String value) {
		return driver.findElements(By.xpath(value));
	}
	
	public static List<WebElement> byXpathThatContainsText(WebDriver driver, String value) throws InterruptedException {
		return driver.findElements(By.xpath("//*[contains(text(), '"+ value +"')]"));
	}
}
