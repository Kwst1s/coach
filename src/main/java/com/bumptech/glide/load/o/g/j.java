package com.bumptech.glide.load.o.g;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder */
public class j implements com.bumptech.glide.load.j<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f4145a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.j<ByteBuffer, c> f4146b;

    /* renamed from: c  reason: collision with root package name */
    private final b f4147c;

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.j<ByteBuffer, c> jVar, b bVar) {
        this.f4145a = list;
        this.f4146b = jVar;
        this.f4147c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    /* renamed from: c */
    public u<c> a(InputStream inputStream, int i2, int i3, h hVar) {
        byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.f4146b.a(ByteBuffer.wrap(e2), i2, i3, hVar);
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, h hVar) {
        return !((Boolean) hVar.c(i.f4144b)).booleanValue() && e.e(this.f4145a, inputStream, this.f4147c) == ImageHeaderParser.ImageType.GIF;
    }
}
