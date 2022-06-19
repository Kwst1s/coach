package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import java.net.URLDecoder;

/* compiled from: DataSchemeDataSource */
public final class g extends f {

    /* renamed from: e  reason: collision with root package name */
    private k f6913e;

    /* renamed from: f  reason: collision with root package name */
    private int f6914f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f6915g;

    public g() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int length = this.f6915g.length - this.f6914f;
        if (length == 0) {
            return -1;
        }
        int min = Math.min(i3, length);
        System.arraycopy(this.f6915g, this.f6914f, bArr, i2, min);
        this.f6914f += min;
        f(min);
        return min;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        h(kVar);
        this.f6913e = kVar;
        Uri uri = kVar.f6922a;
        String scheme = uri.getScheme();
        if ("data".equals(scheme)) {
            String[] c0 = d0.c0(uri.getSchemeSpecificPart(), ",");
            if (c0.length == 2) {
                String str = c0[1];
                if (c0[0].contains(";base64")) {
                    try {
                        this.f6915g = Base64.decode(str, 0);
                    } catch (IllegalArgumentException e2) {
                        throw new ParserException("Error while parsing Base64 encoded string: " + str, e2);
                    }
                } else {
                    this.f6915g = d0.K(URLDecoder.decode(str, "US-ASCII"));
                }
                i(kVar);
                return (long) this.f6915g.length;
            }
            throw new ParserException("Unexpected URI format: " + uri);
        }
        throw new ParserException("Unsupported scheme: " + scheme);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        if (this.f6915g != null) {
            this.f6915g = null;
            g();
        }
        this.f6913e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        k kVar = this.f6913e;
        if (kVar != null) {
            return kVar.f6922a;
        }
        return null;
    }
}
