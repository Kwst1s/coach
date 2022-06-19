package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.p.b;
import com.bumptech.glide.p.c;
import com.bumptech.glide.p.d;
import com.bumptech.glide.p.e;
import com.bumptech.glide.p.f;
import com.bumptech.glide.p.i;
import com.bumptech.glide.r.k;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder */
public class h<TranscodeType> extends com.bumptech.glide.p.a<h<TranscodeType>> implements Cloneable {
    private final Context B;
    private final i C;
    private final Class<TranscodeType> D;
    private final d E;
    private j<?, ? super TranscodeType> F;
    private Object G;
    private List<e<TranscodeType>> H;
    private h<TranscodeType> I;
    private h<TranscodeType> J;
    private Float K;
    private boolean L = true;
    private boolean M;
    private boolean N;

    /* access modifiers changed from: package-private */
    /* compiled from: RequestBuilder */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3540a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3541b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
            // Method dump skipped, instructions count: 144
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.h.a.<clinit>():void");
        }
    }

    static {
        f fVar = (f) ((f) ((f) new f().e(j.f3779b)).Q(f.LOW)).X(true);
    }

    @SuppressLint({"CheckResult"})
    protected h(b bVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.C = iVar;
        this.D = cls;
        this.B = context;
        this.F = iVar.r(cls);
        this.E = bVar.i();
        k0(iVar.p());
        a(iVar.q());
    }

    private c f0(com.bumptech.glide.p.j.h<TranscodeType> hVar, e<TranscodeType> eVar, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        return g0(new Object(), hVar, eVar, null, this.F, aVar.s(), aVar.p(), aVar.o(), aVar, executor);
    }

    private c g0(Object obj, com.bumptech.glide.p.j.h<TranscodeType> hVar, e<TranscodeType> eVar, d dVar, j<?, ? super TranscodeType> jVar, f fVar, int i2, int i3, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        b bVar;
        b bVar2;
        if (this.J != null) {
            bVar2 = new b(obj, dVar);
            bVar = bVar2;
        } else {
            bVar = null;
            bVar2 = dVar;
        }
        c h0 = h0(obj, hVar, eVar, bVar2, jVar, fVar, i2, i3, aVar, executor);
        if (bVar == null) {
            return h0;
        }
        int p = this.J.p();
        int o = this.J.o();
        if (k.r(i2, i3) && !this.J.I()) {
            p = aVar.p();
            o = aVar.o();
        }
        h<TranscodeType> hVar2 = this.J;
        bVar.q(h0, hVar2.g0(obj, hVar, eVar, bVar, hVar2.F, hVar2.s(), p, o, this.J, executor));
        return bVar;
    }

    private c h0(Object obj, com.bumptech.glide.p.j.h<TranscodeType> hVar, e<TranscodeType> eVar, d dVar, j<?, ? super TranscodeType> jVar, f fVar, int i2, int i3, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        f fVar2;
        h<TranscodeType> hVar2 = this.I;
        if (hVar2 != null) {
            if (!this.N) {
                j<?, ? super TranscodeType> jVar2 = hVar2.L ? jVar : hVar2.F;
                if (hVar2.B()) {
                    fVar2 = this.I.s();
                } else {
                    fVar2 = j0(fVar);
                }
                int p = this.I.p();
                int o = this.I.o();
                if (k.r(i2, i3) && !this.I.I()) {
                    p = aVar.p();
                    o = aVar.o();
                }
                i iVar = new i(obj, dVar);
                c u0 = u0(obj, hVar, eVar, aVar, iVar, jVar, fVar, i2, i3, executor);
                this.N = true;
                h<TranscodeType> hVar3 = this.I;
                c g0 = hVar3.g0(obj, hVar, eVar, iVar, jVar2, fVar2, p, o, hVar3, executor);
                this.N = false;
                iVar.p(u0, g0);
                return iVar;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.K == null) {
            return u0(obj, hVar, eVar, aVar, dVar, jVar, fVar, i2, i3, executor);
        } else {
            i iVar2 = new i(obj, dVar);
            iVar2.p(u0(obj, hVar, eVar, aVar, iVar2, jVar, fVar, i2, i3, executor), u0(obj, hVar, eVar, aVar.clone().W(this.K.floatValue()), iVar2, jVar, j0(fVar), i2, i3, executor));
            return iVar2;
        }
    }

    private f j0(f fVar) {
        int i2 = a.f3541b[fVar.ordinal()];
        if (i2 == 1) {
            return f.NORMAL;
        }
        if (i2 == 2) {
            return f.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return f.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + s());
    }

    @SuppressLint({"CheckResult"})
    private void k0(List<e<Object>> list) {
        for (e<Object> eVar : list) {
            d0(eVar);
        }
    }

    private <Y extends com.bumptech.glide.p.j.h<TranscodeType>> Y m0(Y y, e<TranscodeType> eVar, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        com.bumptech.glide.r.j.d(y);
        if (this.M) {
            c f0 = f0(y, eVar, aVar, executor);
            c g2 = y.g();
            if (!f0.e(g2) || p0(aVar, g2)) {
                this.C.o(y);
                y.j(f0);
                this.C.z(y, f0);
                return y;
            }
            com.bumptech.glide.r.j.d(g2);
            if (!g2.isRunning()) {
                g2.i();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean p0(com.bumptech.glide.p.a<?> aVar, c cVar) {
        return !aVar.A() && cVar.k();
    }

    private h<TranscodeType> t0(Object obj) {
        this.G = obj;
        this.M = true;
        return this;
    }

    private c u0(Object obj, com.bumptech.glide.p.j.h<TranscodeType> hVar, e<TranscodeType> eVar, com.bumptech.glide.p.a<?> aVar, d dVar, j<?, ? super TranscodeType> jVar, f fVar, int i2, int i3, Executor executor) {
        Context context = this.B;
        d dVar2 = this.E;
        return com.bumptech.glide.p.h.y(context, dVar2, obj, this.G, this.D, aVar, i2, i3, fVar, hVar, eVar, this.H, dVar, dVar2.f(), jVar.b(), executor);
    }

    public h<TranscodeType> d0(e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(eVar);
        }
        return this;
    }

    /* renamed from: e0 */
    public h<TranscodeType> a(com.bumptech.glide.p.a<?> aVar) {
        com.bumptech.glide.r.j.d(aVar);
        return (h) super.a(aVar);
    }

    /* renamed from: i0 */
    public h<TranscodeType> clone() {
        h<TranscodeType> hVar = (h) super.clone();
        hVar.F = hVar.F.clone();
        return hVar;
    }

    public <Y extends com.bumptech.glide.p.j.h<TranscodeType>> Y l0(Y y) {
        n0(y, null, com.bumptech.glide.r.e.b());
        return y;
    }

    /* access modifiers changed from: package-private */
    public <Y extends com.bumptech.glide.p.j.h<TranscodeType>> Y n0(Y y, e<TranscodeType> eVar, Executor executor) {
        m0(y, eVar, this, executor);
        return y;
    }

    public com.bumptech.glide.p.j.i<ImageView, TranscodeType> o0(ImageView imageView) {
        com.bumptech.glide.p.a<?> aVar;
        k.a();
        com.bumptech.glide.r.j.d(imageView);
        if (!H() && F() && imageView.getScaleType() != null) {
            switch (a.f3540a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = clone().K();
                    break;
                case 2:
                    aVar = clone().L();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = clone().M();
                    break;
                case 6:
                    aVar = clone().L();
                    break;
            }
            com.bumptech.glide.p.j.i<ImageView, TranscodeType> a2 = this.E.a(imageView, this.D);
            m0(a2, null, aVar, com.bumptech.glide.r.e.b());
            return a2;
        }
        aVar = this;
        com.bumptech.glide.p.j.i<ImageView, TranscodeType> a22 = this.E.a(imageView, this.D);
        m0(a22, null, aVar, com.bumptech.glide.r.e.b());
        return a22;
    }

    public h<TranscodeType> q0(Uri uri) {
        t0(uri);
        return this;
    }

    public h<TranscodeType> r0(Object obj) {
        t0(obj);
        return this;
    }

    public h<TranscodeType> s0(String str) {
        t0(str);
        return this;
    }

    public h<TranscodeType> v0(float f2) {
        if (f2 < Utils.FLOAT_EPSILON || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.K = Float.valueOf(f2);
        return this;
    }
}
