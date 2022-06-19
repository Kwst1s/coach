package com.google.android.exoplayer2.source.dash.k;

import java.util.Collections;
import java.util.List;

/* compiled from: AdaptationSet */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f6238a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6239b;

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f6240c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f6241d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d> f6242e;

    public a(int i2, int i3, List<i> list, List<d> list2, List<d> list3) {
        List<d> list4;
        List<d> list5;
        this.f6238a = i2;
        this.f6239b = i3;
        this.f6240c = Collections.unmodifiableList(list);
        if (list2 == null) {
            list4 = Collections.emptyList();
        } else {
            list4 = Collections.unmodifiableList(list2);
        }
        this.f6241d = list4;
        if (list3 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = Collections.unmodifiableList(list3);
        }
        this.f6242e = list5;
    }
}
