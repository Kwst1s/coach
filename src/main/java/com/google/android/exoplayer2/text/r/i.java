package com.google.android.exoplayer2.text.r;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: WebvttSubtitle */
public final class i implements d {

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f6855b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6856c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f6857d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f6858e;

    public i(List<e> list) {
        this.f6855b = list;
        int size = list.size();
        this.f6856c = size;
        this.f6857d = new long[(size * 2)];
        for (int i2 = 0; i2 < this.f6856c; i2++) {
            e eVar = list.get(i2);
            int i3 = i2 * 2;
            long[] jArr = this.f6857d;
            jArr[i3] = eVar.f6831e;
            jArr[i3 + 1] = eVar.f6832f;
        }
        long[] jArr2 = this.f6857d;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f6858e = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // com.google.android.exoplayer2.text.d
    public int a(long j2) {
        int c2 = d0.c(this.f6858e, j2, false, false);
        if (c2 < this.f6858e.length) {
            return c2;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.d
    public long b(int i2) {
        boolean z = true;
        e.a(i2 >= 0);
        if (i2 >= this.f6858e.length) {
            z = false;
        }
        e.a(z);
        return this.f6858e[i2];
    }

    @Override // com.google.android.exoplayer2.text.d
    public List<a> c(long j2) {
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar = null;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < this.f6856c; i2++) {
            long[] jArr = this.f6857d;
            int i3 = i2 * 2;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                e eVar2 = this.f6855b.get(i2);
                if (!eVar2.a()) {
                    arrayList.add(eVar2);
                } else if (eVar == null) {
                    eVar = eVar2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(eVar.f6655b).append((CharSequence) "\n").append(eVar2.f6655b);
                } else {
                    spannableStringBuilder.append((CharSequence) "\n").append(eVar2.f6655b);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new e(spannableStringBuilder));
        } else if (eVar != null) {
            arrayList.add(eVar);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.d
    public int d() {
        return this.f6858e.length;
    }
}
