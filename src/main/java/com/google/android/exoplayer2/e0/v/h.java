package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.e0.v.i;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: OpusReader */
public final class h extends i {
    private static final int o = d0.B("Opus");
    private static final byte[] p = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean n;

    h() {
    }

    private long l(byte[] bArr) {
        int i2 = bArr[0] & 255;
        int i3 = i2 & 3;
        int i4 = 2;
        if (i3 == 0) {
            i4 = 1;
        } else if (!(i3 == 1 || i3 == 2)) {
            i4 = bArr[1] & 63;
        }
        int i5 = i2 >> 3;
        int i6 = i5 & 3;
        return ((long) i4) * ((long) (i5 >= 16 ? 2500 << i6 : i5 >= 12 ? 10000 << (i6 & 1) : i6 == 3 ? 60000 : 10000 << i6));
    }

    private void m(List<byte[]> list, int i2) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i2) * 1000000000) / 48000).array());
    }

    public static boolean n(s sVar) {
        int a2 = sVar.a();
        byte[] bArr = p;
        if (a2 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        sVar.h(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public long e(s sVar) {
        return b(l(sVar.f7062a));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public boolean h(s sVar, long j2, i.b bVar) {
        boolean z = true;
        if (!this.n) {
            byte[] copyOf = Arrays.copyOf(sVar.f7062a, sVar.d());
            int i2 = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            m(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            m(arrayList, 3840);
            bVar.f5378a = l.t(null, "audio/opus", null, -1, -1, i2, 48000, arrayList, null, 0, null);
            this.n = true;
            return true;
        }
        if (sVar.j() != o) {
            z = false;
        }
        sVar.K(0);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.e0.v.i
    public void j(boolean z) {
        super.j(z);
        if (z) {
            this.n = false;
        }
    }
}
