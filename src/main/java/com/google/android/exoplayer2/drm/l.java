package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: DrmInitData */
public final class l implements Comparator<b>, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final b[] f5002b;

    /* renamed from: c  reason: collision with root package name */
    private int f5003c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5004d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5005e;

    /* compiled from: DrmInitData */
    static class a implements Parcelable.Creator<l> {
        a() {
        }

        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* renamed from: b */
        public l[] newArray(int i2) {
            return new l[i2];
        }
    }

    /* compiled from: DrmInitData */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private int f5006b;

        /* renamed from: c  reason: collision with root package name */
        private final UUID f5007c;

        /* renamed from: d  reason: collision with root package name */
        public final String f5008d;

        /* renamed from: e  reason: collision with root package name */
        public final String f5009e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f5010f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5011g;

        /* compiled from: DrmInitData */
        static class a implements Parcelable.Creator<b> {
            a() {
            }

            /* renamed from: a */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* renamed from: b */
            public b[] newArray(int i2) {
                return new b[i2];
            }
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            if (!d0.b(this.f5008d, bVar.f5008d) || !d0.b(this.f5009e, bVar.f5009e) || !d0.b(this.f5007c, bVar.f5007c) || !Arrays.equals(this.f5010f, bVar.f5010f)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.f5006b == 0) {
                int hashCode = this.f5007c.hashCode() * 31;
                String str = this.f5008d;
                this.f5006b = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f5009e.hashCode()) * 31) + Arrays.hashCode(this.f5010f);
            }
            return this.f5006b;
        }

        public boolean k(b bVar) {
            return m() && !bVar.m() && n(bVar.f5007c);
        }

        public b l(byte[] bArr) {
            return new b(this.f5007c, this.f5008d, this.f5009e, bArr, this.f5011g);
        }

        public boolean m() {
            return this.f5010f != null;
        }

        public boolean n(UUID uuid) {
            return d.f4923a.equals(this.f5007c) || uuid.equals(this.f5007c);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f5007c.getMostSignificantBits());
            parcel.writeLong(this.f5007c.getLeastSignificantBits());
            parcel.writeString(this.f5008d);
            parcel.writeString(this.f5009e);
            parcel.writeByteArray(this.f5010f);
            parcel.writeByte(this.f5011g ? (byte) 1 : 0);
        }

        public b(UUID uuid, String str, byte[] bArr, boolean z) {
            this(uuid, null, str, bArr, z);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
            e.e(uuid);
            this.f5007c = uuid;
            this.f5008d = str;
            e.e(str2);
            this.f5009e = str2;
            this.f5010f = bArr;
            this.f5011g = z;
        }

        b(Parcel parcel) {
            this.f5007c = new UUID(parcel.readLong(), parcel.readLong());
            this.f5008d = parcel.readString();
            this.f5009e = parcel.readString();
            this.f5010f = parcel.createByteArray();
            this.f5011g = parcel.readByte() != 0;
        }
    }

    public l(List<b> list) {
        this(null, false, (b[]) list.toArray(new b[list.size()]));
    }

    private static boolean k(ArrayList<b> arrayList, int i2, UUID uuid) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (arrayList.get(i3).f5007c.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static l m(l lVar, l lVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (lVar != null) {
            str = lVar.f5004d;
            b[] bVarArr = lVar.f5002b;
            for (b bVar : bVarArr) {
                if (bVar.m()) {
                    arrayList.add(bVar);
                }
            }
        } else {
            str = null;
        }
        if (lVar2 != null) {
            if (str == null) {
                str = lVar2.f5004d;
            }
            int size = arrayList.size();
            b[] bVarArr2 = lVar2.f5002b;
            for (b bVar2 : bVarArr2) {
                if (bVar2.m() && !k(arrayList, size, bVar2.f5007c)) {
                    arrayList.add(bVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new l(str, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (!d0.b(this.f5004d, lVar.f5004d) || !Arrays.equals(this.f5002b, lVar.f5002b)) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    public int compare(b bVar, b bVar2) {
        UUID uuid = d.f4923a;
        if (uuid.equals(bVar.f5007c)) {
            return uuid.equals(bVar2.f5007c) ? 0 : 1;
        }
        return bVar.f5007c.compareTo(bVar2.f5007c);
    }

    public int hashCode() {
        if (this.f5003c == 0) {
            String str = this.f5004d;
            this.f5003c = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f5002b);
        }
        return this.f5003c;
    }

    public l l(String str) {
        if (d0.b(this.f5004d, str)) {
            return this;
        }
        return new l(str, false, this.f5002b);
    }

    public b n(int i2) {
        return this.f5002b[i2];
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5004d);
        parcel.writeTypedArray(this.f5002b, 0);
    }

    public l(String str, List<b> list) {
        this(str, false, (b[]) list.toArray(new b[list.size()]));
    }

    public l(b... bVarArr) {
        this((String) null, bVarArr);
    }

    public l(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    private l(String str, boolean z, b... bVarArr) {
        this.f5004d = str;
        bVarArr = z ? (b[]) bVarArr.clone() : bVarArr;
        Arrays.sort(bVarArr, this);
        this.f5002b = bVarArr;
        this.f5005e = bVarArr.length;
    }

    l(Parcel parcel) {
        this.f5004d = parcel.readString();
        b[] bVarArr = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f5002b = bVarArr;
        this.f5005e = bVarArr.length;
    }
}
