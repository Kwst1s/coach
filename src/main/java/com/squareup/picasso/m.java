package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/* compiled from: LruCache */
public final class m implements d {

    /* renamed from: a  reason: collision with root package name */
    final LruCache<String, b> f8711a;

    /* compiled from: LruCache */
    class a extends LruCache<String, b> {
        a(m mVar, int i2) {
            super(i2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, b bVar) {
            return bVar.f8713b;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: LruCache */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Bitmap f8712a;

        /* renamed from: b  reason: collision with root package name */
        final int f8713b;

        b(Bitmap bitmap, int i2) {
            this.f8712a = bitmap;
            this.f8713b = i2;
        }
    }

    public m(Context context) {
        this(d0.b(context));
    }

    @Override // com.squareup.picasso.d
    public int a() {
        return this.f8711a.maxSize();
    }

    @Override // com.squareup.picasso.d
    public void b(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int i2 = d0.i(bitmap);
        if (i2 > a()) {
            this.f8711a.remove(str);
        } else {
            this.f8711a.put(str, new b(bitmap, i2));
        }
    }

    @Override // com.squareup.picasso.d
    public Bitmap c(String str) {
        b bVar = this.f8711a.get(str);
        if (bVar != null) {
            return bVar.f8712a;
        }
        return null;
    }

    @Override // com.squareup.picasso.d
    public int size() {
        return this.f8711a.size();
    }

    public m(int i2) {
        this.f8711a = new a(this, i2);
    }
}
