package b.h.j;

import android.util.Log;
import java.io.Writer;

@Deprecated
/* compiled from: LogWriter */
public class b extends Writer {

    /* renamed from: b  reason: collision with root package name */
    private final String f2584b;

    /* renamed from: c  reason: collision with root package name */
    private StringBuilder f2585c = new StringBuilder(128);

    public b(String str) {
        this.f2584b = str;
    }

    private void l() {
        if (this.f2585c.length() > 0) {
            Log.d(this.f2584b, this.f2585c.toString());
            StringBuilder sb = this.f2585c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
        l();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        l();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                l();
            } else {
                this.f2585c.append(c2);
            }
        }
    }
}
