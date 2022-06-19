package com.google.android.exoplayer2.text.p;

import android.text.Layout;

/* access modifiers changed from: package-private */
/* compiled from: TtmlStyle */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f6799a;

    /* renamed from: b  reason: collision with root package name */
    private int f6800b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6801c;

    /* renamed from: d  reason: collision with root package name */
    private int f6802d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6803e;

    /* renamed from: f  reason: collision with root package name */
    private int f6804f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f6805g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f6806h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f6807i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f6808j = -1;

    /* renamed from: k  reason: collision with root package name */
    private float f6809k;
    private String l;
    private e m;
    private Layout.Alignment n;

    private e l(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.f6801c && eVar.f6801c) {
                q(eVar.f6800b);
            }
            if (this.f6806h == -1) {
                this.f6806h = eVar.f6806h;
            }
            if (this.f6807i == -1) {
                this.f6807i = eVar.f6807i;
            }
            if (this.f6799a == null) {
                this.f6799a = eVar.f6799a;
            }
            if (this.f6804f == -1) {
                this.f6804f = eVar.f6804f;
            }
            if (this.f6805g == -1) {
                this.f6805g = eVar.f6805g;
            }
            if (this.n == null) {
                this.n = eVar.n;
            }
            if (this.f6808j == -1) {
                this.f6808j = eVar.f6808j;
                this.f6809k = eVar.f6809k;
            }
            if (z && !this.f6803e && eVar.f6803e) {
                o(eVar.f6802d);
            }
        }
        return this;
    }

    public e a(e eVar) {
        l(eVar, true);
        return this;
    }

    public int b() {
        if (this.f6803e) {
            return this.f6802d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f6801c) {
            return this.f6800b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.f6799a;
    }

    public float e() {
        return this.f6809k;
    }

    public int f() {
        return this.f6808j;
    }

    public String g() {
        return this.l;
    }

    public int h() {
        int i2 = this.f6806h;
        if (i2 == -1 && this.f6807i == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.f6807i == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }

    public Layout.Alignment i() {
        return this.n;
    }

    public boolean j() {
        return this.f6803e;
    }

    public boolean k() {
        return this.f6801c;
    }

    public boolean m() {
        return this.f6804f == 1;
    }

    public boolean n() {
        return this.f6805g == 1;
    }

    public e o(int i2) {
        this.f6802d = i2;
        this.f6803e = true;
        return this;
    }

    public e p(boolean z) {
        com.google.android.exoplayer2.util.e.f(this.m == null);
        this.f6806h = z ? 1 : 0;
        return this;
    }

    public e q(int i2) {
        com.google.android.exoplayer2.util.e.f(this.m == null);
        this.f6800b = i2;
        this.f6801c = true;
        return this;
    }

    public e r(String str) {
        com.google.android.exoplayer2.util.e.f(this.m == null);
        this.f6799a = str;
        return this;
    }

    public e s(float f2) {
        this.f6809k = f2;
        return this;
    }

    public e t(int i2) {
        this.f6808j = i2;
        return this;
    }

    public e u(String str) {
        this.l = str;
        return this;
    }

    public e v(boolean z) {
        com.google.android.exoplayer2.util.e.f(this.m == null);
        this.f6807i = z ? 1 : 0;
        return this;
    }

    public e w(boolean z) {
        com.google.android.exoplayer2.util.e.f(this.m == null);
        this.f6804f = z ? 1 : 0;
        return this;
    }

    public e x(Layout.Alignment alignment) {
        this.n = alignment;
        return this;
    }

    public e y(boolean z) {
        com.google.android.exoplayer2.util.e.f(this.m == null);
        this.f6805g = z ? 1 : 0;
        return this;
    }
}
