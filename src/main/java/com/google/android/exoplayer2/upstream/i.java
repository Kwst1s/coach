package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* compiled from: DataSource */
public interface i {

    /* compiled from: DataSource */
    public interface a {
        i a();
    }

    int a(byte[] bArr, int i2, int i3);

    long b(k kVar);

    Map<String, List<String>> c();

    void close();

    void d(x xVar);

    Uri e();
}
