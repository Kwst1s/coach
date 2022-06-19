package j;

import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Segment */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f10696a;

    /* renamed from: b  reason: collision with root package name */
    int f10697b;

    /* renamed from: c  reason: collision with root package name */
    int f10698c;

    /* renamed from: d  reason: collision with root package name */
    boolean f10699d;

    /* renamed from: e  reason: collision with root package name */
    boolean f10700e;

    /* renamed from: f  reason: collision with root package name */
    p f10701f;

    /* renamed from: g  reason: collision with root package name */
    p f10702g;

    p() {
        this.f10696a = new byte[8192];
        this.f10700e = true;
        this.f10699d = false;
    }

    public final void a() {
        p pVar = this.f10702g;
        if (pVar == this) {
            throw new IllegalStateException();
        } else if (pVar.f10700e) {
            int i2 = this.f10698c - this.f10697b;
            if (i2 <= (8192 - pVar.f10698c) + (pVar.f10699d ? 0 : pVar.f10697b)) {
                f(pVar, i2);
                b();
                q.a(this);
            }
        }
    }

    @Nullable
    public final p b() {
        p pVar = this.f10701f;
        p pVar2 = pVar != this ? pVar : null;
        p pVar3 = this.f10702g;
        pVar3.f10701f = pVar;
        this.f10701f.f10702g = pVar3;
        this.f10701f = null;
        this.f10702g = null;
        return pVar2;
    }

    public final p c(p pVar) {
        pVar.f10702g = this;
        pVar.f10701f = this.f10701f;
        this.f10701f.f10702g = pVar;
        this.f10701f = pVar;
        return pVar;
    }

    /* access modifiers changed from: package-private */
    public final p d() {
        this.f10699d = true;
        return new p(this.f10696a, this.f10697b, this.f10698c, true, false);
    }

    public final p e(int i2) {
        p pVar;
        if (i2 <= 0 || i2 > this.f10698c - this.f10697b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            pVar = d();
        } else {
            pVar = q.b();
            System.arraycopy(this.f10696a, this.f10697b, pVar.f10696a, 0, i2);
        }
        pVar.f10698c = pVar.f10697b + i2;
        this.f10697b += i2;
        this.f10702g.c(pVar);
        return pVar;
    }

    public final void f(p pVar, int i2) {
        if (pVar.f10700e) {
            int i3 = pVar.f10698c;
            if (i3 + i2 > 8192) {
                if (!pVar.f10699d) {
                    int i4 = pVar.f10697b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = pVar.f10696a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        pVar.f10698c -= pVar.f10697b;
                        pVar.f10697b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f10696a, this.f10697b, pVar.f10696a, pVar.f10698c, i2);
            pVar.f10698c += i2;
            this.f10697b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    p(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f10696a = bArr;
        this.f10697b = i2;
        this.f10698c = i3;
        this.f10699d = z;
        this.f10700e = z2;
    }
}
