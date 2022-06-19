package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* compiled from: FragmentManagerState */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<q> f1310b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<String> f1311c;

    /* renamed from: d  reason: collision with root package name */
    b[] f1312d;

    /* renamed from: e  reason: collision with root package name */
    int f1313e;

    /* renamed from: f  reason: collision with root package name */
    String f1314f = null;

    /* compiled from: FragmentManagerState */
    static class a implements Parcelable.Creator<o> {
        a() {
        }

        /* renamed from: a */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        /* renamed from: b */
        public o[] newArray(int i2) {
            return new o[i2];
        }
    }

    public o() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f1310b);
        parcel.writeStringList(this.f1311c);
        parcel.writeTypedArray(this.f1312d, i2);
        parcel.writeInt(this.f1313e);
        parcel.writeString(this.f1314f);
    }

    public o(Parcel parcel) {
        this.f1310b = parcel.createTypedArrayList(q.CREATOR);
        this.f1311c = parcel.createStringArrayList();
        this.f1312d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1313e = parcel.readInt();
        this.f1314f = parcel.readString();
    }
}
