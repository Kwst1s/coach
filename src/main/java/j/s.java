package j;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: Sink */
public interface s extends Closeable, Flushable {
    u c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void e(c cVar, long j2);

    @Override // java.io.Flushable
    void flush();
}
