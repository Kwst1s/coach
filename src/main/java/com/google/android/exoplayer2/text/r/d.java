package com.google.android.exoplayer2.text.r;

import android.text.Layout;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: WebvttCssStyle */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f6820a;

    /* renamed from: b  reason: collision with root package name */
    private String f6821b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f6822c;

    /* renamed from: d  reason: collision with root package name */
    private String f6823d;

    /* renamed from: e  reason: collision with root package name */
    private String f6824e;

    /* renamed from: f  reason: collision with root package name */
    private int f6825f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6826g;

    /* renamed from: h  reason: collision with root package name */
    private int f6827h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6828i;

    /* renamed from: j  reason: collision with root package name */
    private int f6829j;

    /* renamed from: k  reason: collision with root package name */
    private int f6830k;
    private int l;
    private int m;
    private int n;
    private float o;
    private Layout.Alignment p;

    public d() {
        m();
    }

    private static int x(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public int a() {
        if (this.f6828i) {
            return this.f6827h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public int b() {
        if (this.f6826g) {
            return this.f6825f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String c() {
        return this.f6824e;
    }

    public float d() {
        return this.o;
    }

    public int e() {
        return this.n;
    }

    public int f(String str, String str2, String[] strArr, String str3) {
        if (this.f6820a.isEmpty() && this.f6821b.isEmpty() && this.f6822c.isEmpty() && this.f6823d.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int x = x(x(x(0, this.f6820a, str, 1073741824), this.f6821b, str2, 2), this.f6823d, str3, 4);
        if (x == -1 || !Arrays.asList(strArr).containsAll(this.f6822c)) {
            return 0;
        }
        return x + (this.f6822c.size() * 4);
    }

    public int g() {
        int i2 = this.l;
        if (i2 == -1 && this.m == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.m == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }

    public Layout.Alignment h() {
        return this.p;
    }

    public boolean i() {
        return this.f6828i;
    }

    public boolean j() {
        return this.f6826g;
    }

    public boolean k() {
        return this.f6829j == 1;
    }

    public boolean l() {
        return this.f6830k == 1;
    }

    public void m() {
        this.f6820a = BuildConfig.FLAVOR;
        this.f6821b = BuildConfig.FLAVOR;
        this.f6822c = Collections.emptyList();
        this.f6823d = BuildConfig.FLAVOR;
        this.f6824e = null;
        this.f6826g = false;
        this.f6828i = false;
        this.f6829j = -1;
        this.f6830k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.p = null;
    }

    public d n(int i2) {
        this.f6827h = i2;
        this.f6828i = true;
        return this;
    }

    public d o(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public d p(int i2) {
        this.f6825f = i2;
        this.f6826g = true;
        return this;
    }

    public d q(String str) {
        this.f6824e = d0.h0(str);
        return this;
    }

    public d r(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public void s(String[] strArr) {
        this.f6822c = Arrays.asList(strArr);
    }

    public void t(String str) {
        this.f6820a = str;
    }

    public void u(String str) {
        this.f6821b = str;
    }

    public void v(String str) {
        this.f6823d = str;
    }

    public d w(boolean z) {
        this.f6830k = z ? 1 : 0;
        return this;
    }
}
