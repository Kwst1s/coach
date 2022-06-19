package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import i.e0;
import i.g0;
import i.h0;
import i.i;
import java.io.IOException;

/* access modifiers changed from: package-private */
/* compiled from: NetworkRequestHandler */
public class r extends y {

    /* renamed from: a  reason: collision with root package name */
    private final j f8738a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f8739b;

    /* access modifiers changed from: package-private */
    /* compiled from: NetworkRequestHandler */
    public static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    /* compiled from: NetworkRequestHandler */
    static final class b extends IOException {

        /* renamed from: b  reason: collision with root package name */
        final int f8740b;

        /* renamed from: c  reason: collision with root package name */
        final int f8741c;

        b(int i2, int i3) {
            super("HTTP " + i2);
            this.f8740b = i2;
            this.f8741c = i3;
        }
    }

    r(j jVar, a0 a0Var) {
        this.f8738a = jVar;
        this.f8739b = a0Var;
    }

    private static e0 j(w wVar, int i2) {
        i iVar;
        if (i2 == 0) {
            iVar = null;
        } else if (q.a(i2)) {
            iVar = i.n;
        } else {
            i.a aVar = new i.a();
            if (!q.c(i2)) {
                aVar.c();
            }
            if (!q.d(i2)) {
                aVar.d();
            }
            iVar = aVar.a();
        }
        e0.a aVar2 = new e0.a();
        aVar2.g(wVar.f8789d.toString());
        if (iVar != null) {
            aVar2.b(iVar);
        }
        return aVar2.a();
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        String scheme = wVar.f8789d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.y
    public int e() {
        return 2;
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i2) {
        g0 a2 = this.f8738a.a(j(wVar, i2));
        h0 l = a2.l();
        if (a2.L()) {
            t.e eVar = a2.F() == null ? t.e.NETWORK : t.e.DISK;
            if (eVar == t.e.DISK && l.l() == 0) {
                l.close();
                throw new a("Received response with 0 content-length header.");
            }
            if (eVar == t.e.NETWORK && l.l() > 0) {
                this.f8739b.f(l.l());
            }
            return new y.a(l.G(), eVar);
        }
        l.close();
        throw new b(a2.G(), wVar.f8788c);
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.y
    public boolean h(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    @Override // com.squareup.picasso.y
    public boolean i() {
        return true;
    }
}
