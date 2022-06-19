package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultDataSource */
public final class n implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6955a;

    /* renamed from: b  reason: collision with root package name */
    private final List<x> f6956b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final i f6957c;

    /* renamed from: d  reason: collision with root package name */
    private i f6958d;

    /* renamed from: e  reason: collision with root package name */
    private i f6959e;

    /* renamed from: f  reason: collision with root package name */
    private i f6960f;

    /* renamed from: g  reason: collision with root package name */
    private i f6961g;

    /* renamed from: h  reason: collision with root package name */
    private i f6962h;

    /* renamed from: i  reason: collision with root package name */
    private i f6963i;

    /* renamed from: j  reason: collision with root package name */
    private i f6964j;

    public n(Context context, i iVar) {
        this.f6955a = context.getApplicationContext();
        e.e(iVar);
        this.f6957c = iVar;
    }

    private void f(i iVar) {
        for (int i2 = 0; i2 < this.f6956b.size(); i2++) {
            iVar.d(this.f6956b.get(i2));
        }
    }

    private i g() {
        if (this.f6959e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f6955a);
            this.f6959e = assetDataSource;
            f(assetDataSource);
        }
        return this.f6959e;
    }

    private i h() {
        if (this.f6960f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f6955a);
            this.f6960f = contentDataSource;
            f(contentDataSource);
        }
        return this.f6960f;
    }

    private i i() {
        if (this.f6962h == null) {
            g gVar = new g();
            this.f6962h = gVar;
            f(gVar);
        }
        return this.f6962h;
    }

    private i j() {
        if (this.f6958d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f6958d = fileDataSource;
            f(fileDataSource);
        }
        return this.f6958d;
    }

    private i k() {
        if (this.f6963i == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f6955a);
            this.f6963i = rawResourceDataSource;
            f(rawResourceDataSource);
        }
        return this.f6963i;
    }

    private i l() {
        if (this.f6961g == null) {
            try {
                i iVar = (i) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f6961g = iVar;
                f(iVar);
            } catch (ClassNotFoundException unused) {
                m.f("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f6961g == null) {
                this.f6961g = this.f6957c;
            }
        }
        return this.f6961g;
    }

    private void m(i iVar, x xVar) {
        if (iVar != null) {
            iVar.d(xVar);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        i iVar = this.f6964j;
        e.e(iVar);
        return iVar.a(bArr, i2, i3);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        e.f(this.f6964j == null);
        String scheme = kVar.f6922a.getScheme();
        if (d0.P(kVar.f6922a)) {
            if (kVar.f6922a.getPath().startsWith("/android_asset/")) {
                this.f6964j = g();
            } else {
                this.f6964j = j();
            }
        } else if ("asset".equals(scheme)) {
            this.f6964j = g();
        } else if ("content".equals(scheme)) {
            this.f6964j = h();
        } else if ("rtmp".equals(scheme)) {
            this.f6964j = l();
        } else if ("data".equals(scheme)) {
            this.f6964j = i();
        } else if ("rawresource".equals(scheme)) {
            this.f6964j = k();
        } else {
            this.f6964j = this.f6957c;
        }
        return this.f6964j.b(kVar);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Map<String, List<String>> c() {
        i iVar = this.f6964j;
        return iVar == null ? Collections.emptyMap() : iVar.c();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        i iVar = this.f6964j;
        if (iVar != null) {
            try {
                iVar.close();
            } finally {
                this.f6964j = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void d(x xVar) {
        this.f6957c.d(xVar);
        this.f6956b.add(xVar);
        m(this.f6958d, xVar);
        m(this.f6959e, xVar);
        m(this.f6960f, xVar);
        m(this.f6961g, xVar);
        m(this.f6962h, xVar);
        m(this.f6963i, xVar);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        i iVar = this.f6964j;
        if (iVar == null) {
            return null;
        }
        return iVar.e();
    }
}
