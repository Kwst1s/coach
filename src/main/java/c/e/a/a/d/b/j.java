package c.e.a.a.d.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class j extends a implements h {
    public static final Parcelable.Creator<j> CREATOR = new i();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f3228b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3229c;

    public j(List<String> list, String str) {
        this.f3228b = list;
        this.f3229c = str;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status g() {
        if (this.f3229c != null) {
            return Status.f7128g;
        }
        return Status.f7130i;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.k(parcel, 1, this.f3228b, false);
        b.j(parcel, 2, this.f3229c, false);
        b.b(parcel, a2);
    }
}
