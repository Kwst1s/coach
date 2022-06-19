package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.s;
import java.nio.ByteBuffer;

public interface AudioSink {

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    public static final class InitializationException extends Exception {
        public InitializationException(int i2, int i3, int i4, int i5) {
            super("AudioTrack init failed: " + i2 + ", Config(" + i3 + ", " + i4 + ", " + i5 + ")");
        }
    }

    public static final class WriteException extends Exception {
        public WriteException(int i2) {
            super("AudioTrack write failed: " + i2);
        }
    }

    public interface a {
        void a();

        void b(int i2, long j2, long j3);

        void d(int i2);
    }

    void a();

    boolean b();

    void c();

    s d();

    void e();

    s f(s sVar);

    void g(int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7);

    void h();

    boolean i();

    void j();

    long k(boolean z);

    void l();

    void m(a aVar);

    void n(h hVar);

    boolean o(int i2);

    void p(m mVar);

    void q();

    void r(float f2);

    boolean s(ByteBuffer byteBuffer, long j2);

    void t(int i2);
}
