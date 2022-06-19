package org.apache.harmony.luni.util;

import java.io.PrintStream;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
        this(System.err);
    }

    public NotImplementedException(PrintStream printStream) {
        printStream.println("*** NOT IMPLEMENTED EXCEPTION ***");
        StackTraceElement stackTraceElement = getStackTrace()[0];
        printStream.println("*** thrown from class  -> " + stackTraceElement.getClassName());
        printStream.println("***             method -> " + stackTraceElement.getMethodName());
        printStream.print("*** defined in         -> ");
        if (stackTraceElement.isNativeMethod()) {
            printStream.println("a native method");
            return;
        }
        String fileName = stackTraceElement.getFileName();
        if (fileName == null) {
            printStream.println("an unknown source");
            return;
        }
        int lineNumber = stackTraceElement.getLineNumber();
        printStream.print("the file \"" + fileName + "\"");
        if (lineNumber >= 0) {
            printStream.print(" on line #" + lineNumber);
        }
        printStream.println();
    }
}
