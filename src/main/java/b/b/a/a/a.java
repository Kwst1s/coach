package b.b.a.a;

/* compiled from: ArchTaskExecutor */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f2107c;

    /* renamed from: a  reason: collision with root package name */
    private c f2108a;

    /* renamed from: b  reason: collision with root package name */
    private c f2109b;

    private a() {
        b bVar = new b();
        this.f2109b = bVar;
        this.f2108a = bVar;
    }

    public static a b() {
        if (f2107c != null) {
            return f2107c;
        }
        synchronized (a.class) {
            if (f2107c == null) {
                f2107c = new a();
            }
        }
        return f2107c;
    }

    @Override // b.b.a.a.c
    public boolean a() {
        return this.f2108a.a();
    }
}
