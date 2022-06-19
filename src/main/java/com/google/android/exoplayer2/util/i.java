package com.google.android.exoplayer2.util;

/* compiled from: ConditionVariable */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7023a;

    public synchronized void a() {
        while (!this.f7023a) {
            wait();
        }
    }

    public synchronized boolean b() {
        boolean z;
        z = this.f7023a;
        this.f7023a = false;
        return z;
    }

    public synchronized boolean c() {
        if (this.f7023a) {
            return false;
        }
        this.f7023a = true;
        notifyAll();
        return true;
    }
}
