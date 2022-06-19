package c.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Image */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public long f3048b;

    /* renamed from: c  reason: collision with root package name */
    public String f3049c;

    /* renamed from: d  reason: collision with root package name */
    public String f3050d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3051e;

    /* compiled from: Image */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        /* renamed from: b */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f3048b);
        parcel.writeString(this.f3049c);
        parcel.writeString(this.f3050d);
    }

    public b(long j2, String str, String str2, boolean z) {
        this.f3048b = j2;
        this.f3049c = str;
        this.f3050d = str2;
        this.f3051e = z;
    }

    private b(Parcel parcel) {
        this.f3048b = parcel.readLong();
        this.f3049c = parcel.readString();
        this.f3050d = parcel.readString();
    }
}
