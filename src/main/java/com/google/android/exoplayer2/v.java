package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.util.e;

/* compiled from: PlayerMessage */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final b f7091a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7092b;

    /* renamed from: c  reason: collision with root package name */
    private final b0 f7093c;

    /* renamed from: d  reason: collision with root package name */
    private int f7094d;

    /* renamed from: e  reason: collision with root package name */
    private Object f7095e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f7096f;

    /* renamed from: g  reason: collision with root package name */
    private int f7097g;

    /* renamed from: h  reason: collision with root package name */
    private long f7098h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7099i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7100j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7101k;
    private boolean l;
    private boolean m;

    /* compiled from: PlayerMessage */
    public interface a {
        void b(v vVar);
    }

    /* compiled from: PlayerMessage */
    public interface b {
        void m(int i2, Object obj);
    }

    public v(a aVar, b bVar, b0 b0Var, int i2, Handler handler) {
        this.f7092b = aVar;
        this.f7091a = bVar;
        this.f7093c = b0Var;
        this.f7096f = handler;
        this.f7097g = i2;
    }

    public synchronized boolean a() {
        e.f(this.f7100j);
        e.f(this.f7096f.getLooper().getThread() != Thread.currentThread());
        while (!this.l) {
            wait();
        }
        return this.f7101k;
    }

    public boolean b() {
        return this.f7099i;
    }

    public Handler c() {
        return this.f7096f;
    }

    public Object d() {
        return this.f7095e;
    }

    public long e() {
        return this.f7098h;
    }

    public b f() {
        return this.f7091a;
    }

    public b0 g() {
        return this.f7093c;
    }

    public int h() {
        return this.f7094d;
    }

    public int i() {
        return this.f7097g;
    }

    public synchronized boolean j() {
        return this.m;
    }

    public synchronized void k(boolean z) {
        this.f7101k = z | this.f7101k;
        this.l = true;
        notifyAll();
    }

    public v l() {
        e.f(!this.f7100j);
        if (this.f7098h == -9223372036854775807L) {
            e.a(this.f7099i);
        }
        this.f7100j = true;
        this.f7092b.b(this);
        return this;
    }

    public v m(Object obj) {
        e.f(!this.f7100j);
        this.f7095e = obj;
        return this;
    }

    public v n(int i2) {
        e.f(!this.f7100j);
        this.f7094d = i2;
        return this;
    }
}
