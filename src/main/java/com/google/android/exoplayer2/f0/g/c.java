package com.google.android.exoplayer2.f0.g;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: EventMessageEncoder */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f5716a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f5717b;

    public c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f5716a = byteArrayOutputStream;
        this.f5717b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    private static void c(DataOutputStream dataOutputStream, long j2) {
        dataOutputStream.writeByte(((int) (j2 >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j2 >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j2 >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j2) & 255);
    }

    public byte[] a(a aVar, long j2) {
        e.a(j2 >= 0);
        this.f5716a.reset();
        try {
            b(this.f5717b, aVar.f5709b);
            String str = aVar.f5710c;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            b(this.f5717b, str);
            c(this.f5717b, j2);
            c(this.f5717b, d0.Z(aVar.f5712e, j2, 1000000));
            c(this.f5717b, d0.Z(aVar.f5711d, j2, 1000));
            c(this.f5717b, aVar.f5713f);
            this.f5717b.write(aVar.f5714g);
            this.f5717b.flush();
            return this.f5716a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
