package f.a.a.a.b.d;

import java.io.Serializable;
import kotlin.m.b.f;

/* compiled from: COVIDTutorial.kt */
public final class e implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private String f9221b;

    /* renamed from: c  reason: collision with root package name */
    private String f9222c;

    public e(String str, String str2) {
        this.f9221b = str;
        this.f9222c = str2;
    }

    public final String a() {
        return this.f9222c;
    }

    public final String c() {
        return this.f9221b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return f.a(this.f9221b, eVar.f9221b) && f.a(this.f9222c, eVar.f9222c);
    }

    public int hashCode() {
        String str = this.f9221b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f9222c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "COVIDTutorial(text=" + this.f9221b + ", image=" + this.f9222c + ")";
    }
}
