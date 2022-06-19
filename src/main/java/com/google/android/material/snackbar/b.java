package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: SnackbarManager */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static b f7917e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f7918a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f7919b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    private c f7920c;

    /* renamed from: d  reason: collision with root package name */
    private c f7921d;

    /* compiled from: SnackbarManager */
    class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.snackbar.b$b  reason: collision with other inner class name */
    /* compiled from: SnackbarManager */
    public interface AbstractC0156b {
        void a();

        void b(int i2);
    }

    /* access modifiers changed from: private */
    /* compiled from: SnackbarManager */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<AbstractC0156b> f7923a;

        /* renamed from: b  reason: collision with root package name */
        int f7924b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7925c;

        c(int i2, AbstractC0156b bVar) {
            this.f7923a = new WeakReference<>(bVar);
            this.f7924b = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractC0156b bVar) {
            return bVar != null && this.f7923a.get() == bVar;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i2) {
        AbstractC0156b bVar = cVar.f7923a.get();
        if (bVar == null) {
            return false;
        }
        this.f7919b.removeCallbacksAndMessages(cVar);
        bVar.b(i2);
        return true;
    }

    static b c() {
        if (f7917e == null) {
            f7917e = new b();
        }
        return f7917e;
    }

    private boolean f(AbstractC0156b bVar) {
        c cVar = this.f7920c;
        return cVar != null && cVar.a(bVar);
    }

    private boolean g(AbstractC0156b bVar) {
        c cVar = this.f7921d;
        return cVar != null && cVar.a(bVar);
    }

    private void l(c cVar) {
        int i2 = cVar.f7924b;
        if (i2 != -2) {
            if (i2 <= 0) {
                i2 = i2 == -1 ? 1500 : 2750;
            }
            this.f7919b.removeCallbacksAndMessages(cVar);
            Handler handler = this.f7919b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i2);
        }
    }

    private void n() {
        c cVar = this.f7921d;
        if (cVar != null) {
            this.f7920c = cVar;
            this.f7921d = null;
            AbstractC0156b bVar = cVar.f7923a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.f7920c = null;
            }
        }
    }

    public void b(AbstractC0156b bVar, int i2) {
        synchronized (this.f7918a) {
            if (f(bVar)) {
                a(this.f7920c, i2);
            } else if (g(bVar)) {
                a(this.f7921d, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(c cVar) {
        synchronized (this.f7918a) {
            if (this.f7920c == cVar || this.f7921d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(AbstractC0156b bVar) {
        boolean z;
        synchronized (this.f7918a) {
            if (!f(bVar)) {
                if (!g(bVar)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void h(AbstractC0156b bVar) {
        synchronized (this.f7918a) {
            if (f(bVar)) {
                this.f7920c = null;
                if (this.f7921d != null) {
                    n();
                }
            }
        }
    }

    public void i(AbstractC0156b bVar) {
        synchronized (this.f7918a) {
            if (f(bVar)) {
                l(this.f7920c);
            }
        }
    }

    public void j(AbstractC0156b bVar) {
        synchronized (this.f7918a) {
            if (f(bVar)) {
                c cVar = this.f7920c;
                if (!cVar.f7925c) {
                    cVar.f7925c = true;
                    this.f7919b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(AbstractC0156b bVar) {
        synchronized (this.f7918a) {
            if (f(bVar)) {
                c cVar = this.f7920c;
                if (cVar.f7925c) {
                    cVar.f7925c = false;
                    l(cVar);
                }
            }
        }
    }

    public void m(int i2, AbstractC0156b bVar) {
        synchronized (this.f7918a) {
            if (f(bVar)) {
                c cVar = this.f7920c;
                cVar.f7924b = i2;
                this.f7919b.removeCallbacksAndMessages(cVar);
                l(this.f7920c);
                return;
            }
            if (g(bVar)) {
                this.f7921d.f7924b = i2;
            } else {
                this.f7921d = new c(i2, bVar);
            }
            c cVar2 = this.f7920c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f7920c = null;
                n();
            }
        }
    }
}
