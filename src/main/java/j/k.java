package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
public final class k implements t {

    /* renamed from: b  reason: collision with root package name */
    private final e f10678b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f10679c;

    /* renamed from: d  reason: collision with root package name */
    private int f10680d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10681e;

    k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f10678b = eVar;
            this.f10679c = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    private void E() {
        int i2 = this.f10680d;
        if (i2 != 0) {
            int remaining = i2 - this.f10679c.getRemaining();
            this.f10680d -= remaining;
            this.f10678b.b((long) remaining);
        }
    }

    @Override // j.t
    public u c() {
        return this.f10678b.c();
    }

    @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f10681e) {
            this.f10679c.end();
            this.f10681e = true;
            this.f10678b.close();
        }
    }

    public final boolean l() {
        if (!this.f10679c.needsInput()) {
            return false;
        }
        E();
        if (this.f10679c.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f10678b.o()) {
            return true;
        } else {
            p pVar = this.f10678b.a().f10662b;
            int i2 = pVar.f10698c;
            int i3 = pVar.f10697b;
            int i4 = i2 - i3;
            this.f10680d = i4;
            this.f10679c.setInput(pVar.f10696a, i3, i4);
            return false;
        }
    }

    @Override // j.t
    public long v(c cVar, long j2) {
        p V;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (this.f10681e) {
            throw new IllegalStateException("closed");
        } else if (j2 == 0) {
            return 0;
        } else {
            while (true) {
                boolean l = l();
                try {
                    V = cVar.V(1);
                    int inflate = this.f10679c.inflate(V.f10696a, V.f10698c, (int) Math.min(j2, (long) (8192 - V.f10698c)));
                    if (inflate > 0) {
                        V.f10698c += inflate;
                        long j3 = (long) inflate;
                        cVar.f10663c += j3;
                        return j3;
                    } else if (this.f10679c.finished()) {
                        break;
                    } else if (this.f10679c.needsDictionary()) {
                        break;
                    } else if (l) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            E();
            if (V.f10697b != V.f10698c) {
                return -1;
            }
            cVar.f10662b = V.b();
            q.a(V);
            return -1;
        }
    }
}
