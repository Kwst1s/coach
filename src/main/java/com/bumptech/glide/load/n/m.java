package com.bumptech.glide.load.n;

import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k;
import java.util.Queue;

/* compiled from: ModelCache */
public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final g<b<A>, B> f4015a;

    /* compiled from: ModelCache */
    class a extends g<b<A>, B> {
        a(m mVar, long j2) {
            super(j2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public void j(b<A> bVar, B b2) {
            bVar.c();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ModelCache */
    public static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f4016d = k.e(0);

        /* renamed from: a  reason: collision with root package name */
        private int f4017a;

        /* renamed from: b  reason: collision with root package name */
        private int f4018b;

        /* renamed from: c  reason: collision with root package name */
        private A f4019c;

        private b() {
        }

        static <A> b<A> a(A a2, int i2, int i3) {
            b<A> bVar;
            Queue<b<?>> queue = f4016d;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a2, i2, i3);
            return bVar;
        }

        private void b(A a2, int i2, int i3) {
            this.f4019c = a2;
            this.f4018b = i2;
            this.f4017a = i3;
        }

        public void c() {
            Queue<b<?>> queue = f4016d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f4018b == bVar.f4018b && this.f4017a == bVar.f4017a && this.f4019c.equals(bVar.f4019c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f4017a * 31) + this.f4018b) * 31) + this.f4019c.hashCode();
        }
    }

    public m(long j2) {
        this.f4015a = new a(this, j2);
    }

    public B a(A a2, int i2, int i3) {
        b<A> a3 = b.a(a2, i2, i3);
        B g2 = this.f4015a.g(a3);
        a3.c();
        return g2;
    }

    public void b(A a2, int i2, int i3, B b2) {
        this.f4015a.k(b.a(a2, i2, i3), b2);
    }
}
