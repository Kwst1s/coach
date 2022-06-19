package pl.aprilapps.easyphotopicker;

import kotlin.m.b.f;

/* compiled from: EasyImageException.kt */
public final class d extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String str, Throwable th) {
        super(str, th);
        f.f(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(String str) {
        this(str, null);
        f.f(str, "message");
    }
}
