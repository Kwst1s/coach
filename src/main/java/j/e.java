package j;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* compiled from: BufferedSource */
public interface e extends t, ReadableByteChannel {
    long A(byte b2);

    boolean B(long j2, f fVar);

    long C();

    InputStream D();

    @Deprecated
    c a();

    void b(long j2);

    f g(long j2);

    String j();

    byte[] k();

    int m();

    c n();

    boolean o();

    byte[] q(long j2);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    short s();

    long u();

    String w(long j2);

    void x(long j2);
}
