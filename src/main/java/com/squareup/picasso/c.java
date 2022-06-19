package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.os.Build;
import com.squareup.picasso.r;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import j.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* compiled from: BitmapHunter */
public class c implements Runnable {
    private static final Object u = new Object();
    private static final ThreadLocal<StringBuilder> v = new a();
    private static final AtomicInteger w = new AtomicInteger();
    private static final y x = new b();

    /* renamed from: b  reason: collision with root package name */
    final int f8673b = w.incrementAndGet();

    /* renamed from: c  reason: collision with root package name */
    final t f8674c;

    /* renamed from: d  reason: collision with root package name */
    final i f8675d;

    /* renamed from: e  reason: collision with root package name */
    final d f8676e;

    /* renamed from: f  reason: collision with root package name */
    final a0 f8677f;

    /* renamed from: g  reason: collision with root package name */
    final String f8678g;

    /* renamed from: h  reason: collision with root package name */
    final w f8679h;

    /* renamed from: i  reason: collision with root package name */
    final int f8680i;

    /* renamed from: j  reason: collision with root package name */
    int f8681j;

    /* renamed from: k  reason: collision with root package name */
    final y f8682k;
    a l;
    List<a> m;
    Bitmap n;
    Future<?> o;
    t.e p;
    Exception q;
    int r;
    int s;
    t.f t;

    /* compiled from: BitmapHunter */
    static class a extends ThreadLocal<StringBuilder> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* compiled from: BitmapHunter */
    static class b extends y {
        b() {
        }

        @Override // com.squareup.picasso.y
        public boolean c(w wVar) {
            return true;
        }

        @Override // com.squareup.picasso.y
        public y.a f(w wVar, int i2) {
            throw new IllegalStateException("Unrecognized type of request: " + wVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.squareup.picasso.c$c  reason: collision with other inner class name */
    /* compiled from: BitmapHunter */
    public static class RunnableC0176c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f8683b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RuntimeException f8684c;

        RunnableC0176c(c0 c0Var, RuntimeException runtimeException) {
            this.f8683b = c0Var;
            this.f8684c = runtimeException;
        }

        public void run() {
            throw new RuntimeException("Transformation " + this.f8683b.b() + " crashed with exception.", this.f8684c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: BitmapHunter */
    public static class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ StringBuilder f8685b;

        d(StringBuilder sb) {
            this.f8685b = sb;
        }

        public void run() {
            throw new NullPointerException(this.f8685b.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: BitmapHunter */
    public static class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f8686b;

        e(c0 c0Var) {
            this.f8686b = c0Var;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f8686b.b() + " returned input Bitmap but recycled it.");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: BitmapHunter */
    public static class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f8687b;

        f(c0 c0Var) {
            this.f8687b = c0Var;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f8687b.b() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    c(t tVar, i iVar, d dVar, a0 a0Var, a aVar, y yVar) {
        this.f8674c = tVar;
        this.f8675d = iVar;
        this.f8676e = dVar;
        this.f8677f = a0Var;
        this.l = aVar;
        this.f8678g = aVar.d();
        this.f8679h = aVar.i();
        this.t = aVar.h();
        this.f8680i = aVar.e();
        this.f8681j = aVar.f();
        this.f8682k = yVar;
        this.s = yVar.e();
    }

    static Bitmap a(List<c0> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            c0 c0Var = list.get(i2);
            try {
                Bitmap a2 = c0Var.a(bitmap);
                if (a2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(c0Var.b());
                    sb.append(" returned null after ");
                    sb.append(i2);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (c0 c0Var2 : list) {
                        sb.append(c0Var2.b());
                        sb.append('\n');
                    }
                    t.p.post(new d(sb));
                    return null;
                } else if (a2 == bitmap && bitmap.isRecycled()) {
                    t.p.post(new e(c0Var));
                    return null;
                } else if (a2 == bitmap || bitmap.isRecycled()) {
                    i2++;
                    bitmap = a2;
                } else {
                    t.p.post(new f(c0Var));
                    return null;
                }
            } catch (RuntimeException e2) {
                t.p.post(new RunnableC0176c(c0Var, e2));
                return null;
            }
        }
        return bitmap;
    }

    private t.f d() {
        t.f fVar = t.f.LOW;
        List<a> list = this.m;
        boolean z = true;
        boolean z2 = list != null && !list.isEmpty();
        a aVar = this.l;
        if (aVar == null && !z2) {
            z = false;
        }
        if (!z) {
            return fVar;
        }
        if (aVar != null) {
            fVar = aVar.h();
        }
        if (z2) {
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                t.f h2 = this.m.get(i2).h();
                if (h2.ordinal() > fVar.ordinal()) {
                    fVar = h2;
                }
            }
        }
        return fVar;
    }

    static Bitmap e(j.t tVar, w wVar) {
        j.e d2 = l.d(tVar);
        boolean r2 = d0.r(d2);
        boolean z = wVar.r && Build.VERSION.SDK_INT < 21;
        BitmapFactory.Options d3 = y.d(wVar);
        boolean g2 = y.g(d3);
        if (r2 || z) {
            byte[] k2 = d2.k();
            if (g2) {
                BitmapFactory.decodeByteArray(k2, 0, k2.length, d3);
                y.b(wVar.f8793h, wVar.f8794i, d3, wVar);
            }
            return BitmapFactory.decodeByteArray(k2, 0, k2.length, d3);
        }
        InputStream D = d2.D();
        if (g2) {
            n nVar = new n(D);
            nVar.l(false);
            long F = nVar.F(1024);
            BitmapFactory.decodeStream(nVar, null, d3);
            y.b(wVar.f8793h, wVar.f8794i, d3, wVar);
            nVar.E(F);
            nVar.l(true);
            D = nVar;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(D, null, d3);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    static c g(t tVar, i iVar, d dVar, a0 a0Var, a aVar) {
        w i2 = aVar.i();
        List<y> h2 = tVar.h();
        int size = h2.size();
        for (int i3 = 0; i3 < size; i3++) {
            y yVar = h2.get(i3);
            if (yVar.c(i2)) {
                return new c(tVar, iVar, dVar, a0Var, aVar, yVar);
            }
        }
        return new c(tVar, iVar, dVar, a0Var, aVar, x);
    }

    static int l(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    static int m(int i2) {
        return (i2 == 2 || i2 == 7 || i2 == 4 || i2 == 5) ? -1 : 1;
    }

    private static boolean v(boolean z, int i2, int i3, int i4, int i5) {
        return !z || (i4 != 0 && i2 > i4) || (i5 != 0 && i3 > i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap y(com.squareup.picasso.w r26, android.graphics.Bitmap r27, int r28) {
        /*
        // Method dump skipped, instructions count: 674
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.c.y(com.squareup.picasso.w, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    static void z(w wVar) {
        String a2 = wVar.a();
        StringBuilder sb = v.get();
        sb.ensureCapacity(a2.length() + 8);
        sb.replace(8, sb.length(), a2);
        Thread.currentThread().setName(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        boolean z = this.f8674c.n;
        w wVar = aVar.f8634b;
        if (this.l == null) {
            this.l = aVar;
            if (z) {
                List<a> list = this.m;
                if (list == null || list.isEmpty()) {
                    d0.t("Hunter", "joined", wVar.d(), "to empty hunter");
                } else {
                    d0.t("Hunter", "joined", wVar.d(), d0.k(this, "to "));
                }
            }
        } else {
            if (this.m == null) {
                this.m = new ArrayList(3);
            }
            this.m.add(aVar);
            if (z) {
                d0.t("Hunter", "joined", wVar.d(), d0.k(this, "to "));
            }
            t.f h2 = aVar.h();
            if (h2.ordinal() > this.t.ordinal()) {
                this.t = h2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        Future<?> future;
        if (this.l != null) {
            return false;
        }
        List<a> list = this.m;
        if ((list == null || list.isEmpty()) && (future = this.o) != null && future.cancel(false)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f(a aVar) {
        boolean z;
        if (this.l == aVar) {
            this.l = null;
            z = true;
        } else {
            List<a> list = this.m;
            z = list != null ? list.remove(aVar) : false;
        }
        if (z && aVar.h() == this.t) {
            this.t = d();
        }
        if (this.f8674c.n) {
            d0.t("Hunter", "removed", aVar.f8634b.d(), d0.k(this, "from "));
        }
    }

    /* access modifiers changed from: package-private */
    public a h() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public List<a> i() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public w j() {
        return this.f8679h;
    }

    /* access modifiers changed from: package-private */
    public Exception k() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public String n() {
        return this.f8678g;
    }

    /* access modifiers changed from: package-private */
    public t.e o() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f8680i;
    }

    /* access modifiers changed from: package-private */
    public t q() {
        return this.f8674c;
    }

    /* access modifiers changed from: package-private */
    public t.f r() {
        return this.t;
    }

    public void run() {
        try {
            z(this.f8679h);
            if (this.f8674c.n) {
                d0.s("Hunter", "executing", d0.j(this));
            }
            Bitmap t2 = t();
            this.n = t2;
            if (t2 == null) {
                this.f8675d.e(this);
            } else {
                this.f8675d.d(this);
            }
        } catch (r.b e2) {
            if (!q.a(e2.f8741c) || e2.f8740b != 504) {
                this.q = e2;
            }
            this.f8675d.e(this);
        } catch (IOException e3) {
            this.q = e3;
            this.f8675d.g(this);
        } catch (OutOfMemoryError e4) {
            StringWriter stringWriter = new StringWriter();
            this.f8677f.a().a(new PrintWriter(stringWriter));
            this.q = new RuntimeException(stringWriter.toString(), e4);
            this.f8675d.e(this);
        } catch (Exception e5) {
            this.q = e5;
            this.f8675d.e(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* access modifiers changed from: package-private */
    public Bitmap s() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public Bitmap t() {
        Bitmap bitmap;
        if (p.a(this.f8680i)) {
            bitmap = this.f8676e.c(this.f8678g);
            if (bitmap != null) {
                this.f8677f.d();
                this.p = t.e.MEMORY;
                if (this.f8674c.n) {
                    d0.t("Hunter", "decoded", this.f8679h.d(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        int i2 = this.s == 0 ? q.OFFLINE.f8737b : this.f8681j;
        this.f8681j = i2;
        y.a f2 = this.f8682k.f(this.f8679h, i2);
        if (f2 != null) {
            this.p = f2.c();
            this.r = f2.b();
            bitmap = f2.a();
            if (bitmap == null) {
                j.t d2 = f2.d();
                try {
                    bitmap = e(d2, this.f8679h);
                } finally {
                    try {
                        d2.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.f8674c.n) {
                d0.s("Hunter", "decoded", this.f8679h.d());
            }
            this.f8677f.b(bitmap);
            if (this.f8679h.f() || this.r != 0) {
                synchronized (u) {
                    if (this.f8679h.e() || this.r != 0) {
                        bitmap = y(this.f8679h, bitmap, this.r);
                        if (this.f8674c.n) {
                            d0.s("Hunter", "transformed", this.f8679h.d());
                        }
                    }
                    if (this.f8679h.b()) {
                        bitmap = a(this.f8679h.f8792g, bitmap);
                        if (this.f8674c.n) {
                            d0.t("Hunter", "transformed", this.f8679h.d(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f8677f.c(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        Future<?> future = this.o;
        return future != null && future.isCancelled();
    }

    /* access modifiers changed from: package-private */
    public boolean w(boolean z, NetworkInfo networkInfo) {
        int i2 = this.s;
        if (!(i2 > 0)) {
            return false;
        }
        this.s = i2 - 1;
        return this.f8682k.h(z, networkInfo);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f8682k.i();
    }
}
