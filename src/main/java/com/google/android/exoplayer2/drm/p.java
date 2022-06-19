package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.drm.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ExoMediaDrm */
public interface p<T extends o> {

    /* compiled from: ExoMediaDrm */
    public static final class a {
        public a(byte[] bArr, String str) {
        }
    }

    /* compiled from: ExoMediaDrm */
    public interface b<T extends o> {
        void a(p<? extends T> pVar, byte[] bArr, int i2, int i3, byte[] bArr2);
    }

    /* compiled from: ExoMediaDrm */
    public static final class c {
        public c(byte[] bArr, String str) {
        }
    }

    void a(byte[] bArr, byte[] bArr2);

    Map<String, String> b(byte[] bArr);

    void c(String str, String str2);

    void d(byte[] bArr);

    void e(b<? super T> bVar);

    byte[] f(byte[] bArr, byte[] bArr2);

    T g(byte[] bArr);

    c h();

    void i(byte[] bArr);

    a j(byte[] bArr, List<l.b> list, int i2, HashMap<String, String> hashMap);

    byte[] k();
}
