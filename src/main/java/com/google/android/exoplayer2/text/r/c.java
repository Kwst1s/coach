package com.google.android.exoplayer2.text.r;

import com.google.android.exoplayer2.text.a;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.util.e;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Mp4WebvttSubtitle */
public final class c implements d {

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f6819b;

    public c(List<a> list) {
        this.f6819b = Collections.unmodifiableList(list);
    }

    @Override // com.google.android.exoplayer2.text.d
    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.d
    public long b(int i2) {
        e.a(i2 == 0);
        return 0;
    }

    @Override // com.google.android.exoplayer2.text.d
    public List<a> c(long j2) {
        return j2 >= 0 ? this.f6819b : Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.d
    public int d() {
        return 1;
    }
}
