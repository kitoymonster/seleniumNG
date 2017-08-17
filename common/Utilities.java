import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public static void terminateBrowser() throws InterruptedException, AWTException {
		TraceLog.start("terminateBrowser");
		signOut();
		driver.quit();
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
		TraceLog.start("Utilities.ccompareText");
		boolean bResult = false;

		if (text1.trim().toLowerCase().equalsIgnoreCase(text2.trim().toLowerCase()))
			bResult = true;
		
		TraceLog.output(text1.trim().toLowerCase().toLowerCase() + " vs " + text2.trim().toLowerCase() + " : " + bResult);
		TraceLog.ended("Utilities.ccompareText");
		return bResult;
	}
	
	public static boolean checkStringExist(String text1, String text2) {
		TraceLog.start("Utilities.checkStringExist");
		boolean bResult = false;

		if (text1.trim().toLowerCase().contains(text2.trim().toLowerCase()))
			bResult = true;
		
		TraceLog.output(text1.trim().toLowerCase().toLowerCase() + " is found in " + text2.trim().toLowerCase() + " : " + bResult);
		TraceLog.ended("Utilities.checkStringExist");
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
		Thread.sleep(1000);
		Utilities.detectLoginMultiSession(driver, 20);
		TraceLog.ended("Utilities.login");
	}
	
	// logout to the system
	public static void signOut() throws InterruptedException, AWTException {
		RobotClass.forceRefresh();
		Thread.sleep(1000);
		try {
			Utilities.waitForElementVisibility(UM_Login.btnSetting(driver));
			UM_Login.btnSetting(driver).click();
			Thread.sleep(1000);
			UM_Login.btnSignOut(driver).click();
		} catch (StaleElementReferenceException e) {
			TraceLog.output("Can't find element.");
		}
		
	}

	// import project excel
	public void importFile(String filelocation) throws InterruptedException, AWTException {
		Menu_NavBar.navbar_projectExcel(driver).click();
		Thread.sleep(2000);
		DM_Import.linkImport(driver).click();
		RobotClass.uploadFile(filelocation);
		DM_Import.btnUpload(driver).get(1).click();
		Thread.sleep(2000);
		if(DM_Import.fileAlreadyExists(driver).isDisplayed()){
			Thread.sleep(1000);
			DM_Import.btnYesUpload(driver).click();
		}
		Thread.sleep(2000);
		boolean check = DM_Import.importMessageHeaderSuccess(driver).getText().toLowerCase().contains("successfully uploaded files");
		Assert.assertTrue(check);
	}

	// sign off project excel
	public void signOff() throws InterruptedException {
		Menu_NavBar.navbar_signOff(driver).click();
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
			try {
				Thread.sleep(3000);
				if (driver.findElements(By.linkText("PROJECT EXCEL")).size() > 0) {
					TraceLog.output("Multi session not detected: " + Menu_NavBar.navbar_dashboard(driver).isDisplayed());
					break;
				} else if (driver.findElements(By.xpath("//*[@id='sessionModal']/div[3]/div[1]")).size() > 0) {
					TraceLog.output("Session Yes button detected: " + UM_SessionManagement.btnYes(driver).isEnabled());
					UM_SessionManagement.btnYes(driver).click();
					break;
				} else
					Thread.sleep(1000);
			} catch (NoSuchElementException e) {
				TraceLog.output("Waiting for either dashboard or session management pop-up to appear...");
			}
			
			iTimer += 3;
		} while (iTimer < wait);
		
		if (iTimer > wait)
			Assert.assertTrue(false, "Timeout exceeded.");
		
		Thread.sleep(2000);
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
	
	public static boolean clickValueInCountryTable(WebDriver driver, String cssCountryColumn, String valueInTable, int timeout) throws AWTException {
		TraceLog.start("Utilities.clickValueInCountryTable");
		
		boolean foundItem = false;
		int coordx, coordy, count = 0;

		try {
			do {
				List<WebElement> maintable = GetElementsBy.byClassName(driver, cssCountryColumn);
				// get the first element's coordinates to be used for mousewheel down 
				coordx = maintable.get(0).getLocation().getX();
				coordy = maintable.get(0).getLocation().getY();
				RobotClass.mouseMove(coordx, coordy);
				
				for (WebElement e : maintable) {
					if (Utilities.compareText(e.getText(), valueInTable)) {
						TraceLog.output(valueInTable + " found.");
						e.click();
						foundItem = true;
						break;
					}
				}
				
				if (foundItem) 
					break;
				else
					RobotClass.mouseWheelDown(1);
				
				count = count + 1;
				
			} while (foundItem == false && count <= timeout);
		} catch (StaleElementReferenceException e) {
			foundItem = true;
			TraceLog.output("Selenium generates StaleElementReferenceException when pressing the element. Proceeding.");
		}
		
		if (!foundItem || count > timeout)
			TraceLog.output(valueInTable + " not found or timeout needs to be increased.");
		
		TraceLog.ended("Utilities.clickValueInCountryTable");
		return foundItem;
	}

	public static boolean checkboxValueInCountryTable(WebDriver driver, String cssTable, String cssColumn, String valueInTable, int timeout) throws AWTException, InterruptedException {
		TraceLog.start("Utilities.checkboxValueInCountryTable");
		
		boolean foundItem = false;
		int coordx, coordy, count = 0;

		try {
			do {
				// This will find the entire table value
				List<WebElement> maintable = GetElementsBy.byCssSelector(driver, cssTable);
				// get the first element's coordinates to be used for mousewheel down 
				coordx = maintable.get(0).getLocation().getX();
				coordy = maintable.get(0).getLocation().getY();
				RobotClass.mouseMove(coordx, coordy);
				
				for (WebElement e : maintable) {
					// This will then find all the sub-elements inside the table
					List<WebElement> inside = e.findElements(By.xpath(".//*"));
					WebElement checkBox = null;
					for (WebElement ele : inside) {
						// save check-box element in case the text value on the subsequent elements matches
						if (Utilities.compareText(ele.getAttribute("class"), "ag-selection-checkbox"))
							checkBox = ele;
						
						// check the text value if it matches
						if (Utilities.compareText(ele.getAttribute("class"), "ag-group-value")) {
							if (Utilities.compareText(ele.getText(), "AFG_OpMercy_27501_Q42015")) {
								TraceLog.output(valueInTable + " found.");
								checkBox.click();
								foundItem = true;
								break;
							}
						}
					}
					
					if (foundItem)
						break;
				}
				
				if (foundItem) 
					break;
				else
					RobotClass.mouseWheelDown(1);
				
				count = count + 1;
				
			} while (foundItem == false && count <= timeout);
			
		} catch (StaleElementReferenceException e) {
			foundItem = true;
			TraceLog.output("Selenium generates StaleElementReferenceException when pressing the element. Proceeding.");
		}
		
		if (!foundItem || count > timeout)
			TraceLog.output(valueInTable + " not found or timeout needs to be increased.");
		
		TraceLog.ended("Utilities.checkboxValueInCountryTable");
		return foundItem;
	}

	// Was not tried out
	public static LinkedHashMap<String, WebElement> getAllReportNameInCountryTable(WebDriver driver, String cssCountryColumn) throws AWTException {
		TraceLog.start("Utilities.clickValueinTableByCountry");

		boolean foundNewItem;
		int coordx, coordy;
		String countryText;
		LinkedHashMap<String, WebElement> countryData = new LinkedHashMap<String, WebElement>();
		
		do {
			// stays false until item is found or timeout is reached
			foundNewItem = false;
			List<WebElement> maintable = GetElementsBy.byClassName(driver, cssCountryColumn);
			coordx = maintable.get(0).getLocation().getX();
			coordy = maintable.get(0).getLocation().getY();
			RobotClass.mouseMove(coordx, coordy);
			
			for (WebElement e : maintable) {
				// if item is not found in dictionary add the value to dictionary
				// set found to true so once the current screen is added, mouse wheel down is executed
				countryText = e.getText().trim().toLowerCase();
				if (!countryData.containsKey(countryText)) {
					countryData.put(countryText, e);
					foundNewItem = true;
				}
			}
			
			// scroll down once all new items are added to dictionary
			if (foundNewItem) {
				RobotClass.mouseWheelDown(1);
			}
		
		// Exit once no new item is found.
		} while (foundNewItem);
		
		TraceLog.output(String.valueOf(countryData.size()));
		TraceLog.ended("Utilities.clickValueinTableByCountry");
		return countryData;
	}
	
	// Use if element's only way of activation is by clicking.
	public static WebElement getCorrectChildElementByClick(WebDriver driver, String locatorType, String locator) {
		TraceLog.start("Utilities.getCorrectChildElementByClick");
		
		WebElement element = null;
		List<WebElement> elements = null;
		boolean clickable = false;
		
		if (Utilities.compareText(locatorType, "id")) {
			 elements = GetElementsBy.byId(driver, locator);
		} else if (Utilities.compareText(locatorType, "xpath")) {
			 elements = GetElementsBy.byXpath(driver, locator);
		} else if (Utilities.compareText(locatorType, "class")) {
			 elements = GetElementsBy.byClassName(driver, locator);
		} else if (Utilities.compareText(locatorType, "css")) {
			 elements = GetElementsBy.byCssSelector(driver, locator);
		} else
			TraceLog.output("Only the following text input is supported: id, xpath, class, css");
		
		TraceLog.output("Found " + elements.size() + " child elements.");
		for (WebElement e : elements) {
			try {
				TraceLog.output(e.getText());
				e.click();
				clickable = true;
			} catch (ElementNotVisibleException ex) {
				clickable = false;
			}
			
			if (clickable)
				element = e;
		}
		
		TraceLog.ended("Utilities.getCorrectChildElementByClick");
		return element;
	}
	
	// Use if element has a visible text
	public static WebElement getCorrectChildElementByText(WebDriver driver, String locatorType, String locator, String objVisibleText) {
		TraceLog.start("Utilities.getCorrectChildElementByText");
		
		List<WebElement> elements = null;
		WebElement element = null;
		
		if (Utilities.compareText(locatorType, "id")) {
			 elements = GetElementsBy.byId(driver, locator);
		} else if (Utilities.compareText(locatorType, "xpath")) {
			 elements = GetElementsBy.byXpath(driver, locator);
		} else if (Utilities.compareText(locatorType, "class")) {
			 elements = GetElementsBy.byClassName(driver, locator);
		} else if (Utilities.compareText(locatorType, "css")) {
			 elements = GetElementsBy.byCssSelector(driver, locator);
		} else
			TraceLog.output("Only the following text input is supported: id, xpath, class, css");
		
		TraceLog.output("Found " + elements.size() + " child objects.");
		for (WebElement e : elements) {
			TraceLog.output("Object value: " + e.getText());
			if (e.getText().toLowerCase().equalsIgnoreCase(objVisibleText)) {
				element = e;
				break;
			}
		}
		
		TraceLog.ended("Utilities.getCorrectChildElementByText");
		return element;
	}
	
	public static boolean findElementInScreen(WebElement element, String ScrollDirection, int timeOut) throws AWTException {
		TraceLog.start("Utilities.findElementInScreen");
		boolean isFound = false;
		int iTimer = 0, coordx, coordy;
		
		do {	
			try {
				TraceLog.output("try...");
				if (element.isDisplayed()) {
					TraceLog.output("inside if.." + element.getText());
					isFound = true;
					break;
				}
			} catch (Exception e) {
				TraceLog.output("Scrolling down...");
				coordx = driver.manage().window().getSize().getHeight()/2;
				coordy = driver.manage().window().getSize().getWidth()/2;
				RobotClass.mouseMove(coordx, coordy);
				
				if (ScrollDirection.equalsIgnoreCase("down")) {
					TraceLog.output("Scrolling down...");
					RobotClass.mouseWheelDown(1);
				} else if (ScrollDirection.equalsIgnoreCase("up")) {
					TraceLog.output("Scrolling up...");
					RobotClass.mouseWheelUp(1);
				} else {
					TraceLog.output("Only up and down scrolling supported. Performing scroll down.");
					RobotClass.mouseWheelDown(1);
				}
					
			}
			iTimer++;
		} while (iTimer < timeOut && isFound == false);
			
		
		TraceLog.ended("Utilities.findElementInScreen");
		return isFound;
	}
	
	// create user
	public static String createUser(WebDriver driver, int country, int role) throws AWTException, InterruptedException {
		TraceLog.start("Utilities.createUser");
		Menu_NavBar.navbar_registerUser(driver).click();
		RobotClass.forceRefresh();
		// generate a dummy number
		int rng = randomNumberGenerator(0, 99999999);
		
		// set values
		UM_Register.firstName(driver).sendKeys(String.valueOf(rng));
		UM_Register.lastName(driver).sendKeys(String.valueOf(rng));
		UM_Register.sexMale(driver).click();
		UM_Register.email(driver).sendKeys(Constants.tester_email);
		UM_Register.username(driver).click();
		Thread.sleep(1000);
		UM_Register.username(driver).clear();
		UM_Register.username(driver).sendKeys(String.valueOf(rng));
		
		// scrolling dwn to see elements outside of screen
		Utilities.findElementInScreen(UM_Register.country(driver), "down", 99);
		UM_Register.country(driver).click();
		Thread.sleep(2000);
		UM_Register.countrylist(driver).get(country).click();
		UM_Register.role(driver).click();
		Thread.sleep(2000);
		UM_Register.rolelist(driver).get(role).click();
		UM_Register.submit(driver).click();
		// All the name of users who can access the system are added and all are
		// new users as expected.
		Assert.assertTrue(Utilities.compareText(UM_Register.registerHeader(driver).getText(), "User registration was successful!"));
		Assert.assertTrue(Utilities.compareText(UM_Register.registerMessage(driver).getText(), "New account was successfully created."
				+ "\nNew user should receive an email with the temporary password."));
		UM_Register.registerBtnOK(driver).click();
		Thread.sleep(5000);
		TraceLog.ended("Utilities.createUser");
		return String.valueOf(rng);
	}
	
	public static boolean deactivateUser(WebDriver driver, String name) throws AWTException, InterruptedException {
		TraceLog.start("Utilities.deactivateUser");
		
		boolean isFound = false;
		Utilities.findElementInScreen(Menu_NavBar.navbar_deRegisterUser(driver), "down", 99);
		Menu_NavBar.navbar_deRegisterUser(driver).click();
		RobotClass.forceRefresh();
		
		Thread.sleep(15000);
		Utilities.waitForElementVisibility(driver.findElement(By.cssSelector("div.ui.middle.aligned.divided.selection.list")));
		UM_Deregister.searchActive(driver).sendKeys(name);
		Thread.sleep(1000);
		
		WebElement element = null;
		List<WebElement> elements =  UM_Deregister.listActiveUser(driver);
		TraceLog.output("size: " + elements.size());
		
		element = findElementFromList(elements, name);
		element.click();
		
		Utilities.findElementInScreen(UM_Deregister.deactivate(driver), "down", 99);
		
		if (element != null) {
			UM_Deregister.deactivate(driver).click();
			UM_Deregister.btnRemoveSelectedUserConfirm(driver).click();
			isFound = true;
		}
		
		Thread.sleep(20000);
		TraceLog.ended("Utilities.deactivateUser");
		return isFound;
	}
	
	public static boolean removeUser(WebDriver driver, String name) throws AWTException, InterruptedException {
		TraceLog.start("Utilities.removeuser");
		
		boolean isFound = false;
		Utilities.findElementInScreen(Menu_NavBar.navbar_deRegisterUser(driver), "down", 99);
		Thread.sleep(2000);
		Menu_NavBar.navbar_deRegisterUser(driver).click();
		RobotClass.forceRefresh();
		
		Thread.sleep(15000);
		Utilities.waitForElementVisibility(driver.findElement(By.cssSelector("div.ui.middle.aligned.divided.selection.list")));
		UM_Deregister.searchActive(driver).sendKeys(name);
		WebElement element = null;
		List<WebElement> elements =  UM_Deregister.listActiveUser(driver);
		TraceLog.output("size: " + elements.size());
		
		element = findElementFromList(elements, name);
		element.click();
		
		Utilities.findElementInScreen(UM_Deregister.iconRemoveSelectedUser(driver), "down", 99);
		
		if (element != null) {
			UM_Deregister.iconRemoveSelectedUser(driver).click();
			UM_Deregister.btnRemoveSelectedUserConfirm(driver).click();
			isFound = true;
		}
		
		Thread.sleep(20000);
		TraceLog.ended("Utilities.removeuser");
		return isFound;
	}
	
	public static WebElement findElementFromList(List<WebElement> elements, String value) {
		TraceLog.start("Utilities.findElementFromList");
		TraceLog.output("size: " + elements.size());
		
		WebElement element = null;
		for (WebElement e : elements) {
			TraceLog.output(e.getText());
			if (Utilities.checkStringExist(e.getText(), value)) {
				element = e;
				break;
			}	
		}
		TraceLog.ended("Utilities.findElementFromList");
		return element;
	}
	
	public static WebElement columnResize(List<WebElement> elements) {
		TraceLog.start("Utilities.columnResize");
		TraceLog.output("size: " + elements.size());
		
		WebElement element = null;
		Actions action = new Actions(driver);
		
		for (WebElement e : elements) {
			action.doubleClick(e).perform();
		}
		
		TraceLog.ended("Utilities.columnResize");
		return element;
	}
	
	
	public static void mouseHoverUsingAction(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public static void inputValueUsingAction(WebElement element, String value) throws StaleElementReferenceException{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().sendKeys(element, value).perform();
	}
	
	public static String getLatestDownloadedFile(String pathname, String ext){
		File dir = new File(pathname);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0){
			return null;
		}
		
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				if(lastModifiedFile.lastModified() < files[i].lastModified()){
					lastModifiedFile = files[i];
				}	
			}
		}
		
		return lastModifiedFile.getName();
	}
	
	public static void splitFilename (String filename){
		filename = filename.replace(".", "_");
		filename = filename.replaceAll("\\(.*\\)", "");
		filename = filename.replaceAll("\\s", "");

		for(String f : filename.split("\\s")){
			System.out.println(filename);
			String[] keyValue = f.split("_");
			for (int i = 0; i < keyValue.length; i++) {
				System.out.println("-> "+ keyValue[i]);
			}
		}
	}
	
	public static String removeWord(String value){
		StringBuffer sb = new StringBuffer(value);
		sb.delete(0, 17);
		return sb.toString();
	}
	
}
