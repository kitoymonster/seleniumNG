
import java.awt.AWTException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Utilities {
	public static WebDriver driver;
	public static PrintStream stream;
	public static String loggerFileName;
	public static int gTraceLogDepth;
	public static String tabDisplay = " ====================================== ";
	public static String logFilePath;
	public static PrintStream consoleOutputStream;
	public static PrintStream fileOutputStream;
	public static WebDriverWait wait;
	
	@BeforeClass
	public static void startLoggerFile() throws IOException {
		loggerFileName = Utilities.getCurrentDate("yyyyMMddHHmmssSSS") + ".txt";
		logFilePath = System.getProperty(Constants.SYSKEY_USER_DIR) + "\\" + loggerFileName;
		
		File file = new File(logFilePath);
		file.createNewFile();
		FileOutputStream fileOutput = new FileOutputStream(file, true);
		
		consoleOutputStream = System.out;
		fileOutputStream = new PrintStream(fileOutput, true);
		
		//System.setOut(fileOutputStream);
		TraceLog.output("Utilities.startLoggerFile");
	}

	@BeforeMethod
	public static void launchBrowser() throws IOException {
		//Utilities.startLoggerFile(loggerFileName);
		gTraceLogDepth = 0;
		Browsers b = new Browsers(Constants.URL_testServer1);
		driver = b.Drivers();
		wait = new WebDriverWait(driver, 30);
	}

	@AfterMethod
	public static void terminateBrowser() throws InterruptedException {
		TraceLog.start("terminateBrowser");
		signOut();
		driver.close();
		TraceLog.ended("terminateBrowser");
		
	}
	
	@AfterClass
	public static void endLoggerFile() throws IOException {
		consoleOutputStream.println("Log file generated in: " + logFilePath);
	}
	
	
	// Convert integer values to string
	public static String convertIntToString(int numberValue) {
		return String.valueOf(numberValue);
	}
	
	// generates random number between minimum to maximum value specified
	public static int randomNumberGenerator(int min, int max) {
		Random rd = new Random();
		return rd.nextInt(max - min + 1) + min;
	}
	
	// Get the current date and return value on specified format
	// All formats found here: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	public static String getCurrentDate(String format) {
		String sDate = new SimpleDateFormat(format).format(new Date());
		return sDate;
	}
	
	// Text comparison. For cleaner code.
	// returns true;false
	public static boolean compareText(String text1, String text2) {
		TraceLog.start("compareText");
		boolean bResult = false;
		
		if (text1.toLowerCase().equalsIgnoreCase(text2))
			bResult = true;
		
		TraceLog.output(text1.toLowerCase() + " vs " + text2.toLowerCase() + " : " + bResult);
		TraceLog.ended("compareText");
		return bResult;
	}

	// Check if local file exist
	public static boolean checkLocalFileExist(String fileLocalPath, String fileName) {
		boolean returnValue = false;
		File f = new File(fileLocalPath + "\\" + fileName);
		
		if (f.exists())
			returnValue = true;
		
		System.out.println("checkLocalFileExist: " + returnValue);
		return returnValue;
	}
	
	// Delete local file
	public static boolean DeleteLocalFile(String fileLocalPath, String fileName) {
		boolean returnValue = false;
		File f = new File(fileLocalPath + "\\" + fileName);
		
		if (f.exists())
			f.delete();
				
		if (!f.exists())
			returnValue = true;
		
		System.out.println("DeleteLocalFile: " + returnValue);
		return returnValue;
	}
	
	// login to the system
	public static void login(String username, String password) throws InterruptedException {
		TraceLog.start("Utilities.login");
		UM_Login.inputUsername(driver).sendKeys(username);
		UM_Login.inputPassword(driver).sendKeys(password);
		UM_Login.btnLogin(driver).click();
		
		// Checks if multi-session pop-up appears and confirm
		Thread.sleep(5000);
		Utilities.detectLoginMultiSession(driver, 20);
		TraceLog.ended("Utilities.login");
	}
	
	// logout to the system
	public static void signOut() throws InterruptedException {
		UM_Login.btnSetting(driver).click();
		Thread.sleep(1000);
		UM_Login.btnSignOut(driver).click();
	}

	// import project excel
	public void importFile(String filelocation) throws InterruptedException, AWTException {
		GetElementBy.byXpathThatContainsText(driver, Menu_NavBar.navbar_projectExcel);
		Thread.sleep(2000);
		DM_Import.linkImport(driver).click();
		RobotClass.uploadFile(filelocation);
		DM_Import.btnUpload(driver).get(1).click();
		Thread.sleep(2000);
		if(DM_Import.fileAlreadyExists(driver).isDisplayed()){
			Thread.sleep(1000);
			DM_Import.yes(driver).click();
		}
		Thread.sleep(2000);
		boolean check = DM_Import.message(driver).getText().toLowerCase().contains("successfully uploaded files");
		Assert.assertTrue(check);
	}

	// sign off project excel
	public void signOff() throws InterruptedException {
		GetElementBy.byXpathThatContainsText(driver, Menu_NavBar.navbar_signOff(driver));
		DM_Signoff.button_signoff(driver).click();
		DM_Signoff.signOffProjectExcels_SignOff(driver).click();
	}

	// round off values to the nearest 4 decimal places
	public static String roundOff(String aString) throws AWTException{
		double aDouble =  Double.parseDouble(aString);
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		return df.format(aDouble);
	}
	
	// input text to a given xpath (text area/ text field)
	public static void setTextField(WebDriver driver, String xpath, String textInput) {
		driver.findElement(By.xpath(xpath)).sendKeys(textInput);
	}
	
	//  click to a given xpath (text area/ text field)
	public static void clickButton(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	// get the element of a given xpath
	public static List<WebElement> getElements(WebDriver driver, String xpath) {
		return driver.findElements(By.xpath(xpath));
	}
	
	// checks the xpath objects. In case there are multiple objects.
	public static int getElementCount(WebDriver driver, String xpath) {
		return Utilities.getElements(driver, xpath).size();
	}
	
	// checks the xpath objects. If count is > 0.
	public static boolean elementExist(WebDriver driver, String xpath) {
		boolean returnValue = false;
		if (Utilities.getElementCount(driver, xpath) > 0)
			returnValue = true;
		return returnValue;
	}

	// Return the String value of an object
	public static String getText(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	// Return the attribute of an element.
	public static String getAttribute(WebDriver driver, String xpath, String attributeValue) {
		return driver.findElement(By.xpath(xpath)).getAttribute(attributeValue);
	}
	
	// Un-selects a drop-down value.
	public static void deSelectDropdownValue(WebDriver driver, String xpath, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.deselectByVisibleText(value);
	}
	
	// Selects a drop-down value.
	public static void selectDropdownValue(WebDriver driver, String xpath, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(value);
	}
	
	public static boolean isTableContainsData(WebDriver driver, int limit) {
		boolean result = true;
		try {
			for (int count = 1; count < limit; count++) {
				WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='center']/div/div[4]/div[1]/div/div[" + count + "]/div")));
				System.out.println("Value: " + element.getText());

			}
		} catch (Exception e) {
			System.out.println("element not found...");
			result = false;
		}
		return result;
	}
	
	// Detects either main page or session management pop-up. 
	// Returns false if no multi-session is detected, true if detected.
	public static void detectLoginMultiSession(WebDriver driver, int wait) throws InterruptedException {
		TraceLog.start("detectLoginMultiSession");
		int iTimer = 0;

		// Check nav (not multi session) or session management (multi session)
		do {	
			if (driver.findElements(By.linkText("DASHBOARD")).size() > 0) {
				TraceLog.output("Multi session not detected: " + Menu_NavBar.navbar_dashboard(driver).isDisplayed());
				break;
			}
				
			else if (driver.findElements(By.xpath("//*[@id='sessionModal']/div[3]/div[1]")).size() > 0) {
				TraceLog.output("Session Yes button detected: " + UM_SessionManagement.btnYes(driver).isEnabled());
				UM_SessionManagement.btnYes(driver).click();
				break;
			}
				
			else
				Thread.sleep(3000);
				
			iTimer += 3;
		} while (iTimer > wait);
		TraceLog.ended("detectLoginMultiSession");
	}
	
	// Get all elements that matched the partial value. Useful if you are confirming if element exist.
	public static List<WebElement> findElementsByKeyword(WebDriver driver, String text) {
		String stringFindObject = "//*[contains(text(), '" + text + "')]";
		// puts all elements into a list
		return driver.findElements(By.xpath(stringFindObject));
		
	}
	
	public static void waitForElementVisibility(WebElement element) {
		TraceLog.start("Utilities.waitForElementVisibility");
		TraceLog.output("Waiting for element: " + element.toString());
		wait.until(ExpectedConditions.visibilityOf(element));
		TraceLog.ended("Utilities.waitForElementVisibility");
	}
	
	public static void elementToBeClickable(WebElement element) {
		TraceLog.start("Utilities.elementToBeClickable");
		TraceLog.output("Waiting for element: " + element.toString());
		wait.until(ExpectedConditions.elementToBeClickable(element));
		TraceLog.ended("Utilities.elementToBeClickable");
	}

	public static void textToBePresentInElement(WebElement element, String text) {
		TraceLog.start("Utilities.textToBePresentInElement");
		TraceLog.output("Waiting for element: " + element.toString());
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		TraceLog.ended("Utilities.textToBePresentInElement");
	}
	
	public static WebElement getCorrectObjectIndex(WebDriver driver, String cssName, String objVisibleText) {
		TraceLog.start("Utilities.getCorrectObjectIndex");
		
		WebElement element = null;
		List<WebElement> elementlist = GetElementsBy.byCssSelector(driver, cssName);
		TraceLog.output("Found " + elementlist.size() + " child objects.");
		for (WebElement e : elementlist) {
			TraceLog.output("Object value: " + e.getText());
			if (e.getText().toLowerCase().equalsIgnoreCase(objVisibleText)) {
				element = e;
				break;
			}
		}
		
		TraceLog.ended("Utilities.getCorrectObjectIndex");
		return element;
	}
	
	public static WebElement clickValueInCountryTable(WebDriver driver, String cssCountryColumn, String valueInTable) throws AWTException {
		TraceLog.start("Utilities.clickValueInCountryTable");
		
		boolean foundItem = false;
		WebElement element = null;
		int coordx, coordy, count = 0;

		do {
			List<WebElement> maintable = GetElementsBy.byClassName(driver, cssCountryColumn);
			// get the first element's coordinates to be used for mousewheel down 
			coordx = maintable.get(0).getLocation().getX();
			coordy = maintable.get(0).getLocation().getY();
			RobotClass.mouseMove(coordx, coordy);
			
			for (WebElement e : maintable) {
				if (e.getText().toLowerCase().equalsIgnoreCase(valueInTable)) {
					element = e;
					foundItem = true;
					break;
				}
			}
			
			if (foundItem == false) {
				RobotClass.mouseWheelDown(1);
			}
			count = count + 1;
			
		} while (foundItem == false && count < 99);
		
		
		TraceLog.ended("Utilities.clickValueInCountryTable");
		return element;
	}
	
	public static LinkedHashMap<String, WebElement> getAllReportNameInCountryTable(WebDriver driver, String cssCountryColumn) throws AWTException {
		TraceLog.start("Utilities.clickValueinTableByCountry");

		boolean foundNewItem;
		int coordx, coordy, count = 0;
		LinkedHashMap<String, WebElement> countryData = new LinkedHashMap<String, WebElement>();
		
		do {
			// if this stays false, then it means all items are added and will exit loop.
			foundNewItem = false;
			TraceLog.output("Loop " + count);
			List<WebElement> maintable = GetElementsBy.byClassName(driver, cssCountryColumn);
			coordx = maintable.get(0).getLocation().getX();
			coordy = maintable.get(0).getLocation().getY();
			RobotClass.mouseMove(coordx, coordy);
			
			for (WebElement e : maintable) {
				// if item is not found in dictionary, it must be true. add them all.
				if (!countryData.containsKey(e.getText())) {
					countryData.put(e.getText(), e);
					foundNewItem = true;
				}
			}
			
			// scroll down once all new items are added to dictionry
			if (foundNewItem) {
				RobotClass.mouseWheelDown(1);
			}
		} while (foundNewItem);
		
		TraceLog.output(String.valueOf(countryData.size()));
		TraceLog.ended("Utilities.clickValueinTableByCountry");
		return countryData;
	}
}
