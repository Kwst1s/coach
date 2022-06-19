package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f4729a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledFormatException extends Exception {
        public UnhandledFormatException(int i2, int i3, int i4) {
            super("Unhandled format: " + i2 + " Hz, " + i3 + " channels in encoding " + i4);
        }
    }

    boolean b();

    void e();

    ByteBuffer f();

    void flush();

    void g();

    boolean h();

    void i(ByteBuffer byteBuffer);

    int j();

    boolean k(int i2, int i3, int i4);

    int l();

    int m();
}
