package com.google.android.exoplayer2.source.hls.playlist;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.offline.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: HlsMasterPlaylist */
public final class d extends f {

    /* renamed from: j  reason: collision with root package name */
    public static final d f6458j = new d(BuildConfig.FLAVOR, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap());

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f6459d;

    /* renamed from: e  reason: collision with root package name */
    public final List<a> f6460e;

    /* renamed from: f  reason: collision with root package name */
    public final List<a> f6461f;

    /* renamed from: g  reason: collision with root package name */
    public final l f6462g;

    /* renamed from: h  reason: collision with root package name */
    public final List<l> f6463h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, String> f6464i;

    /* compiled from: HlsMasterPlaylist */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f6465a;

        /* renamed from: b  reason: collision with root package name */
        public final l f6466b;

        public a(String str, l lVar) {
            this.f6465a = str;
            this.f6466b = lVar;
        }

        public static a a(String str) {
            return new a(str, l.u("0", null, "application/x-mpegURL", null, null, -1, 0, null));
        }
    }

    public d(String str, List<String> list, List<a> list2, List<a> list3, List<a> list4, l lVar, List<l> list5, boolean z, Map<String, String> map) {
        super(str, list, z);
        this.f6459d = Collections.unmodifiableList(list2);
        this.f6460e = Collections.unmodifiableList(list3);
        this.f6461f = Collections.unmodifiableList(list4);
        this.f6462g = lVar;
        this.f6463h = list5 != null ? Collections.unmodifiableList(list5) : null;
        this.f6464i = Collections.unmodifiableMap(map);
    }

    private static List<a> c(List<a> list, int i2, List<c> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            a aVar = list.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= list2.size()) {
                    break;
                }
                c cVar = list2.get(i4);
                if (cVar.f6022c == i2 && cVar.f6023d == i3) {
                    arrayList.add(aVar);
                    break;
                }
                i4++;
            }
        }
        return arrayList;
    }

    public static d d(String str) {
        List singletonList = Collections.singletonList(a.a(str));
        List emptyList = Collections.emptyList();
        return new d(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null, false, Collections.emptyMap());
    }

    /* renamed from: b */
    public d a(List<c> list) {
        return new d(this.f6485a, this.f6486b, c(this.f6459d, 0, list), c(this.f6460e, 1, list), c(this.f6461f, 2, list), this.f6462g, this.f6463h, this.f6487c, this.f6464i);
    }
}
