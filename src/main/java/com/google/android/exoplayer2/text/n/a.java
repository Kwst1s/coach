package com.google.android.exoplayer2.text.n;

import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SsaDecoder */
public final class a extends b {
    private static final Pattern s = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean n;
    private int o;
    private int p;
    private int q;
    private int r;

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.n = false;
            return;
        }
        this.n = true;
        String t = d0.t(list.get(0));
        e.a(t.startsWith("Format: "));
        F(t);
        G(new s(list.get(1)));
    }

    private void D(String str, List<com.google.android.exoplayer2.text.a> list, n nVar) {
        long j2;
        if (this.o == 0) {
            m.f("SsaDecoder", "Skipping dialogue line before complete format: " + str);
            return;
        }
        String[] split = str.substring(10).split(",", this.o);
        if (split.length != this.o) {
            m.f("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long H = H(split[this.p]);
        if (H == -9223372036854775807L) {
            m.f("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        String str2 = split[this.q];
        if (!str2.trim().isEmpty()) {
            j2 = H(str2);
            if (j2 == -9223372036854775807L) {
                m.f("SsaDecoder", "Skipping invalid timing: " + str);
                return;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        list.add(new com.google.android.exoplayer2.text.a(split[this.r].replaceAll("\\{.*?\\}", BuildConfig.FLAVOR).replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        nVar.a(H);
        if (j2 != -9223372036854775807L) {
            list.add(null);
            nVar.a(j2);
        }
    }

    private void E(s sVar, List<com.google.android.exoplayer2.text.a> list, n nVar) {
        while (true) {
            String l = sVar.l();
            if (l == null) {
                return;
            }
            if (!this.n && l.startsWith("Format: ")) {
                F(l);
            } else if (l.startsWith("Dialogue: ")) {
                D(l, list, nVar);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void F(String str) {
        char c2;
        String[] split = TextUtils.split(str.substring(8), ",");
        this.o = split.length;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        for (int i2 = 0; i2 < this.o; i2++) {
            String h0 = d0.h0(split[i2].trim());
            h0.hashCode();
            switch (h0.hashCode()) {
                case 100571:
                    if (h0.equals("end")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3556653:
                    if (h0.equals("text")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (h0.equals("start")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    this.q = i2;
                    break;
                case 1:
                    this.r = i2;
                    break;
                case 2:
                    this.p = i2;
                    break;
            }
        }
        if (this.p == -1 || this.q == -1 || this.r == -1) {
            this.o = 0;
        }
    }

    private void G(s sVar) {
        String l;
        do {
            l = sVar.l();
            if (l == null) {
                return;
            }
        } while (!l.startsWith("[Events]"));
    }

    public static long H(String str) {
        Matcher matcher = s.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public b z(byte[] bArr, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        n nVar = new n();
        s sVar = new s(bArr, i2);
        if (!this.n) {
            G(sVar);
        }
        E(sVar, arrayList, nVar);
        com.google.android.exoplayer2.text.a[] aVarArr = new com.google.android.exoplayer2.text.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return new b(aVarArr, nVar.d());
    }
}
