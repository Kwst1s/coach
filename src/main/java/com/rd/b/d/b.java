package com.rd.b.d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.rd.b.b.b;

/* compiled from: BaseAnimation */
public abstract class b<T extends Animator> {

    /* renamed from: a  reason: collision with root package name */
    protected long f8521a = 350;

    /* renamed from: b  reason: collision with root package name */
    protected b.a f8522b;

    /* renamed from: c  reason: collision with root package name */
    protected T f8523c;

    public b(b.a aVar) {
        this.f8522b = aVar;
        this.f8523c = a();
    }

    public abstract T a();

    public b b(long j2) {
        this.f8521a = j2;
        T t = this.f8523c;
        if (t instanceof ValueAnimator) {
            t.setDuration(j2);
        }
        return this;
    }

    public void c() {
        T t = this.f8523c;
        if (t != null && t.isStarted()) {
            this.f8523c.end();
        }
    }

    public abstract b d(float f2);

    public void e() {
        T t = this.f8523c;
        if (t != null && !t.isRunning()) {
            this.f8523c.start();
        }
    }
}
