package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* compiled from: FragmentState */
public final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final String f1322b;

    /* renamed from: c  reason: collision with root package name */
    final String f1323c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f1324d;

    /* renamed from: e  reason: collision with root package name */
    final int f1325e;

    /* renamed from: f  reason: collision with root package name */
    final int f1326f;

    /* renamed from: g  reason: collision with root package name */
    final String f1327g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f1328h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f1329i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f1330j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f1331k;
    final boolean l;
    final int m;
    Bundle n;

    /* compiled from: FragmentState */
    static class a implements Parcelable.Creator<q> {
        a() {
        }

        /* renamed from: a */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        /* renamed from: b */
        public q[] newArray(int i2) {
            return new q[i2];
        }
    }

    q(Fragment fragment) {
        this.f1322b = fragment.getClass().getName();
        this.f1323c = fragment.f1214f;
        this.f1324d = fragment.n;
        this.f1325e = fragment.w;
        this.f1326f = fragment.x;
        this.f1327g = fragment.y;
        this.f1328h = fragment.B;
        this.f1329i = fragment.m;
        this.f1330j = fragment.A;
        this.f1331k = fragment.f1215g;
        this.l = fragment.z;
        this.m = fragment.Q.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1322b);
        sb.append(" (");
        sb.append(this.f1323c);
        sb.append(")}:");
        if (this.f1324d) {
            sb.append(" fromLayout");
        }
        if (this.f1326f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1326f));
        }
        String str = this.f1327g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1327g);
        }
        if (this.f1328h) {
            sb.append(" retainInstance");
        }
        if (this.f1329i) {
            sb.append(" removing");
        }
        if (this.f1330j) {
            sb.append(" detached");
        }
        if (this.l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1322b);
        parcel.writeString(this.f1323c);
        parcel.writeInt(this.f1324d ? 1 : 0);
        parcel.writeInt(this.f1325e);
        parcel.writeInt(this.f1326f);
        parcel.writeString(this.f1327g);
        parcel.writeInt(this.f1328h ? 1 : 0);
        parcel.writeInt(this.f1329i ? 1 : 0);
        parcel.writeInt(this.f1330j ? 1 : 0);
        parcel.writeBundle(this.f1331k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }

    q(Parcel parcel) {
        this.f1322b = parcel.readString();
        this.f1323c = parcel.readString();
        boolean z = true;
        this.f1324d = parcel.readInt() != 0;
        this.f1325e = parcel.readInt();
        this.f1326f = parcel.readInt();
        this.f1327g = parcel.readString();
        this.f1328h = parcel.readInt() != 0;
        this.f1329i = parcel.readInt() != 0;
        this.f1330j = parcel.readInt() != 0;
        this.f1331k = parcel.readBundle();
        this.l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }
}
