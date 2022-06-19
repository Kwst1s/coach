package j;

import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
public class i extends u {

    /* renamed from: e  reason: collision with root package name */
    private u f10672e;

    public i(u uVar) {
        if (uVar != null) {
            this.f10672e = uVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // j.u
    public u a() {
        return this.f10672e.a();
    }

    @Override // j.u
    public u b() {
        return this.f10672e.b();
    }

    @Override // j.u
    public long c() {
        return this.f10672e.c();
    }

    @Override // j.u
    public u d(long j2) {
        return this.f10672e.d(j2);
    }

    @Override // j.u
    public boolean e() {
        return this.f10672e.e();
    }

    @Override // j.u
    public void f() {
        this.f10672e.f();
    }

    @Override // j.u
    public u g(long j2, TimeUnit timeUnit) {
        return this.f10672e.g(j2, timeUnit);
    }

    public final u i() {
        return this.f10672e;
    }

    public final i j(u uVar) {
        if (uVar != null) {
            this.f10672e = uVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }
}
