package i.k0.h;

import com.github.mikephil.charting.BuildConfig;
import i.c0;
import java.net.ProtocolException;

/* compiled from: StatusLine */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final c0 f10519a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10520b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10521c;

    public k(c0 c0Var, int i2, String str) {
        this.f10519a = c0Var;
        this.f10520b = i2;
        this.f10521c = str;
    }

    public static k a(String str) {
        c0 c0Var;
        String str2;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                c0Var = c0.HTTP_1_0;
            } else if (charAt == 1) {
                c0Var = c0.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            c0Var = c0.HTTP_1_0;
            i2 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = BuildConfig.FLAVOR;
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(c0Var, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10519a == c0.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f10520b);
        if (this.f10521c != null) {
            sb.append(' ');
            sb.append(this.f10521c);
        }
        return sb.toString();
    }
}
