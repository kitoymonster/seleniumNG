package org.knh.pds.utility;

import java.io.PrintStream;

public class TraceLog {
	private static String msg;
	
	private static void writeLog(final String msgInput, PrintStream consoleOutput, PrintStream fileOutput) {        
		consoleOutput.println(msgInput);
		fileOutput.println(msgInput);
	}
	
	public static void start(String functionName) {
		msg = Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + 
				Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " START: " + functionName;
		writeLog(msg, Utilities.consoleOutputStream, Utilities.fileOutputStream);
		Utilities.gTraceLogDepth = Utilities.gTraceLogDepth + 5;
	}
	
	public static void ended(String functionName) {
		Utilities.gTraceLogDepth = Utilities.gTraceLogDepth - 5;
		msg = Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + 
				Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " ENDED: " + functionName;
		writeLog(msg, Utilities.consoleOutputStream, Utilities.fileOutputStream);
	}
	
	public static void output(Object message) {
		msg = Utilities.getCurrentDate("yyyyMMdd'T'HHmmssSSS") + 
				Utilities.tabDisplay.substring(0, Utilities.gTraceLogDepth) + " " + message.toString();
		writeLog(msg, Utilities.consoleOutputStream, Utilities.fileOutputStream);
	}
	
}
