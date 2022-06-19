package com.bumptech.glide.load.engine.a0;

import android.util.Log;
import com.bumptech.glide.k.a;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f3673a;

    /* renamed from: b  reason: collision with root package name */
    private final File f3674b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3675c;

    /* renamed from: d  reason: collision with root package name */
    private final c f3676d = new c();

    /* renamed from: e  reason: collision with root package name */
    private a f3677e;

    @Deprecated
    protected e(File file, long j2) {
        this.f3674b = file;
        this.f3675c = j2;
        this.f3673a = new j();
    }

    public static a c(File file, long j2) {
        return new e(file, j2);
    }

    private synchronized a d() {
        if (this.f3677e == null) {
            this.f3677e = a.V(this.f3674b, 1, 1, this.f3675c);
        }
        return this.f3677e;
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public void a(f fVar, a.b bVar) {
        String b2 = this.f3673a.b(fVar);
        this.f3676d.a(b2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b2 + " for for Key: " + fVar);
            }
            try {
                com.bumptech.glide.k.a d2 = d();
                if (d2.T(b2) == null) {
                    a.c Q = d2.Q(b2);
                    if (Q != null) {
                        try {
                            if (bVar.a(Q.f(0))) {
                                Q.e();
                            }
                            this.f3676d.b(b2);
                        } finally {
                            Q.b();
                        }
                    } else {
                        throw new IllegalStateException("Had two simultaneous puts for: " + b2);
                    }
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
        } finally {
            this.f3676d.b(b2);
        }
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public File b(f fVar) {
        String b2 = this.f3673a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b2 + " for for Key: " + fVar);
        }
        try {
            a.e T = d().T(b2);
            if (T != null) {
                return T.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }
}
