package i.k0;

/* compiled from: NamedRunnable */
public abstract class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    protected final String f10444b;

    public d(String str, Object... objArr) {
        this.f10444b = e.n(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void k();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f10444b);
        try {
            k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
