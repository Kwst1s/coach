package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public final class a extends com.google.android.gms.common.internal.safeparcel.a {
    @RecentlyNonNull
    public static final Parcelable.Creator<a> CREATOR = new m();
    @RecentlyNonNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f7118f = new a(0);

    /* renamed from: b  reason: collision with root package name */
    private final int f7119b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7120c;

    /* renamed from: d  reason: collision with root package name */
    private final PendingIntent f7121d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7122e;

    a(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f7119b = i2;
        this.f7120c = i3;
        this.f7121d = pendingIntent;
        this.f7122e = str;
    }

    static String p(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7120c == aVar.f7120c && m.a(this.f7121d, aVar.f7121d) && m.a(this.f7122e, aVar.f7122e);
    }

    public final int hashCode() {
        return m.b(Integer.valueOf(this.f7120c), this.f7121d, this.f7122e);
    }

    public final int k() {
        return this.f7120c;
    }

    @RecentlyNullable
    public final String l() {
        return this.f7122e;
    }

    @RecentlyNullable
    public final PendingIntent m() {
        return this.f7121d;
    }

    public final boolean n() {
        return (this.f7120c == 0 || this.f7121d == null) ? false : true;
    }

    public final boolean o() {
        return this.f7120c == 0;
    }

    @RecentlyNonNull
    public final String toString() {
        m.a c2 = m.c(this);
        c2.a("statusCode", p(this.f7120c));
        c2.a("resolution", this.f7121d);
        c2.a("message", this.f7122e);
        return c2.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7119b);
        b.f(parcel, 2, k());
        b.i(parcel, 3, m(), i2, false);
        b.j(parcel, 4, l(), false);
        b.b(parcel, a2);
    }

    public a(int i2) {
        this(i2, null, null);
    }

    public a(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public a(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }
}
