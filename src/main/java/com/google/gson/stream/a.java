package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: JsonWriter */
public class a implements Closeable, Flushable {

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f8317k = new String[128];
    private static final String[] l;

    /* renamed from: b  reason: collision with root package name */
    private final Writer f8318b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f8319c = new int[32];

    /* renamed from: d  reason: collision with root package name */
    private int f8320d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f8321e;

    /* renamed from: f  reason: collision with root package name */
    private String f8322f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8323g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8324h;

    /* renamed from: i  reason: collision with root package name */
    private String f8325i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8326j;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f8317k[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f8317k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public a(Writer writer) {
        S(6);
        this.f8322f = ":";
        this.f8326j = true;
        Objects.requireNonNull(writer, "out == null");
        this.f8318b = writer;
    }

    private void E() {
        int R = R();
        if (R == 1) {
            T(2);
            O();
        } else if (R == 2) {
            this.f8318b.append(',');
            O();
        } else if (R != 4) {
            if (R != 6) {
                if (R != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f8323g) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            T(7);
        } else {
            this.f8318b.append((CharSequence) this.f8322f);
            T(5);
        }
    }

    private a H(int i2, int i3, char c2) {
        int R = R();
        if (R != i3 && R != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f8325i == null) {
            this.f8320d--;
            if (R == i3) {
                O();
            }
            this.f8318b.write(c2);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f8325i);
        }
    }

    private void O() {
        if (this.f8321e != null) {
            this.f8318b.write(10);
            int i2 = this.f8320d;
            for (int i3 = 1; i3 < i2; i3++) {
                this.f8318b.write(this.f8321e);
            }
        }
    }

    private a Q(int i2, char c2) {
        E();
        S(i2);
        this.f8318b.write(c2);
        return this;
    }

    private int R() {
        int i2 = this.f8320d;
        if (i2 != 0) {
            return this.f8319c[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void S(int i2) {
        int i3 = this.f8320d;
        int[] iArr = this.f8319c;
        if (i3 == iArr.length) {
            this.f8319c = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f8319c;
        int i4 = this.f8320d;
        this.f8320d = i4 + 1;
        iArr2[i4] = i2;
    }

    private void T(int i2) {
        this.f8319c[this.f8320d - 1] = i2;
    }

    private void Y(String str) {
        String str2;
        String[] strArr = this.f8324h ? l : f8317k;
        this.f8318b.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.f8318b.write(str, i2, i3 - i2);
            }
            this.f8318b.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.f8318b.write(str, i2, length - i2);
        }
        this.f8318b.write(34);
    }

    private void e0() {
        if (this.f8325i != null) {
            l();
            Y(this.f8325i);
            this.f8325i = null;
        }
    }

    private void l() {
        int R = R();
        if (R == 5) {
            this.f8318b.write(44);
        } else if (R != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        O();
        T(4);
    }

    public a F() {
        e0();
        Q(1, '[');
        return this;
    }

    public a G() {
        e0();
        Q(3, '{');
        return this;
    }

    public a I() {
        H(1, 2, ']');
        return this;
    }

    public a J() {
        H(3, 5, '}');
        return this;
    }

    public final boolean K() {
        return this.f8326j;
    }

    public final boolean L() {
        return this.f8324h;
    }

    public boolean M() {
        return this.f8323g;
    }

    public a N(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f8325i != null) {
            throw new IllegalStateException();
        } else if (this.f8320d != 0) {
            this.f8325i = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public a P() {
        if (this.f8325i != null) {
            if (this.f8326j) {
                e0();
            } else {
                this.f8325i = null;
                return this;
            }
        }
        E();
        this.f8318b.write("null");
        return this;
    }

    public final void U(boolean z) {
        this.f8324h = z;
    }

    public final void V(String str) {
        if (str.length() == 0) {
            this.f8321e = null;
            this.f8322f = ":";
            return;
        }
        this.f8321e = str;
        this.f8322f = ": ";
    }

    public final void W(boolean z) {
        this.f8323g = z;
    }

    public final void X(boolean z) {
        this.f8326j = z;
    }

    public a Z(long j2) {
        e0();
        E();
        this.f8318b.write(Long.toString(j2));
        return this;
    }

    public a a0(Boolean bool) {
        if (bool == null) {
            return P();
        }
        e0();
        E();
        this.f8318b.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a b0(Number number) {
        if (number == null) {
            return P();
        }
        e0();
        String obj = number.toString();
        if (this.f8323g || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            E();
            this.f8318b.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public a c0(String str) {
        if (str == null) {
            return P();
        }
        e0();
        E();
        Y(str);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8318b.close();
        int i2 = this.f8320d;
        if (i2 > 1 || (i2 == 1 && this.f8319c[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f8320d = 0;
    }

    public a d0(boolean z) {
        e0();
        E();
        this.f8318b.write(z ? "true" : "false");
        return this;
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f8320d != 0) {
            this.f8318b.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
}
