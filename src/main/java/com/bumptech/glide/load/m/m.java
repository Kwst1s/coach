package com.bumptech.glide.load.m;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bumptech.glide.load.m.e;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorRewinder */
public final class m implements e<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    private final b f3961a;

    /* compiled from: ParcelFileDescriptorRewinder */
    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.m.e.a
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        /* renamed from: c */
        public e<ParcelFileDescriptor> b(ParcelFileDescriptor parcelFileDescriptor) {
            return new m(parcelFileDescriptor);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: ParcelFileDescriptorRewinder */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelFileDescriptor f3962a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f3962a = parcelFileDescriptor;
        }

        /* access modifiers changed from: package-private */
        public ParcelFileDescriptor a() {
            try {
                Os.lseek(this.f3962a.getFileDescriptor(), 0, OsConstants.SEEK_SET);
                return this.f3962a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    public m(ParcelFileDescriptor parcelFileDescriptor) {
        this.f3961a = new b(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // com.bumptech.glide.load.m.e
    public void b() {
    }

    /* renamed from: d */
    public ParcelFileDescriptor a() {
        return this.f3961a.a();
    }
}
