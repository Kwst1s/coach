package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.github.mikephil.charting.utils.Utils;
import com.squareup.picasso.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request */
public final class w {
    private static final long u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    int f8786a;

    /* renamed from: b  reason: collision with root package name */
    long f8787b;

    /* renamed from: c  reason: collision with root package name */
    int f8788c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f8789d;

    /* renamed from: e  reason: collision with root package name */
    public final int f8790e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8791f;

    /* renamed from: g  reason: collision with root package name */
    public final List<c0> f8792g;

    /* renamed from: h  reason: collision with root package name */
    public final int f8793h;

    /* renamed from: i  reason: collision with root package name */
    public final int f8794i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f8795j;

    /* renamed from: k  reason: collision with root package name */
    public final int f8796k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;
    public final boolean q;
    public final boolean r;
    public final Bitmap.Config s;
    public final t.f t;

    /* compiled from: Request */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Uri f8797a;

        /* renamed from: b  reason: collision with root package name */
        private int f8798b;

        /* renamed from: c  reason: collision with root package name */
        private String f8799c;

        /* renamed from: d  reason: collision with root package name */
        private int f8800d;

        /* renamed from: e  reason: collision with root package name */
        private int f8801e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f8802f;

        /* renamed from: g  reason: collision with root package name */
        private int f8803g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f8804h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8805i;

        /* renamed from: j  reason: collision with root package name */
        private float f8806j;

        /* renamed from: k  reason: collision with root package name */
        private float f8807k;
        private float l;
        private boolean m;
        private boolean n;
        private List<c0> o;
        private Bitmap.Config p;
        private t.f q;

        b(Uri uri, int i2, Bitmap.Config config) {
            this.f8797a = uri;
            this.f8798b = i2;
            this.p = config;
        }

        public w a() {
            boolean z = this.f8804h;
            if (z && this.f8802f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f8802f && this.f8800d == 0 && this.f8801e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (z && this.f8800d == 0 && this.f8801e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.q == null) {
                    this.q = t.f.NORMAL;
                }
                return new w(this.f8797a, this.f8798b, this.f8799c, this.o, this.f8800d, this.f8801e, this.f8802f, this.f8804h, this.f8803g, this.f8805i, this.f8806j, this.f8807k, this.l, this.m, this.n, this.p, this.q);
            }
        }

        public b b(int i2) {
            if (!this.f8804h) {
                this.f8802f = true;
                this.f8803g = i2;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return (this.f8797a == null && this.f8798b == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return (this.f8800d == 0 && this.f8801e == 0) ? false : true;
        }

        public b e() {
            if (this.f8801e == 0 && this.f8800d == 0) {
                throw new IllegalStateException("onlyScaleDown can not be applied without resize");
            }
            this.f8805i = true;
            return this;
        }

        public b f(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i3 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i3 == 0 && i2 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f8800d = i2;
                this.f8801e = i3;
                return this;
            }
        }

        public b g(c0 c0Var) {
            if (c0Var == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (c0Var.b() != null) {
                if (this.o == null) {
                    this.o = new ArrayList(2);
                }
                this.o.add(c0Var);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        Uri uri = this.f8789d;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.f8790e);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f8792g != null;
    }

    public boolean c() {
        return (this.f8793h == 0 && this.f8794i == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        long nanoTime = System.nanoTime() - this.f8787b;
        if (nanoTime > u) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return c() || this.n != Utils.FLOAT_EPSILON;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return e() || b();
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return "[R" + this.f8786a + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i2 = this.f8790e;
        if (i2 > 0) {
            sb.append(i2);
        } else {
            sb.append(this.f8789d);
        }
        List<c0> list = this.f8792g;
        if (list != null && !list.isEmpty()) {
            for (c0 c0Var : this.f8792g) {
                sb.append(' ');
                sb.append(c0Var.b());
            }
        }
        if (this.f8791f != null) {
            sb.append(" stableKey(");
            sb.append(this.f8791f);
            sb.append(')');
        }
        if (this.f8793h > 0) {
            sb.append(" resize(");
            sb.append(this.f8793h);
            sb.append(',');
            sb.append(this.f8794i);
            sb.append(')');
        }
        if (this.f8795j) {
            sb.append(" centerCrop");
        }
        if (this.l) {
            sb.append(" centerInside");
        }
        if (this.n != Utils.FLOAT_EPSILON) {
            sb.append(" rotation(");
            sb.append(this.n);
            if (this.q) {
                sb.append(" @ ");
                sb.append(this.o);
                sb.append(',');
                sb.append(this.p);
            }
            sb.append(')');
        }
        if (this.r) {
            sb.append(" purgeable");
        }
        if (this.s != null) {
            sb.append(' ');
            sb.append(this.s);
        }
        sb.append('}');
        return sb.toString();
    }

    private w(Uri uri, int i2, String str, List<c0> list, int i3, int i4, boolean z, boolean z2, int i5, boolean z3, float f2, float f3, float f4, boolean z4, boolean z5, Bitmap.Config config, t.f fVar) {
        this.f8789d = uri;
        this.f8790e = i2;
        this.f8791f = str;
        if (list == null) {
            this.f8792g = null;
        } else {
            this.f8792g = Collections.unmodifiableList(list);
        }
        this.f8793h = i3;
        this.f8794i = i4;
        this.f8795j = z;
        this.l = z2;
        this.f8796k = i5;
        this.m = z3;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = z4;
        this.r = z5;
        this.s = config;
        this.t = fVar;
    }
}
