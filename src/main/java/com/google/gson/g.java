package com.google.gson;

import com.github.mikephil.charting.BuildConfig;
import com.google.gson.u.d;
import com.google.gson.u.m.m;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GsonBuilder */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private d f8298a = d.f8345h;

    /* renamed from: b  reason: collision with root package name */
    private q f8299b = q.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private e f8300c = d.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, h<?>> f8301d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<s> f8302e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<s> f8303f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f8304g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f8305h;

    /* renamed from: i  reason: collision with root package name */
    private int f8306i = 2;

    /* renamed from: j  reason: collision with root package name */
    private int f8307j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8308k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    private void a(String str, int i2, int i3, List<s> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !BuildConfig.FLAVOR.equals(str.trim())) {
            aVar2 = new a(Date.class, str);
            aVar = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
        } else if (i2 != 2 && i3 != 2) {
            a aVar4 = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar2 = aVar4;
            aVar = aVar5;
            aVar3 = aVar6;
        } else {
            return;
        }
        list.add(m.a(Date.class, aVar2));
        list.add(m.a(Timestamp.class, aVar));
        list.add(m.a(java.sql.Date.class, aVar3));
    }

    public f b() {
        List<s> arrayList = new ArrayList<>(this.f8302e.size() + this.f8303f.size() + 3);
        arrayList.addAll(this.f8302e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f8303f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f8305h, this.f8306i, this.f8307j, arrayList);
        return new f(this.f8298a, this.f8300c, this.f8301d, this.f8304g, this.f8308k, this.o, this.m, this.n, this.p, this.l, this.f8299b, this.f8305h, this.f8306i, this.f8307j, this.f8302e, this.f8303f, arrayList);
    }
}
