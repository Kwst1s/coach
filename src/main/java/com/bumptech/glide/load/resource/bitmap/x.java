package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.r.d;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class x implements j<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final l f4237a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4238b;

    /* access modifiers changed from: package-private */
    /* compiled from: StreamBitmapDecoder */
    public static class a implements l.b {

        /* renamed from: a  reason: collision with root package name */
        private final v f4239a;

        /* renamed from: b  reason: collision with root package name */
        private final d f4240b;

        a(v vVar, d dVar) {
            this.f4239a = vVar;
            this.f4240b = dVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void a(e eVar, Bitmap bitmap) {
            IOException l = this.f4240b.l();
            if (l != null) {
                if (bitmap != null) {
                    eVar.d(bitmap);
                }
                throw l;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void b() {
            this.f4239a.E();
        }
    }

    public x(l lVar, b bVar) {
        this.f4237a = lVar;
        this.f4238b = bVar;
    }

    /* renamed from: c */
    public u<Bitmap> a(InputStream inputStream, int i2, int i3, h hVar) {
        v vVar;
        boolean z;
        if (inputStream instanceof v) {
            vVar = (v) inputStream;
            z = false;
        } else {
            vVar = new v(inputStream, this.f4238b);
            z = true;
        }
        d E = d.E(vVar);
        try {
            return this.f4237a.g(new com.bumptech.glide.r.h(E), i2, i3, hVar, new a(vVar, E));
        } finally {
            E.F();
            if (z) {
                vVar.F();
            }
        }
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, h hVar) {
        return this.f4237a.p(inputStream);
    }
}
