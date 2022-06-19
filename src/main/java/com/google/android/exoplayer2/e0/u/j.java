package com.google.android.exoplayer2.e0.u;

import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: PsshAtomUtil */
public final class j {

    /* access modifiers changed from: private */
    /* compiled from: PsshAtomUtil */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f5293a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5294b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f5295c;

        public a(UUID uuid, int i2, byte[] bArr) {
            this.f5293a = uuid;
            this.f5294b = i2;
            this.f5295c = bArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(c.V);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (!(bArr == null || bArr.length == 0)) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    private static a d(byte[] bArr) {
        s sVar = new s(bArr);
        if (sVar.d() < 32) {
            return null;
        }
        sVar.K(0);
        if (sVar.j() != sVar.a() + 4 || sVar.j() != c.V) {
            return null;
        }
        int c2 = c.c(sVar.j());
        if (c2 > 1) {
            m.f("PsshAtomUtil", "Unsupported pssh version: " + c2);
            return null;
        }
        UUID uuid = new UUID(sVar.r(), sVar.r());
        if (c2 == 1) {
            sVar.L(sVar.C() * 16);
        }
        int C = sVar.C();
        if (C != sVar.a()) {
            return null;
        }
        byte[] bArr2 = new byte[C];
        sVar.h(bArr2, 0, C);
        return new a(uuid, c2, bArr2);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        if (uuid == null || uuid.equals(d2.f5293a)) {
            return d2.f5295c;
        }
        m.f("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + d2.f5293a + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        a d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        return d2.f5293a;
    }

    public static int g(byte[] bArr) {
        a d2 = d(bArr);
        if (d2 == null) {
            return -1;
        }
        return d2.f5294b;
    }
}
