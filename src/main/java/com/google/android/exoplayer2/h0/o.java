package com.google.android.exoplayer2.h0;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.d0.d;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.e;

/* compiled from: VideoRendererEventListener */
public interface o {

    /* compiled from: VideoRendererEventListener */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f5921a;

        /* renamed from: b  reason: collision with root package name */
        private final o f5922b;

        public a(Handler handler, o oVar) {
            Handler handler2;
            if (oVar != null) {
                e.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f5921a = handler2;
            this.f5922b = oVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void g(String str, long j2, long j3) {
            this.f5922b.o(str, j2, j3);
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ void i(d dVar) {
            dVar.a();
            this.f5922b.E(dVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ void k(int i2, long j2) {
            this.f5922b.I(i2, j2);
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ void m(d dVar) {
            this.f5922b.u(dVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void o(l lVar) {
            this.f5922b.t(lVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void q(Surface surface) {
            this.f5922b.B(surface);
        }

        /* access modifiers changed from: private */
        /* renamed from: r */
        public /* synthetic */ void s(int i2, int i3, int i4, float f2) {
            this.f5922b.a(i2, i3, i4, f2);
        }

        public void a(String str, long j2, long j3) {
            if (this.f5922b != null) {
                this.f5921a.post(new d(this, str, j2, j3));
            }
        }

        public void b(d dVar) {
            if (this.f5922b != null) {
                this.f5921a.post(new f(this, dVar));
            }
        }

        public void c(int i2, long j2) {
            if (this.f5922b != null) {
                this.f5921a.post(new c(this, i2, j2));
            }
        }

        public void d(d dVar) {
            if (this.f5922b != null) {
                this.f5921a.post(new b(this, dVar));
            }
        }

        public void e(l lVar) {
            if (this.f5922b != null) {
                this.f5921a.post(new a(this, lVar));
            }
        }

        public void t(Surface surface) {
            if (this.f5922b != null) {
                this.f5921a.post(new e(this, surface));
            }
        }

        public void u(int i2, int i3, int i4, float f2) {
            if (this.f5922b != null) {
                this.f5921a.post(new g(this, i2, i3, i4, f2));
            }
        }
    }

    void B(Surface surface);

    void E(d dVar);

    void I(int i2, long j2);

    void a(int i2, int i3, int i4, float f2);

    void o(String str, long j2, long j3);

    void t(l lVar);

    void u(d dVar);
}
