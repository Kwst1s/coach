package com.bumptech.glide.l;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* compiled from: GifDecoder */
public interface a {

    /* renamed from: com.bumptech.glide.l.a$a  reason: collision with other inner class name */
    /* compiled from: GifDecoder */
    public interface AbstractC0086a {
        Bitmap a(int i2, int i3, Bitmap.Config config);

        void b(byte[] bArr);

        byte[] c(int i2);

        void d(int[] iArr);

        int[] e(int i2);

        void f(Bitmap bitmap);
    }

    int a();

    Bitmap b();

    void c();

    void clear();

    int d();

    int e();

    int f();

    void g(Bitmap.Config config);

    ByteBuffer getData();

    void h();
}
