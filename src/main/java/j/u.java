package j;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
public class u {

    /* renamed from: d  reason: collision with root package name */
    public static final u f10707d = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f10708a;

    /* renamed from: b  reason: collision with root package name */
    private long f10709b;

    /* renamed from: c  reason: collision with root package name */
    private long f10710c;

    /* compiled from: Timeout */
    class a extends u {
        a() {
        }

        @Override // j.u
        public u d(long j2) {
            return this;
        }

        @Override // j.u
        public void f() {
        }

        @Override // j.u
        public u g(long j2, TimeUnit timeUnit) {
            return this;
        }
    }

    public u a() {
        this.f10708a = false;
        return this;
    }

    public u b() {
        this.f10710c = 0;
        return this;
    }

    public long c() {
        if (this.f10708a) {
            return this.f10709b;
        }
        throw new IllegalStateException("No deadline");
    }

    public u d(long j2) {
        this.f10708a = true;
        this.f10709b = j2;
        return this;
    }

    public boolean e() {
        return this.f10708a;
    }

    public void f() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f10708a && this.f10709b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public u g(long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j2);
        } else if (timeUnit != null) {
            this.f10710c = timeUnit.toNanos(j2);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long h() {
        return this.f10710c;
    }
}
