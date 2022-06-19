package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.e;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MediaSourceEventListener */
public interface v {

    /* compiled from: MediaSourceEventListener */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f6618a;

        /* renamed from: b  reason: collision with root package name */
        public final u.a f6619b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<C0135a> f6620c;

        /* renamed from: d  reason: collision with root package name */
        private final long f6621d;

        /* access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.source.v$a$a  reason: collision with other inner class name */
        /* compiled from: MediaSourceEventListener */
        public static final class C0135a {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f6622a;

            /* renamed from: b  reason: collision with root package name */
            public final v f6623b;

            public C0135a(Handler handler, v vVar) {
                this.f6622a = handler;
                this.f6623b = vVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0);
        }

        private void K(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        private long b(long j2) {
            long b2 = d.b(j2);
            if (b2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f6621d + b2;
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(v vVar, c cVar) {
            vVar.K(this.f6618a, this.f6619b, cVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public /* synthetic */ void h(v vVar, b bVar, c cVar) {
            vVar.z(this.f6618a, this.f6619b, bVar, cVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public /* synthetic */ void j(v vVar, b bVar, c cVar) {
            vVar.r(this.f6618a, this.f6619b, bVar, cVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public /* synthetic */ void l(v vVar, b bVar, c cVar, IOException iOException, boolean z) {
            vVar.m(this.f6618a, this.f6619b, bVar, cVar, iOException, z);
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ void n(v vVar, b bVar, c cVar) {
            vVar.l(this.f6618a, this.f6619b, bVar, cVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void p(v vVar, u.a aVar) {
            vVar.A(this.f6618a, aVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void r(v vVar, u.a aVar) {
            vVar.w(this.f6618a, aVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: s */
        public /* synthetic */ void t(v vVar, u.a aVar) {
            vVar.y(this.f6618a, aVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: u */
        public /* synthetic */ void v(v vVar, u.a aVar, c cVar) {
            vVar.J(this.f6618a, aVar, cVar);
        }

        public void A(k kVar, Uri uri, Map<String, List<String>> map, int i2, int i3, l lVar, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            z(new b(kVar, uri, map, j4, j5, j6), new c(i2, i3, lVar, i4, obj, b(j2), b(j3)));
        }

        public void B(k kVar, Uri uri, Map<String, List<String>> map, int i2, long j2, long j3, long j4) {
            A(kVar, uri, map, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
        }

        public void C(b bVar, c cVar, IOException iOException, boolean z) {
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new e(this, next.f6623b, bVar, cVar, iOException, z));
            }
        }

        public void D(k kVar, Uri uri, Map<String, List<String>> map, int i2, int i3, l lVar, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            C(new b(kVar, uri, map, j4, j5, j6), new c(i2, i3, lVar, i4, obj, b(j2), b(j3)), iOException, z);
        }

        public void E(k kVar, Uri uri, Map<String, List<String>> map, int i2, long j2, long j3, long j4, IOException iOException, boolean z) {
            D(kVar, uri, map, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, iOException, z);
        }

        public void F(b bVar, c cVar) {
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new c(this, next.f6623b, bVar, cVar));
            }
        }

        public void G(k kVar, int i2, int i3, l lVar, int i4, Object obj, long j2, long j3, long j4) {
            F(new b(kVar, kVar.f6922a, Collections.emptyMap(), j4, 0, 0), new c(i2, i3, lVar, i4, obj, b(j2), b(j3)));
        }

        public void H(k kVar, int i2, long j2) {
            G(kVar, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2);
        }

        public void I() {
            u.a aVar = this.f6619b;
            e.e(aVar);
            u.a aVar2 = aVar;
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new k(this, next.f6623b, aVar2));
            }
        }

        public void J() {
            u.a aVar = this.f6619b;
            e.e(aVar);
            u.a aVar2 = aVar;
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new h(this, next.f6623b, aVar2));
            }
        }

        public void L() {
            u.a aVar = this.f6619b;
            e.e(aVar);
            u.a aVar2 = aVar;
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new j(this, next.f6623b, aVar2));
            }
        }

        public void M(v vVar) {
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                if (next.f6623b == vVar) {
                    this.f6620c.remove(next);
                }
            }
        }

        public void N(int i2, long j2, long j3) {
            O(new c(1, i2, null, 3, null, b(j2), b(j3)));
        }

        public void O(c cVar) {
            u.a aVar = this.f6619b;
            e.e(aVar);
            u.a aVar2 = aVar;
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new d(this, next.f6623b, aVar2, cVar));
            }
        }

        public a P(int i2, u.a aVar, long j2) {
            return new a(this.f6620c, i2, aVar, j2);
        }

        public void a(Handler handler, v vVar) {
            e.a((handler == null || vVar == null) ? false : true);
            this.f6620c.add(new C0135a(handler, vVar));
        }

        public void c(int i2, l lVar, int i3, Object obj, long j2) {
            d(new c(1, i2, lVar, i3, obj, b(j2), -9223372036854775807L));
        }

        public void d(c cVar) {
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new f(this, next.f6623b, cVar));
            }
        }

        public void w(b bVar, c cVar) {
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new g(this, next.f6623b, bVar, cVar));
            }
        }

        public void x(k kVar, Uri uri, Map<String, List<String>> map, int i2, int i3, l lVar, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            w(new b(kVar, uri, map, j4, j5, j6), new c(i2, i3, lVar, i4, obj, b(j2), b(j3)));
        }

        public void y(k kVar, Uri uri, Map<String, List<String>> map, int i2, long j2, long j3, long j4) {
            x(kVar, uri, map, i2, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
        }

        public void z(b bVar, c cVar) {
            Iterator<C0135a> it = this.f6620c.iterator();
            while (it.hasNext()) {
                C0135a next = it.next();
                K(next.f6622a, new i(this, next.f6623b, bVar, cVar));
            }
        }

        private a(CopyOnWriteArrayList<C0135a> copyOnWriteArrayList, int i2, u.a aVar, long j2) {
            this.f6620c = copyOnWriteArrayList;
            this.f6618a = i2;
            this.f6619b = aVar;
            this.f6621d = j2;
        }
    }

    /* compiled from: MediaSourceEventListener */
    public static final class b {
        public b(k kVar, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        }
    }

    /* compiled from: MediaSourceEventListener */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Object f6624a;

        public c(int i2, int i3, l lVar, int i4, Object obj, long j2, long j3) {
            this.f6624a = obj;
        }
    }

    void A(int i2, u.a aVar);

    void J(int i2, u.a aVar, c cVar);

    void K(int i2, u.a aVar, c cVar);

    void l(int i2, u.a aVar, b bVar, c cVar);

    void m(int i2, u.a aVar, b bVar, c cVar, IOException iOException, boolean z);

    void r(int i2, u.a aVar, b bVar, c cVar);

    void w(int i2, u.a aVar);

    void y(int i2, u.a aVar);

    void z(int i2, u.a aVar, b bVar, c cVar);
}
