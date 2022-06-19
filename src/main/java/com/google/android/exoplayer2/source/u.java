package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: MediaSource */
public interface u {

    /* compiled from: MediaSource */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f6613a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6614b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6615c;

        /* renamed from: d  reason: collision with root package name */
        public final long f6616d;

        /* renamed from: e  reason: collision with root package name */
        public final long f6617e;

        public a(Object obj) {
            this(obj, -1);
        }

        public boolean a() {
            return this.f6614b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f6613a.equals(aVar.f6613a) && this.f6614b == aVar.f6614b && this.f6615c == aVar.f6615c && this.f6616d == aVar.f6616d && this.f6617e == aVar.f6617e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((527 + this.f6613a.hashCode()) * 31) + this.f6614b) * 31) + this.f6615c) * 31) + ((int) this.f6616d)) * 31) + ((int) this.f6617e);
        }

        public a(Object obj, long j2) {
            this(obj, -1, -1, j2, Long.MIN_VALUE);
        }

        public a(Object obj, long j2, long j3) {
            this(obj, -1, -1, j2, j3);
        }

        public a(Object obj, int i2, int i3, long j2) {
            this(obj, i2, i3, j2, Long.MIN_VALUE);
        }

        private a(Object obj, int i2, int i3, long j2, long j3) {
            this.f6613a = obj;
            this.f6614b = i2;
            this.f6615c = i3;
            this.f6616d = j2;
            this.f6617e = j3;
        }
    }

    /* compiled from: MediaSource */
    public interface b {
        void c(u uVar, b0 b0Var, Object obj);
    }

    t a(a aVar, d dVar);

    void b();

    void c(t tVar);

    void e(Handler handler, v vVar);

    void f(v vVar);

    void h(b bVar);

    void i(g gVar, boolean z, b bVar, x xVar);
}
