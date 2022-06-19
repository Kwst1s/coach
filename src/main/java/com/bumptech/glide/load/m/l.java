package com.bumptech.glide.load.m;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.m.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher */
public abstract class l<T> implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    private final Uri f3958b;

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f3959c;

    /* renamed from: d  reason: collision with root package name */
    private T f3960d;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f3959c = contentResolver;
        this.f3958b = uri;
    }

    @Override // com.bumptech.glide.load.m.d
    public void b() {
        T t = this.f3960d;
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
    public abstract T d(Uri uri, ContentResolver contentResolver);

    @Override // com.bumptech.glide.load.m.d
    public a e() {
        return a.LOCAL;
    }

    @Override // com.bumptech.glide.load.m.d
    public final void f(f fVar, d.a<? super T> aVar) {
        try {
            T d2 = d(this.f3958b, this.f3959c);
            this.f3960d = d2;
            aVar.d(d2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.c(e2);
        }
    }
}
