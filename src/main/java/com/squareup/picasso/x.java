package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import com.squareup.picasso.t;
import com.squareup.picasso.w;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestCreator */
public class x {
    private static final AtomicInteger m = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    private final t f8808a;

    /* renamed from: b  reason: collision with root package name */
    private final w.b f8809b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8810c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8811d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8812e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f8813f;

    /* renamed from: g  reason: collision with root package name */
    private int f8814g;

    /* renamed from: h  reason: collision with root package name */
    private int f8815h;

    /* renamed from: i  reason: collision with root package name */
    private int f8816i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f8817j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f8818k;
    private Object l;

    x(t tVar, Uri uri, int i2) {
        if (!tVar.o) {
            this.f8808a = tVar;
            this.f8809b = new w.b(uri, i2, tVar.l);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    private w c(long j2) {
        int andIncrement = m.getAndIncrement();
        w a2 = this.f8809b.a();
        a2.f8786a = andIncrement;
        a2.f8787b = j2;
        boolean z = this.f8808a.n;
        if (z) {
            d0.t("Main", "created", a2.g(), a2.toString());
        }
        this.f8808a.m(a2);
        if (a2 != a2) {
            a2.f8786a = andIncrement;
            a2.f8787b = j2;
            if (z) {
                String d2 = a2.d();
                d0.t("Main", "changed", d2, "into " + a2);
            }
        }
        return a2;
    }

    private Drawable d() {
        int i2 = this.f8813f;
        if (i2 == 0) {
            return this.f8817j;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            return this.f8808a.f8747e.getDrawable(i2);
        }
        if (i3 >= 16) {
            return this.f8808a.f8747e.getResources().getDrawable(this.f8813f);
        }
        TypedValue typedValue = new TypedValue();
        this.f8808a.f8747e.getResources().getValue(this.f8813f, typedValue, true);
        return this.f8808a.f8747e.getResources().getDrawable(typedValue.resourceId);
    }

    public x a() {
        this.f8809b.b(17);
        return this;
    }

    /* access modifiers changed from: package-private */
    public x b() {
        this.l = null;
        return this;
    }

    public void e(ImageView imageView) {
        f(imageView, null);
    }

    public void f(ImageView imageView, e eVar) {
        Bitmap j2;
        long nanoTime = System.nanoTime();
        d0.c();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f8809b.c()) {
            this.f8808a.b(imageView);
            if (this.f8812e) {
                u.d(imageView, d());
            }
        } else {
            if (this.f8811d) {
                if (!this.f8809b.d()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f8812e) {
                            u.d(imageView, d());
                        }
                        this.f8808a.d(imageView, new h(this, imageView, eVar));
                        return;
                    }
                    this.f8809b.f(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            w c2 = c(nanoTime);
            String f2 = d0.f(c2);
            if (!p.a(this.f8815h) || (j2 = this.f8808a.j(f2)) == null) {
                if (this.f8812e) {
                    u.d(imageView, d());
                }
                this.f8808a.f(new l(this.f8808a, imageView, c2, this.f8815h, this.f8816i, this.f8814g, this.f8818k, f2, this.l, eVar, this.f8810c));
                return;
            }
            this.f8808a.b(imageView);
            t tVar = this.f8808a;
            Context context = tVar.f8747e;
            t.e eVar2 = t.e.MEMORY;
            u.c(imageView, context, j2, eVar2, this.f8810c, tVar.m);
            if (this.f8808a.n) {
                String g2 = c2.g();
                d0.t("Main", "completed", g2, "from " + eVar2);
            }
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public x g() {
        this.f8809b.e();
        return this;
    }

    public x h(int i2, int i3) {
        this.f8809b.f(i2, i3);
        return this;
    }

    public x i(c0 c0Var) {
        this.f8809b.g(c0Var);
        return this;
    }

    /* access modifiers changed from: package-private */
    public x j() {
        this.f8811d = false;
        return this;
    }
}
