package com.bumptech.glide.load.n;

import android.util.Log;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.h;
import com.bumptech.glide.r.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder */
public class c implements d<ByteBuffer> {
    /* renamed from: c */
    public boolean a(ByteBuffer byteBuffer, File file, h hVar) {
        try {
            a.e(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}
