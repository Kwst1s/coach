package com.google.android.material.appbar;

import android.view.View;
import b.h.k.u;

/* access modifiers changed from: package-private */
/* compiled from: ViewOffsetHelper */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f7520a;

    /* renamed from: b  reason: collision with root package name */
    private int f7521b;

    /* renamed from: c  reason: collision with root package name */
    private int f7522c;

    /* renamed from: d  reason: collision with root package name */
    private int f7523d;

    /* renamed from: e  reason: collision with root package name */
    private int f7524e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7525f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7526g = true;

    public d(View view) {
        this.f7520a = view;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f7520a;
        u.Y(view, this.f7523d - (view.getTop() - this.f7521b));
        View view2 = this.f7520a;
        u.X(view2, this.f7524e - (view2.getLeft() - this.f7522c));
    }

    public int b() {
        return this.f7523d;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f7521b = this.f7520a.getTop();
        this.f7522c = this.f7520a.getLeft();
    }

    public boolean d(int i2) {
        if (!this.f7526g || this.f7524e == i2) {
            return false;
        }
        this.f7524e = i2;
        a();
        return true;
    }

    public boolean e(int i2) {
        if (!this.f7525f || this.f7523d == i2) {
            return false;
        }
        this.f7523d = i2;
        a();
        return true;
    }
}
