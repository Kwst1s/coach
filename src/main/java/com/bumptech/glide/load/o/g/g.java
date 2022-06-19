package com.bumptech.glide.load.o.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.l;
import com.bumptech.glide.r.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: GifFrameLoader */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.l.a f4126a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f4127b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f4128c;

    /* renamed from: d  reason: collision with root package name */
    final i f4129d;

    /* renamed from: e  reason: collision with root package name */
    private final e f4130e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4131f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4132g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4133h;

    /* renamed from: i  reason: collision with root package name */
    private h<Bitmap> f4134i;

    /* renamed from: j  reason: collision with root package name */
    private a f4135j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4136k;
    private a l;
    private Bitmap m;
    private l<Bitmap> n;
    private a o;
    private d p;
    private int q;
    private int r;
    private int s;

    /* access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader */
    public static class a extends com.bumptech.glide.p.j.c<Bitmap> {

        /* renamed from: e  reason: collision with root package name */
        private final Handler f4137e;

        /* renamed from: f  reason: collision with root package name */
        final int f4138f;

        /* renamed from: g  reason: collision with root package name */
        private final long f4139g;

        /* renamed from: h  reason: collision with root package name */
        private Bitmap f4140h;

        a(Handler handler, int i2, long j2) {
            this.f4137e = handler;
            this.f4138f = i2;
            this.f4139g = j2;
        }

        @Override // com.bumptech.glide.p.j.h
        public void h(Drawable drawable) {
            this.f4140h = null;
        }

        /* access modifiers changed from: package-private */
        public Bitmap l() {
            return this.f4140h;
        }

        /* renamed from: m */
        public void c(Bitmap bitmap, com.bumptech.glide.p.k.b<? super Bitmap> bVar) {
            this.f4140h = bitmap;
            this.f4137e.sendMessageAtTime(this.f4137e.obtainMessage(1, this), this.f4139g);
        }
    }

    /* compiled from: GifFrameLoader */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader */
    private class c implements Handler.Callback {
        c() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.m((a) message.obj);
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                g.this.f4129d.o((a) message.obj);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader */
    public interface d {
        void a();
    }

    g(com.bumptech.glide.b bVar, com.bumptech.glide.l.a aVar, int i2, int i3, l<Bitmap> lVar, Bitmap bitmap) {
        this(bVar.f(), com.bumptech.glide.b.u(bVar.h()), aVar, null, i(com.bumptech.glide.b.u(bVar.h()), i2, i3), lVar, bitmap);
    }

    private static f g() {
        return new com.bumptech.glide.q.b(Double.valueOf(Math.random()));
    }

    private static h<Bitmap> i(i iVar, int i2, int i3) {
        return iVar.m().a(((com.bumptech.glide.p.f) ((com.bumptech.glide.p.f) com.bumptech.glide.p.f.e0(j.f3778a).c0(true)).X(true)).P(i2, i3));
    }

    private void l() {
        if (this.f4131f && !this.f4132g) {
            if (this.f4133h) {
                com.bumptech.glide.r.j.a(this.o == null, "Pending target must be null when starting from the first frame");
                this.f4126a.h();
                this.f4133h = false;
            }
            a aVar = this.o;
            if (aVar != null) {
                this.o = null;
                m(aVar);
                return;
            }
            this.f4132g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f4126a.e());
            this.f4126a.c();
            this.l = new a(this.f4127b, this.f4126a.a(), uptimeMillis);
            h<Bitmap> e0 = this.f4134i.a(com.bumptech.glide.p.f.f0(g()));
            e0.r0(this.f4126a);
            e0.l0(this.l);
        }
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f4130e.d(bitmap);
            this.m = null;
        }
    }

    private void p() {
        if (!this.f4131f) {
            this.f4131f = true;
            this.f4136k = false;
            l();
        }
    }

    private void q() {
        this.f4131f = false;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f4128c.clear();
        n();
        q();
        a aVar = this.f4135j;
        if (aVar != null) {
            this.f4129d.o(aVar);
            this.f4135j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f4129d.o(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f4129d.o(aVar3);
            this.o = null;
        }
        this.f4126a.clear();
        this.f4136k = true;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f4126a.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f4135j;
        return aVar != null ? aVar.l() : this.m;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f4135j;
        if (aVar != null) {
            return aVar.f4138f;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Bitmap e() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f4126a.d();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f4126a.f() + this.q;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public void m(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f4132g = false;
        if (this.f4136k) {
            this.f4127b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f4131f) {
            this.o = aVar;
        } else {
            if (aVar.l() != null) {
                n();
                a aVar2 = this.f4135j;
                this.f4135j = aVar;
                for (int size = this.f4128c.size() - 1; size >= 0; size--) {
                    this.f4128c.get(size).a();
                }
                if (aVar2 != null) {
                    this.f4127b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public void o(l<Bitmap> lVar, Bitmap bitmap) {
        com.bumptech.glide.r.j.d(lVar);
        this.n = lVar;
        com.bumptech.glide.r.j.d(bitmap);
        this.m = bitmap;
        this.f4134i = this.f4134i.a(new com.bumptech.glide.p.f().Y(lVar));
        this.q = k.g(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    /* access modifiers changed from: package-private */
    public void r(b bVar) {
        if (this.f4136k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f4128c.contains(bVar)) {
            boolean isEmpty = this.f4128c.isEmpty();
            this.f4128c.add(bVar);
            if (isEmpty) {
                p();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public void s(b bVar) {
        this.f4128c.remove(bVar);
        if (this.f4128c.isEmpty()) {
            q();
        }
    }

    g(e eVar, i iVar, com.bumptech.glide.l.a aVar, Handler handler, h<Bitmap> hVar, l<Bitmap> lVar, Bitmap bitmap) {
        this.f4128c = new ArrayList();
        this.f4129d = iVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f4130e = eVar;
        this.f4127b = handler;
        this.f4134i = hVar;
        this.f4126a = aVar;
        o(lVar, bitmap);
    }
}
