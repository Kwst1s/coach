package okhttp3.internal.http2;

import com.github.mikephil.charting.BuildConfig;
import i.k0.e;
import j.f;
import java.io.IOException;

/* compiled from: Http2 */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final f f10909a = f.i("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f10910b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    static final String[] f10911c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    static final String[] f10912d = new String[256];

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f10912d;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = e.n("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f10911c;
        strArr2[0] = BuildConfig.FLAVOR;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            String[] strArr3 = f10911c;
            strArr3[i5 | 8] = strArr3[i5] + "|PADDED";
        }
        String[] strArr4 = f10911c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr5 = f10911c;
                int i10 = i9 | i7;
                strArr5[i10] = strArr5[i9] + '|' + strArr5[i7];
                strArr5[i10 | 8] = strArr5[i9] + '|' + strArr5[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f10911c;
            if (i2 < strArr6.length) {
                if (strArr6[i2] == null) {
                    strArr6[i2] = f10912d[i2];
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private d() {
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return BuildConfig.FLAVOR;
        }
        if (!(b2 == 2 || b2 == 3)) {
            if (b2 == 4 || b2 == 6) {
                if (b3 == 1) {
                    return "ACK";
                }
                return f10912d[b3];
            } else if (!(b2 == 7 || b2 == 8)) {
                String[] strArr = f10911c;
                String str = b3 < strArr.length ? strArr[b3] : f10912d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f10912d[b3];
    }

    static String b(boolean z, int i2, int i3, byte b2, byte b3) {
        String[] strArr = f10910b;
        String n = b2 < strArr.length ? strArr[b2] : e.n("0x%02x", Byte.valueOf(b2));
        String a2 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = n;
        objArr[4] = a2;
        return e.n("%s 0x%08x %5d %-13s %s", objArr);
    }

    static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(e.n(str, objArr));
    }

    static IOException d(String str, Object... objArr) {
        throw new IOException(e.n(str, objArr));
    }
}
