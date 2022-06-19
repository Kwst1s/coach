package com.bumptech.glide.load.m;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.m.d;
import java.io.IOException;

/* compiled from: AssetPathFetcher */
public abstract class b<T> implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    private final String f3934b;

    /* renamed from: c  reason: collision with root package name */
    private final AssetManager f3935c;

    /* renamed from: d  reason: collision with root package name */
    private T f3936d;

    public b(AssetManager assetManager, String str) {
        this.f3935c = assetManager;
        this.f3934b = str;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        T t = this.f3936d;
        if (t != null) {
            try {
                c(t);
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(T t);

    @Override // com.bumptech.glide.load.m.d
    public void cancel() {
    }

    /* access modifiers changed from: protected */
    public abstract T d(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.m.d
    public a e() {
        return a.LOCAL;
    }

    @Override // com.bumptech.glide.load.m.d
    public void f(f fVar, d.a<? super T> aVar) {
        try {
            T d2 = d(this.f3935c, this.f3934b);
            this.f3936d = d2;
            aVar.d(d2);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.c(e2);
        }
    }
}
