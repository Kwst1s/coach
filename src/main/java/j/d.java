package j;

import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink */
public interface d extends s, WritableByteChannel {
    c a();

    d d(byte[] bArr, int i2, int i3);

    d f(long j2);

    @Override // j.s, java.io.Flushable
    void flush();

    d h(int i2);

    d i(int i2);

    d p(int i2);

    d r(byte[] bArr);

    d t();

    d y(String str);

    d z(long j2);
}
