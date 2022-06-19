package com.rd.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: PositionSavedState */
public class c extends View.BaseSavedState {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f8597b;

    /* renamed from: c  reason: collision with root package name */
    private int f8598c;

    /* renamed from: d  reason: collision with root package name */
    private int f8599d;

    /* compiled from: PositionSavedState */
    static class a implements Parcelable.Creator<c> {
        a() {
        }

        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel, null);
        }

        /* renamed from: b */
        public c[] newArray(int i2) {
            return new c[i2];
        }
    }

    /* synthetic */ c(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int g() {
        return this.f8599d;
    }

    public int k() {
        return this.f8597b;
    }

    public int l() {
        return this.f8598c;
    }

    public void m(int i2) {
        this.f8599d = i2;
    }

    public void n(int i2) {
        this.f8597b = i2;
    }

    public void o(int i2) {
        this.f8598c = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f8597b);
        parcel.writeInt(this.f8598c);
        parcel.writeInt(this.f8599d);
    }

    public c(Parcelable parcelable) {
        super(parcelable);
    }

    private c(Parcel parcel) {
        super(parcel);
        this.f8597b = parcel.readInt();
        this.f8598c = parcel.readInt();
        this.f8599d = parcel.readInt();
    }
}
