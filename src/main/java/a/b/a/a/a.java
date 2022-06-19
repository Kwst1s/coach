package a.b.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IResultReceiver */
public interface a extends IInterface {

    /* renamed from: a.b.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: IResultReceiver */
    public static abstract class AbstractBinderC0002a extends Binder implements a {

        /* renamed from: a.b.a.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: IResultReceiver */
        private static class C0003a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f9a;

            C0003a(IBinder iBinder) {
                this.f9a = iBinder;
            }

            public IBinder asBinder() {
                return this.f9a;
            }
        }

        public AbstractBinderC0002a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0003a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                Q(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    void Q(int i2, Bundle bundle);
}
