package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.bumptech.glide.load.g;

/* compiled from: DownsampleStrategy */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f4187a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final k f4188b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final k f4189c;

    /* renamed from: d  reason: collision with root package name */
    public static final k f4190d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final k f4191e;

    /* renamed from: f  reason: collision with root package name */
    public static final g<k> f4192f;

    /* renamed from: g  reason: collision with root package name */
    static final boolean f4193g = (Build.VERSION.SDK_INT >= 19);

    /* compiled from: DownsampleStrategy */
    private static class a extends k {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public e a(int i2, int i3, int i4, int i5) {
            if (b(i2, i3, i4, i5) == 1.0f) {
                return e.QUALITY;
            }
            return k.f4187a.a(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, k.f4187a.b(i2, i3, i4, i5));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class b extends k {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public e a(int i2, int i3, int i4, int i5) {
            return e.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class c extends k {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public e a(int i2, int i3, int i4, int i5) {
            if (k.f4193g) {
                return e.QUALITY;
            }
            return e.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public float b(int i2, int i3, int i4, int i5) {
            if (k.f4193g) {
                return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            }
            int max = Math.max(i3 / i5, i2 / i4);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    /* compiled from: DownsampleStrategy */
    private static class d extends k {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public e a(int i2, int i3, int i4, int i5) {
            return e.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k
        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy */
    public enum e {
        MEMORY,
        QUALITY
    }

    static {
        b bVar = new b();
        f4189c = bVar;
        f4191e = bVar;
        f4192f = g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", bVar);
    }

    public abstract e a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
