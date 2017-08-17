
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UM_EditUser {
	public static WebElement element = null;

	// header
	public static WebElement header(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='usersView']/div/div[1]/span")));
		return element;
	}

	// Search Bar
	public static WebElement search(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.search");
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='usersView']/div/div[2]/div/div/div/div[2]/div[1]/div/div/input")));
		TraceLog.ended("UM_EditUser.search");
		return element;
	}

	// Edit Button
	public static WebElement EditButton(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.EditButton");
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='usersView']/div/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/a/i")));
		TraceLog.ended("UM_EditUser.EditButton");
		return element;
	}

	//
	public static WebElement firstName(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='firstName']")));
		return element;
	}

	//
	public static WebElement middleName(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[3]/div[2]/input")));
		return element;
	}

	//
	public static WebElement lastName(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.lastName");
		element = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[4]/div[2]/input")));
		TraceLog.ended("UM_EditUser.lastName");
		return element;
	}

	//
	public static WebElement birthDate(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[5]/div[2]/input")));
		return element;
	}

	//
	public static WebElement year(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.className("yearselect")));
		return element;
	}

	//
	public static WebElement yearOP(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='1993']")));
		return element;
	}

	//
	public static WebElement day(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div/table/tbody/tr[2]/td[6]")));
		return element;
	}

	//
	public static WebElement female(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='female']")));
		return element;
	}

	//
	public static WebElement email(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[7]/div[2]/p")));
		return element;
	}

	//
	public static WebElement username(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[8]/div[2]/p")));
		return element;
	}

	//
	public static WebElement countryOP(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[9]/div[2]/div/div[2]/div[7]")));
		return element;
	}

	//
	public static WebElement role(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.role");
		
		element = GetElementBy.byXpath(driver, "//*[@id='editUserForm']/div[9]/div[2]/div");

		TraceLog.ended("UM_EditUser.role");
		return element;
	}
	
	public static List<WebElement> rolelist(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.rolelist");
		
		List<WebElement> elements = GetElementsBy.byXpath(driver, "//*[@id='editUserForm']/div[9]/div[2]/div/div[2]//*[contains(@class, 'item')]");
		
		TraceLog.ended("UM_EditUser.rolelist");
		return elements;
	}
	
	// country
	public static WebElement country(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.country");
		
		element = GetElementBy.byXpath(driver, "//*[@id='editUserForm']/div[8]/div[2]/div");
		
		TraceLog.ended("UM_EditUser.country");
		return element;
	}
	
	public static List<WebElement> countrylist(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.countrylist");
		
		 List<WebElement> elements = GetElementsBy.byXpath(driver, "//*[@class='menu transition visible']//*[contains(@class, 'item')]");
		
		TraceLog.ended("UM_EditUser.countrylist");
		return elements;
	}

	//
	public static WebElement roleOP2(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[10]/div[2]/div/div[2]/div[5]")));
		return element;
	}

	//
	public static WebElement roleOP1(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='editUserForm']/div[10]/div[2]/div/div[2]/div[1]")));
		return element;
	}

	//
	public static WebElement reset(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='resetBtn']")));
		return element;
	}

	//
	public static WebElement save(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.save");
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addUserBtn']")));
		TraceLog.ended("UM_EditUser.save");
		return element;
	}

	//
	public static WebElement confirm(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_EditUser.confirm");
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='confirmationModal']/div[1]/span")));
		TraceLog.ended("UM_EditUser.confirm");
		return element;
	}

	//
	public static WebElement confirmOK(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.confirmOK");
		
		element =  GetElementBy.byXpath(driver, "//*[@id='confirmationModal']/div[3]/div[2]");
		
		TraceLog.ended("UM_Deregister.confirmOK");
		return element;
	}
	
	public static WebElement confirmDialogOK(WebDriver driver) throws InterruptedException {
		TraceLog.start("UM_Deregister.confirmDialogOK");
		
		element =  GetElementBy.byXpath(driver, "//*[@id='successModal']/div[3]/a");
		
		TraceLog.ended("UM_Deregister.confirmDialogOK");
		return element;
	}

	//
	public static WebElement confirmCancel(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='confirmationModal']/div[3]/div[1]")));
		return element;
	}

	//
	public static WebElement settings(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/i")));
		return element;
	}

	//
	public static WebElement changePassword(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[3]/div/div[1]/a")));
		return element;
	}

	//
	public static WebElement oldPassword(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='oldPW']")));
		return element;
	}

	//
	public static WebElement newPassword(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='newPW']")));
		return element;
	}

	//
	public static WebElement confirmPassword(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='confirmNewPW']")));
		return element;
	}

	//
	public static WebElement btnChangePassword(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("changePwdBtn")));
		return element;
	}

	//
	public static WebElement passwordError(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='changePwdNotif']")));
		return element;
	}

	//
	public static WebElement successful(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[3]/div[2]/div[1]/span")));
		return element;
	}

	//
	public static WebElement successfulOK(WebDriver driver) throws InterruptedException {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[3]/div[2]/div[3]/a")));
		return element;
	}

}
