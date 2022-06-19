package com.google.android.exoplayer2.d0;

import java.nio.ByteBuffer;

/* compiled from: DecoderInputBuffer */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public final b f4950c = new b();

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer f4951d;

    /* renamed from: e  reason: collision with root package name */
    public long f4952e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4953f;

    public e(int i2) {
        this.f4953f = i2;
    }

    private ByteBuffer m(int i2) {
        int i3 = this.f4953f;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f4951d;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i2 + ")");
    }

    public static e r() {
        return new e(0);
    }

    @Override // com.google.android.exoplayer2.d0.a
    public void f() {
        super.f();
        ByteBuffer byteBuffer = this.f4951d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void n(int i2) {
        ByteBuffer byteBuffer = this.f4951d;
        if (byteBuffer == null) {
            this.f4951d = m(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f4951d.position();
        int i3 = i2 + position;
        if (capacity < i3) {
            ByteBuffer m = m(i3);
            if (position > 0) {
                this.f4951d.position(0);
                this.f4951d.limit(position);
                m.put(this.f4951d);
            }
            this.f4951d = m;
        }
    }

    public final void o() {
        this.f4951d.flip();
    }

    public final boolean p() {
        return h(1073741824);
    }

    public final boolean q() {
        return this.f4951d == null && this.f4953f == 0;
    }
}
