package g.a.a.a.a;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESUtils */
public class a {
    public static String a(byte[] bArr, String str) {
        return new String(b(bArr, c(str)));
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    public static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
        }
        return bArr;
    }
}
