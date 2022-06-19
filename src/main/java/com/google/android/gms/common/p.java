package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.r0;
import com.google.android.gms.common.internal.s0;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public abstract class p extends s0 {

    /* renamed from: a  reason: collision with root package name */
    private int f7430a;

    protected p(byte[] bArr) {
        n.a(bArr.length == 25);
        this.f7430a = Arrays.hashCode(bArr);
    }

    protected static byte[] k(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.r0
    public final int P() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        a j2;
        if (obj != null && (obj instanceof r0)) {
            try {
                r0 r0Var = (r0) obj;
                if (r0Var.P() == hashCode() && (j2 = r0Var.j()) != null) {
                    return Arrays.equals(i(), (byte[]) b.k(j2));
                }
                return false;
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f7430a;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] i();

    @Override // com.google.android.gms.common.internal.r0
    public final a j() {
        return b.T(i());
    }
}
