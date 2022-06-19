package j;

/* compiled from: ForwardingSource */
public abstract class h implements t {

    /* renamed from: b  reason: collision with root package name */
    private final t f10671b;

    public h(t tVar) {
        if (tVar != null) {
            this.f10671b = tVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // j.t
    public u c() {
        return this.f10671b.c();
    }

    @Override // j.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10671b.close();
    }

    public final t l() {
        return this.f10671b;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10671b.toString() + ")";
    }

    @Override // j.t
    public long v(c cVar, long j2) {
        return this.f10671b.v(cVar, j2);
    }
}
