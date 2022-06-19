package com.esafirm.imagepicker.features;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.i.b;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ImagePickerConfig */
public class l extends com.esafirm.imagepicker.features.u.a implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<b> f4535d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<File> f4536e;

    /* renamed from: f  reason: collision with root package name */
    private String f4537f;

    /* renamed from: g  reason: collision with root package name */
    private String f4538g;

    /* renamed from: h  reason: collision with root package name */
    private String f4539h;

    /* renamed from: i  reason: collision with root package name */
    private int f4540i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f4541j;

    /* renamed from: k  reason: collision with root package name */
    private int f4542k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private com.esafirm.imagepicker.features.v.a q;

    /* compiled from: ImagePickerConfig */
    static class a implements Parcelable.Creator<l> {
        a() {
        }

        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* renamed from: b */
        public l[] newArray(int i2) {
            return new l[i2];
        }
    }

    public l() {
    }

    @Override // com.esafirm.imagepicker.features.u.a
    public int describeContents() {
        return 0;
    }

    public int l() {
        return this.f4540i;
    }

    public String m() {
        return this.f4539h;
    }

    public ArrayList<File> n() {
        return this.f4536e;
    }

    public String o() {
        return this.f4537f;
    }

    public com.esafirm.imagepicker.features.v.a p() {
        return this.q;
    }

    public String q() {
        return this.f4538g;
    }

    public int r() {
        return this.f4542k;
    }

    public int s() {
        return this.f4541j;
    }

    public ArrayList<b> t() {
        return this.f4535d;
    }

    public int u() {
        return this.l;
    }

    public boolean v() {
        return this.m;
    }

    public boolean w() {
        return this.o;
    }

    @Override // com.esafirm.imagepicker.features.u.a
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeTypedList(this.f4535d);
        parcel.writeByte((byte) (this.f4536e != null ? 1 : 0));
        ArrayList<File> arrayList = this.f4536e;
        if (arrayList != null) {
            parcel.writeList(arrayList);
        }
        parcel.writeString(this.f4537f);
        parcel.writeString(this.f4538g);
        parcel.writeString(this.f4539h);
        parcel.writeInt(this.f4540i);
        parcel.writeInt(this.f4541j);
        parcel.writeInt(this.f4542k);
        parcel.writeInt(this.l);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        parcel.writeByte(this.o ? (byte) 1 : 0);
        parcel.writeByte(this.p ? (byte) 1 : 0);
        parcel.writeSerializable(this.q);
    }

    public boolean x() {
        return this.n;
    }

    public boolean y() {
        return this.p;
    }

    protected l(Parcel parcel) {
        super(parcel);
        this.f4535d = parcel.createTypedArrayList(b.CREATOR);
        boolean z = true;
        if (parcel.readByte() != 0) {
            ArrayList<File> arrayList = new ArrayList<>();
            this.f4536e = arrayList;
            parcel.readList(arrayList, File.class.getClassLoader());
        }
        this.f4537f = parcel.readString();
        this.f4538g = parcel.readString();
        this.f4539h = parcel.readString();
        this.f4540i = parcel.readInt();
        this.f4541j = parcel.readInt();
        this.f4542k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        this.o = parcel.readByte() != 0;
        this.p = parcel.readByte() == 0 ? false : z;
        this.q = (com.esafirm.imagepicker.features.v.a) parcel.readSerializable();
    }
}
