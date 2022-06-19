package com.google.android.exoplayer2.text.o;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SubripDecoder */
public final class a extends b {
    private static final Pattern p = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private static final Pattern q = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder n = new StringBuilder();
    private final ArrayList<String> o = new ArrayList<>();

    public a() {
        super("SubripDecoder");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private com.google.android.exoplayer2.text.a C(Spanned spanned, String str) {
        char c2;
        char c3;
        if (str == null) {
            return new com.google.android.exoplayer2.text.a(spanned);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        int i2 = (c2 == 0 || c2 == 1 || c2 == 2) ? 0 : (c2 == 3 || c2 == 4 || c2 == 5) ? 2 : 1;
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c3 = 0;
                    break;
                }
                c3 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c3 = 1;
                    break;
                }
                c3 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c3 = 2;
                    break;
                }
                c3 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c3 = 6;
                    break;
                }
                c3 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c3 = 7;
                    break;
                }
                c3 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c3 = '\b';
                    break;
                }
                c3 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c3 = 3;
                    break;
                }
                c3 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c3 = 4;
                    break;
                }
                c3 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c3 = 5;
                    break;
                }
                c3 = 65535;
                break;
            default:
                c3 = 65535;
                break;
        }
        int i3 = (c3 == 0 || c3 == 1 || c3 == 2) ? 2 : (c3 == 3 || c3 == 4 || c3 == 5) ? 0 : 1;
        return new com.google.android.exoplayer2.text.a(spanned, null, E(i3), 0, i3, E(i2), i2, Float.MIN_VALUE);
    }

    static float E(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? 0.92f : 0.5f;
        }
        return 0.08f;
    }

    private static long F(Matcher matcher, int i2) {
        return ((Long.parseLong(matcher.group(i2 + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 3)) * 1000) + Long.parseLong(matcher.group(i2 + 4))) * 1000;
    }

    private String G(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = q.matcher(trim);
        int i2 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i2;
            int length = group.length();
            sb.replace(start, start + length, BuildConfig.FLAVOR);
            i2 += length;
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public b z(byte[] bArr, int i2, boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        n nVar = new n();
        s sVar = new s(bArr, i2);
        while (true) {
            String l = sVar.l();
            if (l == null) {
                break;
            } else if (l.length() != 0) {
                try {
                    Integer.parseInt(l);
                    String l2 = sVar.l();
                    if (l2 == null) {
                        m.f("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = p.matcher(l2);
                    if (matcher.matches()) {
                        boolean z2 = true;
                        nVar.a(F(matcher, 1));
                        int i3 = 0;
                        if (!TextUtils.isEmpty(matcher.group(6))) {
                            nVar.a(F(matcher, 6));
                        } else {
                            z2 = false;
                        }
                        this.n.setLength(0);
                        this.o.clear();
                        while (true) {
                            String l3 = sVar.l();
                            if (TextUtils.isEmpty(l3)) {
                                break;
                            }
                            if (this.n.length() > 0) {
                                this.n.append("<br>");
                            }
                            this.n.append(G(l3, this.o));
                        }
                        Spanned fromHtml = Html.fromHtml(this.n.toString());
                        while (true) {
                            if (i3 >= this.o.size()) {
                                str = null;
                                break;
                            }
                            str = this.o.get(i3);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i3++;
                        }
                        arrayList.add(C(fromHtml, str));
                        if (z2) {
                            arrayList.add(null);
                        }
                    } else {
                        m.f("SubripDecoder", "Skipping invalid timing: " + l2);
                    }
                } catch (NumberFormatException unused) {
                    m.f("SubripDecoder", "Skipping invalid index: " + l);
                }
            }
        }
        com.google.android.exoplayer2.text.a[] aVarArr = new com.google.android.exoplayer2.text.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return new b(aVarArr, nVar.d());
    }
}
