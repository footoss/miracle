package com.footoss.basic.log;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormmater extends Formatter{

	@Override
	public String format(LogRecord record) {
//		StackTraceElement[]  stackTraces = record.getThrown().getStackTrace();
		return null;
	}
}
