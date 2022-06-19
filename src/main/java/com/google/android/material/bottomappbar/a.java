package com.google.android.material.bottomappbar;

import c.e.a.b.c0.f;
import c.e.a.b.c0.m;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: BottomAppBarTopEdgeTreatment */
public class a extends f implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private float f7571b;

    /* renamed from: c  reason: collision with root package name */
    private float f7572c;

    /* renamed from: d  reason: collision with root package name */
    private float f7573d;

    /* renamed from: e  reason: collision with root package name */
    private float f7574e;

    /* renamed from: f  reason: collision with root package name */
    private float f7575f;

    @Override // c.e.a.b.c0.f
    public void b(float f2, float f3, float f4, m mVar) {
        float f5 = this.f7573d;
        if (f5 == Utils.FLOAT_EPSILON) {
            mVar.m(f2, Utils.FLOAT_EPSILON);
            return;
        }
        float f6 = ((this.f7572c * 2.0f) + f5) / 2.0f;
        float f7 = f4 * this.f7571b;
        float f8 = f3 + this.f7575f;
        float f9 = (this.f7574e * f4) + ((1.0f - f4) * f6);
        if (f9 / f6 >= 1.0f) {
            mVar.m(f2, Utils.FLOAT_EPSILON);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float sqrt = (float) Math.sqrt((double) ((f10 * f10) - (f11 * f11)));
        float f12 = f8 - sqrt;
        float f13 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f11)));
        float f14 = 90.0f - degrees;
        mVar.m(f12, Utils.FLOAT_EPSILON);
        float f15 = f7 * 2.0f;
        mVar.a(f12 - f7, Utils.FLOAT_EPSILON, f12 + f7, f15, 270.0f, degrees);
        mVar.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        mVar.a(f13 - f7, Utils.FLOAT_EPSILON, f13 + f7, f15, 270.0f - degrees, degrees);
        mVar.m(f2, Utils.FLOAT_EPSILON);
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f7574e;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f7572c;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f7571b;
    }

    public float f() {
        return this.f7573d;
    }

    /* access modifiers changed from: package-private */
    public void g(float f2) {
        if (f2 >= Utils.FLOAT_EPSILON) {
            this.f7574e = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void h(float f2) {
        this.f7572c = f2;
    }

    /* access modifiers changed from: package-private */
    public void i(float f2) {
        this.f7571b = f2;
    }

    public void j(float f2) {
        this.f7573d = f2;
    }

    /* access modifiers changed from: package-private */
    public void k(float f2) {
        this.f7575f = f2;
    }
}
