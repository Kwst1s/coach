package f.a.a.a.b.d;

import java.io.Serializable;
import kotlin.m.b.f;

/* compiled from: Appreciation.kt */
public final class a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private int f9195b;

    /* renamed from: c  reason: collision with root package name */
    private String f9196c;

    /* renamed from: d  reason: collision with root package name */
    private String f9197d;

    public a(int i2, String str, String str2) {
        f.e(str, "content");
        this.f9195b = i2;
        this.f9196c = str;
        this.f9197d = str2;
    }

    public final String a() {
        return this.f9196c;
    }

    public final int c() {
        return this.f9195b;
    }

    public final String d() {
        return this.f9197d;
    }

    public final void e(String str) {
        f.e(str, "<set-?>");
        this.f9196c = str;
    }

    public final void f(String str) {
        this.f9197d = str;
    }
}
