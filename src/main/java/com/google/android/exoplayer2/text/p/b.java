package com.google.android.exoplayer2.text.p;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.util.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* access modifiers changed from: package-private */
/* compiled from: TtmlNode */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f6780a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6781b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6782c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6783d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6784e;

    /* renamed from: f  reason: collision with root package name */
    public final e f6785f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6786g;

    /* renamed from: h  reason: collision with root package name */
    private final String[] f6787h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<String, Integer> f6788i;

    /* renamed from: j  reason: collision with root package name */
    private final HashMap<String, Integer> f6789j;

    /* renamed from: k  reason: collision with root package name */
    private List<b> f6790k;

    private b(String str, String str2, long j2, long j3, e eVar, String[] strArr, String str3) {
        this.f6780a = str;
        this.f6781b = str2;
        this.f6785f = eVar;
        this.f6787h = strArr;
        this.f6782c = str2 != null;
        this.f6783d = j2;
        this.f6784e = j3;
        e.e(str3);
        this.f6786g = str3;
        this.f6788i = new HashMap<>();
        this.f6789j = new HashMap<>();
    }

    private void b(Map<String, e> map, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        e d2 = d.d(this.f6785f, this.f6787h, map);
        if (d2 != null) {
            d.a(spannableStringBuilder, i2, i3, d2);
        }
    }

    public static b c(String str, long j2, long j3, e eVar, String[] strArr, String str2) {
        return new b(str, null, j2, j3, eVar, strArr, str2);
    }

    public static b d(String str) {
        return new b(null, d.b(str), -9223372036854775807L, -9223372036854775807L, null, null, BuildConfig.FLAVOR);
    }

    private SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder) {
        int i2;
        int i3;
        int length = spannableStringBuilder.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (spannableStringBuilder.charAt(i5) == ' ') {
                int i6 = i5 + 1;
                int i7 = i6;
                while (i7 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i7) == ' ') {
                    i7++;
                }
                int i8 = i7 - i6;
                if (i8 > 0) {
                    spannableStringBuilder.delete(i5, i5 + i8);
                    length -= i8;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i9 = 0;
        while (true) {
            i2 = length - 1;
            if (i9 >= i2) {
                break;
            }
            if (spannableStringBuilder.charAt(i9) == '\n') {
                int i10 = i9 + 1;
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    spannableStringBuilder.delete(i10, i9 + 2);
                    length--;
                }
            }
            i9++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == ' ') {
            spannableStringBuilder.delete(i2, length);
            length--;
        }
        while (true) {
            i3 = length - 1;
            if (i4 >= i3) {
                break;
            }
            if (spannableStringBuilder.charAt(i4) == ' ') {
                int i11 = i4 + 1;
                if (spannableStringBuilder.charAt(i11) == '\n') {
                    spannableStringBuilder.delete(i4, i11);
                    length--;
                }
            }
            i4++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == '\n') {
            spannableStringBuilder.delete(i3, length);
        }
        return spannableStringBuilder;
    }

    private void i(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f6780a);
        if (z || equals) {
            long j2 = this.f6783d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f6784e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f6790k != null) {
            for (int i2 = 0; i2 < this.f6790k.size(); i2++) {
                this.f6790k.get(i2).i(treeSet, z || equals);
            }
        }
    }

    private static SpannableStringBuilder k(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void m(long j2, Map<String, e> map, Map<String, SpannableStringBuilder> map2) {
        int i2;
        if (l(j2)) {
            Iterator<Map.Entry<String, Integer>> it = this.f6789j.entrySet().iterator();
            while (true) {
                i2 = 0;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                if (this.f6788i.containsKey(key)) {
                    i2 = this.f6788i.get(key).intValue();
                }
                int intValue = next.getValue().intValue();
                if (i2 != intValue) {
                    b(map, map2.get(key), i2, intValue);
                }
            }
            while (i2 < g()) {
                f(i2).m(j2, map, map2);
                i2++;
            }
        }
    }

    private void n(long j2, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f6788i.clear();
        this.f6789j.clear();
        if (!"metadata".equals(this.f6780a)) {
            if (!BuildConfig.FLAVOR.equals(this.f6786g)) {
                str = this.f6786g;
            }
            if (this.f6782c && z) {
                k(str, map).append((CharSequence) this.f6781b);
            } else if ("br".equals(this.f6780a) && z) {
                k(str, map).append('\n');
            } else if (l(j2)) {
                for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                    this.f6788i.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
                }
                boolean equals = "p".equals(this.f6780a);
                for (int i2 = 0; i2 < g(); i2++) {
                    f(i2).n(j2, z || equals, str, map);
                }
                if (equals) {
                    d.c(k(str, map));
                }
                for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                    this.f6789j.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
                }
            }
        }
    }

    public void a(b bVar) {
        if (this.f6790k == null) {
            this.f6790k = new ArrayList();
        }
        this.f6790k.add(bVar);
    }

    public b f(int i2) {
        List<b> list = this.f6790k;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<b> list = this.f6790k;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<a> h(long j2, Map<String, e> map, Map<String, c> map2) {
        TreeMap treeMap = new TreeMap();
        n(j2, false, this.f6786g, treeMap);
        m(j2, map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar = map2.get(entry.getKey());
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) entry.getValue();
            e(spannableStringBuilder);
            arrayList.add(new a(spannableStringBuilder, (Layout.Alignment) null, cVar.f6793c, cVar.f6794d, cVar.f6795e, cVar.f6792b, Integer.MIN_VALUE, cVar.f6796f, cVar.f6797g, cVar.f6798h));
        }
        return arrayList;
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i2 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        return jArr;
    }

    public boolean l(long j2) {
        long j3 = this.f6783d;
        return (j3 == -9223372036854775807L && this.f6784e == -9223372036854775807L) || (j3 <= j2 && this.f6784e == -9223372036854775807L) || ((j3 == -9223372036854775807L && j2 < this.f6784e) || (j3 <= j2 && j2 < this.f6784e));
    }
}
