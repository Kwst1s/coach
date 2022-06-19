package c.e.a.a.b.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class b implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f3218a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3219b;

    protected b(IBinder iBinder, String str) {
        this.f3218a = iBinder;
        this.f3219b = str;
    }

    public IBinder asBinder() {
        return this.f3218a;
    }

    /* access modifiers changed from: protected */
    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3219b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel i(int i2, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f3218a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }
}
