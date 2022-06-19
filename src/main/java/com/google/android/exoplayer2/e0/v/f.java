package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.io.EOFException;

/* access modifiers changed from: package-private */
/* compiled from: OggPageHeader */
public final class f {

    /* renamed from: i  reason: collision with root package name */
    private static final int f5358i = d0.B("OggS");

    /* renamed from: a  reason: collision with root package name */
    public int f5359a;

    /* renamed from: b  reason: collision with root package name */
    public int f5360b;

    /* renamed from: c  reason: collision with root package name */
    public long f5361c;

    /* renamed from: d  reason: collision with root package name */
    public int f5362d;

    /* renamed from: e  reason: collision with root package name */
    public int f5363e;

    /* renamed from: f  reason: collision with root package name */
    public int f5364f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f5365g = new int[255];

    /* renamed from: h  reason: collision with root package name */
    private final s f5366h = new s(255);

    f() {
    }

    public boolean a(h hVar, boolean z) {
        this.f5366h.G();
        b();
        if (!(hVar.d() == -1 || hVar.d() - hVar.i() >= 27) || !hVar.h(this.f5366h.f7062a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.f5366h.A() == ((long) f5358i)) {
            int y = this.f5366h.y();
            this.f5359a = y;
            if (y == 0) {
                this.f5360b = this.f5366h.y();
                this.f5361c = this.f5366h.n();
                this.f5366h.o();
                this.f5366h.o();
                this.f5366h.o();
                int y2 = this.f5366h.y();
                this.f5362d = y2;
                this.f5363e = y2 + 27;
                this.f5366h.G();
                hVar.j(this.f5366h.f7062a, 0, this.f5362d);
                for (int i2 = 0; i2 < this.f5362d; i2++) {
                    this.f5365g[i2] = this.f5366h.y();
                    this.f5364f += this.f5365g[i2];
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new ParserException("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
    }

    public void b() {
        this.f5359a = 0;
        this.f5360b = 0;
        this.f5361c = 0;
        this.f5362d = 0;
        this.f5363e = 0;
        this.f5364f = 0;
    }
}
