package com.bumptech.glide.load.engine.z;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool */
public class k implements e {

    /* renamed from: j  reason: collision with root package name */
    private static final Bitmap.Config f3902j = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final l f3903a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f3904b;

    /* renamed from: c  reason: collision with root package name */
    private final a f3905c;

    /* renamed from: d  reason: collision with root package name */
    private long f3906d;

    /* renamed from: e  reason: collision with root package name */
    private long f3907e;

    /* renamed from: f  reason: collision with root package name */
    private int f3908f;

    /* renamed from: g  reason: collision with root package name */
    private int f3909g;

    /* renamed from: h  reason: collision with root package name */
    private int f3910h;

    /* renamed from: i  reason: collision with root package name */
    private int f3911i;

    /* access modifiers changed from: private */
    /* compiled from: LruBitmapPool */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.z.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.z.k.a
        public void b(Bitmap bitmap) {
        }
    }

    k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f3906d = j2;
        this.f3903a = lVar;
        this.f3904b = set;
        this.f3905c = new b();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap g(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = f3902j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f3908f + ", misses=" + this.f3909g + ", puts=" + this.f3910h + ", evictions=" + this.f3911i + ", currentSize=" + this.f3907e + ", maxSize=" + this.f3906d + "\nStrategy=" + this.f3903a);
    }

    private void j() {
        q(this.f3906d);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            hashSet.add(null);
        }
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l l() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new n();
        }
        return new c();
    }

    private synchronized Bitmap m(int i2, int i3, Bitmap.Config config) {
        Bitmap c2;
        f(config);
        c2 = this.f3903a.c(i2, i3, config != null ? config : f3902j);
        if (c2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f3903a.a(i2, i3, config));
            }
            this.f3909g++;
        } else {
            this.f3908f++;
            this.f3907e -= (long) this.f3903a.b(c2);
            this.f3905c.a(c2);
            p(c2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f3903a.a(i2, i3, config));
        }
        h();
        return c2;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j2) {
        while (this.f3907e > j2) {
            Bitmap removeLast = this.f3903a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f3907e = 0;
                return;
            }
            this.f3905c.a(removeLast);
            this.f3907e -= (long) this.f3903a.b(removeLast);
            this.f3911i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f3903a.e(removeLast));
            }
            h();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            q(n() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0);
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        if (m == null) {
            return g(i2, i3, config);
        }
        m.eraseColor(0);
        return m;
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public synchronized void d(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (!bitmap.isRecycled()) {
            if (bitmap.isMutable() && ((long) this.f3903a.b(bitmap)) <= this.f3906d) {
                if (this.f3904b.contains(bitmap.getConfig())) {
                    int b2 = this.f3903a.b(bitmap);
                    this.f3903a.d(bitmap);
                    this.f3905c.b(bitmap);
                    this.f3910h++;
                    this.f3907e += (long) b2;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f3903a.e(bitmap));
                    }
                    h();
                    j();
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f3903a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f3904b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } else {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        return m == null ? g(i2, i3, config) : m;
    }

    public long n() {
        return this.f3906d;
    }

    public k(long j2) {
        this(j2, l(), k());
    }
}
