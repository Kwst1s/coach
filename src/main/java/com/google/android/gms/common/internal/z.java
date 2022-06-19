package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.e;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f7421a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private e f7422b;

    public z(e eVar) {
        n.f(eVar);
        this.f7422b = eVar;
    }

    public final int a(Context context, int i2) {
        return this.f7421a.get(i2, -1);
    }

    public final int b(Context context, a.f fVar) {
        n.f(context);
        n.f(fVar);
        int i2 = 0;
        if (!fVar.f()) {
            return 0;
        }
        int g2 = fVar.g();
        int a2 = a(context, g2);
        if (a2 != -1) {
            return a2;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f7421a.size()) {
                i2 = a2;
                break;
            }
            int keyAt = this.f7421a.keyAt(i3);
            if (keyAt > g2 && this.f7421a.get(keyAt) == 0) {
                break;
            }
            i3++;
        }
        if (i2 == -1) {
            i2 = this.f7422b.g(context, g2);
        }
        this.f7421a.put(g2, i2);
        return i2;
    }

    public final void c() {
        this.f7421a.clear();
    }
}
