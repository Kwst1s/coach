package com.google.android.gms.common.internal;

import android.os.Parcel;
import c.e.a.a.b.b.a;
import c.e.a.a.b.b.c;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public abstract class s0 extends a implements r0 {
    public s0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    /* access modifiers changed from: protected */
    @Override // c.e.a.a.b.b.a
    public final boolean e(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            com.google.android.gms.dynamic.a j2 = j();
            parcel2.writeNoException();
            c.b(parcel2, j2);
        } else if (i2 != 2) {
            return false;
        } else {
            int P = P();
            parcel2.writeNoException();
            parcel2.writeInt(P);
        }
        return true;
    }
}
