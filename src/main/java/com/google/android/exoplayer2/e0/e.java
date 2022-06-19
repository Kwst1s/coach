package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.e0.u.g;
import com.google.android.exoplayer2.e0.u.i;
import com.google.android.exoplayer2.e0.v.d;
import com.google.android.exoplayer2.e0.x.d0;
import com.google.android.exoplayer2.e0.x.w;
import com.google.android.exoplayer2.e0.y.b;
import com.google.android.exoplayer2.extractor.flv.c;
import java.lang.reflect.Constructor;

/* compiled from: DefaultExtractorsFactory */
public final class e implements j {

    /* renamed from: j  reason: collision with root package name */
    private static final Constructor<? extends g> f5070j;

    /* renamed from: a  reason: collision with root package name */
    private boolean f5071a;

    /* renamed from: b  reason: collision with root package name */
    private int f5072b;

    /* renamed from: c  reason: collision with root package name */
    private int f5073c;

    /* renamed from: d  reason: collision with root package name */
    private int f5074d;

    /* renamed from: e  reason: collision with root package name */
    private int f5075e;

    /* renamed from: f  reason: collision with root package name */
    private int f5076f;

    /* renamed from: g  reason: collision with root package name */
    private int f5077g;

    /* renamed from: h  reason: collision with root package name */
    private int f5078h = 1;

    /* renamed from: i  reason: collision with root package name */
    private int f5079i;

    static {
        Constructor<? extends U> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(g.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f5070j = constructor;
    }

    @Override // com.google.android.exoplayer2.e0.j
    public synchronized g[] a() {
        g[] gVarArr;
        Constructor<? extends g> constructor = f5070j;
        gVarArr = new g[(constructor == null ? 12 : 13)];
        gVarArr[0] = new com.google.android.exoplayer2.e0.s.e(this.f5074d);
        int i2 = 1;
        gVarArr[1] = new g(this.f5076f);
        gVarArr[2] = new i(this.f5075e);
        gVarArr[3] = new com.google.android.exoplayer2.e0.t.e(this.f5077g | (this.f5071a ? 1 : 0));
        gVarArr[4] = new com.google.android.exoplayer2.e0.x.g(0, this.f5072b | (this.f5071a ? 1 : 0));
        gVarArr[5] = new com.google.android.exoplayer2.e0.x.e();
        gVarArr[6] = new d0(this.f5078h, this.f5079i);
        gVarArr[7] = new c();
        gVarArr[8] = new d();
        gVarArr[9] = new w();
        gVarArr[10] = new b();
        int i3 = this.f5073c;
        if (!this.f5071a) {
            i2 = 0;
        }
        gVarArr[11] = new com.google.android.exoplayer2.e0.r.b(i2 | i3);
        if (constructor != null) {
            try {
                gVarArr[12] = (g) constructor.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
            }
        }
        return gVarArr;
    }
}
