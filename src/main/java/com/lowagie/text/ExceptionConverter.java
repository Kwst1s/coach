package com.lowagie.text;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExceptionConverter extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private Exception f8462b;

    /* renamed from: c  reason: collision with root package name */
    private String f8463c;

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getLocalizedMessage() {
        return this.f8462b.getLocalizedMessage();
    }

    public String getMessage() {
        return this.f8462b.getMessage();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public String toString() {
        return this.f8463c + this.f8462b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            printStream.print(this.f8463c);
            this.f8462b.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            printWriter.print(this.f8463c);
            this.f8462b.printStackTrace(printWriter);
        }
    }
}
