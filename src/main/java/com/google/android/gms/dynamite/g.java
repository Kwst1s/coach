package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import c.e.a.a.b.b.b;
import c.e.a.a.b.b.c;
import com.google.android.gms.dynamic.a;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class g extends b implements h {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.h
    public final a d(a aVar, String str, int i2, a aVar2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i2);
        c.b(e2, aVar2);
        Parcel i3 = i(2, e2);
        a i4 = a.AbstractBinderC0146a.i(i3.readStrongBinder());
        i3.recycle();
        return i4;
    }

    @Override // com.google.android.gms.dynamite.h
    public final a r(a aVar, String str, int i2, a aVar2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i2);
        c.b(e2, aVar2);
        Parcel i3 = i(3, e2);
        a i4 = a.AbstractBinderC0146a.i(i3.readStrongBinder());
        i3.recycle();
        return i4;
    }
}
