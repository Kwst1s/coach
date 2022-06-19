package c.e.a.a.d.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.d0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new n();

    /* renamed from: b  reason: collision with root package name */
    private final int f3232b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.a f3233c;

    /* renamed from: d  reason: collision with root package name */
    private final d0 f3234d;

    l(int i2, com.google.android.gms.common.a aVar, d0 d0Var) {
        this.f3232b = i2;
        this.f3233c = aVar;
        this.f3234d = d0Var;
    }

    public final com.google.android.gms.common.a k() {
        return this.f3233c;
    }

    public final d0 l() {
        return this.f3234d;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f3232b);
        b.i(parcel, 2, this.f3233c, i2, false);
        b.i(parcel, 3, this.f3234d, i2, false);
        b.b(parcel, a2);
    }

    public l(int i2) {
        this(new com.google.android.gms.common.a(8, null), null);
    }

    private l(com.google.android.gms.common.a aVar, d0 d0Var) {
        this(1, aVar, null);
    }
}
