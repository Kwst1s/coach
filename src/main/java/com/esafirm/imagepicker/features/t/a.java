package com.esafirm.imagepicker.features.t;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CameraOnlyConfig */
public class a extends com.esafirm.imagepicker.features.u.a {
    public static final Parcelable.Creator<a> CREATOR = new C0115a();

    /* renamed from: com.esafirm.imagepicker.features.t.a$a  reason: collision with other inner class name */
    /* compiled from: CameraOnlyConfig */
    static class C0115a implements Parcelable.Creator<a> {
        C0115a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* synthetic */ a(Parcel parcel, C0115a aVar) {
        this(parcel);
    }

    @Override // com.esafirm.imagepicker.features.u.a
    public int describeContents() {
        return 0;
    }

    @Override // com.esafirm.imagepicker.features.u.a
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    public a() {
    }

    private a(Parcel parcel) {
        super(parcel);
    }
}
