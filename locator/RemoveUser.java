
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UM_Deregister {
	public static WebElement element = null;

	// header
	public static WebElement header(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='de-register']/div[1]/span")));
		return element;
	}

	// filter - country
	public static WebElement filterCountry(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filters']/div[1]/div/div/div[1]")));
		return element;
	}

	// filter - role
	public static WebElement filterRole(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filters']/div[2]/div/div/div[1]")));
		return element;
	}

	// textfield - active search engine
	public static WebElement searchActive(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/input")));
		return element;
	}

	// textfield - inactive search engine
	public static WebElement searchInactive(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[3]/div/div[2]/div/div[1]/div/div/input")));
		return element;
	}

	// button - select all active
	public static WebElement selectAllActive(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/button[1]")));
		return element;
	}

	// button - select all inactive
	public static WebElement selectAllInactive(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[3]/div/div[2]/div/div[2]/div/button[1]")));
		return element;
	}

	// button - clear active
	public static WebElement clearActive(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/button[2]")));
		return element;
	}

	// button - clear inactive
	public static WebElement clearInactive(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[3]/div/div[2]/div/div[2]/div/button[2]")));
		return element;
	}

	// button - right icon
	public static WebElement activate(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='reg-button']/div/div[2]/div/i")));
		return element;
	}

	// button - left icon
	public static WebElement deactivate(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='reg-button']/div/div[1]/div/i")));
		return element;
	}

	// button - xIcon
	public static WebElement remove(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@title, 'Remove all selected users')]")));
		return element;
	}

	// header - confirmationUserDeactivation
	public static WebElement confirmationUser(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[1]")));
		return element;
	}

	// button - yes
	public static WebElement yes(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]")));
		return element;
	}

	// button - cancel
	public static WebElement cancel(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]")));
		return element;
	}

	// button - selectActivate
	public static WebElement selectActiveAccount(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[1]/div/div[2]/div[3]/div/div/div/label")));
		return element;
	}

	// button - selectDeactivate
	public static WebElement selectInactiveAccount(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[3]/div/div[2]/div/div[3]/div/div/div/label")));
		return element;
	}

	// button - no active users
	public static WebElement noActiveUser(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='de-register']/div[3]/div/div[2]/div[1]/div/div[2]/div[3]/div/div")));
		return element;
	}
	
	// items list - active users 
	public static List<WebElement> listActiveUser(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.listActiveUser");
		
		List<WebElement> elements =  GetElementsBy.byXpath(driver, "//*[@class='ui middle aligned divided selection list']//*[contains(@ng-repeat, 'user in activeUsers track by user.username')]");
		
		TraceLog.ended("UM_Deregister.listActiveUser");
		return elements;
	}
	
	// items list - deactivated users 
	public static List<WebElement> listDeactivatedUser(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.listDeactivatedUser");
		
		List<WebElement> elements =  GetElementsBy.byXpath(driver, "//*[@class='ui middle aligned divided selection list']/*[contains(@ng-repeat, 'user_1 in inactiveUsers track by user_1.username')]");
		
		TraceLog.ended("UM_Deregister.listDeactivatedUser");
		return elements;
	}
	
	
	// remove user icon
	public static WebElement iconRemoveSelectedUser(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.iconRemoveSelectedUser");
		
		element =  GetElementBy.byCssSelector(driver, "i.large.remove.circle.icon");
		
		TraceLog.ended("UM_Deregister.iconRemoveSelectedUser");
		return element;
	}
	
	// remove user confirm
	public static WebElement btnRemoveSelectedUserConfirm(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.btnRemoveSelectedUserConfirm");
		
		element =  GetElementBy.byCssSelector(driver, "div.ui.positive.labeled.icon.button");
		
		TraceLog.ended("UM_Deregister.btnRemoveSelectedUserConfirm");
		return element;
	}
	
	// remove user cancel
	public static WebElement btnRemoveSelectedUserCancel(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.btnRemoveSelectedUserCancel");
		
		element =  GetElementBy.byCssSelector(driver, "div.ui.black.deny.button");
		
		TraceLog.ended("UM_Deregister.btnRemoveSelectedUserCancel");
		return element;
	}
	
	// deactivate user icon
	public static WebElement iconDeactivateSelectedUser(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.iconDeactivateSelectedUser");
		
		element =  GetElementBy.byCssSelector(driver, "i.large.chevron.right.icon");
		
		TraceLog.ended("UM_Deregister.iconDeactivateSelectedUser");
		return element;
	}
	
	// deactivate user confirm
	public static WebElement btnDeactivateSelectedUserConfirm(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.btnDeactivateSelectedUserConfirm");
		
		element =  GetElementBy.byCssSelector(driver, "div.ui.positive.labeled.icon.button");
		
		TraceLog.ended("UM_Deregister.btnDeactivateSelectedUserConfirm");
		return element;
	}
	
	// deactivate user cancel
	public static WebElement btnDeactivateSelectedUserCancel(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.btnDeactivateSelectedUserCancel");
		
		element =  GetElementBy.byCssSelector(driver, "div.ui.black.deny.button");
		
		TraceLog.ended("UM_Deregister.btnDeactivateSelectedUserCancel");
		return element;
	}
	
}
