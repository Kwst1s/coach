package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public int f59b;

    /* renamed from: c  reason: collision with root package name */
    public int f60c;

    /* renamed from: d  reason: collision with root package name */
    public int f61d;

    /* renamed from: e  reason: collision with root package name */
    public int f62e;

    /* renamed from: f  reason: collision with root package name */
    public int f63f;

    static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f59b = parcel.readInt();
        this.f61d = parcel.readInt();
        this.f62e = parcel.readInt();
        this.f63f = parcel.readInt();
        this.f60c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f59b);
        parcel.writeInt(this.f61d);
        parcel.writeInt(this.f62e);
        parcel.writeInt(this.f63f);
        parcel.writeInt(this.f60c);
    }
}
