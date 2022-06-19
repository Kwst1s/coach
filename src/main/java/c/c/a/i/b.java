package c.c.a.i;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Image */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private long f3209b;

    /* renamed from: c  reason: collision with root package name */
    private String f3210c;

    /* renamed from: d  reason: collision with root package name */
    private String f3211d;

    /* compiled from: Image */
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

    public b(long j2, String str, String str2) {
        this.f3209b = j2;
        this.f3210c = str;
        this.f3211d = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return ((b) obj).g().equalsIgnoreCase(g());
    }

    public String g() {
        return this.f3211d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f3209b);
        parcel.writeString(this.f3210c);
        parcel.writeString(this.f3211d);
    }

    protected b(Parcel parcel) {
        this.f3209b = parcel.readLong();
        this.f3210c = parcel.readString();
        this.f3211d = parcel.readString();
    }
}
