
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DM_SendEmail {
	public static WebElement element = null;
	public static List<WebElement> elements = null;
	
	// input recipients
	public static WebElement inputEmailRecipient(WebDriver driver) {
		TraceLog.start("DM_SendEmail.inputEmailRecipient");
		
		element = GetElementBy.byCssSelector(driver, "a.ui.label.transition.visible");
		elements = element.findElements(By.xpath(".//*"));
		TraceLog.output("Found " + elements + " child objects.");
		
		TraceLog.ended("DM_SendEmail.inputEmailRecipient");
		return element;
	}
	
	// select recipients
	public static List<WebElement> selectEmailRecipient(WebDriver driver) {
		TraceLog.start("DM_SendEmail.selectEmailRecipient");
		
		element = GetElementBy.byCssSelector(driver, "div.menu.transition.visible");
		elements = element.findElements(By.xpath(".//*"));
		TraceLog.output("Found " + elements + " child objects.");
		
		TraceLog.ended("DM_SendEmail.selectEmailRecipient");
		return elements;
	}
	
	public static WebElement iconDropDown(WebDriver driver) {
		TraceLog.start("DM_SendEmail.iconDropDown");
		
		element = GetElementBy.byCssSelector(driver, "i.dropdown.icon");
		
		TraceLog.ended("DM_SendEmail.iconDropDown");
		return element;
	}
	

	public static List<WebElement> deleteEmailRecipient(WebDriver driver) {
		TraceLog.start("DM_SendEmail.deleteEmailRecipient");
		
		elements = GetElementsBy.byCssSelector(driver, "i.delete.icon");
		
		TraceLog.ended("DM_SendEmail.deleteEmailRecipient");
		return elements;
	}

	public static WebElement inputEmailSubject(WebDriver driver) {
		TraceLog.start("DM_SendEmail.inputEmailSubject");
		
		// elements = GetElementsBy.byId(driver, "inputEmailSubject");
		element = Utilities.getCorrectChildElementByClick(driver, "id", "inputEmailSubject");
		
		TraceLog.ended("DM_SendEmail.inputEmailSubject");
		return element;
	}
	
	public static WebElement textEmailMsg(WebDriver driver) {
		TraceLog.start("DM_SendEmail.textEmailMsg");
		
		element = Utilities.getCorrectChildElementByClick(driver, "id", "txtAreaEmailMsg");
		
		TraceLog.ended("DM_SendEmail.textEmailMsg");
		return element;
	}
	
	public static WebElement btnSend(WebDriver driver) {
		TraceLog.start("DM_SendEmail.btnSend");
		
		element = Utilities.getCorrectChildElementByText(driver, "css", "div.ui.primary.button.active", "Send");
		
		TraceLog.ended("DM_SendEmail.btnSend");
		return element;
	}

	public static WebElement notificationMessage(WebDriver driver) {
		TraceLog.start("DM_SendEmail.notificationMessage");
		
		element = GetElementBy.byXpath(driver, "//*[@id='modalNotificatonMessage']/p");
		
		TraceLog.ended("DM_SendEmail.notificationMessage");
		return element;
	}
	
	public static WebElement btnSuccessClose(WebDriver driver) {
		TraceLog.start("DM_SendEmail.btnSuccessClose");
		
		element = Utilities.getCorrectChildElementByText(driver, "xpath", "//*[@id='closeSuccessModal']", "Ok");
		
		TraceLog.ended("DM_SendEmail.btnSuccessClose");
		return element;
	}
	
	public static WebElement btnCancel(WebDriver driver) {
		TraceLog.start("DM_SendEmail.btnCancel");
		
		element = GetElementBy.byId(driver, "cancelEmail");
		
		TraceLog.ended("DM_SendEmail.btnCancel");
		return element;
	}
	
	
	public static WebElement iconClose(WebDriver driver) {
		TraceLog.start("DM_SendEmail.iconClose");
		
		element = GetElementBy.byCssSelector(driver, "i.white.close.icon");
		
		TraceLog.ended("DM_SendEmail.iconClose");
		return element;
	}
	
	public static WebElement PE_Raw(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='specific-project']/div[3]/div[1]/label")));
		return element;
	}

	public static WebElement PE_ProjectTable(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='specific-project']/div[3]/div[2]/label")));
		return element;
	}

	public static WebElement PE_warningMessage(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='notifMessage']/p")));
		return element;
	}

	public static WebElement PE_showHide(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='view-specific-excel']/div[2]/div/div[1]/div[4]/div/div/div[1]")));
		return element;
	}

	public static WebElement PE_showHideOP(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id='view-specific-excel']/div[2]/div/div[1]/div[4]/div/div/div[2]/div[2]/div[5]/div[2]/div/label")));
		return element;
	}


	public static WebElement table(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='tableFormat']")));
		return element;
	}

	public static WebElement graph(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@value='graph']")));
		return element;
	}

	// public static WebElement excel(WebDriver driver) throws
	// InterruptedException {
	// element = (new WebDriverWait(driver, 40))
	// .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tableFormats']/div[1]/label")));
	// return element;
	// }

	public static WebElement message(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtAreaEmailMsg']")));
		return element;
	}

	public static WebElement send(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sr-modal-sendBtn']")));
		return element;
	}

	public static WebElement cancel(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cancelEmail']")));
		return element;
	}
}
