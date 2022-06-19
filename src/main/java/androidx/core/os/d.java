package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* compiled from: LocaleListCompat */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private f f1130a;

    static {
        a(new Locale[0]);
    }

    private d(f fVar) {
        this.f1130a = fVar;
    }

    public static d a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d(new LocaleList(localeArr));
        }
        return new d(new e(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static d d(LocaleList localeList) {
        return new d(new g(localeList));
    }

    public Locale c(int i2) {
        return this.f1130a.get(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && this.f1130a.equals(((d) obj).f1130a);
    }

    public int hashCode() {
        return this.f1130a.hashCode();
    }

    public String toString() {
        return this.f1130a.toString();
    }
}
