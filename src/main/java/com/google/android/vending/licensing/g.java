package com.google.android.vending.licensing;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64DecoderException;
import com.google.android.vending.licensing.util.a;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/* access modifiers changed from: package-private */
/* compiled from: LicenseValidator */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final j f8259a;

    /* renamed from: b  reason: collision with root package name */
    private final f f8260b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8261c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8262d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8263e;

    /* renamed from: f  reason: collision with root package name */
    private final c f8264f;

    g(j jVar, c cVar, f fVar, int i2, String str, String str2) {
        this.f8259a = jVar;
        this.f8264f = cVar;
        this.f8260b = fVar;
        this.f8261c = i2;
        this.f8262d = str;
        this.f8263e = str2;
    }

    private void d(int i2) {
        this.f8260b.b(i2);
    }

    private void e() {
        this.f8260b.c(561);
    }

    private void f(int i2, l lVar) {
        this.f8259a.b(i2, lVar);
        if (this.f8259a.a()) {
            this.f8260b.a(i2);
        } else {
            this.f8260b.c(i2);
        }
    }

    public f a() {
        return this.f8260b;
    }

    public int b() {
        return this.f8261c;
    }

    public String c() {
        return this.f8262d;
    }

    public void g(PublicKey publicKey, int i2, String str, String str2) {
        l lVar;
        String str3 = null;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            try {
                Signature instance = Signature.getInstance("SHA1withRSA");
                instance.initVerify(publicKey);
                instance.update(str.getBytes());
                if (!instance.verify(a.a(str2))) {
                    Log.e("LicenseValidator", "Signature verification failed.");
                    e();
                    return;
                }
                try {
                    l a2 = l.a(str);
                    if (a2.f8268a != i2) {
                        Log.e("LicenseValidator", "Response codes don't match.");
                        e();
                        return;
                    } else if (a2.f8269b != this.f8261c) {
                        Log.e("LicenseValidator", "Nonce doesn't match.");
                        e();
                        return;
                    } else if (!a2.f8270c.equals(this.f8262d)) {
                        Log.e("LicenseValidator", "Package name doesn't match.");
                        e();
                        return;
                    } else if (!a2.f8271d.equals(this.f8263e)) {
                        Log.e("LicenseValidator", "Version codes don't match.");
                        e();
                        return;
                    } else {
                        String str4 = a2.f8272e;
                        if (TextUtils.isEmpty(str4)) {
                            Log.e("LicenseValidator", "User identifier gov empty.");
                            e();
                            return;
                        }
                        str3 = str4;
                        lVar = a2;
                    }
                } catch (IllegalArgumentException unused) {
                    Log.e("LicenseValidator", "Could not parse response.");
                    e();
                    return;
                }
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            } catch (InvalidKeyException unused2) {
                d(5);
                return;
            } catch (SignatureException e3) {
                throw new RuntimeException(e3);
            } catch (Base64DecoderException unused3) {
                Log.e("LicenseValidator", "Could not Base64-decode signature.");
                e();
                return;
            }
        } else {
            lVar = null;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                f(561, lVar);
                return;
            } else if (i2 != 2) {
                if (i2 == 3) {
                    d(3);
                    return;
                } else if (i2 == 4) {
                    Log.w("LicenseValidator", "An error has occurred on the licensing server.");
                    f(291, lVar);
                    return;
                } else if (i2 != 5) {
                    switch (i2) {
                        case 257:
                            Log.w("LicenseValidator", "Error contacting licensing server.");
                            f(291, lVar);
                            return;
                        case 258:
                            d(1);
                            return;
                        case 259:
                            d(2);
                            return;
                        default:
                            Log.e("LicenseValidator", "Unknown response code for license check.");
                            e();
                            return;
                    }
                } else {
                    Log.w("LicenseValidator", "Licensing server gov refusing to talk to this device, over quota.");
                    f(291, lVar);
                    return;
                }
            }
        }
        f(this.f8264f.a(str3), lVar);
    }
}
