package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.j;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.e;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Aes128DataSource */
class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private final i f6366a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6367b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f6368c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f6369d;

    public c(i iVar, byte[] bArr, byte[] bArr2) {
        this.f6366a = iVar;
        this.f6367b = bArr;
        this.f6368c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public final int a(byte[] bArr, int i2, int i3) {
        e.e(this.f6369d);
        int read = this.f6369d.read(bArr, i2, i3);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public final long b(k kVar) {
        try {
            Cipher f2 = f();
            try {
                f2.init(2, new SecretKeySpec(this.f6367b, "AES"), new IvParameterSpec(this.f6368c));
                j jVar = new j(this.f6366a, kVar);
                this.f6369d = new CipherInputStream(jVar, f2);
                jVar.E();
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public final Map<String, List<String>> c() {
        return this.f6366a.c();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        if (this.f6369d != null) {
            this.f6369d = null;
            this.f6366a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public final void d(x xVar) {
        this.f6366a.d(xVar);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public final Uri e() {
        return this.f6366a.e();
    }

    /* access modifiers changed from: protected */
    public Cipher f() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }
}
