package com.google.android.exoplayer2.text.r;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.constraintlayout.widget.i;
import b.a.j;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.text.r.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttCueParser */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f6844b = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f6845c = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f6846a = new StringBuilder();

    /* access modifiers changed from: private */
    /* compiled from: WebvttCueParser */
    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        private static final String[] f6847e = new String[0];

        /* renamed from: a  reason: collision with root package name */
        public final String f6848a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6849b;

        /* renamed from: c  reason: collision with root package name */
        public final String f6850c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f6851d;

        private a(String str, int i2, String str2, String[] strArr) {
            this.f6849b = i2;
            this.f6848a = str;
            this.f6850c = str2;
            this.f6851d = strArr;
        }

        public static a a(String str, int i2) {
            String str2;
            String[] strArr;
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = BuildConfig.FLAVOR;
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] c0 = d0.c0(trim, "\\.");
            String str3 = c0[0];
            if (c0.length > 1) {
                strArr = (String[]) Arrays.copyOfRange(c0, 1, c0.length);
            } else {
                strArr = f6847e;
            }
            return new a(str3, i2, str2, strArr);
        }

        public static a b() {
            return new a(BuildConfig.FLAVOR, 0, BuildConfig.FLAVOR, new String[0]);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: WebvttCueParser */
    public static final class b implements Comparable<b> {

        /* renamed from: b  reason: collision with root package name */
        public final int f6852b;

        /* renamed from: c  reason: collision with root package name */
        public final d f6853c;

        public b(int i2, d dVar) {
            this.f6852b = i2;
            this.f6853c = dVar;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            return this.f6852b - bVar.f6852b;
        }
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c2 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                spannableStringBuilder.append('>');
                return;
            case 1:
                spannableStringBuilder.append('<');
                return;
            case 2:
                spannableStringBuilder.append('&');
                return;
            case 3:
                spannableStringBuilder.append(' ');
                return;
            default:
                m.f("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static void b(String str, a aVar, SpannableStringBuilder spannableStringBuilder, List<d> list, List<b> list2) {
        int i2 = aVar.f6849b;
        int length = spannableStringBuilder.length();
        String str2 = aVar.f6848a;
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals(BuildConfig.FLAVOR)) {
                    c2 = 0;
                    break;
                }
                break;
            case i.y0:
                if (str2.equals("b")) {
                    c2 = 1;
                    break;
                }
                break;
            case i.z0:
                if (str2.equals("c")) {
                    c2 = 2;
                    break;
                }
                break;
            case i.F0:
                if (str2.equals("i")) {
                    c2 = 3;
                    break;
                }
                break;
            case j.B0:
                if (str2.equals("u")) {
                    c2 = 4;
                    break;
                }
                break;
            case j.C0:
                if (str2.equals("v")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                break;
            default:
                return;
        }
        list2.clear();
        e(list, str, aVar, list2);
        int size = list2.size();
        for (int i3 = 0; i3 < size; i3++) {
            c(spannableStringBuilder, list2.get(i3).f6853c, i2, length);
        }
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, d dVar, int i2, int i3) {
        if (dVar != null) {
            if (dVar.g() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(dVar.g()), i2, i3, 33);
            }
            if (dVar.k()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
            }
            if (dVar.l()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
            }
            if (dVar.j()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.b()), i2, i3, 33);
            }
            if (dVar.i()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.a()), i2, i3, 33);
            }
            if (dVar.c() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(dVar.c()), i2, i3, 33);
            }
            if (dVar.h() != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(dVar.h()), i2, i3, 33);
            }
            int e2 = dVar.e();
            if (e2 == 1) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.d(), true), i2, i3, 33);
            } else if (e2 == 2) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.d()), i2, i3, 33);
            } else if (e2 == 3) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.d() / 100.0f), i2, i3, 33);
            }
        }
    }

    private static int d(String str, int i2) {
        int indexOf = str.indexOf(62, i2);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void e(List<d> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = list.get(i2);
            int f2 = dVar.f(str, aVar.f6848a, aVar.f6851d, aVar.f6850c);
            if (f2 > 0) {
                list2.add(new b(f2, dVar));
            }
        }
        Collections.sort(list2);
    }

    private static String f(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return d0.d0(trim, "[ \\.]")[0];
    }

    private static boolean g(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case i.y0:
                if (str.equals("b")) {
                    c2 = 0;
                    break;
                }
                break;
            case i.z0:
                if (str.equals("c")) {
                    c2 = 1;
                    break;
                }
                break;
            case i.F0:
                if (str.equals("i")) {
                    c2 = 2;
                    break;
                }
                break;
            case j.B0:
                if (str.equals("u")) {
                    c2 = 3;
                    break;
                }
                break;
            case j.C0:
                if (str.equals("v")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    private static boolean i(String str, Matcher matcher, s sVar, e.b bVar, StringBuilder sb, List<d> list) {
        try {
            bVar.j(h.d(matcher.group(1)));
            bVar.d(h.d(matcher.group(2)));
            j(matcher.group(3), bVar);
            sb.setLength(0);
            while (true) {
                String l = sVar.l();
                if (!TextUtils.isEmpty(l)) {
                    if (sb.length() > 0) {
                        sb.append("\n");
                    }
                    sb.append(l.trim());
                } else {
                    k(str, sb.toString(), bVar, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            m.f("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    static void j(String str, e.b bVar) {
        Matcher matcher = f6845c.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    l(group2, bVar);
                } else if ("align".equals(group)) {
                    bVar.l(o(group2));
                } else if ("position".equals(group)) {
                    n(group2, bVar);
                } else if ("size".equals(group)) {
                    bVar.m(h.c(group2));
                } else {
                    m.f("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException unused) {
                m.f("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static void k(String str, String str2, e.b bVar, List<d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '&') {
                i2++;
                int indexOf = str2.indexOf(59, i2);
                int indexOf2 = str2.indexOf(32, i2);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    a(str2.substring(i2, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i2 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i2++;
            } else {
                int i3 = i2 + 1;
                if (i3 < str2.length()) {
                    int i4 = 1;
                    boolean z = str2.charAt(i3) == '/';
                    i3 = d(str2, i3);
                    int i5 = i3 - 2;
                    boolean z2 = str2.charAt(i5) == '/';
                    if (z) {
                        i4 = 2;
                    }
                    int i6 = i2 + i4;
                    if (!z2) {
                        i5 = i3 - 1;
                    }
                    String substring = str2.substring(i6, i5);
                    String f2 = f(substring);
                    if (f2 != null && g(f2)) {
                        if (z) {
                            while (!arrayDeque.isEmpty()) {
                                a aVar = (a) arrayDeque.pop();
                                b(str, aVar, spannableStringBuilder, list, arrayList);
                                if (aVar.f6848a.equals(f2)) {
                                    break;
                                }
                            }
                        } else if (!z2) {
                            arrayDeque.push(a.a(substring, spannableStringBuilder.length()));
                        }
                    }
                }
                i2 = i3;
            }
        }
        while (!arrayDeque.isEmpty()) {
            b(str, (a) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
        }
        b(str, a.b(), spannableStringBuilder, list, arrayList);
        bVar.k(spannableStringBuilder);
    }

    private static void l(String str, e.b bVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            bVar.f(m(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            bVar.f(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            bVar.e(h.c(str));
            bVar.g(0);
            return;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            parseInt--;
        }
        bVar.e((float) parseInt);
        bVar.g(1);
    }

    private static int m(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                m.f("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void n(String str, e.b bVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            bVar.i(m(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            bVar.i(Integer.MIN_VALUE);
        }
        bVar.h(h.c(str));
    }

    private static Layout.Alignment o(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c2 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return Layout.Alignment.ALIGN_CENTER;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 3:
            case 5:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                m.f("WebvttCueParser", "Invalid alignment value: " + str);
                return null;
        }
    }

    public boolean h(s sVar, e.b bVar, List<d> list) {
        String l = sVar.l();
        if (l == null) {
            return false;
        }
        Pattern pattern = f6844b;
        Matcher matcher = pattern.matcher(l);
        if (matcher.matches()) {
            return i(null, matcher, sVar, bVar, this.f6846a, list);
        }
        String l2 = sVar.l();
        if (l2 == null) {
            return false;
        }
        Matcher matcher2 = pattern.matcher(l2);
        if (matcher2.matches()) {
            return i(l.trim(), matcher2, sVar, bVar, this.f6846a, list);
        }
        return false;
    }
}
