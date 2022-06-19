package i;

import com.github.mikephil.charting.BuildConfig;
import i.k0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Headers */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f10631a;

    /* compiled from: Headers */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f10632a = new ArrayList(20);

        public a a(String str, String str2) {
            x.a(str);
            x.b(str2, str);
            c(str, str2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                c(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                c(BuildConfig.FLAVOR, str.substring(1));
                return this;
            } else {
                c(BuildConfig.FLAVOR, str);
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public a c(String str, String str2) {
            this.f10632a.add(str);
            this.f10632a.add(str2.trim());
            return this;
        }

        public x d() {
            return new x(this);
        }

        @Nullable
        public String e(String str) {
            for (int size = this.f10632a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f10632a.get(size))) {
                    return this.f10632a.get(size + 1);
                }
            }
            return null;
        }

        public a f(String str) {
            int i2 = 0;
            while (i2 < this.f10632a.size()) {
                if (str.equalsIgnoreCase(this.f10632a.get(i2))) {
                    this.f10632a.remove(i2);
                    this.f10632a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public a g(String str, String str2) {
            x.a(str);
            x.b(str2, str);
            f(str);
            c(str, str2);
            return this;
        }
    }

    x(a aVar) {
        List<String> list = aVar.f10632a;
        this.f10631a = (String[]) list.toArray(new String[list.size()]);
    }

    static void a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (!str.isEmpty()) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(e.n("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty");
    }

    static void b(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalArgumentException(e.n("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    @Nullable
    private static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static x g(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                if (strArr2[i2] != null) {
                    strArr2[i2] = strArr2[i2].trim();
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                String str = strArr2[i3];
                String str2 = strArr2[i3 + 1];
                a(str);
                b(str2, str);
            }
            return new x(strArr2);
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    @Nullable
    public String c(String str) {
        return d(this.f10631a, str);
    }

    public String e(int i2) {
        return this.f10631a[i2 * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof x) && Arrays.equals(((x) obj).f10631a, this.f10631a);
    }

    public a f() {
        a aVar = new a();
        Collections.addAll(aVar.f10632a, this.f10631a);
        return aVar;
    }

    public int h() {
        return this.f10631a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10631a);
    }

    public String i(int i2) {
        return this.f10631a[(i2 * 2) + 1];
    }

    public List<String> j(String str) {
        int h2 = h();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < h2; i2++) {
            if (str.equalsIgnoreCase(e(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(i(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int h2 = h();
        for (int i2 = 0; i2 < h2; i2++) {
            sb.append(e(i2));
            sb.append(": ");
            sb.append(i(i2));
            sb.append("\n");
        }
        return sb.toString();
    }

    private x(String[] strArr) {
        this.f10631a = strArr;
    }
}
