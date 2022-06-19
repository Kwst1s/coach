package j;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: ByteString */
public class f implements Serializable, Comparable<f> {

    /* renamed from: e  reason: collision with root package name */
    static final char[] f10665e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: f  reason: collision with root package name */
    public static final f f10666f = m(new byte[0]);

    /* renamed from: b  reason: collision with root package name */
    final byte[] f10667b;

    /* renamed from: c  reason: collision with root package name */
    transient int f10668c;

    /* renamed from: d  reason: collision with root package name */
    transient String f10669d;

    f(byte[] bArr) {
        this.f10667b = bArr;
    }

    static int c(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 == i2) {
                return i3;
            }
            int codePointAt = str.codePointAt(i3);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i4++;
            i3 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    @Nullable
    public static f e(String str) {
        if (str != null) {
            byte[] a2 = b.a(str);
            if (a2 != null) {
                return new f(a2);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public static f f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((g(str.charAt(i3)) << 4) + g(str.charAt(i3 + 1)));
            }
            return m(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    private static int g(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    private f h(String str) {
        try {
            return m(MessageDigest.getInstance(str).digest(this.f10667b));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f i(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(v.f10711a));
            fVar.f10669d = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static f m(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String a() {
        return b.b(this.f10667b);
    }

    /* renamed from: d */
    public int compareTo(f fVar) {
        int r = r();
        int r2 = fVar.r();
        int min = Math.min(r, r2);
        for (int i2 = 0; i2 < min; i2++) {
            int j2 = j(i2) & 255;
            int j3 = fVar.j(i2) & 255;
            if (j2 != j3) {
                if (j2 < j3) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        if (r == r2) {
            return 0;
        }
        if (r < r2) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int r = fVar.r();
            byte[] bArr = this.f10667b;
            if (r != bArr.length || !fVar.o(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f10668c;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.f10667b);
        this.f10668c = hashCode;
        return hashCode;
    }

    public byte j(int i2) {
        return this.f10667b[i2];
    }

    public String k() {
        byte[] bArr = this.f10667b;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f10665e;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public f l() {
        return h("MD5");
    }

    public boolean n(int i2, f fVar, int i3, int i4) {
        return fVar.o(i3, this.f10667b, i2, i4);
    }

    public boolean o(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.f10667b;
            return i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && v.a(bArr2, i2, bArr, i3, i4);
        }
    }

    public f p() {
        return h("SHA-1");
    }

    public f q() {
        return h("SHA-256");
    }

    public int r() {
        return this.f10667b.length;
    }

    public final boolean s(f fVar) {
        return n(0, fVar, 0, fVar.r());
    }

    public f t(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.f10667b;
            if (i3 <= bArr.length) {
                int i4 = i3 - i2;
                if (i4 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i2 == 0 && i3 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i2, bArr2, 0, i4);
                    return new f(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f10667b.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public String toString() {
        if (this.f10667b.length == 0) {
            return "[size=0]";
        }
        String w = w();
        int c2 = c(w, 64);
        if (c2 != -1) {
            String replace = w.substring(0, c2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (c2 < w.length()) {
                return "[size=" + this.f10667b.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.f10667b.length <= 64) {
            return "[hex=" + k() + "]";
        } else {
            return "[size=" + this.f10667b.length + " hex=" + t(0, 64).k() + "…]";
        }
    }

    public f u() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f10667b;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
        }
    }

    public byte[] v() {
        return (byte[]) this.f10667b.clone();
    }

    public String w() {
        String str = this.f10669d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f10667b, v.f10711a);
        this.f10669d = str2;
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void x(c cVar) {
        byte[] bArr = this.f10667b;
        cVar.Y(bArr, 0, bArr.length);
    }
}
