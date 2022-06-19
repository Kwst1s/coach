package com.google.android.exoplayer2.g0;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.z;

/* compiled from: TrackSelectorResult */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f5852a;

    /* renamed from: b  reason: collision with root package name */
    public final z[] f5853b;

    /* renamed from: c  reason: collision with root package name */
    public final h f5854c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f5855d;

    public j(z[] zVarArr, g[] gVarArr, Object obj) {
        this.f5853b = zVarArr;
        this.f5854c = new h(gVarArr);
        this.f5855d = obj;
        this.f5852a = zVarArr.length;
    }

    public boolean a(j jVar) {
        if (jVar == null || jVar.f5854c.f5848a != this.f5854c.f5848a) {
            return false;
        }
        for (int i2 = 0; i2 < this.f5854c.f5848a; i2++) {
            if (!b(jVar, i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(j jVar, int i2) {
        if (jVar != null && d0.b(this.f5853b[i2], jVar.f5853b[i2]) && d0.b(this.f5854c.a(i2), jVar.f5854c.a(i2))) {
            return true;
        }
        return false;
    }

    public boolean c(int i2) {
        return this.f5853b[i2] != null;
    }
}
