package androidx.core.os;

import b.h.j.c;

public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(c.c(str, "The operation has been canceled."));
    }
}
