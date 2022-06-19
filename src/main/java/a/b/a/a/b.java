package a.b.a.a;

import a.b.a.a.a;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: ResultReceiver */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final Handler f10b = null;

    /* renamed from: c  reason: collision with root package name */
    a f11c;

    /* compiled from: ResultReceiver */
    class a implements Parcelable.Creator<b> {
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

    /* renamed from: a.b.a.a.b$b  reason: collision with other inner class name */
    /* compiled from: ResultReceiver */
    class BinderC0004b extends a.AbstractBinderC0002a {
        BinderC0004b() {
        }

        @Override // a.b.a.a.a
        public void Q(int i2, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f10b;
            if (handler != null) {
                handler.post(new c(i2, bundle));
            } else {
                bVar.g(i2, bundle);
            }
        }
    }

    /* compiled from: ResultReceiver */
    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final int f13b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f14c;

        c(int i2, Bundle bundle) {
            this.f13b = i2;
            this.f14c = bundle;
        }

        public void run() {
            b.this.g(this.f13b, this.f14c);
        }
    }

    b(Parcel parcel) {
        this.f11c = a.AbstractBinderC0002a.e(parcel.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void g(int i2, Bundle bundle) {
    }

    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.f11c == null) {
                this.f11c = new BinderC0004b();
            }
            parcel.writeStrongBinder(this.f11c.asBinder());
        }
    }
}
