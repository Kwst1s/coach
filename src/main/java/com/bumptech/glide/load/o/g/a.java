package com.bumptech.glide.load.o.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.l.a;
import com.bumptech.glide.l.c;
import com.bumptech.glide.l.d;
import com.bumptech.glide.l.e;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.k;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder */
public class a implements j<ByteBuffer, c> {

    /* renamed from: f  reason: collision with root package name */
    private static final C0104a f4104f = new C0104a();

    /* renamed from: g  reason: collision with root package name */
    private static final b f4105g = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Context f4106a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f4107b;

    /* renamed from: c  reason: collision with root package name */
    private final b f4108c;

    /* renamed from: d  reason: collision with root package name */
    private final C0104a f4109d;

    /* renamed from: e  reason: collision with root package name */
    private final b f4110e;

    /* access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.o.g.a$a  reason: collision with other inner class name */
    /* compiled from: ByteBufferGifDecoder */
    public static class C0104a {
        C0104a() {
        }

        /* access modifiers changed from: package-private */
        public com.bumptech.glide.l.a a(a.AbstractC0086a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
            return new e(aVar, cVar, byteBuffer, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<d> f4111a = k.e(0);

        b() {
        }

        /* access modifiers changed from: package-private */
        public synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f4111a.poll();
            if (poll == null) {
                poll = new d();
            }
            poll.p(byteBuffer);
            return poll;
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(d dVar) {
            dVar.a();
            this.f4111a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this(context, list, eVar, bVar, f4105g, f4104f);
    }

    private e c(ByteBuffer byteBuffer, int i2, int i3, d dVar, h hVar) {
        Bitmap.Config config;
        long b2 = f.b();
        try {
            c c2 = dVar.c();
            if (c2.b() > 0) {
                if (c2.c() == 0) {
                    if (hVar.c(i.f4143a) == com.bumptech.glide.load.b.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    com.bumptech.glide.l.a a2 = this.f4109d.a(this.f4110e, c2, byteBuffer, e(c2, i2, i3));
                    a2.g(config);
                    a2.c();
                    Bitmap b3 = a2.b();
                    if (b3 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f.a(b2));
                        }
                        return null;
                    }
                    e eVar = new e(new c(this.f4106a, a2, com.bumptech.glide.load.o.c.c(), i2, i3, b3));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f.a(b2));
                    }
                    return eVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f.a(b2));
            }
        }
    }

    private static int e(c cVar, int i2, int i3) {
        int i4;
        int min = Math.min(cVar.a() / i3, cVar.d() / i2);
        if (min == 0) {
            i4 = 0;
        } else {
            i4 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i4);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return max;
    }

    /* renamed from: d */
    public e a(ByteBuffer byteBuffer, int i2, int i3, h hVar) {
        d a2 = this.f4108c.a(byteBuffer);
        try {
            return c(byteBuffer, i2, i3, a2, hVar);
        } finally {
            this.f4108c.b(a2);
        }
    }

    /* renamed from: f */
    public boolean b(ByteBuffer byteBuffer, h hVar) {
        return !((Boolean) hVar.c(i.f4144b)).booleanValue() && com.bumptech.glide.load.e.f(this.f4107b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar, b bVar2, C0104a aVar) {
        this.f4106a = context.getApplicationContext();
        this.f4107b = list;
        this.f4109d = aVar;
        this.f4110e = new b(eVar, bVar);
        this.f4108c = bVar2;
    }
}
