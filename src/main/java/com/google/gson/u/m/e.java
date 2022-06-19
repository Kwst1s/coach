package com.google.gson.u.m;

import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter */
public final class e extends com.google.gson.stream.a {
    private static final Writer p = new a();
    private static final n q = new n("closed");
    private final List<k> m = new ArrayList();
    private String n;
    private k o = l.f8310a;

    /* compiled from: JsonTreeWriter */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public e() {
        super(p);
    }

    private k g0() {
        List<k> list = this.m;
        return list.get(list.size() - 1);
    }

    private void h0(k kVar) {
        if (this.n != null) {
            if (!kVar.e() || K()) {
                ((m) g0()).h(this.n, kVar);
            }
            this.n = null;
        } else if (this.m.isEmpty()) {
            this.o = kVar;
        } else {
            k g0 = g0();
            if (g0 instanceof i) {
                ((i) g0).h(kVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a F() {
        i iVar = new i();
        h0(iVar);
        this.m.add(iVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a G() {
        m mVar = new m();
        h0(mVar);
        this.m.add(mVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a I() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        } else if (g0() instanceof i) {
            List<k> list = this.m;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a J() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        } else if (g0() instanceof m) {
            List<k> list = this.m;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a N(String str) {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        } else if (g0() instanceof m) {
            this.n = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a P() {
        h0(l.f8310a);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Z(long j2) {
        h0(new n(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a0(Boolean bool) {
        if (bool == null) {
            P();
            return this;
        }
        h0(new n(bool));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a b0(Number number) {
        if (number == null) {
            P();
            return this;
        }
        if (!M()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        h0(new n(number));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a c0(String str) {
        if (str == null) {
            P();
            return this;
        }
        h0(new n(str));
        return this;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.m.isEmpty()) {
            this.m.add(q);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a d0(boolean z) {
        h0(new n(Boolean.valueOf(z)));
        return this;
    }

    public k f0() {
        if (this.m.isEmpty()) {
            return this.o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.m);
    }

    @Override // com.google.gson.stream.a, java.io.Flushable
    public void flush() {
    }
}
