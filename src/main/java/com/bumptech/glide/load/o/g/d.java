package com.bumptech.glide.load.o.g;

import android.util.Log;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.r.a;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder */
public class d implements k<c> {
    @Override // com.bumptech.glide.load.k
    public c b(h hVar) {
        return c.SOURCE;
    }

    /* renamed from: c */
    public boolean a(u<c> uVar, File file, h hVar) {
        try {
            a.e(uVar.get().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
