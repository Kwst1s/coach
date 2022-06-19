package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.d0.d;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.e;

/* compiled from: AudioRendererEventListener */
public interface j {

    /* compiled from: AudioRendererEventListener */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f4789a;

        /* renamed from: b  reason: collision with root package name */
        private final j f4790b;

        public a(Handler handler, j jVar) {
            Handler handler2;
            if (jVar != null) {
                e.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f4789a = handler2;
            this.f4790b = jVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public /* synthetic */ void h(int i2) {
            this.f4790b.d(i2);
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public /* synthetic */ void j(int i2, long j2, long j3) {
            this.f4790b.e(i2, j2, j3);
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public /* synthetic */ void l(String str, long j2, long j3) {
            this.f4790b.F(str, j2, j3);
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ void n(d dVar) {
            dVar.a();
            this.f4790b.k(dVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void p(d dVar) {
            this.f4790b.n(dVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void r(l lVar) {
            this.f4790b.x(lVar);
        }

        public void a(int i2) {
            if (this.f4790b != null) {
                this.f4789a.post(new c(this, i2));
            }
        }

        public void b(int i2, long j2, long j3) {
            if (this.f4790b != null) {
                this.f4789a.post(new b(this, i2, j2, j3));
            }
        }

        public void c(String str, long j2, long j3) {
            if (this.f4790b != null) {
                this.f4789a.post(new d(this, str, j2, j3));
            }
        }

        public void d(d dVar) {
            if (this.f4790b != null) {
                this.f4789a.post(new f(this, dVar));
            }
        }

        public void e(d dVar) {
            if (this.f4790b != null) {
                this.f4789a.post(new e(this, dVar));
            }
        }

        public void f(l lVar) {
            if (this.f4790b != null) {
                this.f4789a.post(new a(this, lVar));
            }
        }
    }

    void F(String str, long j2, long j3);

    void d(int i2);

    void e(int i2, long j2, long j3);

    void k(d dVar);

    void n(d dVar);

    void x(l lVar);
}
