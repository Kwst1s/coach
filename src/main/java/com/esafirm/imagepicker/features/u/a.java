package com.esafirm.imagepicker.features.u;

import android.os.Parcel;
import android.os.Parcelable;
import com.esafirm.imagepicker.features.p;
import com.esafirm.imagepicker.features.r;

/* compiled from: BaseConfig */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0116a();

    /* renamed from: b  reason: collision with root package name */
    private p f4560b;

    /* renamed from: c  reason: collision with root package name */
    private r f4561c;

    /* renamed from: com.esafirm.imagepicker.features.u.a$a  reason: collision with other inner class name */
    /* compiled from: BaseConfig */
    static class C0116a implements Parcelable.Creator<a> {
        C0116a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a() {
    }

    public int describeContents() {
        return 0;
    }

    public p g() {
        return this.f4560b;
    }

    public r k() {
        return this.f4561c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f4560b, i2);
        r rVar = this.f4561c;
        parcel.writeInt(rVar == null ? -1 : rVar.ordinal());
    }

    protected a(Parcel parcel) {
        r rVar;
        this.f4560b = (p) parcel.readParcelable(p.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt == -1) {
            rVar = null;
        } else {
            rVar = r.values()[readInt];
        }
        this.f4561c = rVar;
    }
}
