package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* compiled from: LocaleListPlatformWrapper */
public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f1133a;

    g(LocaleList localeList) {
        this.f1133a = localeList;
    }

    @Override // androidx.core.os.f
    public Object a() {
        return this.f1133a;
    }

    public boolean equals(Object obj) {
        return this.f1133a.equals(((f) obj).a());
    }

    @Override // androidx.core.os.f
    public Locale get(int i2) {
        return this.f1133a.get(i2);
    }

    public int hashCode() {
        return this.f1133a.hashCode();
    }

    public String toString() {
        return this.f1133a.toString();
    }
}
