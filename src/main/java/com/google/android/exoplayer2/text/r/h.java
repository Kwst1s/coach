package com.google.android.exoplayer2.text.r;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttParserUtil */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f6854a = Pattern.compile("^NOTE(( |\t).*)?$");

    public static Matcher a(s sVar) {
        String l;
        while (true) {
            String l2 = sVar.l();
            if (l2 == null) {
                return null;
            }
            if (f6854a.matcher(l2).matches()) {
                do {
                    l = sVar.l();
                    if (l == null) {
                        break;
                    }
                } while (!l.isEmpty());
            } else {
                Matcher matcher = f.f6844b.matcher(l2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(s sVar) {
        String l = sVar.l();
        return l != null && l.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] d0 = d0.d0(str, "\\.");
        long j2 = 0;
        for (String str2 : d0.c0(d0[0], ":")) {
            j2 = (j2 * 60) + Long.parseLong(str2);
        }
        long j3 = j2 * 1000;
        if (d0.length == 2) {
            j3 += Long.parseLong(d0[1]);
        }
        return j3 * 1000;
    }

    public static void e(s sVar) {
        int c2 = sVar.c();
        if (!b(sVar)) {
            sVar.K(c2);
            throw new ParserException("Expected WEBVTT. Got " + sVar.l());
        }
    }
}
