package c.e.a.c.a.a;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: DownloadProgressInfo */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public long f3470b;

    /* renamed from: c  reason: collision with root package name */
    public long f3471c;

    /* renamed from: d  reason: collision with root package name */
    public long f3472d;

    /* renamed from: e  reason: collision with root package name */
    public float f3473e;

    /* compiled from: DownloadProgressInfo */
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

    public b(Parcel parcel) {
        this.f3470b = parcel.readLong();
        this.f3471c = parcel.readLong();
        this.f3472d = parcel.readLong();
        this.f3473e = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f3470b);
        parcel.writeLong(this.f3471c);
        parcel.writeLong(this.f3472d);
        parcel.writeFloat(this.f3473e);
    }

    public b(long j2, long j3, long j4, float f2) {
        this.f3470b = j2;
        this.f3471c = j3;
        this.f3472d = j4;
        this.f3473e = f2;
    }
}
