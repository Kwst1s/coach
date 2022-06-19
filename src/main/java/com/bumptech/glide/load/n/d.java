package com.bumptech.glide.load.n;

import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader */
public class d implements n<File, ByteBuffer> {

    /* access modifiers changed from: private */
    /* compiled from: ByteBufferFileLoader */
    public static final class a implements com.bumptech.glide.load.m.d<ByteBuffer> {

        /* renamed from: b  reason: collision with root package name */
        private final File f3985b;

        a(File file) {
            this.f3985b = file;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.m.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.m.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.m.d
        public com.bumptech.glide.load.a e() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.m.d
        public void f(f fVar, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.d(com.bumptech.glide.r.a.a(this.f3985b));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.c(e2);
            }
        }
    }

    /* compiled from: ByteBufferFileLoader */
    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.n.o
        public n<File, ByteBuffer> b(r rVar) {
            return new d();
        }
    }

    /* renamed from: c */
    public n.a<ByteBuffer> a(File file, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(file), new a(file));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
