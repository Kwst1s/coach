package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.f0.h.f;
import com.google.android.exoplayer2.f0.h.j;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: GaplessInfoHolder */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f5080c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f5081a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f5082b = -1;

    private boolean b(String str) {
        Matcher matcher = f5080c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f5081a = parseInt;
            this.f5082b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f5081a == -1 || this.f5082b == -1) ? false : true;
    }

    public boolean c(a aVar) {
        for (int i2 = 0; i2 < aVar.k(); i2++) {
            a.b g2 = aVar.g(i2);
            if (g2 instanceof f) {
                f fVar = (f) g2;
                if ("iTunSMPB".equals(fVar.f5736d) && b(fVar.f5737e)) {
                    return true;
                }
            } else if (g2 instanceof j) {
                j jVar = (j) g2;
                if ("com.apple.iTunes".equals(jVar.f5748c) && "iTunSMPB".equals(jVar.f5749d) && b(jVar.f5750e)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i2) {
        int i3 = i2 >> 12;
        int i4 = i2 & 4095;
        if (i3 <= 0 && i4 <= 0) {
            return false;
        }
        this.f5081a = i3;
        this.f5082b = i4;
        return true;
    }
}
