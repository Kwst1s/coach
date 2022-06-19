package j;

/* compiled from: ForwardingSink */
public abstract class g implements s {

    /* renamed from: b  reason: collision with root package name */
    private final s f10670b;

    public g(s sVar) {
        if (sVar != null) {
            this.f10670b = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // j.s
    public u c() {
        return this.f10670b.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, j.s
    public void close() {
        this.f10670b.close();
    }

    @Override // j.s
    public void e(c cVar, long j2) {
        this.f10670b.e(cVar, j2);
    }

    @Override // j.s, java.io.Flushable
    public void flush() {
        this.f10670b.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10670b.toString() + ")";
    }
}
