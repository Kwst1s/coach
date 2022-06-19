package c.e.a.a.d.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.c0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class k extends a {
    public static final Parcelable.Creator<k> CREATOR = new m();

    /* renamed from: b  reason: collision with root package name */
    private final int f3230b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f3231c;

    k(int i2, c0 c0Var) {
        this.f3230b = i2;
        this.f3231c = c0Var;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f3230b);
        b.i(parcel, 2, this.f3231c, i2, false);
        b.b(parcel, a2);
    }

    public k(c0 c0Var) {
        this(1, c0Var);
    }
}
