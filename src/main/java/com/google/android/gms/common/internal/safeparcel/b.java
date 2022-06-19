package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class b {
    public static int a(@RecentlyNonNull Parcel parcel) {
        return n(parcel, 20293);
    }

    public static void b(@RecentlyNonNull Parcel parcel, int i2) {
        q(parcel, i2);
    }

    public static void c(@RecentlyNonNull Parcel parcel, int i2, boolean z) {
        o(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void d(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull Bundle bundle, boolean z) {
        if (bundle != null) {
            int n = n(parcel, i2);
            parcel.writeBundle(bundle);
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    public static void e(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int n = n(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    public static void f(@RecentlyNonNull Parcel parcel, int i2, int i3) {
        o(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void g(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull int[] iArr, boolean z) {
        if (iArr != null) {
            int n = n(parcel, i2);
            parcel.writeIntArray(iArr);
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    public static void h(@RecentlyNonNull Parcel parcel, int i2, long j2) {
        o(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void i(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull Parcelable parcelable, int i3, boolean z) {
        if (parcelable != null) {
            int n = n(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    public static void j(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull String str, boolean z) {
        if (str != null) {
            int n = n(parcel, i2);
            parcel.writeString(str);
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    public static void k(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull List<String> list, boolean z) {
        if (list != null) {
            int n = n(parcel, i2);
            parcel.writeStringList(list);
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void l(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull T[] tArr, int i3, boolean z) {
        if (tArr != null) {
            int n = n(parcel, i2);
            int length = tArr.length;
            parcel.writeInt(length);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    p(parcel, t, i3);
                }
            }
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void m(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull List<T> list, boolean z) {
        if (list != null) {
            int n = n(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                T t = list.get(i3);
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    p(parcel, t, 0);
                }
            }
            q(parcel, n);
        } else if (z) {
            o(parcel, i2, 0);
        }
    }

    private static int n(Parcel parcel, int i2) {
        parcel.writeInt(i2 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void o(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | -65536);
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    private static <T extends Parcelable> void p(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void q(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }
}
