package com.bumptech.glide.load.o.d;

import com.bumptech.glide.load.m.e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder */
public class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f4099a;

    /* renamed from: com.bumptech.glide.load.o.d.a$a  reason: collision with other inner class name */
    /* compiled from: ByteBufferRewinder */
    public static class C0103a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.m.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        /* renamed from: c */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f4099a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.m.e
    public void b() {
    }

    /* renamed from: c */
    public ByteBuffer a() {
        this.f4099a.position(0);
        return this.f4099a;
    }
}
