package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.text.k.g;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.s;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: UserDataReader */
public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    private final List<l> f5478a;

    /* renamed from: b  reason: collision with root package name */
    private final q[] f5479b;

    public g0(List<l> list) {
        this.f5478a = list;
        this.f5479b = new q[list.size()];
    }

    public void a(long j2, s sVar) {
        if (sVar.a() >= 9) {
            int j3 = sVar.j();
            int j4 = sVar.j();
            int y = sVar.y();
            if (j3 == 434 && j4 == g.f6710a && y == 3) {
                g.b(j2, sVar, this.f5479b);
            }
        }
    }

    public void b(i iVar, e0.d dVar) {
        for (int i2 = 0; i2 < this.f5479b.length; i2++) {
            dVar.a();
            q a2 = iVar.a(dVar.c(), 3);
            l lVar = this.f5478a.get(i2);
            String str = lVar.f5977h;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            e.b(z, "Invalid closed caption mime type provided: " + str);
            a2.d(l.C(dVar.b(), str, null, -1, lVar.z, lVar.A, lVar.B, null, Long.MAX_VALUE, lVar.f5979j));
            this.f5479b[i2] = a2;
        }
    }
}
