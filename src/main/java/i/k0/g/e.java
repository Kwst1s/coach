package i.k0.g;

import j.c;
import j.g;
import j.s;
import java.io.IOException;

/* access modifiers changed from: package-private */
/* compiled from: FaultHidingSink */
public class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private boolean f10500c;

    e(s sVar) {
        super(sVar);
    }

    @Override // j.g, java.io.Closeable, java.lang.AutoCloseable, j.s
    public void close() {
        if (!this.f10500c) {
            try {
                super.close();
            } catch (IOException e2) {
                this.f10500c = true;
                l(e2);
            }
        }
    }

    @Override // j.g, j.s
    public void e(c cVar, long j2) {
        if (this.f10500c) {
            cVar.b(j2);
            return;
        }
        try {
            super.e(cVar, j2);
        } catch (IOException e2) {
            this.f10500c = true;
            l(e2);
        }
    }

    @Override // j.g, j.s, java.io.Flushable
    public void flush() {
        if (!this.f10500c) {
            try {
                super.flush();
            } catch (IOException e2) {
                this.f10500c = true;
                l(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void l(IOException iOException) {
        throw null;
    }
}
