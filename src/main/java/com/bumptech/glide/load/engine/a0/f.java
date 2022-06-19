package com.bumptech.glide.load.engine.a0;

import android.content.Context;
import com.bumptech.glide.load.engine.a0.d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory */
public final class f extends d {

    /* compiled from: InternalCacheDiskCacheFactory */
    class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f3678a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f3679b;

        a(Context context, String str) {
            this.f3678a = context;
            this.f3679b = str;
        }

        @Override // com.bumptech.glide.load.engine.a0.d.a
        public File a() {
            File cacheDir = this.f3678a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f3679b != null ? new File(cacheDir, this.f3679b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
