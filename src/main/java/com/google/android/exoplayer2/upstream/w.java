package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.e;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: StatsDataSource */
public final class w implements i {

    /* renamed from: a  reason: collision with root package name */
    private final i f6986a;

    /* renamed from: b  reason: collision with root package name */
    private long f6987b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f6988c = Uri.EMPTY;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, List<String>> f6989d = Collections.emptyMap();

    public w(i iVar) {
        e.e(iVar);
        this.f6986a = iVar;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        int a2 = this.f6986a.a(bArr, i2, i3);
        if (a2 != -1) {
            this.f6987b += (long) a2;
        }
        return a2;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        this.f6988c = kVar.f6922a;
        this.f6989d = Collections.emptyMap();
        long b2 = this.f6986a.b(kVar);
        Uri e2 = e();
        e.e(e2);
        this.f6988c = e2;
        this.f6989d = c();
        return b2;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Map<String, List<String>> c() {
        return this.f6986a.c();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        this.f6986a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void d(x xVar) {
        this.f6986a.d(xVar);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        return this.f6986a.e();
    }

    public long f() {
        return this.f6987b;
    }

    public Uri g() {
        return this.f6988c;
    }

    public Map<String, List<String>> h() {
        return this.f6989d;
    }

    public void i() {
        this.f6987b = 0;
    }
}
