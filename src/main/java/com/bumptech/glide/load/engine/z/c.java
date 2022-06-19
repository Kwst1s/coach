package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import com.bumptech.glide.r.k;

/* access modifiers changed from: package-private */
/* compiled from: AttributeStrategy */
public class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f3880a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f3881b = new h<>();

    /* access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy */
    public static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f3882a;

        /* renamed from: b  reason: collision with root package name */
        private int f3883b;

        /* renamed from: c  reason: collision with root package name */
        private int f3884c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f3885d;

        public a(b bVar) {
            this.f3882a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.f3882a.c(this);
        }

        public void b(int i2, int i3, Bitmap.Config config) {
            this.f3883b = i2;
            this.f3884c = i3;
            this.f3885d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f3883b == aVar.f3883b && this.f3884c == aVar.f3884c && this.f3885d == aVar.f3885d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f3883b * 31) + this.f3884c) * 31;
            Bitmap.Config config = this.f3885d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.f(this.f3883b, this.f3884c, this.f3885d);
        }
    }

    /* compiled from: AttributeStrategy */
    static class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public a e(int i2, int i3, Bitmap.Config config) {
            a aVar = (a) b();
            aVar.b(i2, i3, config);
            return aVar;
        }
    }

    c() {
    }

    static String f(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    private static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String a(int i2, int i3, Bitmap.Config config) {
        return f(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public int b(Bitmap bitmap) {
        return k.g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        return this.f3881b.a(this.f3880a.e(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public void d(Bitmap bitmap) {
        this.f3881b.d(this.f3880a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String e(Bitmap bitmap) {
        return g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap removeLast() {
        return this.f3881b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f3881b;
    }
}
