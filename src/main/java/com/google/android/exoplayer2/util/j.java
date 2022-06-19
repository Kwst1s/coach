package com.google.android.exoplayer2.util;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventDispatcher */
public final class j<T> {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<b<T>> f7024a = new CopyOnWriteArrayList<>();

    /* compiled from: EventDispatcher */
    public interface a<T> {
        void a(T t);
    }

    /* access modifiers changed from: private */
    /* compiled from: EventDispatcher */
    public static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f7025a;

        /* renamed from: b  reason: collision with root package name */
        private final T f7026b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7027c;

        public b(Handler handler, T t) {
            this.f7025a = handler;
            this.f7026b = t;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(a aVar) {
            if (!this.f7027c) {
                aVar.a(this.f7026b);
            }
        }

        public void b(a<T> aVar) {
            this.f7025a.post(new a(this, aVar));
        }

        public void e() {
            this.f7027c = true;
        }
    }

    public void a(Handler handler, T t) {
        e.a((handler == null || t == null) ? false : true);
        c(t);
        this.f7024a.add(new b<>(handler, t));
    }

    public void b(a<T> aVar) {
        Iterator<b<T>> it = this.f7024a.iterator();
        while (it.hasNext()) {
            it.next().b(aVar);
        }
    }

    public void c(T t) {
        Iterator<b<T>> it = this.f7024a.iterator();
        while (it.hasNext()) {
            b<T> next = it.next();
            if (((b) next).f7026b == t) {
                next.e();
                this.f7024a.remove(next);
            }
        }
    }
}
