package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: TimeModel */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final int f8096b;

    /* renamed from: c  reason: collision with root package name */
    int f8097c;

    /* renamed from: d  reason: collision with root package name */
    int f8098d;

    /* renamed from: e  reason: collision with root package name */
    int f8099e;

    /* compiled from: TimeModel */
    static class a implements Parcelable.Creator<b> {
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

    public b() {
        this(0);
    }

    public static String g(Resources resources, CharSequence charSequence) {
        return k(resources, charSequence, "%02d");
    }

    public static String k(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int l(int i2) {
        return i2 >= 12 ? 1 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f8097c == bVar.f8097c && this.f8098d == bVar.f8098d && this.f8096b == bVar.f8096b && this.f8099e == bVar.f8099e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8096b), Integer.valueOf(this.f8097c), Integer.valueOf(this.f8098d), Integer.valueOf(this.f8099e)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8097c);
        parcel.writeInt(this.f8098d);
        parcel.writeInt(this.f8099e);
        parcel.writeInt(this.f8096b);
    }

    public b(int i2) {
        this(0, 0, 10, i2);
    }

    public b(int i2, int i3, int i4, int i5) {
        this.f8097c = i2;
        this.f8098d = i3;
        this.f8099e = i4;
        this.f8096b = i5;
        l(i2);
    }

    protected b(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
