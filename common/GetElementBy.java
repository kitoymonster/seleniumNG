import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetElementBy {
	public static WebElement element = null;

	public static WebElement byClassName(WebDriver driver, String value) {
		TraceLog.start("GetElementBy.byClassName");
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.className(value)));
		TraceLog.ended("GetElementBy.byClassName");
		return element;
	}

	public static WebElement byCssSelector(WebDriver driver, String value) {
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
		return element;
	}

	public static WebElement byId(WebDriver driver, String value) {
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.id(value)));
		return element;
	}

	public static WebElement byLinkText(WebDriver driver, String value) {
		TraceLog.start("GetElementBy.byLinkText");
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
		TraceLog.ended("GetElementBy.byLinkText");
		return element;
	}

	public static WebElement byName(WebDriver driver, String value) {
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.name(value)));
		return element;
	}

	public static WebElement byPartialLinkText(WebDriver driver, String value) {
		element = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(value)));
		return element;
	}

	public static WebElement byTagName(WebDriver driver, String value) {
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.tagName(value)));
		return element;
	}

	public static WebElement byXpath(WebDriver driver, String value) {
		element = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
		return element;
	}
	
	public static WebElement byXpathThatContainsText(WebDriver driver, String value) throws InterruptedException {
		WebElement element = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[text()[contains(., '"+ value +"')]]")));
		return element;
	}
}
