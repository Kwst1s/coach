package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
public class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    public static class ParseException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParseException(@androidx.annotation.RecentlyNonNull java.lang.String r4, @androidx.annotation.RecentlyNonNull android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    @RecentlyNonNull
    public static Bundle a(@RecentlyNonNull Parcel parcel, int i2) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + o);
        return readBundle;
    }

    @RecentlyNonNull
    public static int[] b(@RecentlyNonNull Parcel parcel, int i2) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + o);
        return createIntArray;
    }

    @RecentlyNonNull
    public static <T extends Parcelable> T c(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + o);
        return createFromParcel;
    }

    @RecentlyNonNull
    public static String d(@RecentlyNonNull Parcel parcel, int i2) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + o);
        return readString;
    }

    @RecentlyNonNull
    public static ArrayList<String> e(@RecentlyNonNull Parcel parcel, int i2) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + o);
        return createStringArrayList;
    }

    @RecentlyNonNull
    public static <T> T[] f(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + o);
        return tArr;
    }

    @RecentlyNonNull
    public static <T> ArrayList<T> g(@RecentlyNonNull Parcel parcel, int i2, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + o);
        return createTypedArrayList;
    }

    public static void h(@RecentlyNonNull Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i2);
            throw new ParseException(sb.toString(), parcel);
        }
    }

    public static int i(int i2) {
        return i2 & 65535;
    }

    public static boolean j(@RecentlyNonNull Parcel parcel, int i2) {
        r(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static int k(@RecentlyNonNull Parcel parcel) {
        return parcel.readInt();
    }

    @RecentlyNonNull
    public static IBinder l(@RecentlyNonNull Parcel parcel, int i2) {
        int o = o(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (o == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + o);
        return readStrongBinder;
    }

    public static int m(@RecentlyNonNull Parcel parcel, int i2) {
        r(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long n(@RecentlyNonNull Parcel parcel, int i2) {
        r(parcel, i2, 8);
        return parcel.readLong();
    }

    public static int o(@RecentlyNonNull Parcel parcel, int i2) {
        return (i2 & -65536) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    public static void p(@RecentlyNonNull Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + o(parcel, i2));
    }

    public static int q(@RecentlyNonNull Parcel parcel) {
        int k2 = k(parcel);
        int o = o(parcel, k2);
        int dataPosition = parcel.dataPosition();
        if (i(k2) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(k2));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = o + dataPosition;
        if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new ParseException(sb.toString(), parcel);
    }

    private static void r(Parcel parcel, int i2, int i3) {
        int o = o(parcel, i2);
        if (o != i3) {
            String hexString = Integer.toHexString(o);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(o);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }
}
