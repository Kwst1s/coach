package c.e.a.a.d.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.a;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class b extends a implements h {
    public static final Parcelable.Creator<b> CREATOR = new d();

    /* renamed from: b  reason: collision with root package name */
    private final int f3225b;

    /* renamed from: c  reason: collision with root package name */
    private int f3226c;

    /* renamed from: d  reason: collision with root package name */
    private Intent f3227d;

    b(int i2, int i3, Intent intent) {
        this.f3225b = i2;
        this.f3226c = i3;
        this.f3227d = intent;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status g() {
        if (this.f3226c == 0) {
            return Status.f7128g;
        }
        return Status.f7130i;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.f(parcel, 1, this.f3225b);
        com.google.android.gms.common.internal.safeparcel.b.f(parcel, 2, this.f3226c);
        com.google.android.gms.common.internal.safeparcel.b.i(parcel, 3, this.f3227d, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }

    public b() {
        this(0, null);
    }

    private b(int i2, Intent intent) {
        this(2, 0, null);
    }
}
