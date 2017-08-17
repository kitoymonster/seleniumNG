
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menu_NavBar {

	// Vertical NavBar - MAIN - Dashboard
	public static WebElement navbar_dashboard(WebDriver driver) {
		TraceLog.start("Menu_NavBar.navbar_dashboard");
		WebElement element = GetElementBy.byLinkText(driver, "DASHBOARD");
		TraceLog.ended("Menu_NavBar.navbar_dashboard");
		return element;
	}
	
	// Vertical NavBar - MAIN - Project Excel
	public static WebElement navbar_projectExcel(WebDriver driver) {
		TraceLog.start("Menu_NavBar.navbar_projectExcel");
		WebElement element = GetElementBy.byLinkText(driver, "PROJECT EXCEL");
		TraceLog.ended("Menu_NavBar.navbar_projectExcel");
		return element;
	}

	// Vertical NavBar - MAIN - Sign Off
	public static WebElement navbar_signOff(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "SIGN OFF");
	}

	// Vertical NavBar - MAIN - My Activity
	public static WebElement navbar_myActivity(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "MY ACTIVITY");
	}

	// Vertical NavBar - REPORTS - Standard
	public static WebElement navbar_standard(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "redirectSearchSR");
	}

	// Vertical NavBar - STANDARD - Total or averages of all indicators
	public static WebElement selection_SR123(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "Totals or averages of all indicators");
	}
	
	// Vertical NavBar - STANDARD - Partner Cluster report
	public static WebElement selection_SR4(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "Partner Cluster report");
	}

	// Vertical NavBar - STANDARD - Project Cluster report
	public static WebElement selection_SR56(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "Project Cluster report");
	}

	// Vertical NavBar - STANDARD - Savings, Funds, and Goals report over time
	public static WebElement selection_SR78(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "Savings, Funds, and Goals report over time");
	}

	// Vertical NavBar - STANDARD - SHG Cluster report
	public static WebElement selection_SR910(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "SHG Cluster report");
	}
	
	// Vertical NavBar - STANDARD - NC Annual report
	public static WebElement selection_SR11(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "NC Annual Report");
	}

	// Vertical NavBar - REPORTS - Issue Based
	public static WebElement navbar_IssueBased(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "ISSUE BASED");
	}
	
	// Vertical NavBar - REPORTS - Issue Based report 1
	public static WebElement navbar_IssueBasedReport1(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "SHG Search based on Criteria");
	}
	
	// Vertical NavBar - REPORTS - Issue Based report 2
	public static WebElement navbar_IssueBasedReport2(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "SHG Cluster Search based on Criteria");
	}

	// Vertical NavBar - REPORTS - Issue Based report 4
	public static WebElement navbar_IssueBasedReport4(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "Distribution of Values per Indicator");
	}

	// Vertical NavBar - REPORTS - Issue Based report 5
	public static WebElement navbar_IssueBasedReport5(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "SHG Performance on Goal Indicators");
	}

	// Vertical NavBar - REPORTS - Custom
	public static WebElement navbar_custom(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "CUSTOM");
	}

	// Vertical NavBar - USER MANAGEMENT - Registration
	public static WebElement navbar_registerUser(WebDriver driver) {
		TraceLog.start("Menu_NavBar.navbar_registerUser");
		WebElement element = GetElementBy.byLinkText(driver, "REGISTER USER");
		TraceLog.ended("Menu_NavBar.navbar_registerUser");
		return element;
	}
	
	// Vertical NavBar - USER MANAGEMENT - Edit user
	public static WebElement navbar_editUser(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "EDIT USER");
	}

	// Vertical NavBar - USER MANAGEMENT - Role Assignment
	public static WebElement navbar_roleAssignment(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "ROLE ASSIGNMENT");
	}

	// Vertical NavBar - USER MANAGEMENT - De-register
	public static WebElement navbar_deRegisterUser(WebDriver driver) {
		TraceLog.output("de-register link count: " + GetElementsBy.byLinkText(driver, "DE-REGISTER USER").size());
		return GetElementBy.byLinkText(driver, "DE-REGISTER USER");
	}

	// Vertical NavBar - USER MANAGEMENT - Distribution
	public static WebElement navbar_recipientsList(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "RECIPIENTS LIST");
	}

	// Vertical NavBar - ADMIN - History
	public static WebElement navbar_userActivity(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "USER ACTIVITY");
	}
	
	// Vertical NavBar - ADMIN - Mapping
	public static WebElement navbar_projectMapping(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "PROJECT MAPPING");
	}

	// Vertical NavBar - ADMIN - Settings
	public static WebElement navbar_settings(WebDriver driver) {
		return GetElementBy.byLinkText(driver, "SETTINGS");
	}
	
}
