package com.google.android.exoplayer2.source.dash.k;

import java.util.Collections;
import java.util.List;

/* compiled from: Period */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f6274a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6275b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f6276c;

    /* renamed from: d  reason: collision with root package name */
    public final List<e> f6277d;

    public f(String str, long j2, List<a> list, List<e> list2) {
        this.f6274a = str;
        this.f6275b = j2;
        this.f6276c = Collections.unmodifiableList(list);
        this.f6277d = Collections.unmodifiableList(list2);
    }

    public int a(int i2) {
        int size = this.f6276c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f6276c.get(i3).f6239b == i2) {
                return i3;
            }
        }
        return -1;
    }
}
