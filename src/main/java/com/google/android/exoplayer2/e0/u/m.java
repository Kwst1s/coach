package com.google.android.exoplayer2.e0.u;

import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.util.e;

/* compiled from: TrackEncryptionBox */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5308a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5309b;

    /* renamed from: c  reason: collision with root package name */
    public final q.a f5310c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5311d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f5312e;

    public m(boolean z, String str, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        boolean z2 = true;
        e.a((bArr2 != null ? false : z2) ^ (i2 == 0));
        this.f5308a = z;
        this.f5309b = str;
        this.f5311d = i2;
        this.f5312e = bArr2;
        this.f5310c = new q.a(a(str), bArr, i3, i4);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
            case 3:
                break;
            default:
                com.google.android.exoplayer2.util.m.f("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                break;
        }
        return 1;
    }
}
