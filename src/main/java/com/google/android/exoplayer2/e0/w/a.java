package com.google.android.exoplayer2.e0.w;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.io.IOException;

/* compiled from: RawCcExtractor */
public final class a implements g {

    /* renamed from: i  reason: collision with root package name */
    private static final int f5395i = d0.B("RCC\u0001");

    /* renamed from: a  reason: collision with root package name */
    private final l f5396a;

    /* renamed from: b  reason: collision with root package name */
    private final s f5397b = new s(9);

    /* renamed from: c  reason: collision with root package name */
    private q f5398c;

    /* renamed from: d  reason: collision with root package name */
    private int f5399d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f5400e;

    /* renamed from: f  reason: collision with root package name */
    private long f5401f;

    /* renamed from: g  reason: collision with root package name */
    private int f5402g;

    /* renamed from: h  reason: collision with root package name */
    private int f5403h;

    public a(l lVar) {
        this.f5396a = lVar;
    }

    private boolean b(h hVar) {
        this.f5397b.G();
        if (!hVar.c(this.f5397b.f7062a, 0, 8, true)) {
            return false;
        }
        if (this.f5397b.j() == f5395i) {
            this.f5400e = this.f5397b.y();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    private void d(h hVar) {
        while (this.f5402g > 0) {
            this.f5397b.G();
            hVar.readFully(this.f5397b.f7062a, 0, 3);
            this.f5398c.a(this.f5397b, 3);
            this.f5403h += 3;
            this.f5402g--;
        }
        int i2 = this.f5403h;
        if (i2 > 0) {
            this.f5398c.c(this.f5401f, 1, i2, 0, null);
        }
    }

    private boolean g(h hVar) {
        this.f5397b.G();
        int i2 = this.f5400e;
        if (i2 == 0) {
            if (!hVar.c(this.f5397b.f7062a, 0, 5, true)) {
                return false;
            }
            this.f5401f = (this.f5397b.A() * 1000) / 45;
        } else if (i2 != 1) {
            throw new ParserException("Unsupported version number: " + this.f5400e);
        } else if (!hVar.c(this.f5397b.f7062a, 0, 9, true)) {
            return false;
        } else {
            this.f5401f = this.f5397b.r();
        }
        this.f5402g = this.f5397b.y();
        this.f5403h = 0;
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        iVar.e(new o.b(-9223372036854775807L));
        this.f5398c = iVar.a(0, 3);
        iVar.h();
        this.f5398c.d(this.f5396a);
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.f5399d = 0;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        this.f5397b.G();
        hVar.j(this.f5397b.f7062a, 0, 8);
        if (this.f5397b.j() == f5395i) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        while (true) {
            int i2 = this.f5399d;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        d(hVar);
                        this.f5399d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (g(hVar)) {
                    this.f5399d = 2;
                } else {
                    this.f5399d = 0;
                    return -1;
                }
            } else if (!b(hVar)) {
                return -1;
            } else {
                this.f5399d = 1;
            }
        }
    }
}
