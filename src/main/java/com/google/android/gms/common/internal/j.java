package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import c.e.a.a.b.b.c;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public interface j extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static abstract class a extends c.e.a.a.b.b.a implements j {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        /* access modifiers changed from: protected */
        @Override // c.e.a.a.b.b.a
        public final boolean e(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                R(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                L(parcel.readInt(), (Bundle) c.a(parcel, Bundle.CREATOR));
            } else if (i2 != 3) {
                return false;
            } else {
                A(parcel.readInt(), parcel.readStrongBinder(), (h0) c.a(parcel, h0.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void A(int i2, IBinder iBinder, h0 h0Var);

    void L(int i2, @RecentlyNonNull Bundle bundle);

    void R(int i2, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull Bundle bundle);
}
