package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

/* compiled from: DateValidatorPointForward */
public class f implements a.c {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final long f7688b;

    /* compiled from: DateValidatorPointForward */
    static class a implements Parcelable.Creator<f> {
        a() {
        }

        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel.readLong(), null);
        }

        /* renamed from: b */
        public f[] newArray(int i2) {
            return new f[i2];
        }
    }

    /* synthetic */ f(long j2, a aVar) {
        this(j2);
    }

    public static f g(long j2) {
        return new f(j2);
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean d(long j2) {
        return j2 >= this.f7688b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof f) && this.f7688b == ((f) obj).f7688b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f7688b)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f7688b);
    }

    private f(long j2) {
        this.f7688b = j2;
    }
}
