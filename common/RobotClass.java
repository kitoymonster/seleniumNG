import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotClass {

	// Enter
	public static void enter() throws AWTException {
		TraceLog.start("RobotClass.enter");
		Robot rb = new Robot();
		rb.delay(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		TraceLog.ended("RobotClass.enter");
	}

	// new tab
	public static void newTab() throws AWTException {
		TraceLog.start("RobotClass.newTab");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		TraceLog.ended("RobotClass.newTab");
	}

	// page up
	public static void pageUp() throws AWTException {
		TraceLog.start("RobotClass.pageUp");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_PAGE_UP);
		rb.keyRelease(KeyEvent.VK_PAGE_UP);
		TraceLog.ended("RobotClass.pageUp");
	}

	// page down
	public static void pageDown() throws AWTException {
		TraceLog.start("RobotClass.pageDown");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
		TraceLog.ended("RobotClass.pageDown");
	}

	// arrow right
	public static void arrowRight() throws AWTException {
		TraceLog.start("RobotClass.arrowRight");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_RIGHT);
		rb.keyRelease(KeyEvent.VK_RIGHT);
		TraceLog.ended("RobotClass.arrowRight");
	}
	
	// arrow right
	public static void escape() throws AWTException {
		TraceLog.start("RobotClass.escape");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		TraceLog.ended("RobotClass.escape");
	}
	
	// arrow right
	public static void dragAndDrop() throws AWTException, InterruptedException {
		TraceLog.start("RobotClass.dragAndDrop");
		Robot rb = new Robot();
		Thread.sleep(4000); 
        rb.mouseMove(400, 350); 
        rb.mousePress(InputEvent.BUTTON1_MASK); 
        Thread.sleep(2000); 
        rb.mouseMove(500, 350); 
        rb.mouseRelease(InputEvent.BUTTON1_MASK); 
        TraceLog.ended("RobotClass.dragAndDrop");
	}

	public static void uploadFile(String filelocation) throws AWTException, InterruptedException {
		TraceLog.start("RobotClass.uploadFile");
		StringSelection stringSelection = new StringSelection(filelocation);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(300);
		robot.keyRelease(KeyEvent.VK_ENTER);
		TraceLog.ended("RobotClass.uploadFile");
	}
	
	// page down
	public static void searchKeyword() throws AWTException {
		TraceLog.start("RobotClass.searchKeyword");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_F);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_F);
		rb.keyPress(KeyEvent.VK_K);
		rb.keyRelease(KeyEvent.VK_K);
		TraceLog.ended("RobotClass.searchKeyword");
	}
	
	public static void forceRefresh() throws AWTException {
		TraceLog.start("RobotClass.forceRefresh");
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_F5);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_F5);
		
		TraceLog.ended("RobotClass.forceRefresh");
	}
	
	public static void mouseMove(int coordx, int coordy) throws AWTException {
		TraceLog.start("RobotClass.mouseMove");
		
		Robot rb = new Robot();
		rb.mouseMove(coordx, coordy);
		
		TraceLog.ended("RobotClass.mouseMove");
	}
	
	public static void mouseWheelDown(int move) throws AWTException {
		TraceLog.start("RobotClass.mouseWheelDown");
		
		Robot rb = new Robot();
		rb.mouseWheel(move);
		
		TraceLog.ended("RobotClass.mouseWheelDown");
	}
	
	public static void mouseWheelUp(int move) throws AWTException {
		TraceLog.start("RobotClass.mouseWheelUp");
		
		Robot rb = new Robot();
		rb.mouseWheel(-move);
		
		TraceLog.ended("RobotClass.mouseWheelUp");
	}
}
