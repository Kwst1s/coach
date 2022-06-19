package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;

/* compiled from: TrackOutput */
public interface q {

    /* compiled from: TrackOutput */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f5103a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f5104b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5105c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5106d;

        public a(int i2, byte[] bArr, int i3, int i4) {
            this.f5103a = i2;
            this.f5104b = bArr;
            this.f5105c = i3;
            this.f5106d = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5103a == aVar.f5103a && this.f5105c == aVar.f5105c && this.f5106d == aVar.f5106d && Arrays.equals(this.f5104b, aVar.f5104b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f5103a * 31) + Arrays.hashCode(this.f5104b)) * 31) + this.f5105c) * 31) + this.f5106d;
        }
    }

    void a(s sVar, int i2);

    int b(h hVar, int i2, boolean z);

    void c(long j2, int i2, int i3, int i4, a aVar);

    void d(l lVar);
}
