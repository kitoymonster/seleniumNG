
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Import {
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	
	// import label
	public static WebElement pageHeader(WebDriver driver) {
		TraceLog.start("DM_Import.pageHeader");
		
		element = GetElementBy.byClassName(driver, "xxx-table-header");
		
		TraceLog.ended("DM_Import.pageHeader");
		return element;
	}
	
	// import link
	public static WebElement linkImport(WebDriver driver) {
		TraceLog.start("DM_Import.linkImport");
		
		element = GetElementBy.byId(driver, "trigger-file-click");
		
		TraceLog.ended("DM_Import.linkImport");
		return element;
	}
	
	// upload specific file
	// The same class is for the individual progress bar. Use List<WebElement>
	// to get all existing progress bar
	public static List<WebElement> btnUpload(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.btnUpload");
		
		Thread.sleep(1000);
		elements =  GetElementsBy.byCssSelector(driver, "div.ui.primary.button");
		
		TraceLog.ended("DM_Import.btnUpload");
		return elements;
	}
	
	public static WebElement btnUploadAll(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.btnUploadAll");

		Thread.sleep(1000);
		element = Utilities.getCorrectObjectIndex(driver, "div.ui.primary.button", "upload all");

		TraceLog.ended("DM_Import.btnUploadAll");
		return element;
	}
	
	// remove specific file
	// The same class is for the individual progress bar. Use List<WebElement>
	// to get all existing progress bar
	public static List<WebElement> btnRemove(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.btnRemove");
		
		Thread.sleep(1000);
		elements = GetElementsBy.byCssSelector(driver, "div.ui.button.red");
		
		TraceLog.ended("DM_Import.btnRemove");
		return elements;
	}
	
	public static WebElement btnRemoveAll(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.btnRemoveAll");

		Thread.sleep(1000);
		element = Utilities.getCorrectObjectIndex(driver, "div.ui.button.red", "remove all");

		TraceLog.ended("DM_Import.btnRemoveAll");
		return element;
	}

	// Progress bar
	// The same class is for the individual progress bar. Use List<WebElement>
	// to get all existing progress bar
	public static WebElement progressbar(WebDriver driver) {
		TraceLog.start("DM_Import.progressbar");
		
		element = GetElementBy.byClassName(driver, "progress");
		
		TraceLog.ended("DM_Import.progressbar");
		return element;
	}
	
	// Confirm upload dialog and friends
	public static WebElement dialogConfirmUpload(WebDriver driver) {
		TraceLog.start("DM_Import.dialogConfirmUpload");
		
		element = GetElementBy.byCssSelector(driver, "div.header.ng-binding");
		
		TraceLog.ended("DM_Import.dialogConfirmUpload");
		return element;
	}
	
	// same values as dialogConfirmUpload, verify by checking the output text
	public static WebElement fileAlreadyExists(WebDriver driver) {
		return GetElementBy.byCssSelector(driver, "div.header.ng-binding");
	}
	
	public static WebElement btnYesUpload(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.btnYesUpload");
		
		Thread.sleep(1000);
		element = Utilities.getCorrectObjectIndex(driver, "div.ui.positive.button", "Yes");
		
		TraceLog.ended("DM_Import.btnYesUpload");
		return element;
	}
	
	public static WebElement btnNoUpload(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.btnNoUpload");
		
		Thread.sleep(1000);
		element = Utilities.getCorrectObjectIndex(driver, "div.ui.negative.button", "No");
		
		TraceLog.ended("DM_Import.btnNoUpload");
		return element;
	}
	
	// successfully uploaded files || error encountered
	public static WebElement importMessageHeader(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.importMessageHeader");
		
		Thread.sleep(2000);
		element = GetElementBy.byXpath(driver, "//*[@id='list-project-excel']/div[2]/div/div[5]/div/div/div[2]/div/div/div[2]/div/div/div/div/div");
		
		TraceLog.ended("DM_Import.importMessageHeader");
		return element;
	}
	
	public static WebElement importMessageHeaderSuccess(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.importMessageHeaderSuccess");
		
		Thread.sleep(2000);
		element = Utilities.getCorrectObjectIndex(driver, "div.header", "Successfully uploaded files:");
		
		TraceLog.ended("DM_Import.importMessageHeaderSuccess");
		return element;
	}
	
	public static WebElement importMessageHeaderFailed(WebDriver driver) throws InterruptedException {
		TraceLog.start("DM_Import.importMessageHeaderFailed");
		
		Thread.sleep(2000);
		element = Utilities.getCorrectObjectIndex(driver, "div.header", "Error encountered\nDownload Log File");
		
		TraceLog.ended("DM_Import.importMessageHeaderFailed");
		return element;
	}
	
	public static List<WebElement> importMessageList(WebDriver driver) {
		TraceLog.start("DM_Import.importMessageList");
		
		elements =  GetElementsBy.byCssSelector(driver, "ul.list");
		
		TraceLog.ended("DM_Import.importMessageList");
		return elements;
	}
	
	public static WebElement importMessageClose(WebDriver driver) {
		TraceLog.start("DM_Import.importMessageClose");
		
		element =  GetElementBy.byXpath(driver, "//*[@id='list-project-excel']/div[2]/div/div[5]/div/div/div[2]/div/div/div[2]/div/div/div/div/i");
		
		TraceLog.ended("DM_Import.importMessageClose");
		return element;
	}
	
	public static WebElement listofUploadedExcel(WebDriver driver) {
		return GetElementBy.byXpath(driver, "//*[@id='upload-table']");
	}
	
	
	public static WebElement text_US(WebDriver driver) {
		return GetElementBy.byXpath(driver, "//*[@id='list-project-excel']/div[2]/div/div[4]/div/div/div[2]/div[1]/div[4]");
	}
	
	public static WebElement text_EURO(WebDriver driver) {
		return GetElementBy.byXpath(driver, "//*[@id='list-project-excel']/div[2]/div/div[4]/div/div/div[2]/div[1]/div[3]");
	}

	public static WebElement forexLink(WebDriver driver) {
		return GetElementBy.byXpath(driver, "//*[@id='list-project-excel']/div[2]/div/div[4]/div/div/div[2]/div[2]/div/a");
	}

}
