package c.e.a.b.d0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.e.g;

/* compiled from: ExtendableSavedState */
public class a extends b.j.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0077a();

    /* renamed from: d  reason: collision with root package name */
    public final g<String, Bundle> f3363d;

    /* renamed from: c.e.a.b.d0.a$a  reason: collision with other inner class name */
    /* compiled from: ExtendableSavedState */
    static class C0077a implements Parcelable.ClassLoaderCreator<a> {
        C0077a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        /* renamed from: b */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        /* renamed from: c */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0077a aVar) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f3363d + "}";
    }

    @Override // b.j.a.a
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        int size = this.f3363d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = this.f3363d.i(i3);
            bundleArr[i3] = this.f3363d.m(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f3363d = new g<>();
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f3363d = new g<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3363d.put(strArr[i2], bundleArr[i2]);
        }
    }
}
