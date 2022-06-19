package h.a.a.a;

/* access modifiers changed from: package-private */
/* compiled from: TimeBase */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private long f10279a;

    /* renamed from: b  reason: collision with root package name */
    private double f10280b = 1.0d;

    public k() {
        f();
    }

    private long d() {
        double nanoTime = (double) (System.nanoTime() / 1000);
        double d2 = this.f10280b;
        Double.isNaN(nanoTime);
        return (long) (nanoTime * d2);
    }

    public long a() {
        return d() - this.f10279a;
    }

    public long b(long j2) {
        return j2 - a();
    }

    public double c() {
        return this.f10280b;
    }

    public void e(double d2) {
        this.f10280b = d2;
    }

    public void f() {
        g(0);
    }

    public void g(long j2) {
        this.f10279a = d() - j2;
    }
}
