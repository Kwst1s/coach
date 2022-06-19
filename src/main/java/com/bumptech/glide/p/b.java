package com.bumptech.glide.p;

import com.bumptech.glide.p.d;

/* compiled from: ErrorRequestCoordinator */
public final class b implements d, c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4301a;

    /* renamed from: b  reason: collision with root package name */
    private final d f4302b;

    /* renamed from: c  reason: collision with root package name */
    private volatile c f4303c;

    /* renamed from: d  reason: collision with root package name */
    private volatile c f4304d;

    /* renamed from: e  reason: collision with root package name */
    private d.a f4305e;

    /* renamed from: f  reason: collision with root package name */
    private d.a f4306f;

    public b(Object obj, d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f4305e = aVar;
        this.f4306f = aVar;
        this.f4301a = obj;
        this.f4302b = dVar;
    }

    private boolean m(c cVar) {
        return cVar.equals(this.f4303c) || (this.f4305e == d.a.FAILED && cVar.equals(this.f4304d));
    }

    private boolean n() {
        d dVar = this.f4302b;
        return dVar == null || dVar.l(this);
    }

    private boolean o() {
        d dVar = this.f4302b;
        return dVar == null || dVar.b(this);
    }

    private boolean p() {
        d dVar = this.f4302b;
        return dVar == null || dVar.g(this);
    }

    @Override // com.bumptech.glide.p.d
    public void a(c cVar) {
        synchronized (this.f4301a) {
            if (!cVar.equals(this.f4304d)) {
                this.f4305e = d.a.FAILED;
                d.a aVar = this.f4306f;
                d.a aVar2 = d.a.RUNNING;
                if (aVar != aVar2) {
                    this.f4306f = aVar2;
                    this.f4304d.i();
                }
                return;
            }
            this.f4306f = d.a.FAILED;
            d dVar = this.f4302b;
            if (dVar != null) {
                dVar.a(this);
            }
        }
    }

    @Override // com.bumptech.glide.p.d
    public boolean b(c cVar) {
        boolean z;
        synchronized (this.f4301a) {
            z = o() && m(cVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.p.c
    public void c() {
        synchronized (this.f4301a) {
            d.a aVar = this.f4305e;
            d.a aVar2 = d.a.RUNNING;
            if (aVar == aVar2) {
                this.f4305e = d.a.PAUSED;
                this.f4303c.c();
            }
            if (this.f4306f == aVar2) {
                this.f4306f = d.a.PAUSED;
                this.f4304d.c();
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public void clear() {
        synchronized (this.f4301a) {
            d.a aVar = d.a.CLEARED;
            this.f4305e = aVar;
            this.f4303c.clear();
            if (this.f4306f != aVar) {
                this.f4306f = aVar;
                this.f4304d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.p.c, com.bumptech.glide.p.d
    public boolean d() {
        boolean z;
        synchronized (this.f4301a) {
            if (!this.f4303c.d()) {
                if (!this.f4304d.d()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.p.c
    public boolean e(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        if (!this.f4303c.e(bVar.f4303c) || !this.f4304d.e(bVar.f4304d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.p.c
    public boolean f() {
        boolean z;
        synchronized (this.f4301a) {
            d.a aVar = this.f4305e;
            d.a aVar2 = d.a.CLEARED;
            z = aVar == aVar2 && this.f4306f == aVar2;
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public boolean g(c cVar) {
        boolean z;
        synchronized (this.f4301a) {
            z = p() && m(cVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public d h() {
        d h2;
        synchronized (this.f4301a) {
            d dVar = this.f4302b;
            h2 = dVar != null ? dVar.h() : this;
        }
        return h2;
    }

    @Override // com.bumptech.glide.p.c
    public void i() {
        synchronized (this.f4301a) {
            d.a aVar = this.f4305e;
            d.a aVar2 = d.a.RUNNING;
            if (aVar != aVar2) {
                this.f4305e = aVar2;
                this.f4303c.i();
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.f4301a) {
            d.a aVar = this.f4305e;
            d.a aVar2 = d.a.RUNNING;
            if (aVar != aVar2) {
                if (this.f4306f != aVar2) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public void j(c cVar) {
        synchronized (this.f4301a) {
            if (cVar.equals(this.f4303c)) {
                this.f4305e = d.a.SUCCESS;
            } else if (cVar.equals(this.f4304d)) {
                this.f4306f = d.a.SUCCESS;
            }
            d dVar = this.f4302b;
            if (dVar != null) {
                dVar.j(this);
            }
        }
    }

    @Override // com.bumptech.glide.p.c
    public boolean k() {
        boolean z;
        synchronized (this.f4301a) {
            d.a aVar = this.f4305e;
            d.a aVar2 = d.a.SUCCESS;
            if (aVar != aVar2) {
                if (this.f4306f != aVar2) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.p.d
    public boolean l(c cVar) {
        boolean z;
        synchronized (this.f4301a) {
            z = n() && m(cVar);
        }
        return z;
    }

    public void q(c cVar, c cVar2) {
        this.f4303c = cVar;
        this.f4304d = cVar2;
    }
}
