package com.bumptech.glide.load.o;

import android.content.Context;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* compiled from: UnitTransformation */
public final class c<T> implements l<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final l<?> f4098b = new c();

    private c() {
    }

    public static <T> c<T> c() {
        return (c) f4098b;
    }

    @Override // com.bumptech.glide.load.l
    public u<T> a(Context context, u<T> uVar, int i2, int i3) {
        return uVar;
    }

    @Override // com.bumptech.glide.load.f
    public void b(MessageDigest messageDigest) {
    }
}
