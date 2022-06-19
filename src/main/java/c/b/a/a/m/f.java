package c.b.a.a.m;

import java.util.Formatter;
import java.util.Locale;

/* compiled from: TimeFormatUtil */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static StringBuilder f3183a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private static Formatter f3184b = new Formatter(f3183a, Locale.getDefault());

    public static String a(long j2) {
        if (j2 < 0) {
            return "--:--";
        }
        long j3 = (j2 % 60000) / 1000;
        long j4 = (j2 % 3600000) / 60000;
        long j5 = (j2 % 86400000) / 3600000;
        f3183a.setLength(0);
        if (j5 > 0) {
            return f3184b.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString();
        }
        return f3184b.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
    }
}
