package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.t;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: Action */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final t f8633a;

    /* renamed from: b  reason: collision with root package name */
    final w f8634b;

    /* renamed from: c  reason: collision with root package name */
    final WeakReference<T> f8635c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f8636d;

    /* renamed from: e  reason: collision with root package name */
    final int f8637e;

    /* renamed from: f  reason: collision with root package name */
    final int f8638f;

    /* renamed from: g  reason: collision with root package name */
    final int f8639g;

    /* renamed from: h  reason: collision with root package name */
    final Drawable f8640h;

    /* renamed from: i  reason: collision with root package name */
    final String f8641i;

    /* renamed from: j  reason: collision with root package name */
    final Object f8642j;

    /* renamed from: k  reason: collision with root package name */
    boolean f8643k;
    boolean l;

    /* renamed from: com.squareup.picasso.a$a  reason: collision with other inner class name */
    /* compiled from: Action */
    static class C0174a<M> extends WeakReference<M> {

        /* renamed from: a  reason: collision with root package name */
        final a f8644a;

        C0174a(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f8644a = aVar;
        }
    }

    a(t tVar, T t, w wVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, boolean z) {
        C0174a aVar;
        this.f8633a = tVar;
        this.f8634b = wVar;
        if (t == null) {
            aVar = null;
        } else {
            aVar = new C0174a(this, t, tVar.f8753k);
        }
        this.f8635c = aVar;
        this.f8637e = i2;
        this.f8638f = i3;
        this.f8636d = z;
        this.f8639g = i4;
        this.f8640h = drawable;
        this.f8641i = str;
        this.f8642j = obj == null ? this : obj;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Bitmap bitmap, t.e eVar);

    /* access modifiers changed from: package-private */
    public abstract void c(Exception exc);

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f8641i;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f8637e;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f8638f;
    }

    /* access modifiers changed from: package-private */
    public t g() {
        return this.f8633a;
    }

    /* access modifiers changed from: package-private */
    public t.f h() {
        return this.f8634b.t;
    }

    /* access modifiers changed from: package-private */
    public w i() {
        return this.f8634b;
    }

    /* access modifiers changed from: package-private */
    public Object j() {
        return this.f8642j;
    }

    /* access modifiers changed from: package-private */
    public T k() {
        WeakReference<T> weakReference = this.f8635c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f8643k;
    }
}
