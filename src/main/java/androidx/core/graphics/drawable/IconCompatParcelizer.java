package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1100a = versionedParcel.p(iconCompat.f1100a, 1);
        iconCompat.f1102c = versionedParcel.j(iconCompat.f1102c, 2);
        iconCompat.f1103d = versionedParcel.r(iconCompat.f1103d, 3);
        iconCompat.f1104e = versionedParcel.p(iconCompat.f1104e, 4);
        iconCompat.f1105f = versionedParcel.p(iconCompat.f1105f, 5);
        iconCompat.f1106g = (ColorStateList) versionedParcel.r(iconCompat.f1106g, 6);
        iconCompat.f1108i = versionedParcel.t(iconCompat.f1108i, 7);
        iconCompat.f1109j = versionedParcel.t(iconCompat.f1109j, 8);
        iconCompat.l();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.m(versionedParcel.f());
        int i2 = iconCompat.f1100a;
        if (-1 != i2) {
            versionedParcel.F(i2, 1);
        }
        byte[] bArr = iconCompat.f1102c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1103d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i3 = iconCompat.f1104e;
        if (i3 != 0) {
            versionedParcel.F(i3, 4);
        }
        int i4 = iconCompat.f1105f;
        if (i4 != 0) {
            versionedParcel.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f1106g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f1108i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f1109j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
