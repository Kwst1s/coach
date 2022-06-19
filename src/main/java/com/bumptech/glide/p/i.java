package com.bumptech.glide.p;

import com.bumptech.glide.p.d;

/* compiled from: ThumbnailRequestCoordinator */
public class i implements d, c {

    /* renamed from: a  reason: collision with root package name */
    private final d f4332a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f4333b;

    /* renamed from: c  reason: collision with root package name */
    private volatile c f4334c;

    /* renamed from: d  reason: collision with root package name */
    private volatile c f4335d;

    /* renamed from: e  reason: collision with root package name */
    private d.a f4336e;

    /* renamed from: f  reason: collision with root package name */
    private d.a f4337f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4338g;

    public i(Object obj, d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f4336e = aVar;
        this.f4337f = aVar;
        this.f4333b = obj;
        this.f4332a = dVar;
    }

    private boolean m() {
        d dVar = this.f4332a;
        return dVar == null || dVar.l(this);
    }

    private boolean n() {
        d dVar = this.f4332a;
        return dVar == null || dVar.b(this);
    }

    private boolean o() {
        d dVar = this.f4332a;
        return dVar == null || dVar.g(this);
    }

    @Override // com.bumptech.glide.p.d
    public void a(c cVar) {
        synchronized (this.f4333b) {
            if (!cVar.equals(this.f4334c)) {
                this.f4337f = d.a.FAILED;
                return;
            }
            this.f4336e = d.a.FAILED;
            d dVar = this.f4332a;
            if (dVar != null) {
                dVar.a(this);
            }
        }
    }

    @Override // com.bumptech.glide.p.d
    public boolean b(c cVar) {
        boolean z;
        synchronized (this.f4333b) {
            z = n() && cVar.equals(this.f4334c) && !d();
        }
        return z;
    }

    @Override // com.bumptech.glide.p.c
    public void c() {
        synchronized (this.f4333b) {
            if (!this.f4337f.a()) {
                this.f4337f = d.a.PAUSED;
                this.f4335d.c();
            }
            if (!this.f4336e.a()) {
                this.f4336e = d.a.PAUSED;
                this.f4334c.c();
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public void clear() {
        synchronized (this.f4333b) {
            this.f4338g = false;
            d.a aVar = d.a.CLEARED;
            this.f4336e = aVar;
            this.f4337f = aVar;
            this.f4335d.clear();
            this.f4334c.clear();
        }
    }

    @Override // com.bumptech.glide.p.c, com.bumptech.glide.p.d
    public boolean d() {
        boolean z;
        synchronized (this.f4333b) {
            if (!this.f4335d.d()) {
                if (!this.f4334c.d()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // com.bumptech.glide.p.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(com.bumptech.glide.p.c r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.p.i
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.p.i r4 = (com.bumptech.glide.p.i) r4
            com.bumptech.glide.p.c r0 = r3.f4334c
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.p.c r0 = r4.f4334c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.p.c r0 = r3.f4334c
            com.bumptech.glide.p.c r2 = r4.f4334c
            boolean r0 = r0.e(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.p.c r0 = r3.f4335d
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.p.c r4 = r4.f4335d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.p.c r0 = r3.f4335d
            com.bumptech.glide.p.c r4 = r4.f4335d
            boolean r4 = r0.e(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p.i.e(com.bumptech.glide.p.c):boolean");
    }

    @Override // com.bumptech.glide.p.c
    public boolean f() {
        boolean z;
        synchronized (this.f4333b) {
            z = this.f4336e == d.a.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public boolean g(c cVar) {
        boolean z;
        synchronized (this.f4333b) {
            z = o() && (cVar.equals(this.f4334c) || this.f4336e != d.a.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public d h() {
        d h2;
        synchronized (this.f4333b) {
            d dVar = this.f4332a;
            h2 = dVar != null ? dVar.h() : this;
        }
        return h2;
    }

    @Override // com.bumptech.glide.p.c
    public void i() {
        d.a aVar;
        d.a aVar2;
        synchronized (this.f4333b) {
            this.f4338g = true;
            try {
                if (!(this.f4336e == d.a.SUCCESS || this.f4337f == (aVar2 = d.a.RUNNING))) {
                    this.f4337f = aVar2;
                    this.f4335d.i();
                }
                if (this.f4338g && this.f4336e != (aVar = d.a.RUNNING)) {
                    this.f4336e = aVar;
                    this.f4334c.i();
                }
            } finally {
                this.f4338g = false;
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.f4333b) {
            z = this.f4336e == d.a.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public void j(c cVar) {
        synchronized (this.f4333b) {
            if (cVar.equals(this.f4335d)) {
                this.f4337f = d.a.SUCCESS;
                return;
            }
            this.f4336e = d.a.SUCCESS;
            d dVar = this.f4332a;
            if (dVar != null) {
                dVar.j(this);
            }
            if (!this.f4337f.a()) {
                this.f4335d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public boolean k() {
        boolean z;
        synchronized (this.f4333b) {
            z = this.f4336e == d.a.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public boolean l(c cVar) {
        boolean z;
        synchronized (this.f4333b) {
            z = m() && cVar.equals(this.f4334c) && this.f4336e != d.a.PAUSED;
        }
        return z;
    }

    public void p(c cVar, c cVar2) {
        this.f4334c = cVar;
        this.f4335d = cVar2;
    }
}
