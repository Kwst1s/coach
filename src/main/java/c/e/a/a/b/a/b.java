package c.e.a.a.b.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class b implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f3214a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3215b;

    protected b(IBinder iBinder, String str) {
        this.f3214a = iBinder;
        this.f3215b = str;
    }

    public IBinder asBinder() {
        return this.f3214a;
    }

    /* access modifiers changed from: protected */
    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3215b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void i(int i2, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f3214a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void k(int i2, Parcel parcel) {
        try {
            this.f3214a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
