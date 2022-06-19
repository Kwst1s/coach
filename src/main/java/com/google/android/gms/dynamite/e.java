package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import c.e.a.a.b.b.b;
import c.e.a.a.b.b.c;
import com.google.android.gms.dynamic.a;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class e extends b implements f {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.f
    public final a C(a aVar, String str, boolean z, long j2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        c.c(e2, z);
        e2.writeLong(j2);
        Parcel i2 = i(7, e2);
        a i3 = a.AbstractBinderC0146a.i(i2.readStrongBinder());
        i2.recycle();
        return i3;
    }

    @Override // com.google.android.gms.dynamite.f
    public final a E(a aVar, String str, int i2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i2);
        Parcel i3 = i(2, e2);
        a i4 = a.AbstractBinderC0146a.i(i3.readStrongBinder());
        i3.recycle();
        return i4;
    }

    @Override // com.google.android.gms.dynamite.f
    public final a d(a aVar, String str, int i2, a aVar2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i2);
        c.b(e2, aVar2);
        Parcel i3 = i(8, e2);
        a i4 = a.AbstractBinderC0146a.i(i3.readStrongBinder());
        i3.recycle();
        return i4;
    }

    @Override // com.google.android.gms.dynamite.f
    public final int j() {
        Parcel i2 = i(6, e());
        int readInt = i2.readInt();
        i2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.f
    public final int l(a aVar, String str, boolean z) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        c.c(e2, z);
        Parcel i2 = i(5, e2);
        int readInt = i2.readInt();
        i2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.f
    public final int t(a aVar, String str, boolean z) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        c.c(e2, z);
        Parcel i2 = i(3, e2);
        int readInt = i2.readInt();
        i2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.f
    public final a v(a aVar, String str, int i2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i2);
        Parcel i3 = i(4, e2);
        a i4 = a.AbstractBinderC0146a.i(i3.readStrongBinder());
        i3.recycle();
        return i4;
    }
}
