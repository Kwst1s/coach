package pl.aprilapps.easyphotopicker;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import kotlin.m.b.d;
import kotlin.m.b.f;

/* compiled from: MediaFile.kt */
public final class g implements Parcelable {
    public static final a CREATOR = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final Uri f11053b;

    /* renamed from: c  reason: collision with root package name */
    private final File f11054c;

    /* compiled from: MediaFile.kt */
    public static final class a implements Parcelable.Creator<g> {
        private a() {
        }

        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            f.f(parcel, "parcel");
            return new g(parcel);
        }

        /* renamed from: b */
        public g[] newArray(int i2) {
            return new g[i2];
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    public g(Uri uri, File file) {
        f.f(uri, "uri");
        f.f(file, "file");
        this.f11053b = uri;
        this.f11054c = file;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return f.a(this.f11053b, gVar.f11053b) && f.a(this.f11054c, gVar.f11054c);
    }

    public final File g() {
        return this.f11054c;
    }

    public int hashCode() {
        Uri uri = this.f11053b;
        int i2 = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        File file = this.f11054c;
        if (file != null) {
            i2 = file.hashCode();
        }
        return hashCode + i2;
    }

    public final Uri k() {
        return this.f11053b;
    }

    public String toString() {
        return "MediaFile(uri=" + this.f11053b + ", file=" + this.f11054c + ")";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        f.f(parcel, "parcel");
        parcel.writeParcelable(this.f11053b, i2);
        parcel.writeSerializable(this.f11054c);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g(android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.String r0 = "parcel"
            kotlin.m.b.f.f(r2, r0)
            java.lang.Class<android.net.Uri> r0 = android.net.Uri.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r2.readParcelable(r0)
            if (r0 == 0) goto L_0x0027
            android.net.Uri r0 = (android.net.Uri) r0
            java.io.Serializable r2 = r2.readSerializable()
            if (r2 == 0) goto L_0x001f
            java.io.File r2 = (java.io.File) r2
            r1.<init>(r0, r2)
            return
        L_0x001f:
            kotlin.TypeCastException r2 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type java.io.File"
            r2.<init>(r0)
            throw r2
        L_0x0027:
            kotlin.m.b.f.l()
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.aprilapps.easyphotopicker.g.<init>(android.os.Parcel):void");
    }
}
