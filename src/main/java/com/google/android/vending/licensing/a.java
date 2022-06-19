package com.google.android.vending.licensing;

import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESObfuscator */
public class a implements i {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f8228c = {16, 74, 71, -80, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74};

    /* renamed from: a  reason: collision with root package name */
    private Cipher f8229a;

    /* renamed from: b  reason: collision with root package name */
    private Cipher f8230b;

    public a(byte[] bArr, String str, String str2) {
        try {
            SecretKeyFactory instance = SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC");
            SecretKeySpec secretKeySpec = new SecretKeySpec(instance.generateSecret(new PBEKeySpec((str + str2).toCharArray(), bArr, 1024, 256)).getEncoded(), "AES");
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f8229a = instance2;
            byte[] bArr2 = f8228c;
            instance2.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            Cipher instance3 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f8230b = instance3;
            instance3.init(2, secretKeySpec, new IvParameterSpec(bArr2));
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException("Invalid environment", e2);
        }
    }

    @Override // com.google.android.vending.licensing.i
    public String a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            Cipher cipher = this.f8229a;
            return com.google.android.vending.licensing.util.a.e(cipher.doFinal(("com.android.vending.licensing.AESObfuscator-1|" + str2 + str).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Invalid environment", e2);
        } catch (GeneralSecurityException e3) {
            throw new RuntimeException("Invalid environment", e3);
        }
    }

    @Override // com.google.android.vending.licensing.i
    public String b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            String str3 = new String(this.f8230b.doFinal(com.google.android.vending.licensing.util.a.a(str)), "UTF-8");
            if (str3.indexOf("com.android.vending.licensing.AESObfuscator-1|" + str2) == 0) {
                return str3.substring(46 + str2.length(), str3.length());
            }
            throw new ValidationException("Header not found (invalid data or key):" + str);
        } catch (Base64DecoderException e2) {
            throw new ValidationException(e2.getMessage() + ":" + str);
        } catch (IllegalBlockSizeException e3) {
            throw new ValidationException(e3.getMessage() + ":" + str);
        } catch (BadPaddingException e4) {
            throw new ValidationException(e4.getMessage() + ":" + str);
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("Invalid environment", e5);
        }
    }
}
