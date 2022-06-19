package com.bumptech.glide.load.n;

import com.bumptech.glide.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0098b<Data> f3982a;

    /* compiled from: ByteArrayLoader */
    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.n.b$a$a  reason: collision with other inner class name */
        /* compiled from: ByteArrayLoader */
        class C0097a implements AbstractC0098b<ByteBuffer> {
            C0097a(a aVar) {
            }

            @Override // com.bumptech.glide.load.n.b.AbstractC0098b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            /* renamed from: c */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.bumptech.glide.load.n.o
        public n<byte[], ByteBuffer> b(r rVar) {
            return new b(new C0097a(this));
        }
    }

    /* renamed from: com.bumptech.glide.load.n.b$b  reason: collision with other inner class name */
    /* compiled from: ByteArrayLoader */
    public interface AbstractC0098b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* access modifiers changed from: private */
    /* compiled from: ByteArrayLoader */
    public static class c<Data> implements com.bumptech.glide.load.m.d<Data> {

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f3983b;

        /* renamed from: c  reason: collision with root package name */
        private final AbstractC0098b<Data> f3984c;

        c(byte[] bArr, AbstractC0098b<Data> bVar) {
            this.f3983b = bArr;
            this.f3984c = bVar;
        }

        @Override // com.bumptech.glide.load.m.d
        public Class<Data> a() {
            return this.f3984c.a();
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
        public void f(f fVar, d.a<? super Data> aVar) {
            aVar.d(this.f3984c.b(this.f3983b));
        }
    }

    /* compiled from: ByteArrayLoader */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: ByteArrayLoader */
        class a implements AbstractC0098b<InputStream> {
            a(d dVar) {
            }

            @Override // com.bumptech.glide.load.n.b.AbstractC0098b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.bumptech.glide.load.n.o
        public n<byte[], InputStream> b(r rVar) {
            return new b(new a(this));
        }
    }

    public b(AbstractC0098b<Data> bVar) {
        this.f3982a = bVar;
    }

    /* renamed from: c */
    public n.a<Data> a(byte[] bArr, int i2, int i3, h hVar) {
        return new n.a<>(new com.bumptech.glide.q.b(bArr), new c(bArr, this.f3982a));
    }

    /* renamed from: d */
    public boolean b(byte[] bArr) {
        return true;
    }
}
