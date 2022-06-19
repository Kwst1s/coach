package com.esafirm.imagepicker.features;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ImagePickerSavePath */
public class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final String f4548b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4549c;

    /* compiled from: ImagePickerSavePath */
    static class a implements Parcelable.Creator<p> {
        a() {
        }

        /* renamed from: a */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        /* renamed from: b */
        public p[] newArray(int i2) {
            return new p[i2];
        }
    }

    protected p(Parcel parcel) {
        this.f4548b = parcel.readString();
        this.f4549c = parcel.readByte() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public String g() {
        return this.f4548b;
    }

    public boolean k() {
        return this.f4549c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f4548b);
        parcel.writeByte(this.f4549c ? (byte) 1 : 0);
    }
}
