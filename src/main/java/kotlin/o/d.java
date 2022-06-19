package kotlin.o;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.j.i;
import kotlin.m.b.f;

/* compiled from: Regex.kt */
public final class d implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final Pattern f10796b;

    public d(Pattern pattern) {
        f.e(pattern, "nativePattern");
        this.f10796b = pattern;
    }

    public final List<String> a(CharSequence charSequence, int i2) {
        f.e(charSequence, "input");
        int i3 = 0;
        if (i2 >= 0) {
            Matcher matcher = this.f10796b.matcher(charSequence);
            if (!matcher.find() || i2 == 1) {
                return i.b(charSequence.toString());
            }
            int i4 = 10;
            if (i2 > 0) {
                i4 = kotlin.n.f.b(i2, 10);
            }
            ArrayList arrayList = new ArrayList(i4);
            int i5 = i2 - 1;
            do {
                arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
                i3 = matcher.end();
                if (i5 >= 0 && arrayList.size() == i5) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public String toString() {
        String pattern = this.f10796b.toString();
        f.d(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.m.b.f.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.m.b.f.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.o.d.<init>(java.lang.String):void");
    }
}
