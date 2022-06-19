package com.google.android.exoplayer2.text.k;

import android.text.Layout;
import com.google.android.exoplayer2.text.a;

/* access modifiers changed from: package-private */
/* compiled from: Cea708Cue */
public final class b extends a implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public final int f6680e;

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5, int i6) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4, z, i5);
        this.f6680e = i6;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        int i2 = bVar.f6680e;
        int i3 = this.f6680e;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }
}
